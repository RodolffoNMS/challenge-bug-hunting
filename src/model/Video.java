package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Video {
    private String title;
    private String description;
    private int duration; // em minutos
    private String category;
    private LocalDate publicationDate;

    public Video(String title, String description, int duration, String category, String publicationDate) {
        setTitle(title);
        setDescription(description);
        setDuration(duration);
        setCategory(category);
        setPublicationDate(publicationDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        }
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("A categoria não pode ser vazia.");
        }
        this.category = category;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Digite a data de publicação (formato dd/MM/yyyy): ");
            String input = scanner.nextLine();

            try {
                this.publicationDate = LocalDate.parse(input, formatter);
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Data de publicação inválida. Use o formato dd/MM/yyyy.");
            }
        }
        }
    @Override
    public String toString() {
        return String.format("Título: %s | Descrição: %s | Duração: %d min | Categoria: %s | Publicado em: %s",
                title, description, duration, category, publicationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}