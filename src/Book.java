

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String translator;
    private String publisher;
    private boolean stateInLibrary;

    public Book(String title, String author, String publisher, String translator){//translator NULL for nothing
        this.author = author;
        this.translator = translator;
        this.title = title;
        this.publisher = publisher;
        stateInLibrary = true;
    }

    public void print() {
        System.out.println("Title: " + title + " | Author: " + author);
    }

    public void printFullData() {
        System.out.println("Title: " + title + " | Author: " + author);
        if(!translator.equals("")){
            System.out.print("Translator: " + translator + " | ");
        }
        System.out.println("Publisher: " + publisher);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isStateInLibrary() {
        return stateInLibrary;
    }

    public void setStateInLibrary(boolean stateInLibrary) {
        this.stateInLibrary = stateInLibrary;
    }
}