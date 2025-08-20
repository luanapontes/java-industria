# 🏭 Teste Prático - Programação Java

Este projeto foi desenvolvido como parte de um **teste prático de programação**, atendendo aos requisitos propostos pela empresa.  
O objetivo foi criar um sistema simples de gestão de funcionários utilizando **Java e Programação Orientada a Objetos (POO)**.

---

## 🚀 Tecnologias utilizadas
- Java 
- IntelliJ
- Collections (List, Map, Stream API)
- BigDecimal para manipulação de valores monetários
- LocalDate e DateTimeFormatter para datas

---

## 📌 Estrutura do Projeto
- **Pessoa.java** → Classe base com atributos `nome` e `dataNascimento`.  
- **Funcionario.java** → Herda de `Pessoa`, adicionando `salario` e `funcao`.  
- **Principal.java** → Classe com método `main` que realiza todas as operações.

---

## ✅ Funcionalidades Implementadas
1. Inserir todos os funcionários na lista.  
2. Exibir lista **antes e depois de remover** o funcionário **João**.  
3. Imprimir todos os funcionários com:
   - Data no formato `dd/MM/yyyy`
   - Salário formatado em padrão brasileiro  
4. Aplicar aumento de **10% no salário** de todos os funcionários.  
5. Agrupar funcionários por função usando `Map`.  
6. Imprimir funcionários agrupados por função.  
7. Listar funcionários que fazem aniversário nos meses **10 (Outubro)** e **12 (Dezembro)**.  
8. Encontrar o funcionário com **maior idade** (nome + idade).  
9. Ordenar a lista de funcionários em **ordem alfabética**.  
10. Calcular o **total dos salários**.  
11. Calcular **quantos salários mínimos** cada funcionário recebe (considerando R$1212,00).  

---

## ▶️ Como executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/luanapontes/java-industria.git

2. Abra o projeto na IDE.
3. Compile e rode a classe Principal.java.
4. O resultado será exibido no console.
