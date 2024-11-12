# 💸 Simulação de Pagamentos com Spring + Kafka

Este projeto fornece um serviço de simulação de pagamentos construído com Spring Boot e Apache Kafka. Permite enviar e consumir mensagens de pagamento, facilitando a integração de dados entre sistemas.

## Funcionalidades ✨
 - Envio de Pagamentos: O serviço permite que os usuários enviem informações de pagamento por meio de uma API REST.
 - Consumo de Pagamentos: As mensagens de pagamento são consumidas por um serviço separado processando e exibindo os dados recebidos.
 - Docker: Kafka e o Zookeeper, é conteinerizado com Docker.
 - Escalável e Integrado: A arquitetura foi projetada para ser simples e escalável, com possibilidade de integrar múltiplos producers e consumers.
   - groupId usado para balancear cargas entre consumers que fazem parte de um mesmo grupo

## Arquitetura 🏗️
 - Spring Boot para a API e services para integração.
 - Kafka para gerenciamento de mensagens de pagamento entre producer e consumer.
 - Docker para containerizar a aplicação e gerenciar Kafka e Zookeeper.

## Configuração ⚙️
1. Clonar o repositório
    ```
    git clone https://github.com/fernandesyuri16/messaging-payments
    cd messaging-payments
    ```

2. Configurar o **application.yml**
- É necessario separar as portas nas quais os projetos serao rodados, de modo que o projeto de producer rode em uma porta diferente do projeto de consumer. Para que assim nao haja conflitos

3. Iniciar o projeto 🐳
    - Inicializar o docker para que tenha o ambiente do Kafta + Zookeeper rodando
      ```
      docker compose up
      ```
    - Subir os projetos executando o comando abaixo em cada ambiente
      ```
      mvn spring-boot:run
      ```

4. Testando os Endpoints ⚡
Simulando um pagamento com uma requisição POST para o service producer, enviando uma mensagem de pagamento para o Kafka:

![image](https://github.com/user-attachments/assets/758a97e5-c69d-4de6-8e3e-fa25759b1919)
  - Após o envio da requisição o service consumer irá executar o tópico do Kafka para processar e seguir o fluxo

5. Consumindo a mensagem
Após o envio do pagamento, o mesmo será consumido pelo service consumer, que neste caso, será processada uma mensagem no console:

![image](https://github.com/user-attachments/assets/f9df13db-f32c-471f-94f8-dd495d222a1c)
  - As mensagens poderão ser vizualizadas via Kibana também, possibilitando um monitoramento e insights em tempo real das transações. Porém, neste projeto nao houve integração com o Kibana.
