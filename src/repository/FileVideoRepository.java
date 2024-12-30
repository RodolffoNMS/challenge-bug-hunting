package repository;

import model.Video;
import util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class FileVideoRepository implements VideoRepository {
    private static final String FILE_PATH = "videos.txt";

    @Override
    public void save(Video video) {
        String videoData = String.format("%s;%s;%d;%s;%s",
                video.getTitle(), video.getDescription(), video.getDuration(),
                video.getCategory(), video.getPublicationDate().toString());
        FileHandler.writeToFile(FILE_PATH, videoData);
    }

    @Override
    public List<Video> findAll() {
        List<String> lines = FileHandler.readFromFile(FILE_PATH);
        List<Video> videos = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 5) {
                String title = parts[0];
                String description = parts[1];
                int duration = Integer.parseInt(parts[2]);
                String category = parts[3];
                String publicationDate = parts[4];
                videos.add(new Video(title, description, duration, category, publicationDate));
            }
        }

        return videos;
    }

    @Override
    public Video findByTitle(String title) {
        return findAll().stream()
                .filter(video -> video.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Video updatedVideo) {
        List<Video> videos = findAll();
        FileHandler.clearFile(FILE_PATH);

        for (Video video : videos) {
            if (video.getTitle().equalsIgnoreCase(updatedVideo.getTitle())) {
                save(updatedVideo);
            } else {
                save(video);
            }
        }
    }

    @Override
    public void delete(String title) {
        List<Video> videos = findAll();
        FileHandler.clearFile(FILE_PATH);

        for (Video video : videos) {
            if (!video.getTitle().equalsIgnoreCase(title)) {
                save(video);
            }
        }
    }
}