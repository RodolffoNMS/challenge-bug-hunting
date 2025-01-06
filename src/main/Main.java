package main;

import model.Video;
import repository.FileVideoRepository;
import service.VideoService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VideoService service = new VideoService(new FileVideoRepository());
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        do {
            System.out.println("\n=== Sistema de Gerenciamento de Vídeos ===");
            System.out.println("1. Adicionar vídeo");
            System.out.println("2. Listar vídeos");
            System.out.println("3. Pesquisar vídeo por título");
            System.out.println("4. Editar vídeo");
            System.out.println("5. Excluir vídeo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int option = getValidIntInput(scanner, "Opção inválida. Escolha uma opção válida (1 a 6):", 1, 6);

            switch (option) {
                case 1 -> addVideo(service, scanner);
                case 2 -> listVideos(service);
                case 3 -> searchVideo(service, scanner);
                case 4 -> editVideo(service, scanner);
                case 5 -> deleteVideo(service, scanner);
                case 6 -> {
                    System.out.println("Saindo...");
                    isRunning = false;
                }
            }
        } while (isRunning);
    }

    private static void addVideo(VideoService service, Scanner scanner) {
        System.out.print("Título: ");
        String title = getValidStringInput(scanner, "O título não pode estar vazio. Digite novamente:");

        System.out.print("Descrição: ");
        String description = getValidStringInput(scanner, "A descrição não pode estar vazia. Digite novamente:");

        System.out.print("Duração (em minutos): ");
        int duration = getValidIntInput(scanner, "A duração deve ser um número positivo. Digite novamente:", 1, Integer.MAX_VALUE);

        System.out.print("Categoria: ");
        String category = getValidStringInput(scanner, "A categoria não pode estar vazia. Digite novamente:");

        System.out.print("Data de publicação (dd/MM/yyyy): ");
        String publicationDate = getValidStringInput(scanner, "A data não pode estar vazia. Digite novamente:");

        try {
            service.addVideo(title, description, duration, category, publicationDate);
            System.out.println("Vídeo adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listVideos(VideoService service) {
        List<Video> videos = service.getAllVideos();
        if (videos.isEmpty()) {
            System.out.println("Nenhum vídeo encontrado.");
        } else {
            System.out.println("\n=== Lista de Vídeos ===");
            videos.forEach(System.out::println);
        }
    }

    private static void searchVideo(VideoService service, Scanner scanner) {
        System.out.print("Digite o título do vídeo: ");
        String title = getValidStringInput(scanner, "O título não pode estar vazio. Digite novamente:");
        Video video = service.getVideoByTitle(title);

        if (video == null) {
            System.out.println("Vídeo não encontrado.");
        } else {
            System.out.println("\n=== Detalhes do Vídeo ===");
            System.out.println(video);
        }
    }

    private static void editVideo(VideoService service, Scanner scanner) {
        System.out.print("Digite o título do vídeo a ser editado: ");
        String title = getValidStringInput(scanner, "O título não pode estar vazio. Digite novamente:");
        Video video = service.getVideoByTitle(title);

        if (video == null) {
            System.out.println("Vídeo não encontrado.");
            return;
        }

        System.out.println("Deixe o campo vazio para manter o valor atual.");
        System.out.print("Novo título: ");
        String newTitle = scanner.nextLine().trim();
        if (!newTitle.isEmpty()) video.setTitle(newTitle);

        System.out.print("Nova descrição: ");
        String newDescription = scanner.nextLine().trim();
        if (!newDescription.isEmpty()) video.setDescription(newDescription);

        System.out.print("Nova duração (em minutos): ");
        String newDuration = scanner.nextLine().trim();
        if (!newDuration.isEmpty()) video.setDuration(Integer.parseInt(newDuration));

        System.out.print("Nova categoria: ");
        String newCategory = scanner.nextLine().trim();
        if (!newCategory.isEmpty()) video.setCategory(newCategory);

        System.out.print("Nova data de publicação (dd/MM/yyyy): ");
        String newDate = scanner.nextLine().trim();
        if (!newDate.isEmpty()) video.setPublicationDate(newDate);

        service.updateVideo(video);
        System.out.println("Vídeo atualizado com sucesso!");
    }

    private static void deleteVideo(VideoService service, Scanner scanner) {
        System.out.print("Digite o título do vídeo a ser excluído: ");
        String title = getValidStringInput(scanner, "O título não pode estar vazio. Digite novamente:");
        service.deleteVideo(title);
        System.out.println("Vídeo excluído com sucesso!");
    }

    private static int getValidIntInput(Scanner scanner, String errorMessage, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    private static String getValidStringInput(Scanner scanner, String errorMessage) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println(errorMessage);
            }
        }
    }
}
