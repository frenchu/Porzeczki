package org.frenchman.borrowings.application.internal.dao.impl;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.frenchman.borrowings.application.internal.dao.PersonDao;
import org.frenchman.borrowings.domain.items.Person;
import org.frenchman.borrowings.domain.items.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/spring/context/hibernate-application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDaoHibernateTest {

  @Inject
  PersonDao personDaoHibernate;
  
  @Test
  @Transactional
  public void testGetPersonById() {
    // given
    Person person = new Person();
    person.setName("Jacek");
    person.setSurname("Poczatek");
    
    // when
    personDaoHibernate.save(person);
    
    // then
    Person queriedPerson = personDaoHibernate.getPersonBySurname(person.getSurname());
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
    personDaoHibernate.save(user);
    
    // then
    User queriedUser = (User) personDaoHibernate.getPersonBySurname(user.getSurname());
    assertNotNull(queriedUser);
    assertEquals(queriedUser.getSurname(), user.getSurname());
    assertEquals(queriedUser.getName(), user.getName());
    assertEquals(queriedUser.getLogin(), user.getLogin());
    assertEquals(queriedUser.getPassword(), user.getPassword());
    assertEquals(queriedUser.getEmail(), user.getEmail());
  }

}
