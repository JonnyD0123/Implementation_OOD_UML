import java.util.ArrayList;

public abstract class User {
    private String userID;
    private ArrayList<Message> inbox;

    public User(String userID) {
        this.userID = userID;
    }

    public User(String userID, ArrayList<Message> inbox) {
        this.userID = userID;
        this.inbox = inbox;
    }

    public void verifyUser(String userID){
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public void setInbox(ArrayList<Message> inbox) {
        this.inbox = inbox;
    }

    public void viewMessages(String userID, ArrayList<Message> inbox) {
        if (inbox.isEmpty()){
            System.out.println("Inbox for " + userID + " is empty.");
        } else {
            System.out.println("Inbox for " + userID);
            for (Message msg : inbox){
                System.out.println(msg);
            }
        }
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public abstract void sendMessage(Message m);

    public void viewLibraryBookDatabase(ArrayList<Book> bookDatabase){
        if (bookDatabase.isEmpty()){
            System.out.println("Database Empty");
        } else {
            for (Book b : bookDatabase) {
                System.out.println(b);
            }
        }
    }

    public String searchDatabase(ArrayList<Book> bookDatabase, Book searchedBook){
        if (bookDatabase.isEmpty()){
            return "Database Empty";
        } else {
            for (Book b : bookDatabase){
                if (b.equals(searchedBook)) {
                    System.out.println(searchedBook);
                    return "Book Found at index: " + bookDatabase.indexOf(b);
                }
            }
            return "Book Not Found";
        }
    }



}
