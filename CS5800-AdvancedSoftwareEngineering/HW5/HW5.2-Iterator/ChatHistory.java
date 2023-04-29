import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser {
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

    @Override
    public Iterator iterator(User userToSearchWith) {
        return new SearchMessagesByUserIterator(userToSearchWith);
    }

    

    private class SearchMessagesByUserIterator implements Iterator<Message> {
        private int currentIndex;
        private User userToSearchWith;

        public SearchMessagesByUserIterator(User userToSearchWith) {
            this.userToSearchWith = userToSearchWith;
            this.currentIndex = -1;
        }

        @Override
    public boolean hasNext() {
        while (currentIndex < messages.size() - 1) {
            currentIndex++;
            Message message = messages.get(currentIndex);
            if (message.getSender().equals(userToSearchWith.getUsername())
                    || message.getRecipients().contains(userToSearchWith.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Message next() {
        if (hasNext()) {
            Message message = messages.get(currentIndex);
            currentIndex++;
            return message;
        }
        return null;
    }
    
    }
}
