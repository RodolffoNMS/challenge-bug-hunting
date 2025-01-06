package repository;

import model.Video;

import java.util.List;

public interface VideoRepository {
    void save(Video video);

    List<Video> findAll();

    Video findByTitle(String title);

    void update(String title, Video updatedVideo);

    void delete(String title);
}