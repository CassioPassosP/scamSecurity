import model.Chat;
import model.Message;
import model.User;
import repository.Database;
import service.ChatService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Database banco = new Database();
        ChatService chatService = new ChatService();

        User user1 = new User(1, "João Silva", "joao@email.com", 119876543);
        Chat chat1 = new Chat(user1.getId(), user1.getName());
        banco.addUser(user1);
        banco.addChat(chat1);

        User user2 = new User(2, "219123456", "maria@email.com", 219123456);
        Chat chat2 = new Chat(user2.getId(), user2.getName());
        banco.addUser(user2);
        banco.addChat(chat2);

        User user3 = new User(3, "Pedro Santos", "pedro@email.com", 319654321);
        Chat chat3 = new Chat(user3.getId(), user3.getName());
        banco.addUser(user3);
        banco.addChat(chat3);

        User user4 = new User(4, "419112233", "ana@email.com", 419112233);
        Chat chat4 = new Chat(user4.getId(), user4.getName());
        banco.addUser(user4);
        banco.addChat(chat4);

        User user5 = new User(5, "Lucas Oliveira", "lucas@email.com", 519998877);
        Chat chat5 = new Chat(user5.getId(), user5.getName());
        banco.addUser(user5);
        banco.addChat(chat5);

        // Mensagens de exemplo, uma por chat, com teores diferentes
        String[] exemplos = {
                "Oi João, tudo bem? Combinamos o almoço de sábado?", // Legitima
                "Atualize seus dados de Conta agora, Acesse o Link enviado", // Suspeito
                "Você foi Aprovado para receber uma Herança, envie R$50 via pix Urgente", // Golpe
                "Cheguei bem em casa, obrigado pela carona!", // Legitima
                "Vaga de Renda Extra disponível, Código de acesso: 4521, clique já" // Golpe
        };

        for(int i = 0; i < banco.getChat().size(); i++){
            Chat chat = banco.getChat().get(i);

            Message msg = new Message(
                    i + 1,
                    exemplos[i],
                    chat.getNameChat(),
                    LocalDateTime.now(),
                    null
            );

            chat.sendMessage(msg);
            chatService.receiveMessage(msg);
        }

        int choice = 0;

        while (choice != 2) {

            System.out.println("""
                    Bem vindo ao JavaZap!
                    
                    O que voce deseja fazer?
                    
                    1 - Ver mensagens recebidas           
                    2 - Sair
                    """);

            choice = leitura.nextInt();

            switch (choice) {
                case 1:
                    int messageChats;
                    int keepChoice;
                    if(!banco.getChat().isEmpty()){
                        int i = 1;
                        System.out.println("Mensagens disponíveis: \n");
                        for (Chat chat : banco.getChat()){
                            System.out.println( i + " - " + chat.getNameChat() + "\n");
                            i ++;
                        }
                    }else{
                        System.out.println("Nenhum mensagem encontrada.");
                    }

                    System.out.println("Escolha um chat para vizualizar(Digite o numero do chat): \n");
                    messageChats = leitura.nextInt();

                    Chat chatView = banco.getChat().stream()
                            .filter(chat -> chat.getId() == messageChats)
                            .findFirst()
                            .orElse(null);

                    if (chatView != null) {
                        System.out.println(chatView.getNameChat() +"\n");

                        for (Message message : chatService.getAnalyzedMessages(chatView)) {
                            System.out.println(message.getContentMessage());
                        }
                    }

                    System.out.println("""
                            Deseja retornar para as mensagens disponiveis?
                            1 - Sim
                            2 - Não
                            """);

                    keepChoice = leitura.nextInt();

                    if (keepChoice == 1) {
                        choice = 0 ;
                    } else if (keepChoice == 2) {
                        choice = 2 ;
                        System.out.println("Encerrando JavaZap...");
                    }

                    break;

                case 2:
                    System.out.println("Encerrando JavaZap...");

                    break;

                default:
                    System.out.println("Opção invalida.");

                    break;
            }


        }
    }
}
