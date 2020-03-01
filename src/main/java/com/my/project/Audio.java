package com.my.project;

import javax.sound.sampled.*;
import java.io.IOException;

public class Audio extends Thread {

    @Override
    public void run() {
        try {
            byte[] b = new byte[1024];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024);
            sourceDataLine.start();
            while((len = audioInputStream.read(b)) > 0) {
                sourceDataLine.write(b, 0, len);
            }
            audioInputStream.close();
            sourceDataLine.drain();
            sourceDataLine.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AudioFormat audioFormat = null;
    private SourceDataLine sourceDataLine = null;
    private DataLine.Info dataLineInfo = null;
    private AudioInputStream audioInputStream = null;

    public Audio(String fileName) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(Audio.class.getClassLoader().getResource(fileName));
            audioFormat = audioInputStream.getFormat();
            dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            byte[] b = new byte[1024*5];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024*5);
            sourceDataLine.start();
            audioInputStream.mark(12358946);
            while((len = audioInputStream.read(b)) > 0) {
                sourceDataLine.write(b, 0, len);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            audioInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Audio a = new Audio("audio/explode.wav");
        a.play();
    }
}
