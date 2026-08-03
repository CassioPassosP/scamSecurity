package service;

import model.Message;

public class ChatService {
    MessageAnalyzer analyzer = new MessageAnalyzer();

    public void receiveMessage(Message message) {
        System.out.println(message.getSender() + "\n Mensagem: " + message.getContentMessage());
        analyzer.classificationMessage(message);
    }
}
