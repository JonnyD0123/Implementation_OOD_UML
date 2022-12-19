import java.util.ArrayList;
import java.util.Scanner;

public class Member extends User {
    private String name;
    private Double feeBalance;
    private ArrayList<Book> booksCheckedOut;

    public Member(String userID, String name, Double feeBalance) {
        super(userID);
        this.name = name;
        this.feeBalance = feeBalance;
    }


    public Member(String userID, String name) {
        super(userID);
        this.name = name;
    }

    public ArrayList<Book> getBooksCheckedOut() {
        return booksCheckedOut;
    }

    public void setBooksCheckedOut(ArrayList<Book> booksCheckedOut) {
        this.booksCheckedOut = booksCheckedOut;
    }

    public Member(String userID, String name, Double feeBalance, ArrayList<Book> booksCheckedOut) {
        super(userID);
        this.name = name;
        this.feeBalance = feeBalance;
        this.booksCheckedOut = booksCheckedOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFeeBalance() {
        return feeBalance;
    }

    public void setFeeBalance(Double feeBalance) {
        this.feeBalance = feeBalance;
    }


    public void payFees(Member m) {
        m.setFeeBalance(0.00);
        System.out.println("Fees paid");
    }

    @Override
    public void sendMessage(Message m) {
        System.out.println("Message: '" + m.getHeader() + "', sent to Librarian.");
    }

    public void selectElectronicBook(Member m){
        System.out.println("Selected Electronic Version");
        Message msg = new Message("Electronic Access Request for Librarian", "Permission request has been sent to instructor.");
        m.sendMessage(msg);
    }

    public void checkIn(Book b) {
        System.out.println("Book checked in.");
        b.setCopies(b.getCopies()+1);

        Message msg = new Message("Book Checked-In", "A copy of " + b.getTitle() + " has been checked-in.");
    }

    public String checkOut(Book b, Member m) {
        if (m.getFeeBalance() > 0.00){
            return "Cannot check-out new book until fees are paid.";
        } else if (b.getCopies().equals(0)){
            return "No copies available.";
        } else {
            booksCheckedOut.add(b);
            return "Checked out book.";
        }
    }

}


