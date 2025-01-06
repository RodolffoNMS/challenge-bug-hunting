package main;

import repository.FileVideoRepository;
import service.VideoManager;
import service.VideoService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        VideoService service = new VideoManager(new FileVideoRepository());
        Scanner scanner = new Scanner(System.in);
        VideoMenu menu = new VideoMenu(service, scanner);
        menu.start();
    }
}