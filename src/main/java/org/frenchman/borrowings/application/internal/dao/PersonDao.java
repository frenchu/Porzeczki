package org.frenchman.borrowings.application.internal.dao;

import org.frenchman.borrowings.domain.items.Person;

public interface PersonDao {
  
  void save(Person person);
  
  Person getPersonById(Long id);

  Person getPersonBySurname(String surname);
}
