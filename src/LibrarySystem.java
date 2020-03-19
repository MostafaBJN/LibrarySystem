

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class LibrarySystem {
    private ArrayList<Library> libraries = new ArrayList<Library>();

    public LibrarySystem(){
    libraries = new ArrayList<Library>();
    }

    public void addLibrary(Library libraryToAdd){
        for (Library library : libraries) {
            if(library.equals(libraryToAdd)){
                System.out.println("This Library is Already Exist !");
                System.out.print("Please Insert New Name : ");
                String name = new Scanner(System.in).next();
                System.out.print("Please Insert New Address : ");
                String address = new Scanner(System.in).next();
                addLibrary(new Library(name, address));
                return;
            }
        }
        libraries.add(libraryToAdd);
    }

    public void removeLibrary(Library libraryToRemove){
        Iterator<Library> itLibs = libraries.iterator();
        do {
            if(itLibs.next().equals(libraryToRemove)){
                itLibs.remove();
                System.out.println("Library Removed Successfully !");
                return;
            }
        }while (itLibs.hasNext());
        System.out.println("Library Not Founds !");
    }

    public void printAllLibraries(){
        for (Library lib : libraries) {
            System.out.print("Name : " + lib.getName() + " | Address : " + lib.getAddress());
            System.out.println(" | Total Number of Books : " + lib.getBooks().size() + " | Number of Users : " + lib.getUsers().size() + " | Number of Borrowed Book Right Now : " + lib.getBorrows().size());
        }
    }

    public ArrayList<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(ArrayList<Library> libraries) {
        this.libraries = libraries;
    }
}
