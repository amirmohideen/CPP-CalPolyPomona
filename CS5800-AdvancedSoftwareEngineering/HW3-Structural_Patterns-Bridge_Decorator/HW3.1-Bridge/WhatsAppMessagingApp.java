public class WhatsAppMessagingApp implements MessagingApp{
    public void sendMessagefromApp(MessageType messageType) {
        System.out.print("\nSending message from WhatsApp...");
        messageType.sendMessage();
    }
}
