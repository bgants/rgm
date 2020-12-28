package com.gants.rgm.alphaservice;

import com.gants.rgm.alphaservice.models.Employee;
import com.gants.rgm.alphaservice.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTests {
  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Test
  public void whenFindByName_thenReturnEmployee() {
    //given
    Employee bob = new Employee("Bob");
    testEntityManager.persist(bob);
    testEntityManager.flush();

    //when
    Employee found = employeeRepository.findByName(bob.getName());

    // then
    assertThat(found.getName())
        .isEqualTo(bob.getName());
  }
}
