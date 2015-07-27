package org.frenchman.borrowings.domain.items;

public class Item {
  private Long id;
  private String name;
  private String description;
  private Category category;
  
  public Long getId() {
    return id;
  }
  
  @SuppressWarnings("unused")
  private void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
