package org.frenchman.borrowings.application.internal.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.frenchman.borrowings.domain.items.Person;
import org.frenchman.borrowings.domain.items.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class PersonDaoTest {

  @Inject
  private PersonDao personDao;
  
  @BeforeClass
  public static void initSystemProperties() {
    System.setProperty("org.jboss.logging.provider", "slf4j");
  }
  
  @Test
  @Transactional
  public void testGetPersonById() {
    // given
    Person person = new Person();
    person.setName("Jacek");
    person.setSurname("Poczatek");
    
    // when
    personDao.save(person);
    
    // then
    Person queriedPerson = personDao.getPersonBySurname(person.getSurname());
    assertNotNull(queriedPerson);
    assertEquals(queriedPerson.getSurname(), person.getSurname());
    assertEquals(queriedPerson.getName(), person.getName());
  }
  
  @Test
  @Transactional
  public void testGetUserById() {
    // given
    User user = new User();
    user.setName("Pawel");
    user.setSurname("Weselak");
    user.setLogin("frenchu");
    user.setPassword("secret");
    user.setEmail("frenchu@o2.pl");
    
    // when
    personDao.save(user);
    
    // then
    User queriedUser = (User) personDao.getPersonBySurname(user.getSurname());
    assertNotNull(queriedUser);
    assertEquals(queriedUser.getSurname(), user.getSurname());
    assertEquals(queriedUser.getName(), user.getName());
    assertEquals(queriedUser.getLogin(), user.getLogin());
    assertEquals(queriedUser.getPassword(), user.getPassword());
    assertEquals(queriedUser.getEmail(), user.getEmail());
  }

}
