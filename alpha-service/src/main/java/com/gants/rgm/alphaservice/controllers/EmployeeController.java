package com.gants.rgm.alphaservice.controllers;

import com.gants.rgm.alphaservice.models.Employee;
import com.gants.rgm.alphaservice.services.EmployeeServiceImpl;
import com.gants.rgm.alphaservice.services.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
public class EmployeeController {
  @Autowired
  EmployeeServiceImpl employeeService;

  @Autowired
  MessageProducer messageProducer;

  @GetMapping("/employee")
  public Collection<Employee> getEmployees() {
    return employeeService.read();
  }

  @PostMapping("/employee")
  @ResponseStatus(HttpStatus.CREATED)
  public Employee create(@RequestBody Employee employee) {
    log.info(this.getClass().getName() + " creating user ");
    messageProducer.sendMessage(employee);
    return employeeService.create(employee);
  }
}
