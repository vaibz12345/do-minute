package com.hexaware.ftp88.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		for (Employee e: res) {
			switch (e.getEmpId()) {
				case 1000:
					assertEquals(1000, e.getEmpId());
					break;
				case 2000:
					assertEquals(2000, e.getEmpId());
					break;				
				case 3000:
					assertEquals(3000, e.getEmpId());
					break;				
				case 4000:
					assertEquals(4000, e.getEmpId());
					break;				
				case 5000:
					assertEquals(5000, e.getEmpId());
					break;			
				default:
					fail("Unknown employee with id:" + e);	
			}
		}
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException {
		Employee res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
		assertEquals(1000, res.getEmpId());
		assertEquals("VAIBHAV TAWARE", res.getEname());
  }
  
  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	} 
}
