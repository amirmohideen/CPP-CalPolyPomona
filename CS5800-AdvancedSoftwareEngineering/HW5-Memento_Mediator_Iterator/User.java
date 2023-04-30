import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User implements Iterable<Message>, IterableByUser {
    private final String username;
    private final ChatServer chatServer;
    private final ChatHistory chatHistory;
    private final List<MessageMemento> messageMementos;
    private final List<User> blockedUsers;

    public User(String username, ChatServer chatServer) {
        this.username = username;
        this.chatServer = chatServer;
        chatServer.registerUser(this);
        this.chatHistory = new ChatHistory();
        this.messageMementos = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    public List<User> getBlockedUsers() {
        return blockedUsers;
    }

    public void sendMessage(Message message) {
        chatHistory.addSentMessage(message);
    }

    public void receiveMessage(Message message) {
        chatHistory.addReceivedMessage(message);
    }

    public void undoLastSentMessage() {
        List<Message> sentMessages = chatHistory.getSentMessages();
        if (!sentMessages.isEmpty()) {
            Message lastMessage = sentMessages.get(sentMessages.size() - 1);
            chatHistory.removeLastSentMessage(lastMessage);
            MessageMemento messageMemento = lastMessage.createMessageSnapshotforMemento();
            lastMessage.restoreMessageSnapshotFromMemento(messageMemento);
            sentMessages.remove(lastMessage);
        }
    }

    public void blockUser(User blockedUser) {
        blockedUsers.add(blockedUser);
        System.out.println("\n(" + username + " has blocked " + blockedUser.getUsername() + ")");
    }

    @Override
    public Iterator<Message> iterator() {
        return chatHistory.iterator();
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }
}
