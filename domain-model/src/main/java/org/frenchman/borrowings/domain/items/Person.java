package org.frenchman.borrowings.domain.items;

public class Person {
  private Long id;
  private String name;
  private String surname;
  private String additionalInfo;
  
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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }
  
  @Override
  public String toString() {
    return "[" + getSurname()
      + ", " + getName()
      + ", " + getAdditionalInfo()
      + "]";
  }
}
