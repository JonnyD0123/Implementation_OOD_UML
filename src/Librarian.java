import java.util.ArrayList;
import java.util.Scanner;

public class Librarian extends User{

    public Librarian(String userID) {
        super(userID);
    }

    public Scanner in = new Scanner(System.in);

    @Override
    public void sendMessage(Message m) {
        System.out.println("Message: '" + m.getHeader() + "', sent to Member.");
    }

    public void addEBookToMemberAccount(Book b, Member m){
        if (b.isElectronicCopy()){
            m.getBooksCheckedOut().add(b);
            System.out.println("Book Added to Member Account.");
            Message eBookAddMsg = new Message("E-Book Added", "A new e-book has been added to your account.");
            sendMessage(eBookAddMsg);
        } else {
            System.out.println("No Electronic Version Available to Add.");
        }
    }

    public void creatMemberAccount(ArrayList<Member> members){
        System.out.println("Enter Member userID: ");
        String userID = in.next();
        System.out.println("Enter Member name: ");
        String name = in.next();

        Member m = new Member(userID, name);
        members.add(m);
        System.out.println("New Member Created");
    }

    public void chargeMemberLateFee(Member m){
        m.setFeeBalance(m.getFeeBalance()+15.00);
        System.out.println("Member Charged for Late Fee --> $15.00");
    }

}
