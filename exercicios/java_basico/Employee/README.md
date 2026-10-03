# 🏢 Sistema de Gestão de Funcionários (Employee System)

> Projeto desenvolvido como exercício prático do **Bootcamp Java IA Itaú** na plataforma da [DIO (Digital Innovation One)](https://dio.me).

---

## 📌 Sobre o Projeto

Este projeto consiste em uma modelagem orientada a objetos de um sistema de funcionários com diferentes perfis de acesso e responsabilidades: **Gerente (`Manager`)**, **Vendedor (`Seller`)** e **Atendente (`Attendant`)**.

O objetivo principal foi exercitar os pilares da Programação Orientada a Objetos (POO), além de aplicar conceitos modernos da linguagem Java (Java 17+) para garantir tipagem estrita, encapsulamento e código limpo (*DRY*).

---

## 🧱 Arquitetura e Modelagem

O sistema foi estruturado a partir de uma hierarquia centralizada na classe abstrata `Employee`:

```text
               ┌───────────────────────┐
               │  «sealed abstract»    │
               │       Employee        │
               └───────────┬───────────┘
                           │
       ┌───────────────────┼───────────────────┐
       ▼                   ▼                   ▼
┌──────────────┐    ┌──────────────┐    ┌──────────────┐
│   Manager    │    │    Seller    │    │  Attendant   │
│   (final)    │    │   (final)    │    │   (final)    │
└──────────────┘    └──────────────┘    └──────────────┘
```

### 💼 Responsabilidades por Perfil

- **`Employee` (Superclasse Abstrata):**
  - Gerenciamento de dados cadastrais (nome, e-mail corporativo e senha).
  - Regras de segurança e validações (formato de e-mail via Regex, tamanho mínimo de senha).
  - Controle centralizado de sessão e autenticação (`login()` e `logoff()`).

- **`Seller` (Vendedor):**
  - Registro de vendas (`sell()`).
  - Consulta do total de vendas realizadas.

- **`Attendant` (Atendente):**
  - Controle operacional de fluxo de caixa (`openRegister()`, `receivePayment()`, `closeRegister()`).
  - Manutenção do saldo acumulado do caixa.

- **`Manager` (Gerente):**
  - Acesso a auditoria e supervisão.
  - Relatório de vendas de vendedores (`checkSales()`).
  - Relatório financeiro de caixas operados por atendentes (`financialReport()`).

---

## 🚀 Conceitos e Tecnologias Aplicadas

- **Java 17+:** Uso de `sealed classes` (`permits`) e subclasses `final`, garantindo um controle estrito da árvore de herança em tempo de compilação.
- **Encapsulamento Rígido:** Atributos privados e métodos de manipulação protegidos/públicos com validação de estado (operações permitidas apenas com usuário logado).
- **Herança e Princípio DRY (*Don't Repeat Yourself*):** Lógica comum de autenticação centralizada na superclasse, evitando duplicação de regras de negócio.
- **Polimorfismo e Type Casting:** Demonstração prática de *downcasting* no fluxo de execução da classe `App`.
- **Expressões Regulares (Regex):** Validação de formato padronizado de e-mails corporativos (`xxx@company.com`).

---

## 🛠️ Como Executar

### Pré-requisitos
- **Java JDK 17** ou superior instalado.

### Passos:
1. Clone o repositório ou navegue até a pasta do projeto:
   ```bash
   cd Employee
   ```

2. Compile os arquivos Java:
   ```bash
   javac src/*.java -d bin/
   ```

3. Execute a aplicação:
   ```bash
   java -cp bin App
   ```

---

## 👨‍💻 Autor

Desenvolvido por **Aluilson**  
Estudante do **Bootcamp Java IA Itaú** pela [DIO](https://dio.me).
