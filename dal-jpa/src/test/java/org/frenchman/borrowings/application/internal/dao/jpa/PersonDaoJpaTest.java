package org.frenchman.borrowings.application.internal.dao.jpa;

import javax.transaction.Transactional;

import org.frenchman.borrowings.application.internal.dao.PersonDaoTest;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("/spring/context/jpa-persistence-test-context.xml")
public class PersonDaoJpaTest extends PersonDaoTest {
  
  @Test(expected = EmptyResultDataAccessException.class)
  @Transactional
  public void testGetPersonBySurnameNonexisting() {
    personDao.getPersonBySurname("Nonexisting");
  }
}
