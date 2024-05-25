package dev.v1k.Employee.Management.System.service;

import dev.v1k.Employee.Management.System.dto.EmployeeProfileDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeDetailsService {
    List<EmployeeProfileDto> getAllEmployees();

    EmployeeProfileDto getEmployee(UUID employeeId);

    EmployeeProfileDto createEmployee(EmployeeProfileDto employeeProfileDto);

    EmployeeProfileDto updateEmployee(EmployeeProfileDto employeeProfileDto, UUID employeeId);

    void deleteEmployee(UUID employeeId);
}
