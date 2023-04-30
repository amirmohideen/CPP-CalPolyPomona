public class MessageMemento {
    private Message lastMessage;

    public MessageMemento(Message lastMessage){
        this.lastMessage = lastMessage;
    }

    public Message getLastMessage(){
        return lastMessage;
    }
}
