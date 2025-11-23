![Java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java)
![Status](https://img.shields.io/badge/Status-Concluído-success)
![License](https://img.shields.io/badge/License-MIT-blue)


# 📚 Sistema de Biblioteca - Java

Sistema de gerenciamento de biblioteca desenvolvido em Java, utilizando Collections Framework para manipulação de dados em memória.

## 🎯 Sobre o Projeto

Projeto desenvolvido como parte dos meus estudos em **Java** e **Estruturas de Dados**, com foco em:
- Collections Framework (List, Set, Map)
- Orientação a Objetos
- Modelagem de classes e relacionamentos
- Lógica de negócio e validações

## 🚀 Funcionalidades

- ✅ **Cadastro de livros** (ISBN, título, autor, categoria)
- ✅ **Cadastro de usuários** (CPF, nome, email)
- ✅ **Empréstimo de livros** (controle de disponibilidade)
- ✅ **Devolução de livros** (registro de data)
- ✅ **Listagem de livros disponíveis**
- ✅ **Listagem de usuários cadastrados**
- ✅ **Listagem de empréstimos por usuário**

## 🛠️ Tecnologias Utilizadas

- **Java 17** 
- **Collections Framework**
  - `ArrayList` - Armazenamento de livros e empréstimos
  - `HashMap` - Busca rápida de usuários por CPF
  - `HashSet` - Controle de categorias únicas
- **LocalDate** - Manipulação de datas
- **JOptionPane** - Interface gráfica simples

## 📂 Estrutura do Projeto
```
src/
├── Entidades/
│   ├── Livro.java          # Modelo de livro
│   ├── Usuario.java        # Modelo de usuário
│   ├── Emprestimo.java     # Modelo de empréstimo
│   └── Biblioteca.java     # Lógica de negócio
└── aplicacao/
    └── MenuMain.java       # Menu principal (CLI)
```

## 💡 Decisões Técnicas

### Por que cada Collection?

<table>
<tr>
<td width="25%">

### 📚 List\<Livro\>
**Uso:** Armazenar livros

**Motivo:** Mantém ordem de cadastro e permite percorrer todos os livros sequencialmente

**Performance:** O(1) acesso por índice

</td>
<td width="25%">

### 👥 Map\<String, Usuario\>
**Uso:** Usuários por CPF

**Motivo:** Busca direta pela chave (CPF) sem loop, ideal para consultas rápidas

**Performance:** O(1) busca

</td>
<td width="25%">

### 🏷️ Set\<String\>
**Uso:** Categorias únicas

**Motivo:** Garante automaticamente que não existem categorias duplicadas

**Performance:** O(1) inserção

</td>
<td width="25%">

### 📋 List\<Emprestimo\>
**Uso:** Histórico completo

**Motivo:** Permite múltiplos empréstimos por usuário com ordem cronológica

**Performance:** O(1) inserção

</td>
</tr>
</table>

### Orientação a Objetos

- **Encapsulamento**: Atributos `private`, acesso via getters/setters
- **equals() e hashCode()**: Comparação por ISBN (Livro) e CPF (Usuario)
- **toString()**: Representação textual dos objetos

### Validações Implementadas

✅ Livro duplicado (mesmo ISBN)  
✅ Usuário duplicado (mesmo CPF)  
✅ Livro disponível antes de emprestar  
✅ Livro emprestado antes de devolver  
✅ Usuário existente antes de emprestar  

## 🏃 Como Executar

### Pré-requisitos
- Java JDK 11+ instalado
- IDE (Eclipse, IntelliJ, VSCode) ou compilador Java

### Passos

1. **Clone o repositório**
```bash
git clone https://github.com/SEU-USUARIO/sistema-biblioteca-java.git
cd sistema-biblioteca-java
```

2. **Abra na sua IDE**
   - Eclipse: File → Open Projects from File System
   - IntelliJ: File → Open
   - VSCode: File → Open Folder

3. **Execute a classe principal**
   - Navegue até `aplicacao/MenuMain.java`
   - Run → Run As → Java Application (Eclipse)
   - Ou compile: `javac aplicacao/MenuMain.java` e execute: `java aplicacao.MenuMain`

4. **Interaja com o menu**
```
***** MENU *****
1. Cadastrar Livro
2. Cadastrar Usuario
3. Emprestar Livro
4. Devolver Livro
5. Listar Livros
6. Listar Usuarios
7. Listar Emprestimos
8. Sair
```

## 📸 Exemplo de Uso

### Cadastrando um livro:
```
ISBN: 978-0132350884
Título: Clean Code
Autor: Robert C. Martin
Categoria: Programação

✅ Livro adicionado com sucesso!
```

### Emprestando um livro:
```
ISBN: 978-0132350884
CPF: 123.456.789-00

✅ Empréstimo criado com sucesso!
```

### Devolvendo um livro:
```
ISBN: 978-0132350884

✅ Devolução realizada com sucesso!
```

## 📚 Conceitos de Java Aplicados

- ✅ Classes e Objetos
- ✅ Encapsulamento (private + getters/setters)
- ✅ Collections (List, Map, Set)
- ✅ Generics (`<T>`)
- ✅ Override (equals, hashCode, toString)
- ✅ LocalDate (java.time)
- ✅ Loops (for, for-each)
- ✅ Validações e tratamento de erros

## 🔄 Próximas Melhorias

- [ ] Persistência em banco de dados (MySQL/PostgreSQL)
- [ ] API REST com Spring Boot
- [ ] Autenticação de usuários
- [ ] Sistema de multas por atraso
- [ ] Relatórios (livros mais emprestados, usuários ativos)
- [ ] Interface gráfica com JavaFX ou Swing
- [ ] Testes unitários (JUnit)

## 🧠 Aprendizados

Este projeto me ensinou:
- Manipulação eficiente de Collections
- Quando usar List vs Set vs Map
- Importância de equals() e hashCode()
- Modelagem de relacionamentos entre classes
- Validações e lógica de negócio
- Organização de código (separação de responsabilidades)

## 👨‍💻 Autor

**[Jean Vicente Lima da Silva]**

- 💼 LinkedIn: [Jean Vicente](www.linkedin.com/in/jean-silva-vicente)
- 🐙 GitHub: [@JevScript](https://github.com/JevScript)
- 📧 Email: jeanvicente2002@gmail.com

---

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais.

---

⭐ **Se este projeto te ajudou, deixe uma estrela!**

💬 **Dúvidas ou sugestões?** Abra uma [issue](https://github.com/JevScript/Sistema-biblioteca-java/issues)!