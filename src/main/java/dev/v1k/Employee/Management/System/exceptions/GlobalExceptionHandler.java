package dev.v1k.Employee.Management.System.exceptions;

import org.apache.coyote.Response;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorObject> handleEmployeeNotFoundException(
            EmployeeNotFoundException ex
    ){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        errorObject.setStatusCode(HttpStatus.NOT_FOUND);
        errorObject.setTimestamp(new Date());

        return new ResponseEntity<ErrorObject>(errorObject, errorObject.getStatusCode());
    }

    @ExceptionHandler(TimesheetNotFoundException.class)
    public ResponseEntity<ErrorObject> handleTimesheetNotFoundException(
            TimesheetNotFoundException ex
    ){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        errorObject.setStatusCode(HttpStatus.NOT_FOUND);
        errorObject.setTimestamp(new Date());

        return new ResponseEntity<ErrorObject>(errorObject, errorObject.getStatusCode());
    }

}
