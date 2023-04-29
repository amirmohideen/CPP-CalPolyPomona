import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        
        ChatServer chatServer = new ChatServer();
        User amir = new User("Amir", chatServer);
        User eren = new User("Eren", chatServer);
        User levi = new User("Levi", chatServer);
        
        amir.sendMessage(Arrays.asList("Eren", "Levi"), "Hey Eren and levi! Wassup!"); //messages can be sent to multiple users 
        amir.sendMessage(Arrays.asList("Eren"), "Levi, send me your homework");
        amir.sendMessage(Arrays.asList("Eren"), "RIGHT NOW");
    
        amir.undoLastMessage(); //message undone as noticed in amir's chat history

        amir.blockUser("Eren");
        eren.sendMessage(Arrays.asList("Amir"), "SHUT UP");
        eren.sendMessage(Arrays.asList("Amir"), "NO");
        amir.unblockUser("Eren");

        eren.sendMessage(Arrays.asList("Amir"), "SUFFER");

        amir.viewChatHistory(); //notice that amir's message is undone and also 2 blocked messages from eren were not recieved by amir
        eren.viewChatHistory(); 
        levi.viewChatHistory(); 

        System.out.println("\nAmir's chat history with Eren:");
        Iterator<Message> amirErenIterator = amir.getChatHistory().iterator(eren);
        while (amirErenIterator.hasNext()) {
            Message message = amirErenIterator.next();
            System.out.println(message.toString());
        }

        System.out.println("\nEren's chat history with Amir:");
        Iterator<Message> erenAmirIterator = eren.getChatHistory().iterator(amir);
        while (erenAmirIterator.hasNext()) {
            Message message = erenAmirIterator.next();
            System.out.println(message.toString());
        }
    
    }
}
