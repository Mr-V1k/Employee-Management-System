package dev.v1k.Employee.Management.System.repository;

import dev.v1k.Employee.Management.System.entity.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, UUID> {
}
