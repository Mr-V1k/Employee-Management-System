package dev.v1k.Employee.Management.System.dto;

import java.time.LocalTime;
import java.util.UUID;

public class EmployeeTimesheetDto {
    private UUID id;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private double totalHours;

    public EmployeeTimesheetDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public EmployeeTimesheetDto(UUID id, LocalTime checkInTime, LocalTime checkOutTime, double totalHours) {
        this.id = id;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.totalHours = totalHours;
    }
}
