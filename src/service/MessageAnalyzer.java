package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Classifications;
import model.Message;

public class MessageAnalyzer {

    public void classificationMessage(Message message){
        Pattern suspectPattern = Pattern.compile("Link|Acesse|Clique|Atualize|Verifique|Alerta|Segurança|Aviso|Conta|CPF|Código|Token|Renda|Extra", Pattern.CASE_INSENSITIVE);
        Pattern scamPattern = Pattern.compile("pix|0800|Ganhou|Brinde|Sorteio|iPhone|Vaga|Tarefa|Herança|Urgente|Imediato|Bloqueio|Retido|Multa|Aprovado|R\\$[0-9]", Pattern.CASE_INSENSITIVE);

        boolean isScam = scamPattern.matcher(message.getContentMessage()).find();
        boolean isSuspect = suspectPattern.matcher(message.getContentMessage()).find();

        if (isScam) {
            message.setClassification(Classifications.SCAM);
        } else if (isSuspect) {
            message.setClassification(Classifications.SUSPECT);
        } else {
            message.setClassification(Classifications.LEGITIMATE);
        }

        System.out.println(showAlert(message));
    }

    public String showAlert(Message message) {
        return switch (message.getClassification()) {
            case SUSPECT -> "Esta mensagem apresenta indícios de conteúdo suspeito. Tenha cautela antes de responder, não compartilhe informações pessoais e evite acessar links ou arquivos anexados até confirmar a autenticidade da mensagem.\n";
            case SCAM -> "Possível tentativa de golpe detectada. Não responda à mensagem, não clique em links, não baixe arquivos e não forneça dados pessoais ou bancários. Se possível, bloqueie e denuncie o remetente.\n";
            case LEGITIMATE -> "";
        };
    }

}
