package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        if (category == null) {
            throw new IllegalArgumentException("A categoria não pode ser nula.");
        }
        this.category = category;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.publicationDate = LocalDate.parse(publicationDate, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida. Use o formato dd/MM/yyyy.");
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
                "Título: %s | Descrição: %s | Duração: %d min | Categoria: %s | Publicado em: %s",
                title,
                description,
                duration,
                category,
                publicationDate.format(formatter)
        );
    }
}