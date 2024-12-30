package model;

public class Video {
    private final String title;
    private final String description;
    private final int duration; // em minutos

    public Video(String title, String description, int duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Descrição: %s | Duração: %d min", title, description, duration);
    }
}