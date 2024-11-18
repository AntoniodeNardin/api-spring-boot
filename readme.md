# User Department API

Este é um projeto de uma API para gerenciamento de usuários e departamentos. A API permite realizar operações CRUD (Create, Read, Update, Delete) para gerenciar usuários e seus respectivos departamentos.

## Tecnologias

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database (Banco de Dados em Memória)**
- **Validation com Hibernate Validator**

## Funcionalidades

A API possui as seguintes funcionalidades:

- **Cadastrar um novo usuário** (`POST /users`)
- **Listar todos os usuários** (`GET /users`)
- **Buscar um usuário pelo ID** (`GET /users/{id}`)
- **Atualizar um usuário** (`PUT /users/{id}`)
- **Excluir um usuário** (`DELETE /users/{id}`)
- **Cadastrar um novo departamento** (`POST /departments`)
- **Listar todos os departamentos** (`GET /departments`)

## Endpoints da API

### Usuários

- **Criar um usuário** (`POST /users`)

  Exemplo de requisição:
  ```json
  {
    "name": "Ricardo",
    "email": "ricardo@gmail.com",
    "department": {
      "id": 1
    }
  }
