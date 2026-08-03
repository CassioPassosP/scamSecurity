package model;

import repository.Database;

import java.util.ArrayList;

public class Chat {
    private int id;
    private String nameChat;
    private ArrayList<Message> messages;
    private Database banco;

    public Chat() {}

    public Chat(int id, String nameChat) {
        this.id = id;
        this.nameChat = nameChat;
        this.messages = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNameChat() {
        return nameChat;
    }

    public void sendMessage(Message message){
        messages.add(message);
    }

    public ArrayList<Message> MessageList() {
        return messages;
    }

}
