package dev.v1k.Employee.Management.System.controller;

import dev.v1k.Employee.Management.System.dto.EmployeeTimesheetDto;
import dev.v1k.Employee.Management.System.service.impl.EmployeeTimesheetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/timesheet")
public class EmployeeTimesheetController {
    @Autowired
    private EmployeeTimesheetServiceImpl employeeTimesheetService;

    @GetMapping
    public String timeSheetApi(){
        return "Timesheet API";
    }

    @PostMapping("create/{employee_id}")
    public ResponseEntity<EmployeeTimesheetDto> createTimesheet(
            @PathVariable UUID employee_id,
            @RequestBody EmployeeTimesheetDto employeeTimesheetDto
    ){
        return ResponseEntity.ok(
                employeeTimesheetService.createNewTimesheet(
                        employee_id,
                        employeeTimesheetDto
                )
        );
    }

    @GetMapping("get-one/{id}")
    public ResponseEntity<EmployeeTimesheetDto> getTimesheetById(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(
                employeeTimesheetService.getTimesheetById(id)
        );
    }

    @GetMapping("get-all/{employee_id}")
    public ResponseEntity<List<EmployeeTimesheetDto>> getAllTimeSheets(@PathVariable UUID employee_id){
        return ResponseEntity.ok(
                employeeTimesheetService.getAllTimeSheetsByEmployeeId(employee_id)
        );
    }

    @PutMapping("update/{employeeId}/{timesheetId}")
    public ResponseEntity<EmployeeTimesheetDto> updateTimesheet(
            @PathVariable("employeeId") UUID employeeId,
            @PathVariable("timesheetId") UUID timesheetId,
            @RequestBody EmployeeTimesheetDto employeeTimesheetDto
    ){
        return ResponseEntity.ok(
                employeeTimesheetService.updateReview(
                        employeeId,
                        timesheetId,
                        employeeTimesheetDto
                )
        );
    }

    @DeleteMapping("delete/{employeeId}/{timesheetId}")
    public ResponseEntity<String> deleteTimesheet(@PathVariable("employeeId") UUID employeeId, @PathVariable("timesheetId") UUID timesheetId) {
        employeeTimesheetService.deleteTimesheet(
                employeeId,
                timesheetId
        );
        return ResponseEntity.ok("Successfully deleted timesheet of id " + timesheetId);
    }
}
