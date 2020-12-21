package com.gants.rgm.alphaservice.repository;

import com.gants.rgm.alphaservice.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  public Employee findByName(String name);
}
