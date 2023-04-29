// ChatServer class acting as a mediator between users

import java.util.ArrayList;
import java.util.List;

class ChatServer {
    private List<User> users;
    
    public ChatServer() {
        this.users = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }
    
    public void unregisterUser(User user) {
        users.remove(user);
    }
    
    public void sendMessage(Message message) {
        List<String> recipients = message.getRecipients();
        for (User user : users) {
            if (recipients.contains(user.getUsername())) {
                user.receiveMessage(message);
            }
        }
    }
    
    public void blockUser(User blocker, String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.blockUser(blocker.getUsername());
                return;
            }
        }
        
        System.out.println("User not found");
    }
    
    public void unblockUser(User unblocker, String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.unblockUser(unblocker.getUsername());
                return;
            }
        }
        
        System.out.println("User not found");
    }
}

