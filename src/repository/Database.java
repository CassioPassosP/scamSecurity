package repository;

import model.Chat;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users = new ArrayList<>();
    private List<Chat> chats = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void addChat(Chat chat) {
        chats.add(chat);
    }

    public List<Chat> getChat() {
        return chats;
    }
}
