import java.util.ArrayList;

public class Chat {
    private int id;
    private String nameChat;
    private ArrayList<Message> messages;
    private Banco banco;

    public Chat() {}

    public Chat(int id, String nameChat) {
        this.id = id;
        this.nameChat = nameChat;
        this.messages = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void sendMessage(Message message){
        messages.add(message);
    }


    public ArrayList<Message> MessageList() {
        return messages;
    }


    public void receiveMessage(){

    }

    public void classificationMessage(){

    }

    public void emitirAlerta(Message message) {
        if(message.getClassification().equals(Classifications.LEGITIMATE)){

        }else if (message.getClassification().equals(Classifications.SUSPECT)) {
            System.out.println("Mensagem suspeita detectada. Tome ao responder, evite enviar dados ou acesssar links");
        }else if (message.getClassification().equals(Classifications.SCAM)){
            System.out.println("Possível golpe detectado. Favor ignorar esta mensagem.");
        }
    }

    public void listChats(){
        if(!banco.getChat().isEmpty()){
            System.out.println("Chats disponíveis: \n");
            for (Chat chat : banco.getChat()){
                System.out.println(chat + "\n");
            }
        }else{
            System.out.println("Nenhum chat disponivel.");
        }
    }

    //enviarMensagem()

    //receberMensagem()

    //classificarMensagem()

    //Atualiza a classificacao da mensagem

    //emitirAlerta() obs:caso necessario
}
