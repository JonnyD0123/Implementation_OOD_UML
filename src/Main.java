import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Maps of Meaning", "Jordan Peterson", 2, false);
        Book book2 = new Book("Magicians of the Gods", "Graham Hancock", 4, false);
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", 2,true);

        ArrayList<Book> libraryDatabase = new ArrayList<>();
        libraryDatabase.add(book1);
        libraryDatabase.add(book2);

        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        booksCheckedOut.add(book1);
        booksCheckedOut.add(book2);

        Member mark = new Member("MD123", "Mark", 15.00, booksCheckedOut);

        Scanner in = new Scanner(System.in);
        System.out.println("Member or Librarian? 'M'/'L' ");
        String input = in.next();

        if(input.equalsIgnoreCase("M")){
            System.out.println("Enter User ID: ");
            String userID = in.next();
            System.out.println("Enter name: ");
            String name = in.next();


            Member m = new Member(userID, name);
            m.verifyUser(userID);
            System.out.println("Welcome " + m.getName());

            m.setFeeBalance(15.00);
            m.setBooksCheckedOut(booksCheckedOut);


            Message msgToLibrarian = new Message("Message to Librarian", "private");
            ArrayList<Message> inbox = new ArrayList<>();

           int endInput = 1;
           while(endInput != 0){
               System.out.println("Select Activity");
               System.out.println("1. Send Message: ");
               System.out.println("2. Pay Fees: ");
               System.out.println("3. View Library Book Database: ");
               System.out.println("4. Search Database: ");
               System.out.println("5. Check-In Book: ");
               System.out.println("6. Check-Out Book: ");
               System.out.println("7. View Messages: ");
               System.out.println("0. Exit Application");
               endInput = in.nextInt();
               switch (endInput){
                   case 0: return;
                   case 1: m.sendMessage(msgToLibrarian);
                      break;
                   case 2: m.payFees(m);
                      break;
                   case 3: m.viewLibraryBookDatabase(libraryDatabase);
                      break;
                   case 4: m.searchDatabase(libraryDatabase, book1);
                      break;
                   case 5: m.checkIn(book2);
                      break;
                   case 6: m.checkOut(book1, m);
                      break;
                   case 7: m.viewMessages(m.getUserID(), inbox);
                      break;
                   default:break;
               }
           }

        } else if (input.equalsIgnoreCase("L")){
            System.out.println("Enter User ID: ");
            String userID = in.next();

            if (userID.equals("Lib123")) {
                Librarian lib = new Librarian(userID);
                lib.verifyUser(userID);
                System.out.println("Welcome " + userID);

                Message msgToMember = new Message("Message to Member", "private");
                ArrayList<Message> inbox = new ArrayList<>();
                ArrayList<Member> members = new ArrayList<>();
                members.add(mark);

                int endInput = 1;
                while (endInput != 0) {
                    System.out.println("1. View Messages: ");
                    System.out.println("2. Send Message: ");
                    System.out.println("3. View Library Book Database: ");
                    System.out.println("4. Search Database: ");
                    System.out.println("5. Add Electronic Book to Member Account: ");
                    System.out.println("6. Create Member Account: ");
                    System.out.println("7. Charge Member Late Fee: ");
                    System.out.println("8. Remove Book: ");
                    System.out.println("9. Add Book: ");
                    System.out.println("0. End Application");
                    endInput = in.nextInt();
                    switch (endInput) {
                        case 0:
                            return;
                        case 1:
                            lib.viewMessages(lib.getUserID(), inbox);
                            break;
                        case 2:
                            lib.sendMessage(msgToMember);
                            break;
                        case 3:
                            lib.viewLibraryBookDatabase(libraryDatabase);
                            break;
                        case 4:
                            lib.searchDatabase(libraryDatabase, book1);
                            break;
                        case 5:
                            lib.addEBookToMemberAccount(book3, mark);
                            break;
                        case 6:
                            lib.creatMemberAccount(members);
                            break;
                        case 7:
                            lib.chargeMemberLateFee(mark);
                            break;
                        case 8:
                            book2.removeBook(lib, book2, libraryDatabase);
                            break;
                        case 9:
                            book3.addBook(lib, libraryDatabase, book3, members);
                            break;
                        default:
                            break;
                    }
                }
            }
        } else {
            System.out.println("Bad Input");
        }
    }
}
