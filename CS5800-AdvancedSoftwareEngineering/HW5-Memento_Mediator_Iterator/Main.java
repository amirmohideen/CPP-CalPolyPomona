import java.util.List;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ChatServer chatServer = new ChatServer();

        User amir = new User("Amir", chatServer);
        User eren = new User("Eren", chatServer);
        User levi = new User("Levi", chatServer);

        chatServer.sendMessage(new Message(amir, List.of(eren, levi), "Hey Eren and levi! Wassup"));
        chatServer.sendMessage(new Message(amir, List.of(eren), "Eren, send me your car's photo!"));
        chatServer.sendMessage(new Message(amir, List.of(eren), "RIGHT NOW"));

        chatServer.undoLastMessage(amir);

        chatServer.sendMessage(new Message(eren, List.of(levi), "Should I send?"));

        amir.blockUser(eren);
        chatServer.sendMessage(new Message(eren, List.of(amir), "I WONT SEND"));
        chatServer.sendMessage(new Message(eren, List.of(amir), "SUFFER HAHA!"));

        System.out.println("\nMessage History of Amir:");
        Iterator<Message> messageHistoryIteratorAmir = amir.iterator();
        while (messageHistoryIteratorAmir.hasNext()) {
            System.out.println(messageHistoryIteratorAmir.next());
        }

        System.out.println("\nMessage History of Eren:");
        Iterator<Message> messageHistoryIteratorEren = eren.iterator();
        while (messageHistoryIteratorEren.hasNext()) {
            System.out.println(messageHistoryIteratorEren.next());
        }

        System.out.println("\nMessage History of Levi:");
        Iterator<Message> messageHistoryIteratorLevi = levi.iterator();
        while (messageHistoryIteratorLevi.hasNext()) {
            System.out.println(messageHistoryIteratorLevi.next());
        }

    }
}