import java.util.Iterator;
import java.util.List;

public class SearchMessagesByUserIterator implements Iterator<Message> {
    private int currentIndex;
    private List<Message> messages;
    private User userToSearchWith;

    public SearchMessagesByUserIterator(List<Message> messages, User userToSearchWith) {
        this.messages = messages;
        this.userToSearchWith = userToSearchWith;
        this.currentIndex = -1;
    }

    @Override
public boolean hasNext() {
    while (currentIndex < messages.size() - 1) {
        currentIndex++;
        Message message = messages.get(currentIndex);
        if (message.getSender().equals(userToSearchWith.getUsername()) || message.getRecipients().contains(userToSearchWith.getUsername())) {
            return true;
        }
    }
    return false;
}

@Override
public Message next() {
    while (currentIndex < messages.size() - 1) {
        currentIndex++;
        Message message = messages.get(currentIndex);
        if (message.getSender().equals(userToSearchWith.getUsername()) || message.getRecipients().contains(userToSearchWith.getUsername())) {
            return message;
        }
    }
    return null;
}

@Override
public void remove() {
    throw new UnsupportedOperationException();
}
}