package repository;

import model.Video;
import util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class FileVideoRepository implements VideoRepository {
    private static final String VIDEO_FILE_PATH = "videos.txt";

    @Override
    public void save(Video video) {
        FileHandler.writeToFile(VIDEO_FILE_PATH, video.toString());
    }

    @Override
    public List<Video> findAll() {
        List<String> lines = FileHandler.readFromFile(VIDEO_FILE_PATH);
        List<Video> videos = new ArrayList<>();
        for (String line : lines) {
            // Simplesmente exibe as linhas como strings (não há parsing nesta versão)
            videos.add(new Video(line, "Descrição não disponível", 0));
        }
        return videos;
    }
}