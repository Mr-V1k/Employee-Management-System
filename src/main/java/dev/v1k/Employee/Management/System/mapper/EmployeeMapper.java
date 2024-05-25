package dev.v1k.Employee.Management.System.mapper;

import dev.v1k.Employee.Management.System.dto.EmployeeProfileDto;
import dev.v1k.Employee.Management.System.entity.EmployeeProfile;

public class EmployeeMapper {
    public static EmployeeProfileDto mapToEmployeeProfileDto(EmployeeProfile employeeProfile){
        return new EmployeeProfileDto(
                employeeProfile.getId(),
                employeeProfile.getName(),
                employeeProfile.getEmail(),
                employeeProfile.getDepartment()
        );
    }

    public static EmployeeProfile mapToEmployeeProfile(EmployeeProfileDto employeeProfileDto){
        return new EmployeeProfile(
                employeeProfileDto.getId(),
                employeeProfileDto.getName(),
                employeeProfileDto.getEmail(),
                employeeProfileDto.getDepartment()
        );
    }
}
