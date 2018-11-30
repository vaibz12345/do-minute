package com.hexaware.ftp88.model;

import com.hexaware.ftp88.persistence.EmployeeDAO;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.Date;
import static org.junit.Assert.assertNull;

//import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
//import mockit.integration.junit4.JMockit;

import java.util.ArrayList;
/**
 * unit test for employ.
 */
public class EmployeeTest {
/**
 * Javadoc for method.
 *
 * @throws ParseException if a problem occurs.
 */
  @Test
    public final void testEmployee() throws ParseException {
    SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    Date d1 = df.parse("12-10-2011");
    Employee ob1 = new Employee(1, "vaibhav", "7685949390", "vaibhavsingh161997@gmail.com", "xyz", d1, 2000, 20);
    assertEquals(1, ob1.getEmpId());
    assertEquals("vaibhav", ob1.getEname());
    assertEquals("7685949390", ob1.getEmpPhone());
    assertEquals("vaibhavsingh161997@gmail.com", ob1.getEmpEmail());
    assertEquals("xyz", ob1.getEmpDept());
    assertEquals(df.parse("12-10-2011"), ob1.getEmpJoinDate());
    assertEquals(2000, ob1.getEmpMgrId());
    assertEquals(20, ob1.getEmpLeaveBal());
  }
  /**
  * unit test for employ.
  * Javadoc for method.
  * @throws ParseException if a problem occurs.
  */
  @Test
    public final void testStudentSetter() throws ParseException {
    SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    Date d1 = df.parse("12-10-2011");
    Employee ob1 = new Employee();
    ob1.setEmpId(1);
    ob1.setEname("vaibhav");
    ob1.setEmpPhone("7685949390");
    ob1.setEmpEmail("vaibhavsingh@gmail.com");
    ob1.setEmpDept("hubli");
    ob1.setEmpJoinDate(d1);
    ob1.setEmpMgrId(1);
    ob1.setEmpLeaveBal(20);
    assertEquals(1, ob1.getEmpId());
    assertEquals("vaibhav", ob1.getEname());
    assertEquals("7685949390", ob1.getEmpPhone());
    assertEquals("vaibhavsingh@gmail.com", ob1.getEmpEmail());
    assertEquals("hubli", ob1.getEmpDept());
    assertEquals(df.parse("12-10-2011"), ob1.getEmpJoinDate());
    assertEquals(1, ob1.getEmpMgrId());
    assertEquals(20, ob1.getEmpLeaveBal());
    Employee e1 = null;
    assertFalse(ob1.equals(e1));
    LeaveDetails ld = new LeaveDetails();
    assertFalse(ob1.equals(ld));
  }
  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
    Employee e1 = new Employee(1, "vaibhav", "vaibhavsingh161997@gmail.com", "java", "987456321",
        sdf3.parse("2014-08-17"),
        10, 1000);
    Employee e2 = new Employee(1, "vaibhav", "vaibhavsingh161997@gmail.com", "java", "987456321",
        sdf3.parse("2014-08-17"),
        10, 1000);
    Employee e3 = new Employee(2, "kaushal", "rahul@gmail.com", "sql", "984588456", sdf3.parse("2014-08-18"), 12, 3000);
    assertEquals(e1, e2);
    assertNotEquals(e1, e3);
    assertNotEquals(e2, e3);
  }

  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testHashCode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee e1 = new Employee(1, "vaibhav", "vaibhavsingh161997@gmail.com", "java", "987456321",
        sdf.parse("2014-08-17"), 10, 1000);
    Employee e2 = new Employee(1, "vaibhav", "vaibhavsingh161997@gmail.com", "java", "987456321",
        sdf.parse("2014-08-17"), 10, 1000);
    Employee e3 = new Employee(2, "rahul", "rahul@gmail.com", "sql", "984588456", sdf.parse("2016-08-18"), 12, 3000);
    assertEquals(e1.hashCode(), e2.hashCode());
    assertNotEquals(e1.hashCode(), e3.hashCode());
    assertNotEquals(e2.hashCode(), e3.hashCode());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(100, "Dhanya", "84823444", "dhanya@gmail.com",
        "java", sf.parse("2018-08-01"), 1, 12);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testDecrement(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(100, "Dhanya", "84823444", "dhanya@gmail.com",
        "java", sf.parse("2018-08-01"), 1, 12);
    new Expectations() {
      {
        dao.find(100); result = e100;
      }
    };
    new Expectations() {
      {
        dao.decrement(100, 2);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e1 = Employee.listById(100);
    assertEquals(e1, e100);
    String result = Employee.decrement(100, 2);
    assertEquals("Leave Balance Updated", result);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testIncrement(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(100, "Dhanya", "84823444", "dhanya@gmail.com",
        "java", sf.parse("2018-08-01"), 1, 12);
    new Expectations() {
      {
        dao.find(100); result = e100;
      }
    };
    new Expectations() {
      {
        dao.increment(100, 12);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e1 = Employee.listById(100);
    assertEquals(e1, e100);
    String result = Employee.increment(100, 12);
    assertEquals("Leave Balance Updated", result);
  }
}

