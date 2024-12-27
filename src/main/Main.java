package main;

import model.Video;
import repository.FileVideoRepository;
import repository.VideoRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VideoRepository repository = new FileVideoRepository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistema de Gerenciamento de Vídeos ===");
            System.out.println("1. Adicionar vídeo");
            System.out.println("2. Listar vídeos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (option) {
                case 1 -> {
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();
                    System.out.print("Duração (em minutos): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    Video video = new Video(title, description, duration);
                    repository.save(video);
                    System.out.println("Vídeo adicionado com sucesso!");
                }
                case 2 -> {
                    System.out.println("\n=== Lista de Vídeos ===");
                    repository.findAll().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}