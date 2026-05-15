package ru.itis.inf501.lab2_17;

import javax.sound.sampled.Clip;
import java.util.List;

public class MusicBox {

    private Clip currentClip;
    private Integer currentTrak;

    public void showMenu() {

    }

    public void userChoiceHandler() {
        // ввод числа - пункта меню
        // вызов соответствующего метода
    }

    public Clip play(int trakNumber) {
        // запустить воспроизведение в отдельном потоке
        return null;
    }

    public Catalog loadCatalog() {
        return null;
    }

    public void saveCatalog() {

    }

    public void showAllTraks() {

    }

    public MusikTrack findByNumber() {
        return null;
    }

    public List<MusikTrack> findByName(String name) {
        return null;
    }

    public List<MusikTrack> findByAuthor(String author) {
        return null;
    }

    public void stopClip() {

    }

    public void delete(int trakNumber) {

    }

    public MusikTrack addTrak(String name, String author, String file) {
        return null;
    }
}
