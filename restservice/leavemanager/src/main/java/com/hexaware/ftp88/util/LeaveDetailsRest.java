package com.hexaware.ftp88.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.hexaware.ftp88.model.LeaveDetails;
import com.hexaware.ftp88.model.Employee;

/**
 * This class provides a REST interface for the LeaveDetails entity.
 */
@Path("/leaves")
public class LeaveDetailsRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leavesList() {
    System.out.println("Employee List");
    final LeaveDetails[] leaves = LeaveDetails.listAll();
    return leaves;
  }

  /**
   * Returns a specific employee's leave  details.
   * @param empId the id of the Employee
   * @param ld the object of the LeaveDetails
   * @throws ParseException for Parsing errors.
   * @return the Leave details
   */

  @POST
  @Path("/applyleave/{empId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String employeeApplyLeave(@PathParam("empId") final int empId,
                   final LeaveDetails ld) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String leType = ld.getLeaveType().toString();
    String result = LeaveDetails.applyLeave(empId, ld.getLeaveDays(), sdf.format(ld.getLeaveStartDate()),
              sdf.format(ld.getLeaveEndDate()), ld.getLeaveReason(), sdf.format(ld.getLeaveAppliedOn()), leType);
    return result;
  }

    /**
   * Returns a specific employee's leave  details.
   * @param empId the id of the Employee
   * @param led the object of the LeaveDetails
   * @throws ParseException for Parsing errors.
   * @return the Leave details
   */
  @POST
  @Path("/approvedeny/{empId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String employeeapproveDeny(final LeaveDetails led, @PathParam("empId") final int empId)
  throws ParseException {
    String leStatus = led.getLeaveStatus().toString();
    String status = null;
    if (leStatus.equals("APPROVED")) {
      status = "YES";
    } else {
      status = "NO";
    }
    String results = LeaveDetails.approveDeny(led.getLeaveId(), status, led.getLeaveMgrComment(), empId);
    return results;
  }
    /**
   * Returns a specific employee's details.
   * @param leaveEmpId the id of the employee
   * @return the employee details
   */
  @GET
   @Path("/leavehistory/{leaveEmpId}")
   @Produces(MediaType.APPLICATION_JSON)
   public final LeaveDetails[] empHistory(@PathParam("leaveEmpId") final int leaveEmpId) {
    final Employee emp = Employee.listById(leaveEmpId);
    if (emp == null) {
      throw new NotFoundException("No such Employee ID :" + leaveEmpId);
    }
    final LeaveDetails[] l1 = LeaveDetails.leaveHis(leaveEmpId);
    if (l1.length == 0) {
      throw new NotFoundException("no such Leave Id exist :" + leaveEmpId);
    }
    return l1;
  }
  /**
   * Returns a specific employee's details.
   * @param leaveEmpId the id of the employee
   * @return the employee details
   */
  @GET
   @Path("/pending/{leaveEmpId}")
   @Produces(MediaType.APPLICATION_JSON)
   public final LeaveDetails[] empPenHistory(@PathParam("leaveEmpId") final int leaveEmpId) {
    final Employee emp = Employee.listById(leaveEmpId);
    if (emp == null) {
      throw new NotFoundException("No such Employee ID :" + leaveEmpId);
    }
    final LeaveDetails[] l1 = LeaveDetails.listPending(leaveEmpId);
    if (l1.length == 0) {
      throw new NotFoundException("no such Leave Id exist :" + leaveEmpId);
    }
    return l1;
  }
}
