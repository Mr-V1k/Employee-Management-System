package dev.v1k.Employee.Management.System.service;

import dev.v1k.Employee.Management.System.dto.EmployeeProfileDto;
import dev.v1k.Employee.Management.System.dto.EmployeeTimesheetDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeTimesheetService {

    EmployeeTimesheetDto createNewTimesheet(UUID employee_id, EmployeeTimesheetDto employeeTimesheetDto);

    List<EmployeeTimesheetDto> getAllTimeSheetsByEmployeeId(UUID employee_id);

    EmployeeTimesheetDto getTimesheetById(UUID id);

    EmployeeTimesheetDto updateReview(UUID employeeId, UUID timesheetId, EmployeeTimesheetDto employeeTimesheetDto);

    void deleteTimesheet(UUID employeeId, UUID timesheetId);
}
