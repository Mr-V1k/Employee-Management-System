package dev.v1k.Employee.Management.System.mapper;

import dev.v1k.Employee.Management.System.dto.EmployeeTimesheetDto;
import dev.v1k.Employee.Management.System.entity.EmployeeTimesheet;

public class EmployeeTimesheetMapper {
    public static EmployeeTimesheetDto toEmployeeTimeSheetDto(
            EmployeeTimesheet employeeTimesheet
    ){
        return new EmployeeTimesheetDto(
                employeeTimesheet.getId(),
                employeeTimesheet.getCheckInTime(),
                employeeTimesheet.getCheckOutTime(),
                employeeTimesheet.getTotalHours()
        );
    }

    public static EmployeeTimesheet toEmployeeTimesheet(EmployeeTimesheetDto employeeTimesheetDto){
        return new EmployeeTimesheet(
                employeeTimesheetDto.getId(),
                employeeTimesheetDto.getCheckInTime(),
                employeeTimesheetDto.getCheckOutTime(),
                employeeTimesheetDto.getTotalHours()
        );
    }


}
