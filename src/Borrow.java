

import java.util.Date;
import java.util.Objects;

public class Borrow {
    private Book book;
    private User borrower;
    private Date issuedDate;
    private Date deadlineDate;
    public static final int MAX_LIMIT_DATE = 14;//number of days

    public Borrow(Book book, User borrower, Date deadlineDate) {
        this.book = book;
        this.borrower = borrower;
        issuedDate = new Date();
        this.deadlineDate = deadlineDate;
    }

    public void print(){
        System.out.println("Borrower => Full Name: " + borrower.getFirstName() + " " + borrower.getLastName() + " | Author: " + borrower.getIdNum());
        System.out.println("Book => Title: " + book.getTitle() + " | Author: " + book.getAuthor());
        System.out.println("IssuedData => " + issuedDate );
        System.out.println("Deadline => " + deadlineDate );
        System.out.println("Remaining => " + (deadlineDate.getDate() - issuedDate.getDate()));
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrow)) return false;
        Borrow borrow = (Borrow) o;
        return book.equals(borrow.book) &&
                borrower.equals(borrow.borrower) &&
                issuedDate.equals(borrow.issuedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, borrower, issuedDate);
    }
}
