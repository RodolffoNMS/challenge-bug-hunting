# Versão 1: Sistema Básico de Gerenciamento de Vídeos
Funcionalidades
Adicionar vídeos.
Listar vídeos.
Estrutura Inicial do Projeto

````
src/
├── main/
│   └── Main.java
├── model/
│   └── Video.java
├── repository/
│   ├── VideoRepository.java
│   └── FileVideoRepository.java
└── util/
    └── FileHandler.java
````
## 🗒 Passo a passo para Desenvolvimento

### 1. Configurando o ambiente

Antes de começar, certifique-se de que você tem as ferramentas necessárias instaladas no seu ambiente de desenvolvimento:

- Java 17 ou superior.
- Um editor de código ou IDE, como IntelliJ IDEA ou VSCode.
- Git para versionamento de código.

### 2. Rodando o sistema
   Para rodar o sistema, basta compilar e executar o arquivo Main.java. Caso use o IntelliJ basta "dar play" ou, caso utilize o terminal, pode rodar via comando. Por exemplo:
   
```
javac -d bin src/main/Main.java
java ./src/main/Main.java
```
O sistema permite que o usuário:

- Adicione novos vídeos.
- Liste os vídeos armazenados.
- Pesquise vídeos por título.
