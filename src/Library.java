

import java.util.*;

public class Library {
    private ArrayList<User> users;//no duplicate by idNum
    private ArrayList<Book> books;//no duplicate by title and author
    private ArrayList<Borrow> borrows;
    private String name;
    private String address;
    private HashMap<String, String> addresses;

    public Library(String name,String address){
        users = new ArrayList<User>();
        books = new ArrayList<Book>();
        borrows = new ArrayList<Borrow>();
        addresses = new HashMap<String, String>();
        this.name = name;
        this.address = address;
        addresses.put(name, address);
    }

    public void addUser(User userToAdd){
        for (User user : users) {
            if(user.equals(userToAdd)){
                System.out.println("This User is Already Exist !");
                System.out.print("Please Insert New First Name : ");
                String firstName = new Scanner(System.in).next();
                System.out.print("Please Insert New Last Name : ");
                String lastName = new Scanner(System.in).next();
                String idNum;
                while(true) {
                    System.out.print("Please Insert New ID Number : ");
                    idNum = new Scanner(System.in).next();
                    if(idNum.length() != 10){
                        System.out.println("Please Insert A 10 Digit Number !");
                    }
                    else{
                        break;
                    }
                }
                addUser(new User(firstName, lastName, idNum));
                return;
            }
        }
        users.add(userToAdd);
    }

    public void removeUser(User userToRemove){
        Iterator<User> itUsers = users.iterator();
        Iterator<Borrow> itBorrows = borrows.iterator();
        //Check if this user exists
        while (itUsers.hasNext()){
            if (itUsers.next().equals(userToRemove)) {
                //Check if this user have not borrowed any book
                while (itBorrows.hasNext()){
                    if (itBorrows.next().getBorrower().equals(userToRemove)) {
                        System.out.println("User didn't Give Back All Books He Borrowed !");
                        return;
                    }
                }
                itUsers.remove();
                System.out.println("User Removed Successfully !");
                return;
            }
        }
        System.out.println("User Not Founds !");
    }

    public void addBook(Book bookToAdd){
        for (Book book : books) {
            if(book.equals(bookToAdd)){
                System.out.println("This Book is Already Exist !");
                System.out.print("Please Insert New Title : ");
                String title = new Scanner(System.in).next();
                System.out.print("Please Insert New Author : ");
                String author = new Scanner(System.in).next();
                addBook(new Book(title, author,"",""));
                return;
            }
        }
        books.add(bookToAdd);
    }

    public void removeBook(Book bookToRemove){
        Iterator<Book> itBooks = books.iterator();
        Iterator<Borrow> itBorrows = borrows.iterator();
        //Check if this book exists
        while (itBooks.hasNext()){
            if (itBooks.next().equals(bookToRemove)) {
                //Check if this book haven't been borrow
                while (itBorrows.hasNext()){
                    if (itBorrows.next().getBook().equals(bookToRemove)) {
                        System.out.println("Book didn't Given Back to Library !");
                        return;
                    }
                }
                itBooks.remove();
                System.out.println("Book Removed Successfully !");
                return;
            }
        }
        System.out.println("Book Not Founds !");
    }

    public void borrowBook(Book bookToBorrow, User borrower, Date deadline){
        for (Borrow borrow : borrows) {
            if(borrow.getBook().equals(bookToBorrow)){
                System.out.println("This Book has Already been Borrowed !");
                return;
            }
        }
        System.out.println("Book Borrowed Successfully !");
        borrows.add(new Borrow(bookToBorrow, borrower, deadline));
        bookToBorrow.setStateInLibrary(false);
    }

    public void giveBackBook(Borrow borrowToGiveBack){
        Iterator<Borrow> itBorrow = borrows.iterator();
        while (itBorrow.hasNext()) {
            Borrow borrow = itBorrow.next();
            if (borrow.equals(borrowToGiveBack)) {
                borrow.getBook().setStateInLibrary(true);
                itBorrow.remove();
                System.out.println("Book Given Back Successfully !");
                return;
            }
        }
        System.out.println("Book Not Borrowed !");
    }

    public void printPassedDeadlineBorrows(){
        for (Borrow borrow : borrows){
            if(borrow.getDeadlineDate().before(new Date())){
                borrow.print();
            }
        }
    }

    public User findUser(String idNum){
        for (User user : users) {
            if(user.getIdNum().equals(idNum)) {
                return user;
            }
        }
        System.out.println("User Not Founds !");
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return name.equals(library.name) &&
                address.equals(library.address);
    }

    @Override
    public int hashCode() { return Objects.hash(name, address); }

    public ArrayList<User> getUsers() { return users; }

    public void setUsers(ArrayList<User> users) { this.users = users; }

    public ArrayList<Book> getBooks() { return books; }

    public void setBooks(ArrayList<Book> books) { this.books = books; }

    public ArrayList<Borrow> getBorrows() { return borrows; }

    public void setBorrows(ArrayList<Borrow> borrows) { this.borrows = borrows; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public HashMap<String, String> getAddresses() { return addresses; }

    public void setAddresses(HashMap<String, String> addresses) { this.addresses = addresses; }
}
