package ru.itis.inf501.lab2_17;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MusicBox {

    private String catalogFileName = "catalog.json";
    private Clip currentClip;
    private Integer currentTrack;
    private MusicCatalog catalog;

    public MusicBox() {
        this.catalog = loadCatalog();
        if (catalog == null) {
            catalog = new MusicCatalog();
        }
    }

    public void showMenu() {
        System.out.println("\nМЕНЮ");
        System.out.println("1. Загрузка каталога");
        System.out.println("2. Ввод нового трека");
        System.out.println("3. Удаление трека");
        System.out.println("4. Просмотр всех треков");
        System.out.println("5. Поиск трека по номеру");
        System.out.println("6. Поиск трека по названию");
        System.out.println("7. Поиск трека по автору/исполнителю");
        System.out.println("8. Проигрывание трека");
        System.out.println("9. Остановка трека");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
        userChoiceHandler();
    }

    public void userChoiceHandler() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    loadCatalog();
                    break;
                case 2:
                    System.out.println("Введите название трека, автора трека и путь к файлу через enter");
                    Scanner scanner1 = new Scanner(System.in);
                    String name = scanner1.nextLine();
                    Scanner scanner2 = new Scanner(System.in);
                    String author = scanner2.nextLine();
                    Scanner scanner3 = new Scanner(System.in);
                    String file = scanner3.nextLine();
                    addTrack(name, author, file);
                    break;

                case 3:
                    System.out.println("Введите номер трека");
                    Scanner scanner4 = new Scanner(System.in);
                    int num1 = scanner4.nextInt();
                    delete(num1);
                    break;

                case 4:
                    showAllTracks();
                    break;

                case 5:
                    System.out.println("Введите номер трека");
                    Scanner scanner5 = new Scanner(System.in);
                    int num2 = scanner5.nextInt();
                    findByNumber(num2);
                    break;

                case 6:
                    System.out.println("Введите название трека");
                    Scanner scanner6 = new Scanner(System.in);
                    String name1 = scanner6.nextLine();
                    findByName(name1);
                    break;

                case 7:
                    System.out.println("Введите автора трека");
                    Scanner scanner7 = new Scanner(System.in);
                    String author1 = scanner7.nextLine();
                    findByName(author1);
                    break;

                case 8:
                    System.out.println("Введите номер трека");
                    Scanner scanner8 = new Scanner(System.in);
                    int num3 = scanner8.nextInt();
                    play(num3);
                    break;

                case 9:
                    stopClip();
                    break;

                case 0:
                    System.out.println("Программа завершена");
                    return;

            }
        }
    }

    public Clip play(int trackNumber) {
        // запустить воспроизведение в отдельном потоке
        try (AudioInputStream audioStream =
                     AudioSystem.getAudioInputStream(new File(findByNumber(trackNumber).getFile()))){
            if (currentClip != null) {
                if (currentClip.isRunning()) {
                    currentClip.stop();
                }
                currentClip.close();
            }

            currentTrack = trackNumber;

            currentClip = AudioSystem.getClip();
            currentClip.open(audioStream);
            currentClip.start();
            return currentClip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public MusicCatalog loadCatalog() {
        // TODO Мухамедзянова
        return null;
    }

    public void saveCatalog() {
        // TODO Талбиева
    }

    public void showAllTracks() {
        System.out.println("Список всех треков:");
        if (catalog.getMusicTrack() != null) {
            catalog.getMusicTrack().stream()
                    .filter(track -> track != null)
                    .forEach(track -> System.out.println(track.getName() + " (исполняет: " + track.getAuthor() + ")"));
        } else {
            System.out.println("Пустой каталог");
        }
    }

    public List<MusicTrack> findByName(String name) {
        MusicCatalog catalog = loadCatalog();
        return catalog.getMusicTrack().stream()
                .filter(track ->
                        track.getName()
                                .toLowerCase()
                                .contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public MusicTrack findByNumber(int trackNumber) {
        //TODO
        if (catalog == null || catalog.getMusicTrack() == null) {
            return null;
        }
        int index = trackNumber - 1;
        if (index < 0 || index >= catalog.getMusicTrack().size()) {
            System.out.println("Трека с таким номером не существует");
            return null;
        }
        return catalog.getMusicTrack().get(index);
    }

    public List<MusicTrack> findByAuthor(String author) {
        // TODO Круглов
        return null;
    }

    public void stopClip() {

    }

    public void delete(int trakNumber) {
        List<MusicTrack> traks = this.catalog.getMusicTrack();
        if (traks == null || traks.isEmpty()) {
            System.out.println("Каталог пуст.");
            showMenu();
            return;
        }
        int index = trakNumber - 1;
        if (index < 0 || index >
                = traks.size()) {
            System.out.println("Трека с таким номером нет.");
            showMenu();
            return;
        }
        MusicTrack deletedTrack = traks.remove(index);
        saveCatalog();
        System.out.println("Трек удалён: " +
                deletedTrack.getName() +
                " - " + deletedTrack.getAuthor());
        showMenu();
    }

    public MusicTrack addTrack(String name, String author, String file) throws FileNotExistException {
        Path path = Paths.get(file);
        if (!Files.exists(path)) {
            throw new FileNotExistException();
        }

        MusicTrack toAdd = new MusicTrack(name, author, file);

        this.catalog.getMusicTrack().add(toAdd);
        return toAdd;
    }
}
