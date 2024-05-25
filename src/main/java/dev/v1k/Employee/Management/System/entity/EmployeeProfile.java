package dev.v1k.Employee.Management.System.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String department;

    @OneToMany(mappedBy = "employeeProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeTimesheet> employeeTimesheets = new ArrayList<>();

    public List<EmployeeTimesheet> getEmployeeTimesheets() {
        return employeeTimesheets;
    }

    public void setEmployeeTimesheets(List<EmployeeTimesheet> employeeTimesheets) {
        this.employeeTimesheets = employeeTimesheets;
    }

    public EmployeeProfile() {
    }

    public EmployeeProfile(UUID id, String name, String email, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
