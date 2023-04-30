import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private User sender;
    private List<User> recipients;
    private String timestamp;
    private String messageContent;

    public Message(User sender, List<User> recipients, String messageContent) {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = new SimpleDateFormat("yyyy/MM/dd h:m:s a").format(new Date());
        
        this.messageContent = messageContent;
    }

    public User getSender() {
        return sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public MessageMemento createMessageSnapshotforMemento() {
        return new MessageMemento(this);
    }

    public void restoreMessageSnapshotFromMemento(MessageMemento messageMemento) {
        Message lastMessage = messageMemento.getLastMessage();
        this.sender = lastMessage.getSender();
        this.recipients = lastMessage.getRecipients();
        this.messageContent = lastMessage.getMessageContent();
        this.timestamp = lastMessage.getTimestamp();
    }

    public String toString() {
        StringBuilder recipientUsernamesBuilder = new StringBuilder();
        for (int i = 0; i < recipients.size(); i++) {
            recipientUsernamesBuilder.append(recipients.get(i).getUsername());
            if (i < recipients.size() - 1) {
                recipientUsernamesBuilder.append(" & ");
            }
        }

        return String.format("[%s] - %s to [%s]: %s", timestamp, sender.getUsername(),
                recipientUsernamesBuilder.toString(), messageContent);
    }

}