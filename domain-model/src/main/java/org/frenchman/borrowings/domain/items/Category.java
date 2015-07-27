package org.frenchman.borrowings.domain.items;

public class Category {
  private Long id;
  private Category parentCategory;
  private String name;
  
  public Long getId() {
    return id;
  }
  
  @SuppressWarnings("unused")
  private void setId(Long id) {
    this.id = id;
  }
  
  public Category getParentCategory() {
    return parentCategory;
  }
  
  public void setParentCategory(Category parentCategory) {
    this.parentCategory = parentCategory;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
}
