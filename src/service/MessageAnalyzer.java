package service;

import java.util.regex.Pattern;

import model.Classifications;
import model.Message;

public class MessageAnalyzer {

    //funcao que procura as palavras padrao para realizar a classificacao
    public void classificationMessage(Message message){
        //palavras padrao para mensagens suspeitas
        Pattern suspectPattern = Pattern.compile("Link|Acesse|Clique|Atualize|Verifique|Alerta|Segurança|Aviso|Conta|CPF|Código|Token|Renda|Extra", Pattern.CASE_INSENSITIVE);
        //palavras padrao para possiveis golpes
        Pattern scamPattern = Pattern.compile("pix|0800|Ganhou|Brinde|Sorteio|iPhone|Herança|Urgente|Imediato|Bloqueio|Retido|Multa|Aprovado|R\\$[0-9]", Pattern.CASE_INSENSITIVE);

        // verifica se encontrou padroes usando
        //.mathcer() - recebe uma String
        //.find() - procura a coerencia
        boolean isScam = scamPattern.matcher(message.getContentMessage()).find();
        boolean isSuspect = suspectPattern.matcher(message.getContentMessage()).find();

        // se isScam encontrar a coerencia ele classifica a mensagem como golpe
        if (isScam) {
            message.setClassification(Classifications.SCAM);
            System.out.println(showAlert(message));
        // senao se isSuspect encontrar a coerencia ele classifica a mensagem como suspeito
        } else if (isSuspect) {
            message.setClassification(Classifications.SUSPECT);
            System.out.println(showAlert(message));
        // senao ele classifica a mensagem como legitima
        } else {
            message.setClassification(Classifications.LEGITIMATE);
        }
    }

    //Exibe um alerta ao usuario sobre a mensagem recebida
    public String showAlert(Message message) {
        return switch (message.getClassification()) {
            case SUSPECT -> "Esta mensagem apresenta indícios de conteúdo suspeito. Tenha cautela antes de responder, não compartilhe informações pessoais e evite acessar links ou arquivos anexados até confirmar a autenticidade da mensagem.\n";
            case SCAM -> "Possível tentativa de golpe detectada. Não responda à mensagem, não clique em links, não baixe arquivos e não forneça dados pessoais ou bancários. Se possível, bloqueie e denuncie o remetente.\n";
            case LEGITIMATE -> null;
        };
    }

}
