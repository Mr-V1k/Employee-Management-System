package dev.v1k.Employee.Management.System.repository;

import dev.v1k.Employee.Management.System.entity.EmployeeTimesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeTimesheetRepository extends JpaRepository<EmployeeTimesheet, UUID> {
    List<EmployeeTimesheet> findByEmployeeProfileId(UUID id);
}
