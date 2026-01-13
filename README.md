# 🐾 PetShop API --- Cadastro de Pets

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de
**cadastro de pets de um petshop**. A aplicação permite cadastrar pets
informando apenas a **raça**, enriquecendo automaticamente os dados do
animal através de uma **API externa**.

------------------------------------------------------------------------

## 📌 Visão Geral

Este projeto tem como foco demonstrar:

-   Uso de Spring Boot com arquitetura organizada
-   Aplicação prática de Padrões de Projeto
-   Integração com API externa
-   Persistência de dados com H2
-   Documentação automática com Swagger / OpenAPI

------------------------------------------------------------------------

## 🎯 Objetivo do Projeto

-   Cadastrar pets pertencentes a um petshop
-   Armazenar dados do dono do pet
-   Informar apenas a raça do pet
-   Buscar automaticamente características do animal (peso, pelagem,
    comportamento)
-   Manter o projeto simples, extensível e didático

------------------------------------------------------------------------

## 🧱 Arquitetura

Controller → Facade → Service → Repository\
            ↓\
          Factory → Strategy

------------------------------------------------------------------------

## 🧩 Padrões de Projeto Utilizados

### Facade

Centraliza o fluxo de negócio, desacoplando o Controller da lógica
interna.

### Strategy

Define estratégias para obtenção de informações de pets. -
DogPetInfoProvider (implementado) - CatPetInfoProvider (estrutura
criada)

### Factory

Seleciona dinamicamente a estratégia correta conforme o tipo do pet.

### DTO

Controla dados de entrada e saída da API.

### Mapper

Responsável pela conversão entre DTOs e Entidades.

------------------------------------------------------------------------

## 📦 Tecnologias

-   Java 17
-   Spring Boot 3
-   Spring Web
-   Spring Data JPA
-   H2 Database
-   Swagger (Springdoc OpenAPI)
-   Maven

------------------------------------------------------------------------

## 🗄️ Banco de Dados

Banco em memória H2.

Console: http://localhost:8080/h2-console

-   JDBC URL: jdbc:h2:mem:petdb
-   Usuário: sa
-   Senha: (vazio)

------------------------------------------------------------------------

## 🌐 Swagger

http://localhost:8080/swagger-ui/index.html

------------------------------------------------------------------------

## 🔌 API Externa (Dog API)

Busca automática de: - Peso médio - Tipo de pelagem - Temperamento
(traduzido)

------------------------------------------------------------------------

## 🔑 API Key

⚠️ Nunca versionar a chave real.

application.properties:

dogapi.url=https://api.thedogapi.com/v1\
dogapi.api-key=KEY_API_DOG

------------------------------------------------------------------------

## 🔄 Endpoints

POST /pets\
GET /pets\
GET /pets/{id}\
PUT /pets/{id}\
DELETE /pets/{id}

------------------------------------------------------------------------

## 📄 Exemplo JSON

{ "nomeDono": "João Silva", "telefone": "11999999999", "raca":
"Labrador" }

------------------------------------------------------------------------

## 📁 Estrutura de Packages

controller\
facade\
service\
repository\
entity\
dto\
mapper\
factory\
strategy\
config

------------------------------------------------------------------------

## 🚀 Evoluções Futuras

-   Integração com Cat API
-   Cache por raça
-   Autenticação JWT
-   Testes unitários
-   Deploy em cloud

------------------------------------------------------------------------

