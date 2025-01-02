package main;

import model.Video;
import service.VideoService;

import java.util.List;
import java.util.Scanner;

public class VideoActions{

    public static void addVideo(VideoService service, Scanner scanner) {
        String title = getTitle(scanner);
        String description = getDescription(scanner);
        int duration = getDuration(scanner);
        String category = getCategory(scanner);
        String publicationDate = getPublicationDate(scanner);

        try {
            Video video = new Video(title, description, duration, category, publicationDate);
            service.addVideo(video);
            System.out.println("Vídeo adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar o vídeo: " + e.getMessage());
        }
    }

    public static void listVideos(VideoService service) {
        List<Video> videos = service.getAllVideos();
        if (videos.isEmpty()) {
            System.out.println("Nenhum vídeo encontrado.");
        } else {
            System.out.println("\n=== Lista de Vídeos ===");
            videos.forEach(System.out::println);
        }
    }

    public static void searchVideo(VideoService service, Scanner scanner) {
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

    public static void editVideo(VideoService service, Scanner scanner) {
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
        if (!newTitle.isEmpty()) {
            video.setTitle(newTitle);
        }

        System.out.print("Nova descrição: ");
        String newDescription = scanner.nextLine().trim();
        if (!newDescription.isEmpty()) {
            video.setDescription(newDescription);
        }

        System.out.print("Nova duração (em minutos): ");
        String newDuration = scanner.nextLine().trim();
        if (!newDuration.isEmpty()) {
            try {
                int duration = Integer.parseInt(newDuration);
                if (duration > 0) {
                    video.setDuration(duration);
                } else {
                    System.out.println("Duração inválida. Deve ser um número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Duração inválida. Deve ser um número positivo.");
            }
        }

        System.out.print("Nova categoria: ");
        String newCategory = scanner.nextLine().trim();
        if (!newCategory.isEmpty()) {
            try {
                video.setCategory(String.valueOf(newCategory.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Categoria inválida. Certifique-se de usar: FILME, SERIE ou DOCUMENTARIO.");
            }
        }

        System.out.print("Nova data de publicação (dd/MM/yyyy): ");
        String newDate = scanner.nextLine().trim();
        if (!newDate.isEmpty()) {
            try {
                video.setPublicationDate(newDate);
            } catch (IllegalArgumentException e) {
                System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
            }
        }

        service.updateVideo(title, video);
        System.out.println("Vídeo atualizado com sucesso!");
    }

    public static void deleteVideo(VideoService service, Scanner scanner) {
        System.out.print("Digite o título do vídeo a ser excluído: ");
        String title = getValidStringInput(scanner, "O título não pode estar vazio. Digite novamente:");
        service.deleteVideo(title);
        System.out.println("Vídeo excluído com sucesso!");
    }

    public static void filterByCategory(VideoService service, Scanner scanner) {
        System.out.print("Digite a categoria: ");
        String category = getValidStringInput(scanner, "A categoria não pode estar vazia. Tente novamente:");
        List<Video> videos = service.filterByCategory(category);
        if (videos.isEmpty()) {
            System.out.println("Nenhum vídeo encontrado para a categoria: " + category);
        } else {
            videos.forEach(System.out::println);
        }
    }

    public static void sortVideosByDate(VideoService service) {
        List<Video> videos = service.sortByPublicationDate();
        videos.forEach(System.out::println);
    }

    public static void showStatistics(VideoService service) {
        System.out.println(service.generateStatistics());
    }

    public static void filterByDuration(VideoService service, Scanner scanner) {
        System.out.print("Digite a duração mínima (em minutos): ");
        int minDuration = getValidIntInput(scanner, "A duração mínima deve ser um número positivo. Tente novamente:", 1, Integer.MAX_VALUE);
        System.out.print("Digite a duração máxima (em minutos): ");
        int maxDuration = getValidIntInput(scanner, "A duração máxima deve ser maior ou igual à duração mínima. Tente novamente:", minDuration, Integer.MAX_VALUE);
        List<Video> videos = service.filterByDuration(minDuration, maxDuration);
        if (videos.isEmpty()) {
            System.out.println("Nenhum vídeo encontrado no intervalo de duração especificado.");
        } else {
            System.out.println("\n=== Vídeos no Intervalo de Duração ===");
            videos.forEach(System.out::println);
        }
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

    private static String getTitle(Scanner scanner) {
        System.out.print("Título: ");
        return getValidStringInput(scanner, "O título não pode estar vazio. Digite novamente:");
    }

    private static String getDescription(Scanner scanner) {
        System.out.print("Descrição: ");
        return getValidStringInput(scanner, "A descrição não pode estar vazia. Digite novamente:");
    }

    private static int getDuration(Scanner scanner) {
        System.out.print("Duração (em minutos): ");
        return getValidIntInput(scanner, "A duração deve ser um número positivo. Digite novamente:", 1, Integer.MAX_VALUE);
    }

    private static String getCategory(Scanner scanner) {
        System.out.print("Categoria: ");
        return getValidStringInput(scanner, "A categoria não pode estar vazia. Digite novamente:");
    }

    private static String getPublicationDate(Scanner scanner) {
        System.out.print("Data de publicação (dd/MM/yyyy): ");
        return getValidStringInput(scanner, "A data não pode estar vazia. Digite novamente:");
    }

    private static void createAndSaveVideo(VideoService service, String title, String description, int duration, String  category, String publicationDate) {
        try {
            Video video = new Video(title, description, duration, category, publicationDate);
            service.addVideo(video);
            System.out.println("Vídeo adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar o vídeo. Verifique os dados fornecidos.");
        }
    }
}


