package com.hexaware.ftp88.persistence;

import com.hexaware.ftp88.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE_DETAILS")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);
  // /**
  //  * Update LeaveBalance for selected employee.
  //  * @param empID the id of the employee.
  //  * @param leaveTaken no of days employee applied leave.
  //  */
  // @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_ELBAL = :leaveTaken WHERE EMP_ID = :empID")
  // void decrement(@Bind("empID") int empID, @Bind("leaveTaken") int leaveTaken);
  /**
   * Update LeaveBalance for selected employee.
   * @param empID the id of the employee.
   * @param leaveTaken no of days employee applied leave.
   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_ELBAL = :leaveTaken WHERE EMP_ID = :empID")
  void decrementEL(@Bind("empID") int empID, @Bind("leaveTaken") int leaveTaken);
  /**
   * Update LeaveBalance for selected employee.
   * @param empID the id of the employee.
   * @param leaveTaken no of days employee applied leave.
   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_MLBAL = :leaveTaken WHERE EMP_ID = :empID")
  void decrementML(@Bind("empID") int empID, @Bind("leaveTaken") int leaveTaken);
  /**
   * Update LeaveBalance for selected employee.
   * @param empID the id of the employee.
   * @param leaveTaken no of days employee applied leave.
   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_SLBAL = :leaveTaken WHERE EMP_ID = :empID")
  void decrementSL(@Bind("empID") int empID, @Bind("leaveTaken") int leaveTaken);
// /**
//    * Updated LeaveBalnce after Rejection for selected employee.
//    * @param empID the id of the employee.
//    * @param leaveDays for Leave Table of employee.

//    */
//   @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_LEAVEBAL = EMP_LEAVEBAL + :leaveDays WHERE EMP_ID = :empID")
//   void increment(@Bind("empID") int empID, @Bind("leaveDays") int leaveDays);
  /**
   * Updated LeaveBalnce after Rejection for selected employee.
   * @param empID the id of the employee.
   * @param leaveDays for Leave Table of employee.

   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_ELBAL = EMP_ELBAL + :leaveDays WHERE EMP_ID = :empID")
  void incrementEL(@Bind("empID") int empID, @Bind("leaveDays") int leaveDays);
  /**
   * Updated LeaveBalnce after Rejection for selected employee.
   * @param empID the id of the employee.
   * @param leaveDays for Leave Table of employee.

   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_MLBAL = EMP_MLBAL + :leaveDays WHERE EMP_ID = :empID")
  void incrementML(@Bind("empID") int empID, @Bind("leaveDays") int leaveDays);
  /**
   * Updated LeaveBalnce after Rejection for selected employee.
   * @param empID the id of the employee.
   * @param leaveDays for Leave Table of employee.

   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_SLBAL = EMP_SLBAL + :leaveDays WHERE EMP_ID = :empID")
  void incrementSL(@Bind("empID") int empID, @Bind("leaveDays") int leaveDays);



  /**
  * close with no args is used to close the connection.
  */
  void close();
}
