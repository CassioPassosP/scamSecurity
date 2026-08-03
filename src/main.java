import model.Chat;
import model.User;
import repository.Database;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Database banco = new Database();

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

        int choice = 0;

        System.out.println("""
                    Bem vindo ao JavaZap!
                    
                    O que voce deseja fazer?
                    
                    1 - Ver mensagens recebidas
                    2 - enviar mensagem
                    3 - Sair
                    """);

        choice = leitura.nextInt();

        while (choice != 5) {

            switch (choice) {
                case 1:

                    break;

                case 2:
                    int choiceChat;
                    if(!banco.getChat().isEmpty()){
                        int i = 1;
                        System.out.println("Chats disponíveis: \n");
                        for (Chat chat : banco.getChat()){
                            System.out.println( i + " - " + chat.getNameChat() + "\n");
                            i ++;
                        }
                    }else{
                        System.out.println("Nenhum chat disponivel.");
                    }

                    choiceChat = leitura.nextInt();

                    break;

                case 3:
                    System.out.println("Encerrando JavaZap...");
                    break;
            }


        }
    }
}
