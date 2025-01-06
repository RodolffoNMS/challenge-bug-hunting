# Versão 4: Sistema Básico de Gerenciamento de Vídeos
### Este projeto é um sistema de gerenciamento de vídeos que permite realizar operações como adicionar, listar, editar, excluir e filtrar vídeos. Ele utiliza uma arquitetura modular com camadas de modelo, serviço e repositório, além de um menu interativo para interação com o usuário.


## Funcionalidades:
- **Adicionar Vídeo**: Permite adicionar um novo vídeo com título, descrição, duração, categoria e data de publicação.
- **Listar Vídeos**: Exibe todos os vídeos cadastrados.
- **Pesquisar Vídeo por Título**: Busca um vídeo específico pelo título.
- **Editar Vídeo**: Permite editar as informações de um vídeo existente.
- **Excluir Vídeo**: Remove um vídeo do sistema pelo título.
- **Filtrar Vídeos por Categoria**: Exibe vídeos de uma categoria específica.
- **Ordenar Vídeos por Data de Publicação**: Lista os vídeos em ordem cronológica de publicação.
- **Exibir Relatório de Estatísticas**: Gera um relatório com o total de vídeos e a duração total.
- **Filtrar Vídeos por Duração**: Exibe vídeos dentro de um intervalo de duração especificado.


## Estrutura do Projeto
### O projeto segue uma arquitetura modular, com separação de responsabilidades em pacotes:

- main/Main.java: Classe principal que inicializa o sistema, gerencia a interação com o usuário e executa o menu.
- main/VideoMenu.java: Classe responsável por exibir o menu interativo e gerenciar as opções escolhidas pelo usuário.
- main/VideoActions.java: Contém métodos utilitários para realizar ações como adicionar, listar, editar e excluir vídeos.
- model/Video.java: Classe que representa o modelo de dados de um vídeo, com atributos como título, descrição, duração, categoria e data de publicação.
- repository/VideoRepository.java: Interface que define os métodos para persistência de vídeos.
- repository/FileVideoRepository.java: Implementação da interface VideoRepository que utiliza arquivos para armazenar os dados.
- service/VideoService.java: Interface que define a lógica de negócios, como adicionar, buscar, editar e excluir vídeos.
- service/VideoManager.java: Implementação da interface VideoService, contendo a lógica de negócios do sistema.
- util/FileHandler.java: Classe utilitária para manipulação de arquivos, como leitura, escrita e limpeza de arquivos.

````
src/ 
├── main/ 
│ ├── Main.java # Classe principal que gerencia a interação com o usuário 
│ ├── VideoMenu.java # Menu interativo para navegação no sistema 
│ └── VideoActions.java # Métodos utilitários para ações específicas no menu 
├── model/ 
│ └── Video.java # Representação do modelo de vídeo 
├── repository/ 
│ ├── VideoRepository.java # Interface para persistência de vídeos 
│ └── FileVideoRepository.java # Implementação da persistência em arquivo 
├── service/ 
│ ├── VideoService.java # Interface para lógica de negócios 
│ └── VideoManager.java # Implementação da lógica de negócios 
└── util/ 
└── FileHandler.java # Utilitário para manipulação de arquivos
````
## 1. Configurando o ambiente

Antes de começar, certifique-se de que você tem as ferramentas necessárias instaladas no seu ambiente de desenvolvimento:

- Java 17 ou superior.
- Um editor de código ou IDE, como IntelliJ IDEA ou VSCode.
- Git para versionamento de código.

Você deve clonar o repositório e analisar o código existente para entender como ele funciona.

## 2. Como Executar

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```
2. Compile o projeto:
   ```bash
   javac -d out $(find . -name "*.java")
   ```
3. Execute o programa:
   ```bash
   java -cp out main.Main
   ```

## 3. Estrutura do Menu
#### Ao executar o programa, o menu interativo será exibido com as seguintes opções:

1. Adicionar vídeo
2. Listar vídeos
3. Pesquisar vídeo por título
4. Editar vídeo
5. Excluir vídeo
6. Filtrar vídeos por categoria
7. Ordenar vídeos por data de publicação
8. Exibir o relatório de estatísticas
9. Filtrar vídeos por duração
10. Sair

## 4. Exemplo de Uso
####  Adicionar um Vídeo 
   1. Escolha a opção 1 no menu.
   2. Insira os dados solicitados, como título, descrição, duração, categoria e data de publicação.
#### Listar Vídeos
   1. Escolha a opção 2 no menu.
   2. O sistema exibirá todos os vídeos cadastrados.
#### Pesquisar Vídeo por Título
  1. Escolha a opção 3 no menu.
  2. Insira o título do vídeo que deseja buscar.

## Desenvolvido com 💻 e ☕ por RodolffoNMS.