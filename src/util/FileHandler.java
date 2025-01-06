package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<String> readFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {// Cria o arquivo se ele não existir

            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar o arquivo: " + filePath, e);
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(";");
                    if (parts.length != 5) {
                        System.out.println("Linha inválida no arquivo: " + line);
                        continue;
                    }
                    String title = parts[0];
                    String description = parts[1];
                    int duration = Integer.parseInt(parts[2]); // Pode lançar NumberFormatException
                    String category = parts[3];
                    String publicationDate = parts[4];
                    lines.add(line);// Adiciona a linha válida à lista

                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter a duração para número na linha: " + line);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Erro: Linha com formato inválido no arquivo: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + filePath, e);
        }

        return lines;
    }

    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo: " + filePath, e);
        }
    }

    public static void clearFile(String filePath) {
        try {
            Files.write(Paths.get(filePath), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        } catch (NoSuchFileException e) {
            System.out.println("Arquivo não encontrado: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao limpar o arquivo: " + filePath, e);
        }
    }
}