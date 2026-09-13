# 🏥 Health Scheduler API

API RESTful completa desenvolvida em **Spring Boot 3** para gerenciamento de agendamentos médicos, autenticação e controle de pacientes e médicos.

Projeto implantado e rodando em nuvem com banco de dados relacional **PostgreSQL**.

---

## 🔗 Links Úteis & Produção

* **URL base da API (Railway):** `https://healthscheduler-production.up.railway.app`
* **Documentação Interativa (Swagger UI):** [Acessar Swagger UI](https://healthscheduler-production.up.railway.app/swagger-ui.html)
* **Especificação OpenAPI:** `https://healthscheduler-production.up.railway.app/v3/api-docs`

---

## 🛠️ Tecnologias Utilizadas

* **Java 21 (LTS)**
* **Spring Boot 3.x**
* **Spring Data JPA / Hibernate**
* **Spring Security + JWT (JSON Web Tokens)**
* **PostgreSQL** (Banco de dados em Produção)
* **MapStruct & Lombok** (Mapeamento de DTOs e código limpo)
* **OpenAPI / Swagger UI** (Documentação automatizada)
* **Railway & Railpacks** (Deploy / CI-CD)

---

## 🔑 Autenticação

A API utiliza segurança baseada em **Spring Security** e tokens **JWT (JSON Web Token)**.

1. **Cadastre um usuário:** Faça um `POST` em `/auth/register` enviando o payload com a role desejada (`ADMIN` ou `USER`).
2. **Obtenha o Token:** Faça um `POST` em `/auth/login` para receber seu token de acesso.
3. **Autentique as requisições:** Nas rotas protegidas, inclua o cabeçalho HTTP:
   ```http
   Authorization: Bearer <seu_token_jwt>
