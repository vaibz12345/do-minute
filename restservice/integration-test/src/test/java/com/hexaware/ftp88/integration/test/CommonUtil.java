package com.hexaware.ftp88.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "ftp88");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}



class Employee {
    
    /**
   * empId to store employee id.
   */
  private int empId;
  private String ename;
  private String empPhone;
  private String empEmail;
  private String empDept;
  private Date empJoinDate;
  private int empMgrId;
  private int empLeaveBal;
  /**
   * default constructor.
   */
  public Employee() {

  }



  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(ename, emp.ename) && Objects.equals(empPhone, emp.empPhone)
        && Objects.equals(empEmail, emp.empEmail) && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empJoinDate, emp.empJoinDate) && Objects.equals(empMgrId, emp.empMgrId)
        && Objects.equals(empLeaveBal, emp.empLeaveBal)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, ename, empPhone, empEmail, empDept, empDept, empJoinDate, empMgrId, empLeaveBal);
  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argEname to initialize employee id.
   * @param argPhone to initialize employee id.
   * @param argEmail to initialize employee id.
   * @param argDept to initialize employee id.
   * @param argDate to initialize employee id.
   * @param argEmpMgrId to initialize employee id.
   * @param argLeaveBal to initialize employee id.
  */
  public Employee(final int argEmpId, final String argEname, final String argPhone, final String argEmail,
        final String argDept, final Date argDate, final int argEmpMgrId,
        final int argLeaveBal) {
    this.empId = argEmpId;
    this.ename = argEname;
    this.empPhone = argPhone;
    this.empEmail = argEmail;
    this.empDept = argDept;
    this.empJoinDate = argDate;
    this.empMgrId = argEmpMgrId;
    this.empLeaveBal = argLeaveBal;

  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEname() {
    return ename;
  }
  /**
   * Gets the EmployeePhone.
   * @return this Employee's Phone.
   */
  public final String getEmpPhone() {
    return empPhone;
  }
  /**
   * Gets the Employee Email.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }
   /**
   * Gets the Employee Dept.
   * @return this Employee's Dept.
   */
  public final String getEmpDept() {
    return empDept;
  }
  /**
   * Gets the Employee join date.
   * @return this Employee's join date.
   */
  public final Date getEmpJoinDate() {
    return empJoinDate;
  }
  /**
   * Gets the Employee Manager ID.
   * @return this Employee's Manager ID.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }
  /**
   * Gets the Employee Leave Bal.
   * @return this Employee's Leave Bal.
   */
  public final int getEmpLeaveBal() {
    return empLeaveBal;
  }
  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   *
   * @param argEname to set employee name.
   */
  public final void setEname(final String argEname) {
    this.ename = argEname;
  }
  /**
   *
   * @param argPhone to set employee Phone.
   */
  public final void setEmpPhone(final String argPhone) {
    this.empPhone = argPhone;
  }
  /**
   *
   * @param argEmail to set employee Email.
   */
  public final void setEmpEmail(final String argEmail) {
    this.empEmail = argEmail;
  }
  /**
   *
   * @param argDept to set employee Dept.
   */
  public final void setEmpDept(final String argDept) {
    this.empDept = argDept;
  }
  /**
   *
   * @param argDate to set employee Date of Join.
   */
  public final void setEmpJoinDate(final Date argDate) {
    this.empJoinDate = argDate;
  }
  /**
   *
   * @param argEmpMgrId to set employee Manager Id.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }
  /**
   *
   * @param argLeaveBal to set employee Leave Bal.
   */
  public final void setEmpLeaveBal(final int argLeaveBal) {
    this.empLeaveBal = argLeaveBal;
  }
}
class LeaveDetails {

    /**
     * leaveID to store leave id.
     * leaveStartDate to store starting date of leave.
     * leaveEndDate to store end date of leave.
     * leaveEmpId is to store employee Id.
     * leaveReason to store Reason for the leave.
     * leaveAppliedOn to store applied date.
     * leaveMgrComment to store manager comment.
     * leavestatus to store leavestatus.
     * leavetype to store leave type.
     */
  private int leaveId;
  private int leaveDays;
  private Date leaveStartDate;
  private Date leaveEndDate;
  private int leaveEmpId;
  private String leaveReason;
  private Date leaveAppliedOn;
  private String leaveMgrComment;
  private LeaveStatus leavestatus;
  private LeaveType leavetype;

  /**
    * default constructor.
   */
  public LeaveDetails() {

  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails l = (LeaveDetails) obj;
    if (Objects.equals(leaveId, l.leaveId) && Objects.equals(leaveDays, l.leaveDays)
        && Objects.equals(leaveStartDate, l.leaveStartDate)
        && Objects.equals(leaveEndDate, l.leaveEndDate) && Objects.equals(leaveEmpId, l.leaveEmpId)
        && Objects.equals(leaveReason, l.leaveReason) && Objects.equals(leaveAppliedOn, l.leaveAppliedOn)
        && Objects.equals(leaveMgrComment, l.leaveMgrComment) && Objects.equals(leavestatus, l.leavestatus)
        && Objects.equals(leavetype, l.leavetype)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, leaveDays, leaveStartDate, leaveEndDate, leaveEmpId, leaveReason, leaveAppliedOn,
     leaveMgrComment, leavestatus, leavetype);
  }
  /**
   * @param argLeaveID to initialize employee id.
   * @param argLeaveDays to initialize employee id.
   * @param argLeaveStartDate to initialize employee id.
   * @param argLeaveEndDate to initialize employee id.
   * @param arglvetype to initialize employee id.
   * @param arglvestatus to initialize employee id.
   * @param argLeaveEmpId to initialize employee id.
   * @param argLeaveReason to initialize employee id.
   * @param argLeaveAppliedOn to initialize employee id.
   * @param argLeaveMgrComment to initialize employee id.
  */
  public LeaveDetails(final int argLeaveID, final int argLeaveDays, final Date argLeaveStartDate,
                      final Date argLeaveEndDate, final LeaveType arglvetype, final LeaveStatus arglvestatus,
                      final int argLeaveEmpId, final String argLeaveReason,
                      final Date argLeaveAppliedOn, final String argLeaveMgrComment) {
    this.leaveId = argLeaveID;
    this.leaveDays = argLeaveDays;
    this.leaveStartDate = argLeaveStartDate;
    this.leaveEndDate = argLeaveEndDate;
    this.leaveEmpId = argLeaveEmpId;
    this.leaveReason = argLeaveReason;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.leaveMgrComment = argLeaveMgrComment;
    this.leavetype = arglvetype;
    this.leavestatus = arglvestatus;
  }

/**
     * Gets the leaveDays.
     * @return this leaveDays.
     */
  public final int getLeaveDays() {
    return leaveDays;
  }

    /**
     * set the leaveDays.
     * @param argLeaveDays to set leaveDays.
     */
  public final void setLeaveDays(final int argLeaveDays) {
    this.leaveDays = argLeaveDays;
  }
  /**
     * Gets the LeaveId.
     * @return this leave ID.
     */
  public final int getLeaveId() {
    return leaveId;
  }

    /**
     * set the leaveId.
     * @param argLeaveId to set leave id.
     */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }
    /**
     * Gets the starting date.
     * @return this starting date.
     */
  public final Date getLeaveStartDate() {
    return leaveStartDate;
  }

    /**
     *
     * @param argLeaveStartDate to set the start date.
     */
  public final void setLeaveStartDate(final Date argLeaveStartDate) {
    this.leaveStartDate = argLeaveStartDate;
  }

    /**
     * Gets the leave ending date.
     * @return this leave end date.
     */
  public final Date getLeaveEndDate() {
    return leaveEndDate;
  }

    /**
     *
     * @param argLeaveEndDate to set leave end date.
     */
  public final void setLeaveEndDate(final Date argLeaveEndDate) {
    this.leaveEndDate = argLeaveEndDate;
  }

    /**
     * Gets the emloyee id.
     * @return this employee id.
     */
  public final int getLeaveEmpId() {
    return leaveEmpId;
  }

    /**
     *
     * @param argLeaveEmpId to set leave status.
     */
  public final void setLeaveEmpId(final int argLeaveEmpId) {
    this.leaveEmpId = argLeaveEmpId;
  }

    /**
     * Gets the reason of leave.
     * @return this reason of leave.
     */
  public final String getLeaveReason() {
    return leaveReason;
  }

    /**
     *
     * @param argLeaveReason to set employee joining date.
     */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }

    /**
     * Gets the leave applied date.
     * @return this leave applied date.
     */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }

    /**
     *
     * @param argLeaveAppliedOn to set ManagerID.
     */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }

    /**
     * Gets the manager comment.
     * @return this manager comment.
     */
  public final String getLeaveMgrComment() {
    return leaveMgrComment;
  }

    /**
     *
     * @param argLeaveMgrComment to set manager comment.
     */
  public final void setLeaveMgrComment(final String argLeaveMgrComment) {
    this.leaveMgrComment = argLeaveMgrComment;
  }

  /**
   * Gets the leave type.
   * @return the leave type.
   */
  public final LeaveType getLeaveType() {
    return leavetype;
  }

  /**
   *
   * @param argLevtype to set manager comment.
   */
  public final void setLeaveType(final LeaveType argLevtype) {
    this.leavetype = argLevtype;
  }

  /**
   * Gets the leave status.
   * @return the leave status.
   */
  public final LeaveStatus getLeaveStatus() {
    return leavestatus;
  }

  /**
   *
   * @param argsLevStatus to set leave status.
   */
  public final void setLeaveStatus(final LeaveStatus argsLevStatus) {
    this.leavestatus = argsLevStatus;
  }

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}

/**
  * enum class to store enum values.
  * @author hexaware
  */
enum LeaveStatus {
/**
 * This is status of leave.
 */
    APPROVED, DENIED, PENDING
}

/**
  * enum class to store enum values.
  * @author hexaware
  */
enum LeaveType {
  /**
     * Earned for EL.
     */
    EL,

    /**
     * Earned for SL.
     */
     SL,

     /**
      * Earned for ML.
      */
     ML
}
