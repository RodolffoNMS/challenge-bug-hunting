package repository;

import model.Video;
import util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class FileVideoRepository implements VideoRepository {
    private static final String FILE_PATH = "videos.txt";

    @Override
    public void save(Video video) {
        String videoData = String.format("%s;%s;%d", video.getTitle(), video.getDescription(), video.getDuration());
        FileHandler.writeToFile(FILE_PATH, videoData);
    }

    @Override
    public List<Video> findAll() {
        List<String> lines = FileHandler.readFromFile(FILE_PATH);
        List<Video> videos = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 3) {
                String title = parts[0];
                String description = parts[1];
                int duration = Integer.parseInt(parts[2]);
                videos.add(new Video(title, description, duration));
            }
        }

        return videos;
    }
}