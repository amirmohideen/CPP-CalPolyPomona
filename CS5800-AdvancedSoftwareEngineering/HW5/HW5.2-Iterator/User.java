import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class User implements Iterable<Message>{
    private String username;
    private ChatServer chatServer;
    private ChatHistory chatHistory;
    private Stack<MessageMemento> messageMementos; // for Memento pattern
    private List<String> blockedUsers; // for Mediator pattern
    
    public User(String username, ChatServer chatServer) {
        this.username = username;
        this.chatServer = chatServer;
        this.chatHistory = new ChatHistory();
        this.messageMementos = new Stack<>();
        this.blockedUsers = new ArrayList<>();
        this.chatServer.registerUser(this);
    }
    
    public void sendMessage(List<String> recipients, String content) {
        if (!blockedUsers.isEmpty() && blockedUsers.contains(recipients.get(0))) {
            System.out.println("You have blocked messages from " + recipients.get(0));
            return;
        }

        Message message = new Message(username, recipients, content);
        chatServer.sendMessage(message);
        chatHistory.addMessage(message);

        // create a memento of the message
        MessageMemento memento = new MessageMemento(message.getContent(), message.getTimestamp());
        messageMementos.push(memento);
    }

    public void receiveMessage(Message message) {
        if (blockedUsers.contains(message.getSender())) {
            System.out.println("Blocked message from " + message.getSender());
            return;
        }

        System.out.println(message.getSender() + ": " + message.getContent());
        chatHistory.addMessage(message);
    }
    
    public void viewChatHistory() {
        System.out.println("\nChat history for " + username);
        List<Message> messages = chatHistory.getMessages();
        for (Message message : messages) {
            System.out.println(message.getTimestamp() + " - " + message.getSender() + ": " + message.getContent());
        }
    }
    
    public void undoLastMessage() {
        if (messageMementos.isEmpty()) {
            System.out.println("No messages to undo");
            return;
        }

        MessageMemento memento = messageMementos.pop();
        LocalDateTime timestamp = memento.getTimestamp();

        // find the message in the chat history and remove it
        List<Message> messages = chatHistory.getMessages();
        for (int i = messages.size() - 1; i >= 0; i--) {
            Message message = messages.get(i);
            if (message.getSender().equals(username) && message.getTimestamp().equals(timestamp)) {
                messages.remove(i);
                System.out.println("Message undone");
                return;
            }
        }
    }
    
    public void blockUser(String username) {
        if (!blockedUsers.contains(username)) {
            blockedUsers.add(username);
            System.out.println("Blocked " + username);
        }
    }

    public void unblockUser(String username) {
        if (blockedUsers.contains(username)) {
            blockedUsers.remove(username);
            System.out.println("Unblocked " + username);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ChatServer getChatServer() {
        return chatServer;
    }

    public void setChatServer(ChatServer chatServer) {
        this.chatServer = chatServer;
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(ChatHistory chatHistory) {
        this.chatHistory = chatHistory;
    }

    public Stack<MessageMemento> getMessageMementos() {
        return messageMementos;
    }

    public void setMessageMementos(Stack<MessageMemento> messageMementos) {
        this.messageMementos = messageMementos;
    }

    public List<String> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(List<String> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }
    
    @Override
    public Iterator<Message> iterator() {
        return chatHistory.iterator(this);
    }
}
