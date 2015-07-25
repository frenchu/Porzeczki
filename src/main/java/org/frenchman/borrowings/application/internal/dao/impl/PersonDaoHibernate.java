package org.frenchman.borrowings.application.internal.dao.impl;

import javax.inject.Inject;

import org.frenchman.borrowings.application.internal.dao.PersonDao;
import org.frenchman.borrowings.domain.items.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoHibernate implements PersonDao {

  @Inject
  private SessionFactory sessionFactory;
  
  @Override
  public void save(Person person) {
    sessionFactory.getCurrentSession().saveOrUpdate(person);
  }

  @Override
  public Person getPersonById(Long id) {
    return (Person) sessionFactory.getCurrentSession().get(Person.class, id);
  }

  @Override
  public Person getPersonBySurname(String surname) {
    return (Person) sessionFactory.getCurrentSession()
        .createQuery("select Person where surname = ?")
        .setString(0, surname)
        .uniqueResult();
  }
}
