package service;

import model.Video;
import repository.VideoRepository;

import java.util.List;

public class VideoService {
    private final VideoRepository repository;

    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public void addVideo(String title, String description, int duration) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        }

        Video video = new Video(title, description, duration);
        repository.save(video);
    }

    public List<Video> getAllVideos() {
        return repository.findAll();
    }
}