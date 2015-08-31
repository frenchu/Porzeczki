package org.frenchman.borrowings.application.internal.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/context/jpa-persistence-test-context.xml")
public class PersonServiceTest {

  @Inject
  private PersonService personService;
  
  @Test
  public void testDeletePersonBySurname() {
    personService.deletePersonBySurname("Kowalski");
  }
}
