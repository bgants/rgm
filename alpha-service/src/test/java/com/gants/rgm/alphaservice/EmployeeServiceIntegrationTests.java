package com.gants.rgm.alphaservice;

import com.gants.rgm.alphaservice.models.Employee;
import com.gants.rgm.alphaservice.repository.EmployeeRepository;
import com.gants.rgm.alphaservice.services.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceIntegrationTests {

  @MockBean()
  private EmployeeRepository employeeRepository;

  @InjectMocks
  private EmployeeServiceImpl employeeService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenValidListOfEmployees_thenEmployeesShouldBeFound() {
    Mockito.when(employeeRepository.findAll()).thenReturn(Arrays.asList(
        new Employee("Bob"),
        new Employee("Joe"),
        new Employee("Lisa")
    ));
    Collection<Employee> employees = employeeService.read();
    employees.forEach(employee -> {
      assert(employee.getName().equals("Bob")
          || employee.getName().equals("Joe")
          || employee.getName().equals("Lisa"));
    });
  }

  @Test
  public void whenEmployeeCreated_thenEmployeeServiceShouldNotReturnNull() {
    Mockito.when(employeeRepository.save(Mockito.any(Employee.class)))
        .thenReturn(new Employee("Bob"));

    Employee employee = new Employee("Bob");

    assertThat(employeeService.create(employee), is(notNullValue()));
  }
}
