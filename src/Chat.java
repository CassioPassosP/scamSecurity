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

    public void setId(int id) {
        this.id = id;
    }

    public String getNameChat() {
        return nameChat;
    }

    public void setNameChat(String nameChat) {
        this.nameChat = nameChat;
    }

    public void sendMessage(Message message){
        messages.add(message);
    }

    public ArrayList<Message> MessageList() {
        return messages;
    }

    public void receiveMessage(){

    }

    public void classificationMessage(Message message){
        //logica onde definimos se e necessario emitir alerta
    }

    public String showAlert(Message message) {
        if(message.getClassification().equals(Classifications.SUSPECT)) {
            return "Mensagem suspeita detectada. Tome ao responder, evite enviar dados ou acesssar links";
        }else if (message.getClassification().equals(Classifications.SCAM)){
            return "Possível golpe detectado. Favor ignorar esta mensagem.";
        }
        return "Erro durante a analise";
    }

    public void messageList() {
        if(!messages.isEmpty()){
            System.out.println("Chat" + nameChat +":\n");
            for (Message message : messages){
                System.out.println(message.getContentMessage());
            }
        }else{
            System.out.println("Nenhuma mensagem.");
        }

    }

}
