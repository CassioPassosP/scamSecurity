package service;

import model.Chat;
import model.Message;

import java.util.List;

public class ChatService {
    MessageAnalyzer analyzer = new MessageAnalyzer();

    public List<Message> getAnalyzedMessages(Chat chat){

        for(Message message : chat.MessageList()){
            analyzer.classificationMessage(message);
        }

        return chat.MessageList();
    }

    public void receiveMessage(Message message) {
        System.out.println(message.getSender() + "\n    Mensagem: " + message.getContentMessage());
        analyzer.classificationMessage(message);
    }
}
