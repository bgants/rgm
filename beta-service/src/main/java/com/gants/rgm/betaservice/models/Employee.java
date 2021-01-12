package com.gants.rgm.betaservice.models;

import javax.validation.constraints.Size;
public class Employee {

  @Size(min = 3, max = 20)
  private String name;

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Employee{" +
        ", name='" + name + '\'' +
        '}';
  }

}
