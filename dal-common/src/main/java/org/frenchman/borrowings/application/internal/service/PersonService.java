package org.frenchman.borrowings.application.internal.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.frenchman.borrowings.application.internal.dao.PersonDao;
import org.frenchman.borrowings.domain.items.Person;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {

  @Inject
  private PersonDao personDao; 
  
  public void save(Person person) {
    personDao.save(person);
  }
  
  public Person deletePersonBySurname(String surname) {
    Person person = getPersonBySurname(surname);
    if (person != null) {
      personDao.remove(person);
    }
    return person;
  }
  
  public Person getPersonById(Long id) {
    return personDao.getPersonById(id);
  }

  public Person getPersonBySurname(String surname) {
    try {
      return personDao.getPersonBySurname(surname);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }
  
  public List<Person> getAllPersons() {
    return personDao.getAllPersons();
  }

}
