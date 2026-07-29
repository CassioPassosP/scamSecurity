import java.util.ArrayList;

public class Banco{
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Chat> chats = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addChat(Chat chat) {
        chats.add(chat);
    }

    public ArrayList<Chat> getChat() {
        return chats;
    }
}
