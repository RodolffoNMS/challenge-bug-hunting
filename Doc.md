# Sistema de Gerenciamento de Vídeos
#### Este projeto é um sistema de gerenciamento de vídeos que permite adicionar, listar, pesquisar, editar, excluir e filtrar vídeos. Ele também fornece estatísticas sobre os vídeos armazenados.

## Estrutura do Projeto
### O projeto está dividido em pacotes e classes para facilitar a organização e a manutenção do código.

## Pacotes
- main: Contém a classe principal e o menu de interação com o usuário.
- model: Define a estrutura de dados do vídeo.
- repository: Gerencia o armazenamento e a recuperação de vídeos.
- service: Contém a lógica de negócios para manipulação de vídeos.
- util: Fornece utilitários para manipulação de arquivos.
- Classes e Responsabilidades
## Main
**Descrição**: Classe principal que inicializa o sistema e exibe o menu.

**Localização**: main.Main
## VideoMenu
**Descrição:** Gerencia o menu de interação com o usuário.

**Localização:** main.VideoMenu

**Principais Métodos:**
- start(): Inicia o menu.
- printMenu(): Exibe as opções do menu.
- handleOption(int option): Processa a opção selecionada pelo usuário.
## VideoActions
**Descrição:** Contém as ações que podem ser realizadas no sistema, como adicionar, listar, editar e excluir vídeos.

**Localização:** main.VideoActions

**Principais Métodos:**
- addVideo(VideoService service, Scanner scanner): Adiciona um novo vídeo.
- listVideos(VideoService service): Lista todos os vídeos.
- searchVideo(VideoService service, Scanner scanner): Pesquisa um vídeo pelo título.
- editVideo(VideoService service, Scanner scanner): Edita as informações de um vídeo.
- deleteVideo(VideoService service, Scanner scanner): Exclui um vídeo pelo título.
## Video
**Descrição:** Representa um vídeo com informações como título, descrição, duração, categoria e data de publicação.

**Localização:** model.Video

**Principais Métodos:**
- setTitle(String title): Define o título do vídeo.
- setDescription(String description): Define a descrição do vídeo.
- setDuration(int duration): Define a duração do vídeo.
- setCategory(String category): Define a categoria do vídeo.
- setPublicationDate(String publicationDate): Define a data de publicação do vídeo.
## FileVideoRepository
**Descrição:** Implementa o repositório de vídeos utilizando arquivos para armazenamento.

**Localização:** repository.FileVideoRepository

**Principais Métodos:**

- save(Video video): Salva um vídeo no arquivo.
- findAll(): Retorna todos os vídeos armazenados.
- findByTitle(String title): Busca um vídeo pelo título.
- update(String title, Video updatedVideo): Atualiza as informações de um vídeo.
- delete(String title): Exclui um vídeo pelo título.

## VideoManager
**Descrição:** Implementa a lógica de negócios para manipulação de vídeos.

**Localização:** service.VideoManager

**Principais Métodos:**
- addVideo(Video video): Adiciona um vídeo.
- deleteVideo(String title): Exclui um vídeo pelo título.
- updateVideo(String title, Video updatedVideo): Atualiza as informações de um vídeo.
- getVideoByTitle(String title): Retorna um vídeo pelo título.
- getAllVideos(): Retorna todos os vídeos.
- filterByDuration(int minDuration, int maxDuration): Filtra vídeos por duração.
- filterByCategory(String category): Filtra vídeos por categoria.
- sortByPublicationDate(): Ordena vídeos por data de publicação.
- generateStatistics(): Gera um relatório de estatísticas.
## FileHandler
**Descrição:** Utilitário para manipulação de arquivos.

**Localização:** util.FileHandler

**Principais Métodos:**
- readFromFile(String filePath): Lê dados de um arquivo.
- writeToFile(String filePath, String content): Escreve dados em um arquivo.
- clearFile(String filePath): Limpa o conteúdo de um arquivo.