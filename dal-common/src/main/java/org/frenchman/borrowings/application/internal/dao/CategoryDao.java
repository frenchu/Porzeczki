package org.frenchman.borrowings.application.internal.dao;

import org.frenchman.borrowings.domain.items.Category;

public interface CategoryDao {

  void save(Category category);
  
  void delete(Category category);
}
