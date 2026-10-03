# ⏰ Exercício Clock - Bootcamp Java com IA | Itaú & DIO

Projeto desenvolvido como parte dos exercícios práticos de Java Básico do **Bootcamp Java com IA** (parceria **Itaú** & **DIO**).

O objetivo do projeto é simular o funcionamento de diferentes modelos de relógios com fusos horários (`ZoneId`) e formatos de exibição específicos (formato 24h brasileiro e formato 12h AM/PM americano), aplicando os pilares da Programação Orientada a Objetos (POO) e recursos modernos da linguagem Java.

---

## 🚀 Conceitos e Tecnologias Aplicados

- **Java 17 / 21+**
- **POO Avançada**:
  - **Classes Abstratas e Herança**: classe base `Clock` definindo o comportamento comum e template de fuso horário.
  - **Encapsulamento**: atributos privados com atualização controlada através do método `updateClock()`.
  - **Polimorfismo e Sobrescrita**: personalização de formatos e fusos em cada subclasse.
- **Recursos Modernos do Java**:
  - **Sealed Classes (`sealed` / `permits`)**: restrição e controle estrito das subclasses permitidas (`AmericanClock`, `BrazilianClock`).
  - **Pattern Matching for `switch`**: verificação exaustiva de tipos no switch sem necessidade de `default` graças à classe selada.
- **API `java.time`**:
  - Manipulação atômica de horários usando `OffsetDateTime`, `ZoneId` e `LocalTime`.
  - Formatação e internacionalização com `DateTimeFormatter` e `Locale.US`.

---

## 📁 Estrutura do Projeto

```text
Clock/
├── src/
│   ├── Clock.java            # Classe base abstrata e selada (lógica central do relógio)
│   ├── BrazilianClock.java   # Relógio no fuso 'America/Sao_Paulo' (formato 24h)
│   ├── AmericanClock.java    # Relógio no fuso 'America/New_York' (formato 12h AM/PM)
│   └── App.java              # Ponto de entrada (Main) com Pattern Matching no switch
└── bin/                      # Bytecodes compilados (.class)
```

---

## ⚙️ Como Executar

### Pré-requisitos
- JDK 21 (ou superior) instalado e configurado no PATH.

### Compilação e Execução via Terminal

1. Compile os arquivos Java para o diretório `bin/`:
   ```bash
   javac -d bin src/*.java
   ```

2. Execute a aplicação:
   ```bash
   java -cp bin App
   ```

### Saída Esperada no Console

```text
Relógio Americano.
São: 07:03:52 pm
===========================
Relógio Brasileiro.
São: 20:03:52
Fim de execução.
```

---

Desenvolvido para fins de estudo e prática no ecossistema de aprendizado da [DIO](https://dio.me).
