package ru.itis.inf501.lab2_17.examples;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class WavPlayer {
    public static void main(String[] args) {
        try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new File("zarina-asylkaeva-kaz-kanaty.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            Thread.sleep(2000);
            //clip.stop();
            Thread.sleep(clip.getMicrosecondLength() / 1000); // Ждём окончания
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}