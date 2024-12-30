package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo: " + filePath, e);
        }
    }

    public static List<String> readFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar o arquivo: " + filePath, e);
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + filePath, e);
        }
        return lines;
    }
    public static void clearFile(String filePath) {
        try {
            Files.write(Paths.get(filePath), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        } catch (NoSuchFileException e) {
            // Se o arquivo não existir, não faz nada
        } catch (IOException e) {
            throw new RuntimeException("Erro ao limpar o arquivo: " + filePath, e);
        }
    }
}