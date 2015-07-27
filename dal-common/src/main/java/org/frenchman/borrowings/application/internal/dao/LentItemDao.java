package org.frenchman.borrowings.application.internal.dao;

import java.util.List;

import org.frenchman.borrowings.domain.items.LentItem;
import org.frenchman.borrowings.domain.items.Person;

public interface LentItemDao {

  void save(LentItem lentItem);
  
  List<LentItem> findAllByLender(Person lender);
  
  List<LentItem> findAllByBorrower(Person borrower);
}
