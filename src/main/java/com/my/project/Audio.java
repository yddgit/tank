package com.my.project;

import javax.sound.sampled.*;
import java.io.Closeable;
import java.io.IOException;

public class Audio implements Closeable {

    byte[] b = new byte[1024 * 1024 * 15];

    public void loop() {
        try {
            while(true) {
                int len = 0;
                sourceDataLine.open(audioFormat, 1024 * 1024 * 15);

                // change background audio volume to -40.0dB
                FloatControl volCtrl = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
                volCtrl.setValue(-30.0f);

                sourceDataLine.start();
                audioInputStream.mark(12358946);
                while((len = audioInputStream.read(b)) > 0) {
                    sourceDataLine.write(b, 0, len);
                }
                audioInputStream.reset();
                sourceDataLine.drain();
                sourceDataLine.close();
            }
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
        this.play(0);
    }

    public void play(float volume) {
        try {
            byte[] b = new byte[1024*5];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024*5);

            // set volume
            FloatControl volCtrl = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
            volCtrl.setValue(volume);

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

    @Override
    public void close() {
        try {
            audioInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Audio a = new Audio("audio/war1.wav");
        a.loop();
    }
}
