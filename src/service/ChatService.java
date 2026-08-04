package service;

import model.Chat;
import model.Message;

import java.util.List;

public class ChatService {
    MessageAnalyzer analyzer = new MessageAnalyzer();

    // Retorna uma List em vez de ArrayList, pois o metodo precisa apenas fornecer
    public List<Message> getAnalyzedChatMessages(Chat chat){

        // Percorre todas as mensagens do chat analisando e classificando cada uma
        for(Message message : chat.MessageList()){
            analyzer.classificationMessage(message);
        }

        //retorna as mensagens classificadas
        return chat.MessageList();
    }
}
