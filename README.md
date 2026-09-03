# JavaZap - Scam Security

Aplicação Java de console desenvolvida para identificar possíveis golpes em mensagens de chat. O projeto simula conversas, analisa o conteúdo recebido e classifica cada mensagem como legítima, suspeita ou golpe.

## Funcionalidades

- Criação de usuários e chats em memória.
- Inserção de mensagens de exemplo em diferentes cenários.
- Classificação automática das mensagens por palavras-chave e expressões regulares.
- Alertas no console para mensagens suspeitas ou identificadas como possíveis golpes.
- Consulta das mensagens por chat através de um menu interativo.

## Classificações

| Classificação | Descrição |
| --- | --- |
| `LEGITIMATE` | Mensagem sem padrões de risco identificados. |
| `SUSPECT` | Mensagem com termos que exigem cautela, como links, atualização de dados ou códigos. |
| `SCAM` | Mensagem com indícios fortes de golpe, como PIX urgente, prêmio, bloqueio ou cobrança suspeita. |

A análise é baseada em regras estáticas no arquivo `src/service/MessageAnalyzer.java`. Portanto, ela serve como uma demonstração educacional e não substitui mecanismos reais de segurança ou moderação.

## Tecnologias

- Java 17 ou superior
- Java Collections Framework
- Expressões regulares (`java.util.regex.Pattern`)
- `LocalDateTime` para registrar a data e hora das mensagens

O Java 17 é recomendado porque o código utiliza text blocks e switch expressions.

## Pré-requisitos

Verifique se o Java está instalado:

```bash
java -version
javac -version
```

## Como executar

Na raiz do projeto, compile todos os arquivos `.java`:

### Windows PowerShell

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out main
```

### Linux, macOS ou Git Bash

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out main
```

## Como usar

1. Execute a aplicação.
2. Escolha `1` para visualizar as mensagens disponíveis.
3. Informe o número do chat desejado, de `1` a `9`.
4. Leia as mensagens e os alertas gerados pela análise.
5. Escolha se deseja consultar outro chat ou sair com a opção `2`.

As mensagens e os usuários são criados automaticamente quando o programa inicia. Como os dados são mantidos somente em memória, todas as informações são perdidas ao encerrar a aplicação.

## Estrutura do projeto

```text
src/
├── main.java                 # Ponto de entrada e menu do console
├── model/
│   ├── Chat.java             # Chat e sua lista de mensagens
│   ├── Classifications.java  # Enumera as classificações possíveis
│   ├── Message.java          # Representa uma mensagem
│   └── User.java             # Representa um usuário
├── repository/
│   └── Database.java         # Armazena usuários e chats em memória
└── service/
    ├── ChatService.java      # Coordena a análise das mensagens do chat
    └── MessageAnalyzer.java  # Aplica as regras de classificação
```

## Possíveis evoluções

- Persistir usuários, chats e mensagens em um banco de dados.
- Permitir o cadastro de novas mensagens pelo usuário.
- Separar as regras de detecção em uma configuração ou serviço independente.
- Adicionar testes automatizados para os diferentes padrões de mensagens.

## Objetivo educacional

O projeto faz parte de um desafio sobre golpes digitais e demonstra conceitos de orientação a objetos, coleções, enumerações, expressões regulares e serviços.
