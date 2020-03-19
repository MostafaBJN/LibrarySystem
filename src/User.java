

import java.util.Objects;

public class User {
    String firstName;
    String lastName;
    String idNum;
    //int numberOfBorrowedBookNow;
    //int numberOfBorrowedBookTotal;

    public User (String firstName, String lastName, String idNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNum = idNum;
        //numberOfBorrowedBookNow = 0;
        //numberOfBorrowedBookTotal = 0;
    }

    public void print() {
        System.out.println("Full Name: " + firstName + " " + lastName + " | ID: " + idNum);
    }

    public void printFullData() {
        System.out.println("Full Name: " + firstName + " " + lastName + " | ID: " + idNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return idNum.equals(user.idNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNum);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

}
