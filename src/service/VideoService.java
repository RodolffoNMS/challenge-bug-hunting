package service;

import model.Video;
import java.util.List;

public interface VideoService {
    void addVideo(Video video); // Adicionar um vídeo
    void deleteVideo(String title); // Deletar um vídeo pelo título
    void updateVideo(String title, Video updatedVideo); // Atualizar um vídeo pelo título
    Video getVideoByTitle(String title); // Buscar um vídeo pelo título
    List<Video> getAllVideos(); // Obter todos os vídeos
    List<Video> filterByDuration(int minDuration, int maxDuration); // Filtrar vídeos por duração
    List<Video> filterByCategory(String category); // Filtrar vídeos por categoria
    List<Video> sortByPublicationDate(); // Ordenar vídeos por data de publicação
    String generateStatistics(); // Gerar relatório de estatísticas
}