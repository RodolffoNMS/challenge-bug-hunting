# Versão 3: Sistema Básico de Gerenciamento de Vídeos
### Este é um sistema simples de gerenciamento de vídeos, desenvolvido em Java, que permite adicionar, listar, pesquisar, editar e excluir vídeos. Os dados dos vídeos são armazenados em um arquivo de texto (videos.txt), utilizando o padrão de repositório para persistência. Busquei seguir as boas práticas e conceitos de **SRP (Single Responsibility Principle)** e **KISS (Keep It Simple, Stupid)**.

## Funcionalidades:
- Adicionar vídeo: Permite adicionar um novo vídeo ao sistema.
- Listar vídeos: Exibe todos os vídeos cadastrados.
- Pesquisar vídeo por título: Busca um vídeo pelo título.
- Editar vídeo: Permite editar as informações de um vídeo existente.
- Excluir vídeo: Remove um vídeo do sistema.
- Persistência: Os dados são armazenados em um arquivo de texto para garantir que as informações sejam mantidas entre execuções.


## Estrutura do Projeto
### O projeto segue uma arquitetura modular, com separação de responsabilidades em pacotes:

- main: Contém a classe principal (Main) que gerencia a interação com o usuário.
- model: Define a classe Video, que representa o modelo de dados.
- repository: Contém a interface VideoRepository e sua implementação FileVideoRepository, responsável pela persistência dos dados.
- service: Contém a classe VideoService, que encapsula a lógica de negócios.
- util: Contém a classe FileHandler, que fornece utilitários para manipulação de arquivos.


````
src/
├── main/
│ └── Main.java # Classe principal que gerencia a interação com o usuário
├── model/
│ └── Video.java # Representação do modelo de vídeo
├── repository/
│ ├── VideoRepository.java # Interface para persistência de vídeos
│ └── FileVideoRepository.java # Implementação da persistência em arquivo
├── service/
│ └── VideoService.java # Camada de serviço para lógica de negócios
└── util/
└── FileHandler.java # Utilitário para manipulação de arquivos
````
## 1. Configurando o ambiente

Antes de começar, certifique-se de que você tem as ferramentas necessárias instaladas no seu ambiente de desenvolvimento:

- Java 17 ou superior.
- Um editor de código ou IDE, como IntelliJ IDEA ou VSCode.
- Git para versionamento de código.

Você deve clonar o repositório e analisar o código existente para entender como ele funciona.

## 2 Exemplo de Uso

- Adicionar um Vídeo
  - Escolha a opção 1 no menu.
  - Insira o título, descrição e duração do vídeo.
  - O sistema confirmará que o vídeo foi adicionado com sucesso.
- Listar Vídeos
  - Escolha a opção 2 no menu.
  - O sistema exibirá todos os vídeos cadastrados no formato: Título: <título> | Descrição: <descrição> | Duração: <duração> min
- Sair
  - Escolha a opção 3 no menu para encerrar o programa.

## Boas Práticas Aplicadas
- Clean Code: Código limpo, legível e fácil de entender.
- SRP (Single Responsibility Principle): Cada classe tem uma única responsabilidade.
- KISS (Keep It Simple, Stupid): Soluções simples e diretas.
- DRY (Don't Repeat Yourself): Evitamos duplicação de código, centralizando lógica comum.
- Tratamento de Erros: Validações e mensagens claras para entradas inválidas.

## Desenvolvido com 💻 e ☕ por RodolffoNMS.


