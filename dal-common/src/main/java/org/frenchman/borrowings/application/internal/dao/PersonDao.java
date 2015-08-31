package org.frenchman.borrowings.application.internal.dao;

import java.util.List;

import org.frenchman.borrowings.domain.items.Person;

public interface PersonDao {
  
  void save(Person person);

  void remove(Person person);
  
  Person getPersonById(Long id);

  Person getPersonBySurname(String surname);
  
  List<Person> getAllPersons();

}
