public class TelegramMessagingApp implements MessagingApp{
    public void sendMessagefromApp(MessageType messageType) {
        System.out.print("\nSending message from Telegram...");
        messageType.sendMessage();
    }
}
