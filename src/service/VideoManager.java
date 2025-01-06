package service;

import model.Video;
import repository.VideoRepository;

import java.util.List;

public class VideoManager implements VideoService {
    private final VideoRepository repository;

    public VideoManager(VideoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addVideo(Video video) {
        repository.save(video);
    }

    @Override
    public void deleteVideo(String title) {
        repository.delete(title);
    }

    @Override
    public void updateVideo(String title, Video updatedVideo) {
        Video existingVideo = repository.findByTitle(title);
        if (existingVideo == null) {
            throw new IllegalArgumentException("Vídeo não encontrado.");
        }
        repository.update(title, updatedVideo);
    }

    @Override
    public Video getVideoByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<Video> getAllVideos() {
        return repository.findAll();
    }

    @Override
    public List<Video> filterByDuration(int minDuration, int maxDuration) {
        return repository.findAll().stream()
                .filter(video -> video.getDuration() >= minDuration && video.getDuration() <= maxDuration)
                .toList();
    }

    @Override
    public List<Video> filterByCategory(String category) {
        return repository.findAll().stream()
                .filter(video -> video.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @Override
    public List<Video> sortByPublicationDate() {
        return repository.findAll().stream()
                .sorted((v1, v2) -> v1.getPublicationDate().compareTo(v2.getPublicationDate()))
                .toList();
    }

    @Override
    public String generateStatistics() {
        List<Video> videos = repository.findAll();
        long totalVideos = videos.size();
        int totalDuration = videos.stream().mapToInt(Video::getDuration).sum();

        return String.format("""
            === Relatório de Estatísticas ===
            Total de vídeos: %d
            Duração total: %d minutos
            """, totalVideos, totalDuration);
    }
}