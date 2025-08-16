Encurtador de URLs

Aplicação para encurtar URLs, construída em Java com Spring Boot e MongoDB. Gera URLs curtas com códigos de 5 a 10 caracteres alfanuméricos, armazena no banco com validade de 30 dias e redireciona para a URL original. Retorna 404 se a URL não existe ou expirou. A lógica principal está implementada diretamente no controller.
Funcionalidades

Encurtar URL: POST /shorten-url com {"url": "https://backendbrasil.com.br"} retorna {"url": "https://xxx.com/DXB6V"}.
Redirecionamento: GET /DXB6V redireciona para a URL original (HTTP 301) ou retorna 404 se inválida.
Códigos: Apenas letras e números, 5-10 caracteres.
Validade: URLs expiram em 30 dias.

Tecnologias

Java 17
Spring Boot (Web, Data MongoDB)
MongoDB
Maven
Docker (com docker-compose para MongoDB)

Instalação

Clone o repositório:
git clone https://github.com/seu-usuario/encurtador-urls.git
cd encurtador-urls


Configure o MongoDB com Docker:

Certifique-se de ter o Docker e o Docker Compose instalados.
Crie um arquivo docker-compose.yml na raiz do projeto:version: '3.8'
services:
mongodb:
image: mongo:latest
container_name: mongodb
ports:
- "27017:27017"
environment:
- MONGO_INITDB_DATABASE=encurtador
volumes:
- mongodb_data:/data/db
volumes:
mongodb_data:




Inicie o MongoDB:
docker-compose up -d


Adicione application.properties em src/main/resources:
spring.data.mongodb.uri=mongodb://localhost:27017/encurtador
app.host.url=https://xxx.com
app.expiration.days=30


Compile e execute a aplicação:
mvn clean install
mvn spring-boot:run



Uso

Encurtar: POST http://localhost:8080/shorten-url
Redirecionar: GET http://localhost:8080/[código]

Estrutura
encurtador-urls/
├── src/main/java/com/example/encurtador/
│   ├── controller/    # Endpoints REST e lógica de encurtamento
│   ├── repository/    # Acesso ao MongoDB
│   ├── model/         # Entidades
│   └── EncurtadorApplication.java
├── src/main/resources/application.properties
├── docker-compose.yml  # Configuração do MongoDB
└── pom.xml

Parar o MongoDB
Para parar o container do MongoDB:
docker-compose down
