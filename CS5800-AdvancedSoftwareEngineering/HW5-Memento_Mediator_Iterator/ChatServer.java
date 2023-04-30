import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<User> users;

    public ChatServer() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void unregisterUser(User user) {
        users.remove(user);
    }

    public void sendMessage(Message message) {
        User sender = message.getSender();
        sender.sendMessage(message);
        for (User recipient : message.getRecipients()) {
            if (recipient.getBlockedUsers().contains(sender)) {
                System.out.println(
                        "[" + message.getTimestamp() + "] - (" + sender.getUsername()
                                + "'s message sent but not recieved by " + recipient.getUsername() + ")");
            } else {
                recipient.receiveMessage(message);
                System.out.println("[" + message.getTimestamp() + "] - " + sender.getUsername() + " to "
                        + recipient.getUsername() + ": " + message.getMessageContent());
            }
        }
    }

    public void undoLastMessage(User user) {
        ChatHistory chatHistory = user.getChatHistory();
        Message lastSentMessage = chatHistory.getLastSentMessage();
        user.undoLastSentMessage();
        List<User> recipients = lastSentMessage.getRecipients();
        for (User recipient : recipients) {
            recipient.getChatHistory().removeLastReceivedMessage(lastSentMessage);
        }
        System.out.println(
                "[" + lastSentMessage.getTimestamp() + "] - (" + user.getUsername() + "'s last message unsent)");
    }

}
