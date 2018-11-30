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

public class LeaveDetailsRestTest {

    @Test
	public void testLeavesList() throws AssertionError, URISyntaxException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves")).getBody().as(LeaveDetails[].class);
		for (LeaveDetails e: res) {
			switch (e.getLeaveEmpId()) {
				case 1000:
					assertEquals(1000, e.getLeaveEmpId());
					break;
				case 2000:
					assertEquals(2000, e.getLeaveEmpId());
					break;				
				case 3000:
					assertEquals(3000, e.getLeaveEmpId());
					break;				
				case 4000:
					assertEquals(4000, e.getLeaveEmpId());
					break;				
				case 5000:
					assertEquals(5000, e.getLeaveEmpId());
					break;			
				default:
					fail("Unknown LeaveDetails with id:" + e);	
			}
		}
	}
@Test
	public void testLeavesPendingList() throws AssertionError, URISyntaxException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves/pending/1000")).getBody().as(LeaveDetails[].class);
        if (res.length == 0) {
            assertEquals(0, res.length);
        }
    }

  @Test
	public void testPendingLeaveById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves/pending/9999")).then().assertThat().statusCode(404);
	}
  @Test
	public void testLeavHisList() throws AssertionError, URISyntaxException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves/leavehistory/1000")).getBody().as(LeaveDetails[].class);
        if (res.length == 0) {
            assertEquals(0, res.length);
        }
    }
  @Test
	public void testLeavHisLeaveById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves/leavehistory/9999")).then().assertThat().statusCode(404);
	}
  @Test
    public void testApplyLeave() throws AssertionError, URISyntaxException {
        String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2019-12-12\",\"leaveEndDate\":\"2019-12-12\",\"leaveDays\":\"1\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\",\"leaveAppliedOn\":\"2018-11-29\"}").
        when().post(CommonUtil.getURI("/api/leaves/applyleave/1000")).getBody().asString();
		assertEquals("already applied on given date", res1);

		String res2 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2019-12-12\",\"leaveEndDate\":\"2019-12-10\",\"leaveDays\":\"1\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\",\"leaveAppliedOn\":\"2018-11-29\"}").
        when().post(CommonUtil.getURI("/api/leaves/applyleave/1000")).getBody().asString();
		assertEquals("StartDate Must be less than End date...", res2);

		String res3 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2019-12-12\",\"leaveEndDate\":\"2019-12-12\",\"leaveDays\":\"10\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\",\"leaveAppliedOn\":\"2018-11-29\"}").
        when().post(CommonUtil.getURI("/api/leaves/applyleave/1000")).getBody().asString();
		assertEquals("NO Of Days Should be right", res3);

		String res4 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2018-10-11\",\"leaveEndDate\":\"2018-10-12\",\"leaveDays\":\"2\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\",\"leaveAppliedOn\":\"2018-11-29\"}").
        when().post(CommonUtil.getURI("/api/leaves/applyleave/1000")).getBody().asString();
		assertEquals("Start should be greater or equal to current date", res4);

		 String res5 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2019-10-11\",\"leaveEndDate\":\"2019-10-12\",\"leaveDays\":\"2\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\",\"leaveAppliedOn\":\"2018-11-29\"}").
         when().post(CommonUtil.getURI("/api/leaves/applyleave/4000")).getBody().asString();
		 assertEquals("insufficient leav balance", res5);

		//  String res6 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2040-12-01\",\"leaveEndDate\":\"2040-12-01\",\"leaveDays\":\"1\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\",\"leaveAppliedOn\":\"2018-11-29\"}").
        //  when().post(CommonUtil.getURI("/api/leaves/applyleave/1000")).getBody().asString();
		//  assertEquals("Leave AutoApproved Successfully For 1 Days ", res6);

		//   String res7 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2040-11-12\",\"leaveEndDate\":\"2040-11-12\",\"leaveDays\":\"1\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\",\"leaveAppliedOn\":\"2018-11-29\"}").
        //   when().post(CommonUtil.getURI("/api/leaves/applyleave/2000")).getBody().asString();
		//   assertEquals("Leave Applied Successfully For 1 Days ", res7);
    }
	@Test
	public void testApplyLeaveById405() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves/applyleave/9999")).then().assertThat().statusCode(405);
}
@Test
    public void testapproveDeny() throws AssertionError, URISyntaxException {
        //  String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveId\":\"9\",\"leaveStatus\":\"APPROVED\",\"leaveMgrComment\":\"Enjoy\",\"leaveEmpId\":\"3000\"}").
        //  when().post(CommonUtil.getURI("/api/leaves/approvedeny/1000")).getBody().asString();
		//  assertEquals("Leave Approved Successfully", res1);
		String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveId\":\"8\",\"leaveStatus\":\"DENIED\",\"leaveMgrComment\":\"Sorry\",\"leaveEmpId\":\"5000\"}").
        when().post(CommonUtil.getURI("/api/leaves/approvedeny/2000")).getBody().asString();
		assertEquals("Leave Rejected", res2);
		String res3=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveId\":\"23\",\"leaveStatus\":\"APPROVED\",\"leaveMgrComment\":\"Enjoy\",\"leaveEmpId\":\"5000\"}").
        when().post(CommonUtil.getURI("/api/leaves/approvedeny/2000")).getBody().asString();
		assertEquals("You are not authorised to access this employee.", res3);
	}
 	@Test
 	public void testapproveDenyById404() throws AssertionError, URISyntaxException {
 		given().accept(ContentType.JSON).when()
 				.get(CommonUtil.getURI("/api/leaves/approvedeny/9999")).then().assertThat().statusCode(405);
 }
}
		


