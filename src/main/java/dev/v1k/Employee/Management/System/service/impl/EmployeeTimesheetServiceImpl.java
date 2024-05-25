package dev.v1k.Employee.Management.System.service.impl;

import dev.v1k.Employee.Management.System.contants.Constants;
import dev.v1k.Employee.Management.System.dto.EmployeeTimesheetDto;
import dev.v1k.Employee.Management.System.entity.EmployeeProfile;
import dev.v1k.Employee.Management.System.entity.EmployeeTimesheet;
import dev.v1k.Employee.Management.System.exceptions.EmployeeNotFoundException;
import dev.v1k.Employee.Management.System.exceptions.TimesheetNotFoundException;
import dev.v1k.Employee.Management.System.mapper.EmployeeTimesheetMapper;
import dev.v1k.Employee.Management.System.repository.EmployeeProfileRepository;
import dev.v1k.Employee.Management.System.repository.EmployeeTimesheetRepository;
import dev.v1k.Employee.Management.System.service.EmployeeTimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeTimesheetServiceImpl implements EmployeeTimesheetService {

    private final EmployeeTimesheetRepository employeeTimesheetRepository;
    private final EmployeeProfileRepository employeeProfileRepository;

    @Autowired
    EmployeeTimesheetServiceImpl(EmployeeTimesheetRepository employeeTimesheetRepository, EmployeeProfileRepository employeeProfileRepository){
        this.employeeTimesheetRepository = employeeTimesheetRepository;
        this.employeeProfileRepository = employeeProfileRepository;
    }

    @Override
    public EmployeeTimesheetDto createNewTimesheet(
            UUID employee_id,
            EmployeeTimesheetDto employeeTimesheetDto
    ) {
        EmployeeProfile emp = employeeProfileRepository.findById(employee_id).orElseThrow(
                () -> new EmployeeNotFoundException(Constants.employeeNotFoundMessage)
        );
        EmployeeTimesheet employeeTimesheet = EmployeeTimesheetMapper.toEmployeeTimesheet(
                employeeTimesheetDto
        );
        employeeTimesheet.setEmployeeProfile(emp);
        return EmployeeTimesheetMapper.toEmployeeTimeSheetDto(
                employeeTimesheetRepository.save(
                        employeeTimesheet
                )
        );
    }

    @Override
    public List<EmployeeTimesheetDto> getAllTimeSheetsByEmployeeId(UUID employee_id) {
        return employeeTimesheetRepository
                .findByEmployeeProfileId(employee_id)
                .stream()
                .map(EmployeeTimesheetMapper::toEmployeeTimeSheetDto)
                .toList();
    }

    @Override
    public EmployeeTimesheetDto getTimesheetById(UUID id) {
        return EmployeeTimesheetMapper.toEmployeeTimeSheetDto(
                employeeTimesheetRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new TimesheetNotFoundException(Constants.timesheetNotFoundMessage)
                        )
        );
    }

    @Override
    public EmployeeTimesheetDto updateReview(UUID employeeId, UUID timesheetId, EmployeeTimesheetDto employeeTimesheetDto) {
        EmployeeProfile employeeProfile = employeeProfileRepository
                .findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(Constants.employeeNotFoundMessage));
        EmployeeTimesheet employeeTimesheet = employeeTimesheetRepository
                .findById(timesheetId)
                .orElseThrow(() -> new TimesheetNotFoundException(Constants.timesheetNotFoundMessage));

        assert employeeTimesheet != null;
        if(employeeTimesheet.getEmployeeProfile().getId() != employeeProfile.getId()){
            throw new TimesheetNotFoundException(Constants.getTimesheetNotFoundUnderUserMessage);
        }

        employeeTimesheet.setCheckInTime(employeeTimesheetDto.getCheckInTime());
        employeeTimesheet.setCheckOutTime(employeeTimesheetDto.getCheckOutTime());
        employeeTimesheet.setTotalHours(employeeTimesheetDto.getTotalHours());

        return EmployeeTimesheetMapper.toEmployeeTimeSheetDto(
                employeeTimesheetRepository.save(employeeTimesheet)
        );
    }

    @Override
    public void deleteTimesheet(UUID employeeId, UUID timesheetId) {
        EmployeeProfile employeeProfile = employeeProfileRepository
                .findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(Constants.employeeNotFoundMessage));
        EmployeeTimesheet employeeTimesheet = employeeTimesheetRepository
                .findById(timesheetId)
                .orElseThrow(() -> new TimesheetNotFoundException(Constants.timesheetNotFoundMessage));

        assert employeeTimesheet != null;
        assert employeeProfile != null;
        if(employeeTimesheet.getEmployeeProfile().getId() != employeeProfile.getId()){
            throw new RuntimeException();
        }

        employeeTimesheetRepository.delete(employeeTimesheet);

    }
}
