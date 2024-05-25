package dev.v1k.Employee.Management.System.service.impl;

import dev.v1k.Employee.Management.System.contants.Constants;
import dev.v1k.Employee.Management.System.dto.EmployeeProfileDto;
import dev.v1k.Employee.Management.System.entity.EmployeeProfile;
import dev.v1k.Employee.Management.System.exceptions.EmployeeNotFoundException;
import dev.v1k.Employee.Management.System.mapper.EmployeeMapper;
import dev.v1k.Employee.Management.System.repository.EmployeeProfileRepository;
import dev.v1k.Employee.Management.System.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
    private final EmployeeProfileRepository employeeProfileRepository;

    @Autowired
    EmployeeDetailsServiceImpl(EmployeeProfileRepository employeeProfileRepository){
        this.employeeProfileRepository = employeeProfileRepository;
    }

    @Override
    public List<EmployeeProfileDto> getAllEmployees() {
        return employeeProfileRepository
                .findAll()
                .stream()
                .map(EmployeeMapper::mapToEmployeeProfileDto)
                .toList();
    }

    @Override
    public EmployeeProfileDto getEmployee(UUID id) {
        return EmployeeMapper.mapToEmployeeProfileDto(
                employeeProfileRepository
                        .findById(id)
                        .orElseThrow(() -> new EmployeeNotFoundException(Constants.employeeNotFoundMessage))
        );
    }

    @Override
    public EmployeeProfileDto createEmployee(EmployeeProfileDto employeeProfileDto) {
        EmployeeProfile newEmp = EmployeeMapper.mapToEmployeeProfile(employeeProfileDto);
        return EmployeeMapper.mapToEmployeeProfileDto(
                employeeProfileRepository.save(newEmp)
        );
    }

    @Override
    public EmployeeProfileDto updateEmployee(
            EmployeeProfileDto employeeProfileDto,
            UUID employeeId
    ) {
        EmployeeProfile employeeProfile = employeeProfileRepository
                .findById(employeeId)
                .orElseThrow(
                        () -> new EmployeeNotFoundException(
                                Constants.employeeNotFoundMessage
                        )
                );
        assert employeeProfile != null;
        employeeProfile.setName(employeeProfileDto.getName());
        employeeProfile.setDepartment(employeeProfileDto.getDepartment());
        employeeProfile.setEmail(employeeProfileDto.getEmail());
        return EmployeeMapper.mapToEmployeeProfileDto(employeeProfileRepository.save(employeeProfile));
    }

    @Override
    public void deleteEmployee(UUID id) {
        EmployeeProfile employeeProfile = employeeProfileRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(Constants.employeeNotFoundMessage));
        employeeProfileRepository.delete(employeeProfile);
    }
}
