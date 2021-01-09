package com.gants.rgm.alphaservice.controllers;

import com.gants.rgm.alphaservice.models.Employee;
import com.gants.rgm.alphaservice.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EmployeeController {
  @Autowired
  EmployeeServiceImpl employeeService;

  @GetMapping("/employee")
  public Collection<Employee> getEmployees() {
    return employeeService.read();
  }

  @PostMapping("/employee")
  @ResponseStatus(HttpStatus.CREATED)
  public Employee create(@RequestBody Employee employee) {
    return employeeService.create(employee);
  }
}
