# Avaliação Java SVA

## Tecnologias presentes na prova:  

* Spring Boot  
* Spring Data JPA
* Flyway Mogration
* MySql Driver
* Linguagem Java 11

## Subir a Aplicação:

Para executar o projeto será necessário  abrir o projeto em uma IDE (utilizei SpringToolSuite4), depois alterar o arquivo application.properties pra configurar o acesso ao banco de dados, como visto abaixo:
  * spring.datasource.url=jdbc:mysql://localhost:3306/brq_apirest?createDatabaseIfNotExist=true&serverTimezone=UTC
  * spring.datasource.username=root
  * spring.datasource.password=admin
Deverá configurar a porta que a aplicação ira rodar, como visto abaixo:
  * server.port=8089
 
## Para rodar a aplicação:

Para testar o sistema, utilizei a ferramente postman e vou deixar os exemplos de execução inserida no projeto (BRQ.postman_collection.json), lembrando que basta utilizar a mesma porta que foi mapeada em cima. Foi colocado algumas validações, como por exemplo:
  * Validação de tamanho
  * Validação de formado correto de email
  * validação de obrigatoriedade
  * A aplicação não deve deixar inserir duas pessoas com o mesmo cpf (poderia colocar também pra não deixar pro mesmo rg)

## Rodar os testes unitários:

Para rodar os testes unitários, basta executar a classe BrqApirestApplicationTests.java em run as e escolhe Junit test.

## Melhoria na entrega:

Uma melhoria interessante era colocar essa aplicação em um container do docker, pra baixar o mysql, o maven e etc 








