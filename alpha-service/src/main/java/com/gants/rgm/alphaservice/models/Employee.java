package com.gants.rgm.alphaservice.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="person" )
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Size(min = 3, max = 20)
  private String name;

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

}
