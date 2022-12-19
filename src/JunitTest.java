import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JunitTest {

    @Test
    public void testBookAddBook(){
        Librarian lib = new Librarian("Lib123");

        ArrayList<Book> bookDatabase = new ArrayList<>();
        ArrayList<Member> allMembers = new ArrayList<>();

        Book b3 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 5, true);

        String result = b3.addBook(lib, bookDatabase, b3, allMembers);
        assertEquals("New Book Added to Database" + "\nMessage sent to all members.", result);
    }

    @Test
    public void testMessageSendMsgToAllUsers(){
        ArrayList<Member> members = new ArrayList<>();

        Member m1 = new Member("JD123", "Jonny");
        Member m2 = new Member("CD456", "Christian");

        members.add(m1);
        members.add(m2);

        Librarian lib = new Librarian("Lib123");
        Message closedForRenovations = new Message("Library Closed for Renovations", "A reminder to all members: Library is closed this week for renovations.");

        String returnStatement = closedForRenovations.sendMsgToAllMembers(members, lib, closedForRenovations);
        assertEquals("Message sent to all members.", returnStatement);
    }

    @Test
    public void testLibrarianLateFeeCharge(){
        Librarian lib = new Librarian("Lib123");
        Member m1 = new Member("JD123", "Jonny", 0.00);

        lib.chargeMemberLateFee(m1);
        double result = m1.getFeeBalance();

        assertEquals(15.0, result);
    }

    @Test
    public void testUserDBsearch(){
        Book book1 = new Book("Maps of Meaning", "Jordan Peterson", 2, false);
        Book book2 = new Book("Magicians of the Gods", "Graham Hancock", 4, false);
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", 2,true);

        ArrayList<Book> libraryDatabase = new ArrayList<>();
        libraryDatabase.add(book1);
        libraryDatabase.add(book2);
        libraryDatabase.add(book3);

        Member m = new Member("JD123", "Jonny");

        String result = m.searchDatabase(libraryDatabase, book3);
        assertEquals("Book Found at index: 2", result);
    }

    @Test
    public void testMemberCheckOutwithFee(){
        Book hobbit = new Book("The Hobbit", "J.R.R. Tolkien", 2,true);
        ArrayList<Book> m1Books = new ArrayList<>();

        Member m1 = new Member("JD123", "Jonny", 15.00, m1Books);

        String result = m1.checkOut(hobbit, m1);

        assertEquals("Cannot check-out new book until fees are paid.", result);
    }

}
