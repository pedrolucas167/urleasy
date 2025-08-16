# Encurtador de URLs

Uma aplicação para encurtar URLs, desenvolvida em **Java 17** com **Spring Boot** e **MongoDB**. Gera URLs curtas com códigos alfanuméricos de 5 a 10 caracteres, armazena-as no banco com validade de 30 dias e redireciona para a URL original. Retorna HTTP 404 se a URL não existir ou estiver expirada. A lógica principal está implementada diretamente no controller.

## Funcionalidades

- **Encurtar URL**: Envie uma requisição `POST /shorten-url` com o corpo `{"url": "https://example.com"}` para receber uma URL curta, como `{"url": "https://xxx.com/DXB6V"}`.
- **Redirecionamento**: Acesse `GET /[código]` (ex.: `GET /DXB6V`) para ser redirecionado à URL original (HTTP 301) ou receber 404 se o código for inválido ou expirado.
- **Códigos de URL**: Compostos por letras (A-Z, a-z) e números (0-9), com tamanho entre 5 e 10 caracteres.
- **Validade**: URLs curtas expiram após 30 dias.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Web, Data MongoDB)
- **MongoDB**
- **Maven**
- **Docker** (com `docker-compose` para gerenciar o MongoDB)

## Pré-requisitos

- **Java 17** instalado
- **Maven** instalado
- **Docker** e **Docker Compose** instalados
- Conexão com a internet para baixar dependências e imagens Docker

## Instalação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/encurtador-urls.git
   cd encurtador-urls
   
