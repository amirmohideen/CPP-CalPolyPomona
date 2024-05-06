public class Main {
    public static void main(String[] args) {
        
        MessagingApp whatsApp = new WhatsAppMessagingApp();
        MessagingApp telegram = new TelegramMessagingApp();
        MessagingApp facebook = new FacebookMessagingApp();

        MessageType textMessage = new TextMessage();
        MessageType imageMessage = new ImageMessage();
        MessageType videoMessage = new VideoMessage();

        System.out.println("\n-----WHATSAPP-----");
        whatsApp.sendMessagefromApp(textMessage);
        whatsApp.sendMessagefromApp(imageMessage);
        whatsApp.sendMessagefromApp(videoMessage);
       
        System.out.println("\n-----TELEGRAM-----");
        telegram.sendMessagefromApp(textMessage);
        telegram.sendMessagefromApp(imageMessage);
        telegram.sendMessagefromApp(videoMessage);
        
        System.out.println("\n-----FACEBOOK-----");
        facebook.sendMessagefromApp(textMessage);
        facebook.sendMessagefromApp(imageMessage);
        facebook.sendMessagefromApp(videoMessage);
    }
}
