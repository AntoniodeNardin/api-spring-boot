User Department API
Este projeto é uma API RESTful desenvolvida com Java e Spring Boot para o gerenciamento de usuários e departamentos. A API permite realizar operações CRUD (Create, Read, Update, Delete) tanto para usuários quanto para seus respectivos departamentos.

Tecnologias Utilizadas
Java 11+: Linguagem de programação principal.
Spring Boot: Framework utilizado para facilitar o desenvolvimento da API.
Spring Data JPA: Para interagir com o banco de dados e realizar operações de persistência.
Hibernate Validator: Para validar as entradas dos dados de forma eficiente.
H2 Database: Banco de dados em memória utilizado durante o desenvolvimento e testes.
Funcionalidades
A API oferece as seguintes funcionalidades para gerenciar usuários e departamentos:

Usuários
Cadastrar um novo usuário (POST /users)
Listar todos os usuários (GET /users)
Buscar um usuário pelo ID (GET /users/{id})
Atualizar um usuário (PUT /users/{id})
Excluir um usuário (DELETE /users/{id})
Departamentos
Cadastrar um novo departamento (POST /departments)
Listar todos os departamentos (GET /departments)
Estrutura de Endpoints
Usuários
1. Criar um novo usuário
Método: POST /users
Descrição: Cria um novo usuário, associando-o a um departamento existente.
Exemplo de requisição:

json
Copiar código
{
  "name": "Ricardo",
  "email": "ricardo@gmail.com",
  "department": {
    "id": 1
  }
}
Resposta de Sucesso:

json
Copiar código
{
  "id": 1,
  "name": "Ricardo",
  "email": "ricardo@gmail.com",
  "department": {
    "id": 1,
    "name": "TI"
  }
}
2. Listar todos os usuários
Método: GET /users
Descrição: Retorna a lista de todos os usuários cadastrados.
Exemplo de resposta:

json
Copiar código
[
  {
    "id": 1,
    "name": "Ricardo",
    "email": "ricardo@gmail.com",
    "department": {
      "id": 1,
      "name": "TI"
    }
  },
  {
    "id": 2,
    "name": "Ana",
    "email": "ana@gmail.com",
    "department": {
      "id": 2,
      "name": "Marketing"
    }
  }
]
3. Buscar um usuário pelo ID
Método: GET /users/{id}
Descrição: Retorna os detalhes de um usuário específico, dado o seu ID.
Exemplo de resposta:

json
Copiar código
{
  "id": 1,
  "name": "Ricardo",
  "email": "ricardo@gmail.com",
  "department": {
    "id": 1,
    "name": "TI"
  }
}
4. Atualizar um usuário
Método: PUT /users/{id}
Descrição: Atualiza as informações de um usuário existente.
Exemplo de requisição:

json
Copiar código
{
  "name": "Ricardo Silva",
  "email": "ricardo.silva@gmail.com",
  "department": {
    "id": 1
  }
}
Resposta de Sucesso:

json
Copiar código
{
  "id": 1,
  "name": "Ricardo Silva",
  "email": "ricardo.silva@gmail.com",
  "department": {
    "id": 1,
    "name": "TI"
  }
}
5. Excluir um usuário
Método: DELETE /users/{id}
Descrição: Exclui um usuário específico pelo ID.
Resposta de Sucesso:

json
Copiar código
{
  "message": "Usuário excluído com sucesso."
}
Departamentos
1. Criar um novo departamento
Método: POST /departments
Descrição: Cria um novo departamento.
Exemplo de requisição:

json
Copiar código
{
  "name": "TI"
}
Resposta de Sucesso:

json
Copiar código
{
  "id": 1,
  "name": "TI"
}
2. Listar todos os departamentos
Método: GET /departments
Descrição: Retorna a lista de todos os departamentos cadastrados.
Exemplo de resposta:

json
Copiar código
[
  {
    "id": 1,
    "name": "TI"
  },
  {
    "id": 2,
    "name": "Marketing"
  }
]
Como Rodar o Projeto
Pré-requisitos
Java 11 ou superior.
Maven para gerenciamento de dependências e execução do projeto.
Passos para execução
Clone o repositório do projeto.
bash
Copiar código
git clone <link-do-repositório>
Acesse o diretório do projeto.
bash
Copiar código
cd user-department-api
Compile o projeto utilizando Maven.
bash
Copiar código
mvn clean install
Execute o projeto.
bash
Copiar código
mvn spring-boot:run
A API estará disponível em http://localhost:8080.
Testando a API
Para testar os endpoints da API, você pode utilizar o Postman ou qualquer outra ferramenta de testes de APIs.

Exemplo de teste com Postman:

GET /users: Listar todos os usuários.
POST /users: Cadastrar um novo usuário.
Banco de Dados
Este projeto utiliza o H2 Database em memória. O banco de dados é automaticamente configurado pelo Spring Boot e não requer configuração adicional. No entanto, em ambientes de produção, é recomendável utilizar um banco de dados persistente como MySQL ou PostgreSQL.

Considerações Finais
Esta API foi desenvolvida com o objetivo de gerenciar usuários e departamentos de forma simples e eficiente. Para futuras melhorias, é possível adicionar funcionalidades como autenticação, autorização, e mais validações de dados.
