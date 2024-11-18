# User Department API

API RESTful para gerenciamento de usuários e departamentos utilizando **Java** e **Spring Boot**.

## Tecnologias

- **Java 11+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate Validator**
- **H2 Database** (em memória)

## Funcionalidades

- **Usuários**: CRUD completo (Criar, Ler, Atualizar, Excluir)
- **Departamentos**: CRUD completo

## Endpoints

### Usuários

- **POST /users**: Criar usuário
- **GET /users**: Listar usuários
- **GET /users/{id}**: Buscar usuário por ID
- **PUT /users/{id}**: Atualizar usuário
- **DELETE /users/{id}**: Excluir usuário

### Departamentos

- **POST /departments**: Criar departamento
- **GET /departments**: Listar departamentos

## Como Rodar

1. Clone o repositório:

    ```bash
    git clone <link-do-repositório>
    ```

2. Compile e execute com Maven:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. Acesse a API em: [http://localhost:8080](http://localhost:8080)

## Testes

Use o **Postman** para testar os endpoints da API.

Exemplo de requisição para criar usuário:

```json
{
  "name": "Ricardo",
  "email": "ricardo@gmail.com",
  "department": {
    "id": 1
  }
}
