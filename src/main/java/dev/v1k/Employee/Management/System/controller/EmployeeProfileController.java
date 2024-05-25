package dev.v1k.Employee.Management.System.controller;

import dev.v1k.Employee.Management.System.dto.EmployeeProfileDto;
import dev.v1k.Employee.Management.System.service.impl.EmployeeDetailsServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee-profile")
public class EmployeeProfileController {
    private final EmployeeDetailsServiceImpl employeeDetailsService;

    @Autowired
    public EmployeeProfileController(EmployeeDetailsServiceImpl employeeDetailsService){
        this.employeeDetailsService = employeeDetailsService;
    }

    @GetMapping
    public String employeeApi(){
        return "Employee API";
    }

    @PostMapping("create")
    public ResponseEntity<EmployeeProfileDto> addEmployee(@RequestBody EmployeeProfileDto employeeProfileDto){
        return ResponseEntity.ok(employeeDetailsService.createEmployee(employeeProfileDto));
    }

    @GetMapping("get-one/{id}")
    public ResponseEntity<EmployeeProfileDto> getEmployeeDetails(@PathVariable UUID id){
        return ResponseEntity.ok(employeeDetailsService.getEmployee(id));
    }

    @GetMapping("get-all")
    public ResponseEntity<List<EmployeeProfileDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeDetailsService.getAllEmployees());
    }

    @PutMapping("update/{employeeId}")
    public ResponseEntity<EmployeeProfileDto> updateEmployee(
            @PathVariable("employeeId") UUID employeeId,
            @RequestBody EmployeeProfileDto employeeProfileDto
    ){
        return ResponseEntity.ok(
                employeeDetailsService.updateEmployee(
                    employeeProfileDto,
                    employeeId
                )
        );
    }

    @DeleteMapping("delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") UUID employeeId){
        employeeDetailsService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Deleted the user with id " + employeeId);
    }
}
