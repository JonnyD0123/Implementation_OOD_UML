import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Book {

    private String title;
    private String author;
    private Integer copies;
    private boolean electronicCopy;

    public Book(String title, String author, Integer copies, boolean electronicCopy) {
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.electronicCopy = electronicCopy;
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

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public boolean isElectronicCopy() {
        return electronicCopy;
    }

    public void setElectronicCopy(boolean electronicCopy) {
        this.electronicCopy = electronicCopy;
    }

    public void checkElectronic(){
        if (this.electronicCopy){
            System.out.println("Electronic Version Available.");
        } else {
            System.out.println("No Electronic Version Available.");
        }
    }

    public void removeBook(Librarian lib, Book b, ArrayList<Book> bookDatabase){
        if (bookDatabase.contains(b)){
            bookDatabase.remove(b);
            System.out.println("Book removed from Database.");
            Message bookRemovedMsg = new Message("Book Removed", b.getTitle() + " has been removed from database.");
            lib.sendMessage(bookRemovedMsg);
        } else {
            System.out.println("Database does not contain book.");
        }
    }

    public String addBook(Librarian lib, ArrayList<Book> bookDatabase, Book newBook, ArrayList<Member> allMembers){
        bookDatabase.add(newBook);
        String newBookAdded = "New Book Added to Database";

        Message bookAddedMsg = new Message("Book Added", newBook.getTitle() + " has been added to database.");

        return newBookAdded + "\n" + bookAddedMsg.sendMsgToAllMembers(allMembers, lib, bookAddedMsg);
    }

    @Override
    public String toString() {
        return "Book --> " +
                "Title: '" + title + '\'' +
                ", Author: '" + author + '\'' +
                ", Copies Available: " + copies +
                ", Electronic Copy Available: " + electronicCopy;
    }
}
