# Employee-Management-System
***

## Employee Profile API
***
* Employee Profile API has endpoints with suffix `api/employee-profile`.

### Create Employee
***
* Endpoint: `create`
* Need a request body of EmployeeDto
```json
{
  "name": "Bruce Wayne",
  "email": "wayne@gmail.com",
  "department": "VP"
}
```
### Get Employee by their ID
***
* Endpoint: `get-one/{employeeId}`

### Get all Employees
***
* Endpoint: `get-all`

### Update Employee
***
* Endpoint: `update/{employeeId}`
* Throws: Employee Not Found Exception
* Need employeeDto
```json
{
    "name": "Sathvik",
    "email": "sathvik@gmail.com",
    "department": "CSE"
}
```

### Delete Employee
***
* Endpoint `delete/{employeeId}`
* Throws: Employee Not Found Exception

## Employee Timesheet API
***
Timesheet API has suffix `api/timesheet`.
### Create a new Timesheet for the Employee
***
* Endpoint: `create/{employeeId}`
* Throws: Employee Not Found Exception
* Need a request body of type EmployeeTimesheetDto:
```json
{
    "checkInTime": "09:00:00.000",
    "checkOutTime": "18:30:00.000",
    "totalHours": "10.25"
}
```

### Get one timesheet by its id
***
* Endpoint: `get-one/{timesheetId}`
* Throws: Timesheet not found Exception

### Get all timesheet by employee id
***
* Endpoint: `get-all/{employeeId}`
* Throws: Employee Not Found Exception

### Update timesheet of employee with it's id
***
* Endpoint: `update/{employeeId}/{timesheetId}`
* Throws: Employee Not Found exception, Timesheet not found exception
* Needs a request body like EmployeeTimesheetDto
```json
{
    "checkInTime": "09:15:00",
    "checkOutTime": "17:30:00",
    "totalHours": 8.25
}
```

### Delete timesheet of an employee
***
* Endpoint: `delete/{employeeId}/{timesheetId}`
* Throws: Employee Not Found exception, Timesheet Not Found exception
