package org.frenchman.borrowings.domain.items;

import java.util.Date;

public class LentItem {
  private Long id;
  private Person lender;
  private Person borrower;
  private Item borrowing;
  private Date lentDate;
  private Date returnDate;
  
  public Long getId() {
    return id;
  }

  @SuppressWarnings("unused")
  private void setId(Long id) {
    this.id = id;
  }
  
  public Person getLender() {
    return lender;
  }

  public void setLender(Person lender) {
    this.lender = lender;
  }

  public Person getBorrower() {
    return borrower;
  }

  public void setBorrower(Person borrower) {
    this.borrower = borrower;
  }

  public Item getBorrowing() {
    return borrowing;
  }

  public void setBorrowing(Item borrowing) {
    this.borrowing = borrowing;
  }

  public Date getLentDate() {
    return lentDate;
  }

  public void setLentDate(Date lentDate) {
    this.lentDate = lentDate;
  }

  public Date getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }
}
