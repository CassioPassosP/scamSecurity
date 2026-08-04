package service;

import model.Chat;
import model.Message;

import java.util.List;

public class ChatService {
    MessageAnalyzer analyzer = new MessageAnalyzer();

    //funcao criada para analisar todas as mensagens do chat recebido nos paramentros
    public List<Message> getAnalyzedChatMessages(Chat chat){

        //percorre as mensagens do chat chamando a funcao .classificationMessage() responsavel por analisar e classificar a mensagem
        for(Message message : chat.MessageList()){
            analyzer.classificationMessage(message);
        }

        //retorna as mensagens classificadas
        return chat.MessageList();
    }
}
