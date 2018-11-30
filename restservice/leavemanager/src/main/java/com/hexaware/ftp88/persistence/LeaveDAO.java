package com.hexaware.ftp88.persistence;

import com.hexaware.ftp88.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for LeaveDetails.
 */
public interface LeaveDAO {
  /**
   * return all the details of all the LeaveDetails.
   * @return the LeaveDetails array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the details of the selected LEAVE_DETAILS.
   * @param leaID the id of the LEAVE_DETAILS
   * @return the LEAVE_DETAILS object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEA_ID = :leaID")
  @Mapper(LeaveMapper.class)
  LeaveDetails find(@Bind("leaID") int leaID);
  /**
   * return all the details of the selected employee.
   * @param leaveEmpId the id of the employee
   * @param leaveStartDate leaveStartDate of employee
   * @param leaveEndDate leaveEndDate of employee.
   * @return the total record count
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS "
      +    " WHERE LEA_STARTDATE BETWEEN :leaveStartDate AND :leaveEndDate "
      + " AND LEA_EMPID = :leaveEmpId")
  int count(@Bind("leaveEmpId") int leaveEmpId, @Bind("leaveStartDate") String leaveStartDate,
      @Bind("leaveEndDate") String leaveEndDate);
/**
   * @param leaveMgrComment Updated Manager Response data.
   * @param leavestatus Updated Manager Status data.
   * @param leaveId the id of the LeaveDetails
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEA_MGRCOMMENT = :leaveMgrComment, LEA_STATUS = :leavestatus WHERE "
      + "LEA_ID = :leaveId")
  void comment(@Bind("leaveMgrComment") String leaveMgrComment, @Bind("leavestatus") String leavestatus,
      @Bind("leaveId") int leaveId);

/**
   * @param leaveDays to initialize employee id.
   * @param leaveStartDate to initialize employee id.
   * @param leaveEndDate to initialize employee id.
   * @param leaveEmpId to initialize employee id.
   * @param leaveReason to initialize employee id.
   * @param leaveAppliedOn to initialize employee id.
   * @param leavestatus to initialize employee id.
   * @param leavetype to initialize employee id.
  */

  @SqlUpdate("insert into LEAVE_DETAILS "
      +
      "             (LEA_NO_OF_DAYS, "
      +
      "              LEA_STARTDATE, "
      +
      "              LEA_ENDDATE, "
      +
      "              LEA_EMPID, "
      +
      "              LEA_REASONS, "
      +
      "              LEA_APPLIEDON, "
      +
      "              LEA_STATUS, "
      +
      "              LEA_TYPE) "
      +
      "values       ( "
      +
      "              :leaveDays, "
      +
      "              :leaveStartDate, "
      +
      "              :leaveEndDate, "
      +
      "              :leaveEmpId, "
      +
      "              :leaveReason, "
      +
      "              :leaveAppliedOn, "
      +
      "              :leavestatus, "
      +
      "              :leavetype)")

void apply(@Bind("leaveDays") int leaveDays,
       @Bind("leaveStartDate") String leaveStartDate,
       @Bind("leaveEndDate") String leaveEndDate,
       @Bind("leaveEmpId") int leaveEmpId,
       @Bind("leaveReason") String leaveReason,
       @Bind("leaveAppliedOn") String leaveAppliedOn,
       @Bind("leavestatus") String leavestatus,
       @Bind("leavetype") String leavetype);
 /**
   * return all the details of the Pending LeaveDetails.
   * @param empId the id of the LeaveDetails
   * @return the LeaveDetails Array object
   */

  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEA_EMPID IN "
      + " (SELECT E2.EMP_ID FROM "
      + " EMPLOYEE_DETAILS E1 INNER JOIN "
      + " EMPLOYEE_DETAILS E2 ON E1.EMP_ID = E2.EMP_MGRID  WHERE E1.EMP_ID=:empId) AND "
      + " LEA_STATUS='PENDING'")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> pending(@Bind("empId") int empId);
  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the total record count
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEA_EMPID = :empID")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> empHistory(@Bind("empID") int empID);
  /**
   * return all the details of the selected employee.
   * @param leaveId the id of the employee
   * @return the ManagerID value
   */
  @SqlQuery("SELECT E1.EMP_ID FROM Employee_DETAILS E1 "
      + " JOIN Employee_DETAILS E2 ON E1.EMP_ID=E2.EMP_MGRID WHERE E2.EMP_ID =(SELECT LEA_EMPID FROM LEAVE_DETAILS "
      + "   WHERE LEA_ID = :leaveId)")
      int showManager(@Bind("leaveId") int leaveId);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
