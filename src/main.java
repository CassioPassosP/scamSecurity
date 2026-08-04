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
        Database database = new Database();
        ChatService chatService = new ChatService();

        User user1 = new User(1, "João Silva", "joao@email.com", 119876543);
        Chat chat1 = new Chat(user1.getId(), user1.getName());
        database.addUser(user1);
        database.addChat(chat1);

        User user2 = new User(2, "Maria Oliveira", "maria@email.com", 219123456);
        Chat chat2 = new Chat(user2.getId(), user2.getName());
        database.addUser(user2);
        database.addChat(chat2);

        User user3 = new User(3, "Pedro Santos", "pedro@email.com", 319654321);
        Chat chat3 = new Chat(user3.getId(), user3.getName());
        database.addUser(user3);
        database.addChat(chat3);

        User user4 = new User(4, "Ana Pereira", "ana@email.com", 419112233);
        Chat chat4 = new Chat(user4.getId(), user4.getName());
        database.addUser(user4);
        database.addChat(chat4);

        User user5 = new User(5, "Lucas Oliveira", "lucas@email.com", 519998877);
        Chat chat5 = new Chat(user5.getId(), user5.getName());
        database.addUser(user5);
        database.addChat(chat5);

        User user6 = new User(6, "Carla Mendes", "carla@email.com", 619998877);
        Chat chat6 = new Chat(user6.getId(), user6.getName());
        database.addUser(user6);
        database.addChat(chat6);

        User user7 = new User(7, "Roberto Lima", "roberto@email.com", 719887766);
        Chat chat7 = new Chat(user7.getId(), user7.getName());
        database.addUser(user7);
        database.addChat(chat7);

        User user8 = new User(8, "Fernanda Costa", "fernanda@email.com", 819776655);
        Chat chat8 = new Chat(user8.getId(), user8.getName());
        database.addUser(user8);
        database.addChat(chat8);

        User user9 = new User(9, "Gabriel Souza", "gabriel@email.com", 919665544);
        Chat chat9 = new Chat(user9.getId(), user9.getName());
        database.addUser(user9);
        database.addChat(chat9);

        // Mensagens de exemplo, uma por chat, com teores diferentes
        String[] exemplos = {
                // Legítima
                "Oi João, tudo bem? Combinamos o almoço de sábado?",

                // Golpe de promoção falsa
                "Parabéns! Você foi selecionado para ganhar um iPhone 16. Clique no link e resgate agora.",

                // Golpe de transação bancária
                "Detectamos uma compra suspeita de R$ 2.450,00. Confirme seus dados bancários imediatamente.",

                // Golpe de pedido de ajuda falso (troca de número)
                "Oi mãe, troquei de número. Estou sem acesso ao database, consegue fazer um PIX urgente para mim?",

                // Falsa vaga de emprego
                "Vaga de renda extra! Ganhe R$ 500 por dia trabalhando de casa. Cadastre-se agora.",

                // Entrega suspeita
                "Sua encomenda está retida. Clique no link para pagar a taxa de liberação.",

                // Legítima
                "Cheguei bem em casa, obrigado pela carona!",

                // Mensagem legítima de database
                "Sua fatura de agosto já está disponível no aplicativo oficial do database.",

                // Golpe de suporte técnico
                "Seu WhatsApp será bloqueado em 24 horas. Confirme seu código de verificação para evitar o bloqueio."
        };

        // loop usado para inserir o array de mensagens mockadas nos chats criados
        for(int i = 0; i < database.getChat().size(); i++){
            Chat chat = database.getChat().get(i);

            Message msg = new Message(
                    i + 1,
                    exemplos[i],
                    chat.getNameChat(),
                    LocalDateTime.now(),
                    null
            );

            chat.saveMessage(msg);
        }

        //variavel para escolha do menu principal
        int choice = 0;

        //enquanto for diferente de 2 o loop continuara
        while (choice != 2) {

            //""" - exibe o bloco inteiro do texto incluindo quebra de linhas
            System.out.println("""
                    ==============================================
                                 Bem vindo ao JavaZap!
                    
                                O que voce deseja fazer?
                    ==============================================
                        1 - Ver mensagens recebidas           
                        2 - Sair
                    ==============================================
                    """);

            choice = leitura.nextInt();

            switch (choice) {
                case 1:
                    int messageChats;
                    int keepChoice;
                    //Se tiver chats disponiveis no banco ele exibe os chats
                    if(!database.getChat().isEmpty()){
                        int i = 1;
                        System.out.println("Mensagens disponíveis: \n");
                        // Percorre os chats armazenados no banco de dados e exibe o ID e o nome de cada um
                        for (Chat chat : database.getChat()){
                            System.out.println( chat.getId() + " - " + chat.getNameChat() + "\n");
                            i ++;
                        }
                    }else{
                        System.out.println("Nenhum mensagem encontrada.");
                    }

                    System.out.println("Escolha um chat para vizualizar(Digite o numero do chat): \n");
                    messageChats = leitura.nextInt();

                    //.stream() - pega a lista e transforma em um fluxo de dados em movimento que vai sendo percorrido item por item
                    //.filter(chat -> chat.getId() == messageChats) - para cada chat que passar verifique se o id ele e igual a messageChats(numero id escolhido por nos)
                    //.findFirst() - Pega o primeiro que passar e para o stream
                    //.orElse(null) - Se achou, entrega o usuário. Se não achou, vira null
                    Chat chatView = database.getChat().stream()
                            .filter(chat -> chat.getId() == messageChats)
                            .findFirst()
                            .orElse(null);

                    //Se o chat criado for DIFERENTE de null , ele executa as intrucoes abaixo
                    if (chatView != null) {
                        //Exibe o nome de chat atraves do metodo de acesso
                        System.out.println(chatView.getNameChat());

                        //Percorre as mensagens analisadas do chat e exibe o conteudo
                        for (Message message : chatService.getAnalyzedChatMessages(chatView)) {
                            System.out.println(message.getContentMessage());
                        }
                    }

                    System.out.println("""
                            ==============================================
                            Deseja retornar para as mensagens disponiveis?
                            ==============================================
                            1 - Sim
                            2 - Não
                            ==============================================
                            """);

                    keepChoice = leitura.nextInt();

                    // se desejo continuar olhando as mensagens
                    if (keepChoice == 1) {
                        choice = 0 ;
                    // senao se desejo parar
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
