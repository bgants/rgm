package com.gants.rgm.alphaservice.services;

import com.gants.rgm.alphaservice.models.Employee;

import java.util.Collection;

public interface EmployeeService {
  Employee create(Employee employee);
  Collection<Employee> read();
  void update(Employee employee);
  void delete(Employee employee);
  Employee findEmployee(Employee employee);
}
