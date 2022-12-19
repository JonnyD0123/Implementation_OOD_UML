import java.util.ArrayList;
import java.util.Scanner;

public class Message {
    private String header;
    private String body;

    public Message(String header, String body) {
        this.header = header;
        this.body = body;

    }

    public Scanner in = new Scanner(System.in);

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void deleteMessage(User u, Message m){
        if (u.getInbox().contains(m)){
            u.getInbox().remove(m);
            System.out.println("Message removed from inbox");
        } else {
            System.out.println("Message not found in inbox.");
        }
    }

    public void clearInbox(User u, ArrayList<Message> inbox){
        for (Message msg : inbox){
            inbox.remove(msg);
        }
        System.out.println("Inbox cleared.");
    }

    public String sendMsgToAllMembers(ArrayList<Member> allMembers, Librarian lib, Message msg){
        for (Member m : allMembers){
            lib.sendMessage(msg);
        }

        return "Message sent to all members.";
    }
}
