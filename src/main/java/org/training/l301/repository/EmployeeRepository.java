package org.training.l301.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.training.l301.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
