package org.frenchman.borrowings.application.internal.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.frenchman.borrowings.application.internal.dao.PersonDao;
import org.frenchman.borrowings.domain.items.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoJpa implements PersonDao {

  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void save(Person person) {
    entityManager.persist(person);
  }

  @Override
  public Person getPersonById(Long id) {
    return (Person) entityManager.find(Person.class, id);
  }

  @Override
  public Person getPersonBySurname(String surname) {
    Query query = entityManager.createQuery("from Person as p where p.surname = :surname");
    query.setParameter("surname", surname);
    return (Person) query.getSingleResult();
  }
  
  public static void main(String[] args) {
    
  }
}
