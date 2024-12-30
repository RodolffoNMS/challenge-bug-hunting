package service;

import model.Video;
import repository.VideoRepository;

import java.util.List;

public class VideoService {
    private final VideoRepository repository;

    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public void addVideo(String title, String description, int duration, String category, String publicationDate) {
        Video video = new Video(title, description, duration, category, publicationDate);
        repository.save(video);
    }

    public List<Video> getAllVideos() {
        return repository.findAll();
    }

    public Video getVideoByTitle(String title) {
        return repository.findByTitle(title);
    }

    public void updateVideo(Video video) {
        repository.update(video);
    }

    public void deleteVideo(String title) {
        repository.delete(title);
    }
}