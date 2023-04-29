import java.util.ArrayList;
import java.util.List;

public class ChatHistory {
    private List<Message> messages;

    public ChatHistory() {
        messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Message getLastMessage() {
        if (messages.isEmpty()) {
            return null;
        }
        return messages.get(messages.size() - 1);
    }

    public MessageMemento saveLastMessage() {
        Message lastMessage = getLastMessage();
        if (lastMessage == null) {
            return null;
        }
        return new MessageMemento(lastMessage.getContent(), lastMessage.getTimestamp());
    }

    public void restoreLastMessage(MessageMemento memento) {
        Message lastMessage = getLastMessage();
        if (lastMessage == null) {
            return;
        }
        lastMessage.setContent(memento.getContent());
        lastMessage.setTimestamp(memento.getTimestamp());
    }
}
