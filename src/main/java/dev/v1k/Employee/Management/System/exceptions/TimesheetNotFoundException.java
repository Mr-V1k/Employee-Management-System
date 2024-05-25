package dev.v1k.Employee.Management.System.exceptions;

public class TimesheetNotFoundException extends RuntimeException {
    public TimesheetNotFoundException(String message){
        super(message);
    }
}
