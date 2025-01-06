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

        while (true) {
            System.out.println("\n=== Sistema de Gerenciamento de Vídeos ===");
            System.out.println("1. Adicionar vídeo");
            System.out.println("2. Listar vídeos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int option = getValidIntInput(scanner, "Opção inválida. Escolha uma opção válida (1, 2 ou 3):", 1, 3);

            switch (option) {
                case 1 -> {
                    System.out.print("Título: ");
                    String title = getValidStringInput(scanner, "O título não pode estar vazio. Digite novamente:");

                    System.out.print("Descrição: ");
                    String description = getValidStringInput(scanner, "A descrição não pode estar vazia. Digite novamente:");

                    System.out.print("Duração (em minutos): ");
                    int duration = getValidIntInput(scanner, "A duração deve ser um número positivo. Digite novamente:", 1, Integer.MAX_VALUE);

                    try {
                        service.addVideo(title, description, duration);
                        System.out.println("Vídeo adicionado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                case 2 -> {
                    List<Video> videos = service.getAllVideos();
                    if (videos.isEmpty()) {
                        System.out.println("Nenhum vídeo encontrado.");
                    } else {
                        System.out.println("\n=== Lista de Vídeos ===");
                        videos.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.println("Saindo...");
                    return;
                }
            }
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
}