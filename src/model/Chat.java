package model;

import repository.Database;

import java.util.ArrayList;

public class Chat {
    private int id;
    private String nameChat;
    private ArrayList<Message> messages;

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

    //Essa funcao adiciona uma nova mensagem no chat
    public void saveMessage(Message message){
        messages.add(message);
    }

    //Essa funcao retorna toda a lista de mensagem
    public ArrayList<Message> MessageList() {
        return messages;
    }

}
