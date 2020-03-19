

import javax.management.loading.PrivateClassLoader;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
/**
 *A Full library system with full access in menus.
 *
 *
 * @author Mostafa Bijani
 * @version 1.0
 */
public class TestLibrarySystem {
    public static Scanner scan = new Scanner(System.in);
    public static LibrarySystem librarySystem = new LibrarySystem();
    public static void main(String[] args) {
        test();
        mainMenu();
    }

    public static void mainMenu () {
        int choice;
        while (true) {
            System.out.println("***Main Menu***");
            System.out.println(
                    "1)Libraries\n" +
                    "2)Books\n" +
                    "3)Users\n" +
                    "4)Borrows\n" +
                    //"5)Test\n" +
                    "5)Exit");
            choice = scan.nextInt();
            switch (choice) {
                case (1):
                    LibrarysMenu();
                    break;
                case (2):
                    BooksMenu();
                    break;
                case (3):
                    UsersMenu();
                    break;
                case (4):
                    BorrowsMenu();
                    break;
                //case (5):
                  //  test();
                  //  break;
                case (5):
                    System.out.println("GoodBye");
                    return;
            }
        }
    }

    public static void test () {
        Library lib1 = new Library("A", "here");
        Library lib2 = new Library("B", "there");
        librarySystem.addLibrary(lib1);
        librarySystem.addLibrary(lib2);
        lib1.addUser(new User("A","AA","0000000001"));
        lib1.addUser(new User("B","BB","0000000002"));
        lib1.addUser(new User("C","CC","0000000003"));
        lib1.addUser(new User("D","DD","0000000004"));
        lib1.addUser(new User("E","EE","0000000005"));
        lib2.addUser(new User("A","AA","0000000006"));
        lib2.addUser(new User("B","BB","0000000007"));
        lib2.addUser(new User("C","CC","0000000008"));
        lib2.addUser(new User("D","DD","0000000009"));
        lib2.addUser(new User("E","EE","0000000010"));
        lib1.addBook(new Book("AAA","Z","",""));
        lib1.addBook(new Book("BBB","Y","",""));
        lib1.addBook(new Book("CCC","X","",""));
        lib1.addBook(new Book("DDD","W","",""));
        lib1.addBook(new Book("EEE","U","",""));
        lib2.addBook(new Book("ZZZ","A","",""));
        lib2.addBook(new Book("YYY","B","",""));
        lib2.addBook(new Book("XXX","C","",""));
        lib2.addBook(new Book("WWW","D","",""));
        lib2.addBook(new Book("UUU","E","",""));
    }

    public static void LibrarysMenu () {
        while (true) {
            System.out.println("***Libraries Menu***");
            System.out.println(
                    "1)Add Library\n" +
                    "2)Remove Library\n" +
                    "3)List of All Libraries\n" +
                    "4)Main Menu");
            int choice = scan.nextInt();
            Library lib;
            String libraryName;
            String libraryAddress;
            switch (choice) {
                case (1):
                    System.out.print("Enter Name of Library : ");
                    libraryName = scan.next();
                    System.out.print("Enter Address of Library : ");
                    libraryAddress = scan.next();
                    librarySystem.addLibrary(new Library(libraryName, libraryAddress));
                    break;
                case (2):
                    librarySystem.printAllLibraries();
                    System.out.print("Enter Name of Library : ");
                    libraryName = scan.next();
                    System.out.print("Enter Address of Library : ");
                    libraryAddress = scan.next();
                    librarySystem.removeLibrary(new Library(libraryName, libraryAddress));
                    break;
                case (3):
                    librarySystem.printAllLibraries();
                    break;
                case (4):
                    return;
            }
        }
    }

    private static Library chooseLibrary (){
        String libraryName;
        librarySystem.printAllLibraries();
        while(true) {
            System.out.print("Select a Library by Entering Its Name : ");
            libraryName = scan.next();
            for (Library lib : librarySystem.getLibraries()) {
                if (lib.getName().equals(libraryName) && lib.getAddress().equals(lib.getAddresses().get(libraryName))) {
                    return lib;
                }
            }
            System.out.println("Library Not Founds !");
        }
    }

    public static void BooksMenu () {
        Library library = chooseLibrary();
        while (true) {
            System.out.println("***Books Menu***");
            System.out.println(
                    "1)Add Book to This Library\n" +
                    "2)Remove Book from This Library\n" +
                    "3)List of All Books of This Library\n" +
                    "4)Change Selected Library\n" +
                    "5)Main Menu");
            int choice = scan.nextInt();
            String title;
            String author;
            switch (choice) {
                case (1):
                    System.out.println("Enter Title of Book");
                    title = scan.next();
                    System.out.println("Enter Author of Book");
                    author = scan.next();
                    library.addBook(new Book(title, author , "", ""));
                    break;
                case (2):
                    System.out.println("Enter Title of Book");
                    title = scan.next();
                    System.out.println("Enter Author of Book");
                    author = scan.next();
                    library.removeBook(new Book(title, author , "", ""));
                    break;
                case (3):
                    for (Book book : library.getBooks()) {
                        book.print();
                    }
                    break;
                case (4):
                    library = chooseLibrary();
                    break;
                case(5):
                    return;
            }
        }
    }

    public static void UsersMenu () {
        Library library = chooseLibrary();
        while (true) {
            System.out.println("***Users Menu***");
            System.out.println(
                    "1)Add User to This Library\n" +
                    "2)Remove User from This Library\n" +
                    "3)List of All Users of This Library\n" +
                    "4)Select A User\n" +
                    "5)Change Selected Library\n" +
                    "6)Main Menu");
            int choice = scan.nextInt();
            String firstName;
            String lastName;
            String idNum;
            switch (choice) {
                case (1):
                    System.out.print("Enter First Name of User : ");
                    firstName = scan.next();
                    System.out.print("Enter Last Name of User : ");
                    lastName = scan.next();
                    while (true) {
                        System.out.print("Enter ID Number of User : ");
                        idNum = scan.next();
                        if (idNum.length() != 10) {
                            System.out.println("Please Insert A 10 Digit Number !");
                        } else {
                            break;
                        }
                    }
                    library.addUser(new User(firstName, lastName, idNum));
                    break;
                case (2):
                    while (true) {
                        System.out.print("Enter ID Number of User : ");
                        idNum = scan.next();
                        if (idNum.length() != 10) {
                            System.out.println("Please Insert A 10 Digit Number !");
                        } else {
                            break;
                        }
                    }
                    library.removeUser(new User("", "", idNum));
                    break;
                case (3):
                    for (User user : library.getUsers()) {
                        user.print();
                    }
                    break;
                case (4):
                    if (userMenu(chooseUser(library),library))
                        return;
                    break;
                case (5):
                    library = chooseLibrary();
                    break;
                case (6):
                    return;
            }
        }
    }

    public static boolean userMenu(User user, Library library){
        while (true) {
            System.out.println("*** " + user.getFirstName() + " " + user.getLastName() + " Menu***");
            System.out.println(
                    "1)User Data\n" +
                    "2)User Detailed Data\n" +
                    "3)List of Borrowed Book\n" +
                    "4)Borrow A Book\n" +
                    "5)Give Back A Book\n" +
                    "6)Check Dead Lines\n" +
                    "7)Users Menu\n" +
                    "8)Main Menu");
            int choice = scan.nextInt();
            switch (choice) {
                case(1):
                    user.print();
                    break;
                case (2):
                    user.printFullData();
                    break;
                case (3):
                    for (Borrow borrow : library.getBorrows()) {
                        if(borrow.getBorrower().equals(user))
                            borrow.print();
                    }
                    break;
                case (4):
                    Date deadLineDate = new Date(new Date().getYear(),new Date().getMonth(),new Date().getDate()+Borrow.MAX_LIMIT_DATE,20,0,0);
                    Book book = findBook(library);
                    if(book != null) {
                        library.borrowBook(book, user, deadLineDate);
                    }
                    break;
                case (5):
                    book = findBookBorrowed(library);
                    if(book != null) {
                        for (Borrow borrow : library.getBorrows()) {
                            if (borrow.getBook().equals(book)) {
                                library.giveBackBook(borrow);
                                break;
                            }
                        }
                    }
                    break;
                case (6):
                    for (Borrow borrow : library.getBorrows()){
                        if(borrow.getBorrower().equals(user)){
                            if(borrow.getDeadlineDate().before(new Date())) {
                                borrow.print();
                            }
                        }
                    }
                    break;
                case (7):
                    return false;
                case (8):
                    return true;
            }
        }
    }

    private static Book findBook(Library bookLibrary){
        System.out.println("Enter Title of Book : ");
        String title = scan.next();
        System.out.println("Enter Author of Book : ");
        String author = scan.next();
        //System.out.println("Enter Translator of Book : ");
        //scan.next();
        //System.out.println("Enter Publisher of Book : ");
        //scan.next();
        Book bookToFind = new Book(title, author, "", "");
        for (Book book : bookLibrary.getBooks()){
            if(book.equals(bookToFind)) {
                if (book.isStateInLibrary()){
                    return book;
                } else {
                    System.out.println("Book has Already been Borrowed !");
                    return null;
                }
            }
        }
        System.out.println("Book Not Founds !");
        return null;
    }

    private static Book findBookBorrowed(Library bookLibrary){
        System.out.println("Enter Title of Book : ");
        String title = scan.next();
        System.out.println("Enter Author of Book : ");
        String author = scan.next();
        //System.out.println("Enter Translator of Book : ");
        //scan.next();
        //System.out.println("Enter Publisher of Book : ");
        //scan.next();
        Book bookToFind = new Book(title, author, "", "");
        for (Book book : bookLibrary.getBooks()){
            if(book.equals(bookToFind)) {
                if (!book.isStateInLibrary()){
                    return book;
                } else {
                    System.out.println("Book Not Borrowed !");
                    return null;
                }
            }
        }
        System.out.println("Book Not Founds !");
        return null;
    }

    private static User chooseUser(Library userLibrary){
        String idNum;
        User user;
        while(true) {
            System.out.print("Enter ID Number of User : ");
            idNum = scan.next();
            if(idNum.length() != 10){
                System.out.println("Please Insert A 10 Digit Number !");
                continue;
            }
            user = userLibrary.findUser(idNum);
            if(user != null){
                return user;

            }
        }
    }

    public static void BorrowsMenu() {
        Library library = chooseLibrary();
        while (true) {
            System.out.println("***Borrows Menu***");
            System.out.println(
                    "1)List of Borrowers\n" +
                    "2)List of Books Borrowed\n" +
                    "3)All Barrows\n" +
                    "4)Check All Dead Lines\n" +
                    "5)Change Dead Line Date of A Borrowed Book\n" +
                    "6)Main Menu");
            int choice = scan.nextInt();
            switch (choice) {
                case (1):
                    for(Borrow borrow : library.getBorrows()) {
                        borrow.getBorrower().print();
                    }
                   break;
                case (2):
                    for(Borrow borrow : library.getBorrows()) {
                        borrow.getBook().print();
                    }
                    break;
                case (3):
                    for (Borrow borrow : library.getBorrows()) {
                        borrow.print();
                    }
                    break;
                case (4):
                    library.printPassedDeadlineBorrows();
                    break;
                case(5):
                    for (Borrow borrow : library.getBorrows()){
                        if(borrow.getBook().equals(findBookBorrowed(library))){
                            System.out.print("Month 1 to 12 : ");
                            int month = scan.nextInt() - 1;
                            System.out.print("Witch Day 1 to 31 : ");
                            int day = scan.nextInt();
                            Date date = new Date(new Date().getYear(),month,day,20,0, 0);
                            if(date.after(borrow.getIssuedDate())) {
                                borrow.setDeadlineDate(date);
                            }
                            else{
                                System.out.println("WHAT !!! It's Impossible !");
                            }
                            break;
                        }
                    }
                    //System.out.println("Book Not Borrowed !");
                    break;
                case(6):
                    return;
            }
        }
    }

}
