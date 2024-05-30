# API Movies

API RESTful que possibilita a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

## Informações Gerais
Projeto desenvolvido seguindo como referência os requisitos solicitados, onde a API deve:
* Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao inciar a aplicação.
* Obter o  produtor com  maior  intervalo  entre  dois  prêmios consecutivos.
* Obter o  produtor que ganhou  dois  prêmios mais rápido.

## Tecnologias Utilizadas

* Java 17
* SpringBoot(JPA, rest, web, test, Lombok, JUnit, OpenCSV)
* H2 in Memory Database

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas na sua máquina:

- **Java JDK 17**: Você pode baixá-lo [aqui](https://www.oracle.com/br/java/technologies/downloads/#java17).
- **Maven (Opcional)**: Você pode baixá-lo [aqui](https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.zip), mas é opcional caso queira compilar manualmente o projeto.
- **Git (Opcional)**: Caso não queira ter o Git instalado, basta fazer o download do projeto [aqui](https://github.com/stegel-felipe/apiMovies/archive/refs/heads/main.zip).
- **Postman (Opcional)**: Para testar as requisições da API, você pode baixá-lo [aqui](https://www.postman.com/downloads/).

## Configuração

Para rodar o projeto em ambiente local de desenvolvimento basta clonar o projeto e importar em alguma IDE (Ex.: Eclipse, Intellij).

Executar a classe ``` MoviesWebServiceApplication ``` para subir a API que ficará disponível em ```http://locahost/8080``` ou através do comando maven: ```mvn spring-boot:run```

Ao executar esta classe e subir a aplicação o sistema irá invocar o método ```importMoviesFromCSV``` da classe ```MovieService``` importando o arquivo CSV de filmes.
Esse arquivo deve estar no dirétorio ```src/main/resources/data```.

## Running os testes

Para rodar os testes de integração basta rodar a classe ```MoviesWebServiceApplicationTest``` ou através do comando maven: ```mvn test```

## Acessando o Banco de Dados

1. Após a inicialização da aplicação, você pode acessar o console do banco de dados H2 em: [H2 Console](http://localhost:8080/h2-console)

2. Para se conectar ao banco de dados, não é necessário inserir uma senha.

    Driver Class: org.h2.Driver <br/>
    JDBC URL: jdbc:h2:mem:indicadores <br/>
    User name: sa <br/>
    Password:


## REST Api

Para testar a API, pode utilizar o Postman para testar a requisição. Abaixo está um exemplo de como fazer uma requisição:

- Método: GET
- URL: http://localhost:8080/api/movies/interval
- Descrição: Retorna o produtor com maior intervalo entre dois prêmios consecutivos e o produtor que obteve dois prêmios mais rápido.

Pode também acessar via browser que irá trazer o resultado: `http://localhost:8080/api/movies/interval`

### Acessando o Swagger
Após a aplicação estiver sendo executada, acesse a página do [Swagger](http://localhost:8080/swagger-ui.html), onde poderá ver uma documentação com os detalhes do endpoint.


## Autor

[Felipe Stegel](https://www.linkedin.com/in/felipestegel/)
