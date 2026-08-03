package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Classifications;
import model.Message;

public class MessageAnalyzer {

    public void classificationMessage(Message message){
        Pattern suspectPattern = Pattern.compile("Link|Acesse|Clique|Atualize|Verifique|Alerta|Segurança|Aviso|Conta|CPF|Código|Token|Renda|Extra" , Pattern.CASE_INSENSITIVE);
        Matcher suspectMatcher = suspectPattern.matcher(message.getContentMessage());
        boolean matchSuspectFound = suspectMatcher.find();
        if(matchSuspectFound) {
            message.setClassification(Classifications.SUSPECT);
            showAlert(message);
        } else {
            message.setClassification(Classifications.LEGITIMATE);
        }

        Pattern scamPattern = Pattern.compile("pix|0800|Ganhou|Brinde|Sorteio|iPhone|Vaga|Tarefa|Herança|Urgente|Imediato|Bloqueio|Retido|Multa|Aprovado|R$[0-9]" , Pattern.CASE_INSENSITIVE);
        Matcher scamMatcher = scamPattern.matcher(message.getContentMessage());
        boolean matchFound = scamMatcher.find();
        if(matchFound) {
            message.setClassification(Classifications.SCAM);
            showAlert(message);
        } else {
            message.setClassification(Classifications.LEGITIMATE);
        }
    }

    public String showAlert(Message message) {
        if(message.getClassification().equals(Classifications.SUSPECT)) {
            return "⚠️ Esta mensagem apresenta indícios de conteúdo suspeito. Tenha cautela antes de responder, não compartilhe informações pessoais e evite acessar links ou arquivos anexados até confirmar a autenticidade da mensagem.";
        }else if (message.getClassification().equals(Classifications.SCAM)){
            return "🚨 Possível tentativa de golpe detectada. Não responda à mensagem, não clique em links, não baixe arquivos e não forneça dados pessoais ou bancários. Se possível, bloqueie e denuncie o remetente.";
        }
        return "Erro durante a análise";
    }

}
