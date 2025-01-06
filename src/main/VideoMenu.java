package main;

import service.VideoService;
import java.util.Scanner;

public class VideoMenu {
    private final VideoService service;
    private final Scanner scanner;

    public VideoMenu(VideoService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            int option = getValidIntInput("Opção inválida. Escolha uma opção válida (1 a 10):", 1, 10);
            isRunning = handleOption(option);
        }
    }

    private void printMenu() {
        System.out.println("\n=== Sistema de Gerenciamento de Vídeos ===");
        System.out.println("1. Adicionar vídeo");
        System.out.println("2. Listar vídeos");
        System.out.println("3. Pesquisar vídeo por título");
        System.out.println("4. Editar vídeo");
        System.out.println("5. Excluir vídeo");
        System.out.println("6. Filtrar vídeos por categoria");
        System.out.println("7. Ordenar vídeos por data de publicação");
        System.out.println("8. Exibir o relatório de estatísticas");
        System.out.println("9. Filtrar vídeos por duração");
        System.out.println("10. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private boolean handleOption(int option) {
        switch (option) {
            case 1 -> VideoActions.addVideo(service, scanner);
            case 2 -> VideoActions.listVideos(service);
            case 3 -> VideoActions.searchVideo(service, scanner);
            case 4 -> VideoActions.editVideo(service, scanner);
            case 5 -> VideoActions.deleteVideo(service, scanner);
            case 6 -> VideoActions.filterByCategory(service, scanner);
            case 7 -> VideoActions.sortVideosByDate(service);
            case 8 -> VideoActions.showStatistics(service);
            case 9 -> VideoActions.filterByDuration(service, scanner);
            case 10 -> {
                System.out.println("Saindo...");
                return false;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
        return true;
    }

    private int getValidIntInput(String errorMessage, int min, int max) {
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
}