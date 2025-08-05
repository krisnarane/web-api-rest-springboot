# Web API

API REST desenvolvida com Spring Boot para gerenciamento de usuários, com tratamento de exceções, documentação Swagger/OpenAPI e exemplos de boas práticas.

## Sumário

- [Descrição](#descrição)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Executar](#como-executar)
- [Endpoints](#endpoints)
- [Tratamento de Erros](#tratamento-de-erros)
- [Documentação Swagger](#documentação-swagger)
- [Testes](#testes)
- [Autor](#autor)

---

## Descrição

Este projeto é uma API RESTful para cadastro e gerenciamento de usuários, implementada em Java 21 com Spring Boot 3.3.0. O repositório de usuários é em memória (não utiliza banco de dados), ideal para fins didáticos e prototipagem.

---

## Funcionalidades

- Cadastro de usuários com validação de dados.
- Listagem de todos os usuários.
- Busca de usuário por login ou ID.
- Atualização e remoção de usuários.
- Tratamento global de exceções.
- Documentação automática com Swagger/OpenAPI.

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.3.0
- Spring Web
- Spring Validation
- Springdoc OpenAPI (Swagger)
- JUnit 5 (testes)
- Maven

---

## Como Executar

1. **Pré-requisitos:** Java 21 e Maven instalados.
2. **Clone o repositório:**
   ```sh
   git clone https://github.com/krisnarane/web-api-rest-springboot
   cd web-api
   ```
3. **Compile e execute:**
   ```sh
   mvn clean compile spring-boot:run
   ```
4. Acesse a API em: `http://localhost:8080`

---

## Endpoints

### Welcome

- `GET /`  
  Mensagem de boas-vindas.

### Usuários

- `GET /users`  
  Lista todos os usuários.

- `GET /users/{username}`  
  Busca usuário pelo login.

- `GET /users/id/{id}`  
  Busca usuário pelo ID.

- `POST /users`  
  Cria um novo usuário.  
  **Body:**  
  ```json
  {
    "login": "usuario",
    "password": "senha"
  }
  ```

- `PUT /users`  
  Atualiza um usuário existente.

- `DELETE /users/{id}`  
  Remove usuário pelo ID.

---

## Tratamento de Erros

- Erros de negócio e validação retornam resposta padronizada:
  ```json
  {
    "timestamp": "2025-08-05T12:00:00",
    "status": "error",
    "statusCode": 409,
    "error": "Mensagem de erro"
  }
  ```

---

## Documentação Swagger

Acesse a documentação interativa em:  
`http://localhost:8080/swagger-ui.html`  
ou  
`http://localhost:8080/swagger-ui/index.html`

---

## Testes

Os testes automatizados estão em `src/test/java`. Para rodar:

```sh
mvn test
```

---

## Autor

- Nome: Julia Krisnarane
- Email: jkrisnarane@gmail.com

---
