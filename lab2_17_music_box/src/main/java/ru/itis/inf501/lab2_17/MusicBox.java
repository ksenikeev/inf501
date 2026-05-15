package ru.itis.inf501.lab2_17;

import javax.sound.sampled.Clip;
import java.util.List;

public class MusicBox {

    private String catalogFileName = "catalog.json";
    private Clip currentClip;
    private Integer currentTrak;

    public void showMenu() {
        // TODO Крайнова
    }

    public void userChoiceHandler() {
        // TODO Осадчая
        // ввод числа - пункта меню
        // вызов соответствующего метода
    }

    public Clip play(int trakNumber) {
        // TODO Файзуллина
        // запустить воспроизведение в отдельном потоке
        return null;
    }

    public Catalog loadCatalog() {
        // TODO Мухамедзянова
        return null;
    }

    public void saveCatalog() {
        // TODO Талбиева
    }

    public void showAllTraks() {
        // TODO Киямутдинов
    }

    public MusikTrack findByNumber(int number) {
        // TODO Шамсутдинова
        return null;
    }

    public List<MusikTrack> findByName(String name) {
        // TODO Фомин
        return null;
    }

    public List<MusikTrack> findByAuthor(String author) {
        // TODO Круглов
        return null;
    }

    public void stopClip() {

    }

    public void delete(int trakNumber) {
        // TODO Агафонов
    }

    public MusikTrack addTrak(String name, String author, String file) {
        // TODO Бессонов
        return null;
    }
}
