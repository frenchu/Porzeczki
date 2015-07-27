package org.frenchman.borrowings.application.internal.dao.hibernate;

import java.util.List;

import javax.inject.Inject;

import org.frenchman.borrowings.application.internal.dao.LentItemDao;
import org.frenchman.borrowings.domain.items.LentItem;
import org.frenchman.borrowings.domain.items.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LentItemDaoHibernate implements LentItemDao {

  @Inject
  private SessionFactory sessionFactory;

  @Override
  public void save(LentItem lentItem) {
    sessionFactory.getCurrentSession().saveOrUpdate(lentItem);
  }

  @Override
  public List<LentItem> findAllByLender(Person lender) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<LentItem> findAllByBorrower(Person borrower) {
    // TODO Auto-generated method stub
    return null;
  }
  
  
}
