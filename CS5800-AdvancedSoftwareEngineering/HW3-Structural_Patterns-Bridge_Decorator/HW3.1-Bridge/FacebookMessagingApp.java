public class FacebookMessagingApp implements MessagingApp{
    public void sendMessagefromApp(MessageType messageType) {
        System.out.print("\nSending message from Facebook... ");
        messageType.sendMessage();
    }
}
