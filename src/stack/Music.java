package stack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class Music {
    Clip clip;

    public void setFile(URL u){
        try{
            URL url = u;
            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
