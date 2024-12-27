package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException exception) {
            throw new RuntimeException("Erro!\nNão foi possível escrever no arquivo: " + filePath, exception);
        }
    }

    public static List<String> readFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException exception) {
            throw new RuntimeException("Erro!\nNão foi possível ler o arquivo: " + filePath, exception);
        }
        return lines;
    }
}