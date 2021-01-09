package com.gants.rgm.alphaservice.services;

import com.gants.rgm.alphaservice.models.Employee;
import com.gants.rgm.alphaservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 EmployeeRepository employeeRepository;

 @Override
  public Employee create(Employee employee) {
    return employeeRepository.save(employee);
 }

  @Override
  public Collection<Employee> read() {
    return employeeRepository.findAll();
  }

  @Override
  public void update(Employee employee) {

  }

  @Override
  public void delete(Employee employee) {

  }

  @Override
  public Employee findEmployee(Employee employee) {
  return employeeRepository.findByName(employee.getName());
 }
}
