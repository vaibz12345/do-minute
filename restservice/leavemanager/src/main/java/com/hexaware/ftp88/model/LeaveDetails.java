package com.hexaware.ftp88.model;

import com.hexaware.ftp88.persistence.LeaveDAO;
import com.hexaware.ftp88.persistence.EmployeeDAO;
import com.hexaware.ftp88.persistence.DbConnection;
import java.util.Objects;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class LeaveDetails {

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
  /**
   * The dao for employee.
   */
  private static LeaveDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDAO.class);
  }
  /**
   * The dao for EmployeeDetails.
   */
  private static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
  /**
   * list all Leave details.
   * @return all Leaves' details
   */
  public static LeaveDetails[] listAll() {

    List<LeaveDetails> es = dao().list();
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
   * list all employee leave details.
   * @param mgrId id to get employee leave details.
   * @return all employees' leave details
   */
  public static LeaveDetails[] listPending(final int mgrId) {

    List<LeaveDetails> es = dao().pending(mgrId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
  * returns ManagerId for. LeaveId value
  * @param leaveId id to get employee manager details.
  * @return int.
  */
  public static int showManager(final int leaveId) {
    return dao().showManager(leaveId);
  }

  /**
   * list Leave details by id.
   * @param leaveId  to get Leave details.
   * @return Leave details
   */
  public static LeaveDetails listById(final int leaveId) {
    return dao().find(leaveId);
  }
  /**
   * NO of overlapping Leaves.
   * @param leaveEmpId id to get employee details.
   * @param leaveStartDate id to get employee details.
   * @param leaveEndDate id to get employee details.
   * @return count of no of employee.
   */
  public static int countNo(final int leaveEmpId, final String leaveStartDate, final String leaveEndDate) {
    int count = dao().count(leaveEmpId, leaveStartDate, leaveEndDate);
    return count;
  }

  /**
   * Method for Approve or Deny the Leave.
   * @param leaveId to enter LeaveId to approve/deny.
   * @param leavestatus to enter status to approve/deny.
   * @param leaveMgrComment to get manager comments.
   * @param empId to get employee id.
   * @return String.
   */
  public static String approveDeny(final int leaveId, final String leavestatus,
      final String leaveMgrComment, final int empId) {
    LeaveDetails ld = LeaveDetails.listById(leaveId);
    int empdId = LeaveDetails.showManager(leaveId);
    String res = null;
    String dbStatus = null;
    if (ld != null) {
      int leaveDays = ld.getLeaveDays();
      int leaveEmpId = ld.getLeaveEmpId();
      System.out.println(leavestatus);
      if (empId != empdId) {
        res = "You are not authorised to access this employee.";
        return res;
      }
      if (leavestatus.equals("YES") || leavestatus.equals("yes")) {
        dbStatus = "APPROVED";
        res = "Leave Approved Successfully";
      } else {
        dbStatus = "DENIED";
        res = "Leave Rejected";
        if (ld.getLeaveType().equals(LeaveType.EL)) {
          edao().incrementEL(leaveEmpId, leaveDays);
        }
        if (ld.getLeaveType().equals(LeaveType.ML)) {
          edao().incrementML(leaveEmpId, leaveDays);
        }
        if (ld.getLeaveType().equals(LeaveType.SL)) {
          edao().incrementSL(leaveEmpId, leaveDays);
        }
      }

      dao().comment(leaveMgrComment, dbStatus, leaveId);
    } else {
      res = "LeaveId Not Found";
    }
    return res;
  }

  /**
   * NO of overlapping Leaves.
   * @param leaveEmpId id to get employee details.
   * @return  employee's leave history.
   */
  public static LeaveDetails[] leaveHis(final int leaveEmpId) {
    List<LeaveDetails> es = dao().empHistory(leaveEmpId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
   * ApplyLeave for Employee.
   * @param leaveDays to initialize employee id.
   * @param leaveStartDate to initialize employee id.
   * @param leaveEndDate to initialize employee id.
   * @param leaveEmpId to initialize employee id.
   * @param leaveReason to initialize employee id.
   * @param leaveAppliedOn to initialize employee id.
   * @param leavetype to initialize employee id.
   * @throws ParseException to handled parsing errors.
   * @return ApplyLeave Status.
   */
  public static String applyLeave(final int leaveEmpId, final int leaveDays,
            final String leaveStartDate,
            final String leaveEndDate, final String leaveReason,
            final String leaveAppliedOn,
            final String leavetype) throws ParseException {
    Employee emplo = Employee.listById(leaveEmpId);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date stDate = sdf.parse(leaveStartDate);
    Date enDate = sdf.parse(leaveEndDate);
    Calendar start = Calendar.getInstance();
    start.setTime(stDate);
    Calendar end = Calendar.getInstance();
    end.setTime(enDate);
    int count = 0;
    for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
      if (dayOfWeek == 1 || dayOfWeek == 7) {
        count++;
      }
    }
    System.out.println(count);
    Date today = new Date();
    long diff = enDate.getTime() - stDate.getTime();
    long days = diff / (1000 * 60 * 60 * 24);
    long tdiff = stDate.getTime() - today.getTime();
    long tdays = tdiff / (1000 * 60 * 60 * 24);
    System.out.println("Difference is " + tdays);
    //Date today = new Date();
    days = days + 1;
    String s = null;
    //long updLeave = 0;
    //int availBal = 0;
    if (emplo != null) {
    //Employee employee = edao().find(leaveEmpId);
      int overlap = LeaveDetails.countNo(leaveEmpId, leaveStartDate, leaveEndDate);
      int availBal1 = emplo.getEmpELBal();
      int availBal2 = emplo.getEmpMLBal();
      int availBal3 = emplo.getEmpSLBal();
      System.out.println("You Applied for " + days);
      long difEL = availBal1 - days;
      long difML = availBal2 - days;
      long difSL = availBal3 - days;
      System.out.println("Balance Available " + availBal1);
      System.out.println("Balance Available " + availBal2);
      System.out.println("Balance Available " + availBal3);
     // updLeave = days - count;
      String status = null;
      if (days <= 0) {
        s = "StartDate Must be less than End date...";
      } else if (difEL < 0) {
        s = "insufficient leav balance";
      } else if (difML < 0) {
        s = "insufficient leav balance";
      } else if (difSL < 0) {
        s = "insufficient leav balance";
      } else if (leaveDays != days) {
        s = "NO Of Days Should be right";
      } else if (tdays < 0) {
        s = "Start should be greater or equal to current date";
      } else if (overlap > 0) {
        s = "already applied on given date";
      } else {
        if (emplo.getEmpMgrId() == 0) {
          status = "APPROVED";
          s = "Leave AutoApproved Successfully For "  + (days - count) + " Days ";
        } else {
          status = "PENDING";
          s = "Leave Applied Successfully For "  + (days - count) + " Days.";
        }
        dao().apply(leaveDays, leaveStartDate, leaveEndDate, leaveEmpId,
              leaveReason, leaveAppliedOn, status, leavetype);
        if (leavetype.equals("EL") || leavetype.equals("el")) {
          int bal1 = (int) difEL;
          edao().decrementEL(leaveEmpId, bal1);
        }
        if (leavetype.equals("ML") || leavetype.equals("ml")) {
          int bal2 = (int) difML;
          edao().decrementML(leaveEmpId, bal2);
        }
        if (leavetype.equals("SL") || leavetype.equals("sl")) {
          int bal3 = (int) difSL;
          edao().decrementSL(leaveEmpId, bal3);
        }
      }
    } else {
      s = "Employ Id Not Found";
    }
    return s;
  }
}

