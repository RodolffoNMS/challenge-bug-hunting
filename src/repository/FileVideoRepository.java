package repository;

import model.Video;
import util.FileHandler;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileVideoRepository implements VideoRepository {
    private static final String FILE_PATH = "videos.txt";

    @Override
    public void save(Video video) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = video.getPublicationDate().format(formatter);
        String videoData = String.format("%s;%s;%d;%s;%s",
                video.getTitle(),
                video.getDescription(),
                video.getDuration(),
                video.getCategory(),
                formattedDate
        );
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
                String videoCategory = String.valueOf(category.toUpperCase());
                videos.add(new Video(title, description, duration, videoCategory, publicationDate));
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
    public void update(String title, Video updatedVideo) {
        List<Video> videos = findAll();
        FileHandler.clearFile(FILE_PATH);
        for (Video video : videos) {
            if (video.getTitle().equalsIgnoreCase(title)) {
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