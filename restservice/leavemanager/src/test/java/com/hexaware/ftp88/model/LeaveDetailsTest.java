package com.hexaware.ftp88.model;

import com.hexaware.ftp88.persistence.LeaveDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import com.hexaware.ftp88.persistence.EmployeeDAO;
//import com.hexaware.ftp88.persistence.LeaveDAO;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNull;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;

//import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

//import java.util.ArrayList;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

    /**
    * Function for testing setters.
    * @throws ParseException throws the parse exception which might occurs.
     */
    /**
 * Test class for Employee.
 */
@RunWith(JMockit.class)

public class LeaveDetailsTest {
    /**
 * Javadoc for method.
 *
 * @throws ParseException if a problem occurs.
 */
  @Test
    public final void testLeaveDetailsCon() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    LeaveDetails l1 = new LeaveDetails(1, 6, sdf.parse("2018-12-12"), sdf.parse("2018-12-16"), LeaveType.EL,
                                LeaveStatus.PENDING, 1000, "Wedding",
                                sdf.parse("2018-11-22"), "Bhau Enjoy !!");

    assertEquals(1, l1.getLeaveId());
    assertEquals(6, l1.getLeaveDays());
    assertEquals(sdf.parse("2018-12-12"), l1.getLeaveStartDate());
    assertEquals(sdf.parse("2018-12-16"), l1.getLeaveEndDate());
    assertEquals(LeaveType.EL, l1.getLeaveType());
    assertEquals(LeaveStatus.PENDING, l1.getLeaveStatus());
    assertEquals(1000, l1.getLeaveEmpId());
    assertEquals("Wedding", l1.getLeaveReason());
    assertEquals(sdf.parse("2018-11-22"), l1.getLeaveAppliedOn());
    assertEquals("Bhau Enjoy !!", l1.getLeaveMgrComment());
  }
    /**
    * Function for testing setters.
    * @throws ParseException throws the parse exception which might occurs.
     */

  @Test
    public final void testLeaveDetailsSetters() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails l1 =  new LeaveDetails();

    l1.setLeaveId(1);
    l1.setLeaveDays(6);
    l1.setLeaveStartDate(sdf.parse("2018-12-12"));
    l1.setLeaveEndDate(sdf.parse("2018-12-16"));
    l1.setLeaveEmpId(1000);
    l1.setLeaveReason("Wedding");
    l1.setLeaveAppliedOn(sdf.parse("2018-11-22"));
    l1.setLeaveMgrComment("Bhau Enjoy !!");
    l1.setLeaveType(LeaveType.EL);
    l1.setLeaveStatus(LeaveStatus.PENDING);

    assertEquals(1, l1.getLeaveId());
    assertEquals(6, l1.getLeaveDays());
    assertEquals(sdf.parse("2018-12-12"), l1.getLeaveStartDate());
    assertEquals(sdf.parse("2018-12-16"), l1.getLeaveEndDate());
    assertEquals(1000, l1.getLeaveEmpId());
    assertEquals("Wedding", l1.getLeaveReason());
    assertEquals(sdf.parse("2018-11-22"), l1.getLeaveAppliedOn());
    assertEquals("Bhau Enjoy !!", l1.getLeaveMgrComment());
    assertEquals(LeaveType.EL, l1.getLeaveType());
    assertEquals(LeaveStatus.PENDING, l1.getLeaveStatus());
    Employee e1 = null;
    assertFalse(l1.equals(e1));
    LeaveDetails ld = new LeaveDetails();
    Employee e = new Employee();
    assertFalse(ld.equals(e));
  }
    /**
    * Function for testing setters.
    * @throws ParseException throws the parse exception which might occurs.
     */
  @Test
    public final void testLeaveDetailsHashCode() throws ParseException {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    LeaveDetails l1 =  new LeaveDetails(1, 6, sdf.parse("2018-12-12"), sdf.parse("2018-12-16"),
                                        LeaveType.EL, LeaveStatus.PENDING, 1000, "bhau charcha kara",
                                         sdf.parse("2018-11-22"), "bhau nice!!");
    LeaveDetails l2 =  new LeaveDetails(1, 6, sdf.parse("2018-12-12"), sdf.parse("2018-12-16"),
                                        LeaveType.EL, LeaveStatus.PENDING, 1000, "bhau charcha kara",
                                         sdf.parse("2018-11-22"), "bhau nice!!");
    LeaveDetails l3 =  new LeaveDetails(2, 20, sdf.parse("2018-12-11"), sdf.parse("2018-12-04"),
                                        LeaveType.SL, LeaveStatus.PENDING, 1000, "wait",
                                         sdf.parse("2018-11-22"), "really nice!!");

    assertEquals(l1.hashCode(), l2.hashCode());
    assertNotEquals(l1.hashCode(), l3.hashCode());
    assertNotEquals(l2.hashCode(), l3.hashCode());
  }
  /**
    * Function for testing setters.
    * @throws ParseException throws the parse exception which might occurs.
     */
  @Test
    public final void testLeaveDetailsEquals() throws ParseException {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    LeaveDetails l1 =  new LeaveDetails(1, 6, sdf.parse("2018-12-12"), sdf.parse("2018-12-16"),
                                        LeaveType.EL, LeaveStatus.PENDING, 1000, "bhau charcha kara",
                                         sdf.parse("2018-11-22"), "bhau nice!!");
    LeaveDetails l2 =  new LeaveDetails(1, 6, sdf.parse("2018-12-12"), sdf.parse("2018-12-16"),
                                        LeaveType.EL, LeaveStatus.PENDING, 1000, "bhau charcha kara",
                                         sdf.parse("2018-11-22"), "bhau nice!!");
    LeaveDetails l3 =  new LeaveDetails(2, 20, sdf.parse("2018-12-11"), sdf.parse("2018-12-04"),
                                        LeaveType.SL, LeaveStatus.PENDING, 1000, "wait",
                                         sdf.parse("2018-11-22"), "really nice!!");

    assertEquals(l1, l2);
    assertNotEquals(l1, l3);
    assertNotEquals(l2, l3);
  }
   /**
   Tests that a list with some employees is handled correctly.
   * @param dao mocking the EmployeeDAO class.
   @throws ParseException throws the parse exception which might occurs.
   */
  @Test
   public final void testApproveDeny(@Mocked final LeaveDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final LeaveDetails ld1 = new LeaveDetails(200, 2, sf.parse("2018-12-23"), sf.parse("2018-12-24"),
            LeaveType.EL, LeaveStatus.PENDING, 2, "SICK", sf.parse("2018-12-20"), "ENJOY");
    new Expectations() {
      {
        dao.find(200); result = ld1;
        dao.find(300); result = null;
      }
    };

    new Expectations() {
      {
        dao.showManager(200); result = 1;
        dao.showManager(400); result = 2;
      }
    };

    new Expectations() {
      {
        dao.comment("Enjoy", "APPROVED", 200);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String s1 = LeaveDetails.approveDeny(200, "YES", "Enjoy", 1);
    assertEquals(s1, "Leave Approved Successfully");
    String s2 = LeaveDetails.approveDeny(200, "NO", "Sorry", 1);
    assertEquals(s2, "Leave Rejected");
    String s3 = LeaveDetails.approveDeny(300, "NO", "Sorry", 1);
    assertEquals(s3, "LeaveId Not Found");
    String s4 = LeaveDetails.approveDeny(400, "YES", "Enjoy", 1);
    assertEquals(s4, "You are not authorised to access this employee.");
  }
   /**
   * Tests that a list with some employees is handled correctly.
   * @param edao mocking the EmployeeDAO class.
   * @param ldao mocking the LeaveDAO class.
   * @throws ParseException for exceptions.
   */
  @Test
  public final void testApplyLeave(@Mocked final EmployeeDAO edao, @Mocked final LeaveDAO ldao)
                    throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        ldao.count(1, "2018-12-26", "2018-12-27"); result = 0;
      }
    };
    new Expectations() {
      {
        ldao.count(1, "2018-12-30", "2018-12-30"); result = 1;
      }
    };
    new Expectations() {
      {
        edao.find(1);  result = new Employee(1, "Dhanya", "9949391111",
            "dhanya@gmail.com", "Java", sf.parse("2018-08-01"), 1, 44);
        edao.find(2);  result = new Employee(2, "Kaushal", "8879421498",
            "xyz@gmail.com", "SQL", sf.parse("2018-08-01"), 0, 44);
        edao.find(3); result = null;
      }
    };
    new Expectations() {
      {
        ldao.apply(1, "2018-12-26", "2018-12-26", 1, "sick", "2018-11-22", "PENDING", "EL");
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return ldao;
      }
    };
    String str1 = LeaveDetails.applyLeave(1, 1, "2018-12-26", "2018-12-26", "sick",
                      "2018-11-22", "EL");
    assertEquals("Leave Applied Successfully For 1 Days ", str1);
    String str2 = LeaveDetails.applyLeave(1, 1, "2018-12-25", "2018-12-26", "sick",
                      "2018-11-22", "EL");
    assertEquals("NO Of Days Should be right", str2);
    String str4 = LeaveDetails.applyLeave(1, 1, "2018-12-30", "2018-12-30", "sick",
                      "2018-11-22", "EL");
    assertEquals("already applied on given date", str4);
    String str5 = LeaveDetails.applyLeave(1, 1, "2018-12-26", "2019-12-26", "sick",
                      "2018-11-22", "EL");
    assertEquals("insufficient leav balance", str5);
    String str6 = LeaveDetails.applyLeave(1, 2, "2018-12-26", "2018-12-27", "sick",
                      "2018-11-22", "EL");
    assertEquals("Leave Applied Successfully For 2 Days ", str6);
    String str7 = LeaveDetails.applyLeave(3, 2, "2018-12-26", "2018-12-27", "sick",
                      "2018-11-22", "EL");
    assertEquals("Employ Id Not Found", str7);
    String str8 = LeaveDetails.applyLeave(1, 3, "2018-12-03", "2018-12-01", "sick",
                      "2018-11-22", "EL");
    assertEquals("StartDate Must be less than End date...", str8);
    String str9 = LeaveDetails.applyLeave(2, 2, "2018-12-13", "2018-12-14", "sick",
                      "2018-12-11", "EL");
    assertEquals("Leave AutoApproved Successfully For 2 Days ", str9);
    String str10 = LeaveDetails.applyLeave(2, 2, "2011-10-11", "2011-10-12", "sick",
                      "2011-10-10", "EL");
    assertEquals("Start should be greater or equal to current date", str10);



   /* Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]); */
  }

   /**
   * Tests that a fetch of a specific employee works correctly.
   * @param ldao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testListById(@Mocked final LeaveDAO ldao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final LeaveDetails e100 = new LeaveDetails(200, 2, sf.parse("2018-12-23"), sf.parse("2018-12-24"),
            LeaveType.EL, LeaveStatus.PENDING, 2, "SICK", sf.parse("2018-12-20"), "ENJOY");
    new Expectations() {
      {
        ldao.find(2); result = e100;
        ldao.find(-1); result = null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return ldao;
      }
    };
    LeaveDetails l = LeaveDetails.listById(2);
    assertEquals(e100, l);

    l = LeaveDetails.listById(-1);
    assertNull(l);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for handling Dateparse Errors.
   */
  @Test
  public final void testLeaveHistory(@Mocked final LeaveDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
        es.add(new LeaveDetails(1, 2, sf.parse("2018-11-11"), sf.parse("2018-11-12"),
            LeaveType.EL, LeaveStatus.PENDING, 1, "Sick", sf.parse("2018-11-11"), "Wait"));
        dao.empHistory(100); result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ls = LeaveDetails.leaveHis(100);
    assertEquals(1, ls.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for date parsing.
   */
  @Test
  public final void testPending(@Mocked final LeaveDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld1 = new LeaveDetails();
    final ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
    final ArrayList<LeaveDetails> es2 = new ArrayList<LeaveDetails>();
    new Expectations() {
      {
        es.add(new LeaveDetails(1, 2, sf.parse("2018-11-11"), sf.parse("2018-11-12"),
            LeaveType.EL, LeaveStatus.PENDING, 2, "Sick", sf.parse("2018-11-11"), "Wait"));
        es.add(new LeaveDetails(1, 2, sf.parse("2018-11-13"), sf.parse("2018-11-14"),
            LeaveType.EL, LeaveStatus.PENDING, 3, "Sick", sf.parse("2018-11-11"), "go"));
        es.add(new LeaveDetails(1, 2, sf.parse("2018-11-14"), sf.parse("2018-11-15"),
            LeaveType.EL, LeaveStatus.PENDING, 4, "Sick", sf.parse("2018-11-11"), "enjoy"));
        es.add(new LeaveDetails(1, 2, sf.parse("2018-11-16"), sf.parse("2018-11-17"),
            LeaveType.EL, LeaveStatus.PENDING, 5, "Sick", sf.parse("2018-11-11"), "gohead"));
        dao.pending(1); result = es;
        dao.pending(2); result = es2;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] lds1 = LeaveDetails.listPending(1);
    assertEquals(4, lds1.length);
    LeaveDetails[] lds2 = LeaveDetails.listPending(2);
    assertEquals(0, lds2.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException mocking the dao class
   */
  @Test
  public final void testListAll(@Mocked final LeaveDAO dao) throws ParseException {



    new Expectations() {
      {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final ArrayList<LeaveDetails> es1 = new ArrayList<LeaveDetails>();

        es1.add(new LeaveDetails(1, 1, sdf.parse("2019-07-13"), sdf.parse("2019-07-13"),
                                LeaveType.EL, LeaveStatus.PENDING, 100, "sick", sdf.parse("2018-11-23"), "Enjoy"));

        es1.add(new LeaveDetails(1, 1, sdf.parse("2019-07-13"), sdf.parse("2019-07-13"),
                                LeaveType.EL, LeaveStatus.PENDING, 100, "sick", sdf.parse("2018-11-23"), "Enjoy"));

        es1.add(new LeaveDetails(1, 1, sdf.parse("2019-07-13"), sdf.parse("2019-07-13"),
                                LeaveType.EL, LeaveStatus.PENDING, 100, "sick", sdf.parse("2018-11-23"), "Enjoy"));

        dao.list(); result = es1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] e1 = LeaveDetails.listAll();
    assertEquals(3, e1.length);
  }
}
