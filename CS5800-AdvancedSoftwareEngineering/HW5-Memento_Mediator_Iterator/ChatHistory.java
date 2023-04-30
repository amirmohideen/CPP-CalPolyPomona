import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements Iterable<Message> {
    private List<Message> sentMessages;
    private List<Message> receivedMessages;

    public ChatHistory() {
        sentMessages = new ArrayList<>();
        receivedMessages = new ArrayList<>();
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void addSentMessage(Message message) {
        sentMessages.add(message);
    }

    public void addReceivedMessage(Message message) {
        receivedMessages.add(message);
    }

    public Message getLastSentMessage() {
        if (sentMessages.size() > 0) {
            return sentMessages.get(sentMessages.size() - 1);
        } else {
            return null;
        }
    }

    public void removeLastSentMessage(Message message) {
        sentMessages.remove(message);
    }

    public void removeLastReceivedMessage(Message message) {
        receivedMessages.remove(message);
    }

    public Iterator<Message> iterator(User userToSearchWith) {
        return new SearchMessagesByUser(allMessages().iterator(), userToSearchWith);
    }

    public List<Message> allMessages() {
        List<Message> allMessages = new ArrayList<>();
        allMessages.addAll(receivedMessages);
        allMessages.addAll(sentMessages);
        return allMessages;
    }

    @Override
    public Iterator<Message> iterator() {
        return allMessages().iterator();
    }

}
