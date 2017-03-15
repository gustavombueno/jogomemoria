package code;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author Gustavo Moraes Bueno
 */
public class Audio {

    public void emiteSom(String caminhoAudio) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(caminhoAudio)));
            clip.start();

        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}