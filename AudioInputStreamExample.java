import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JComponent;
 
public class AudioInputStreamExample{
  public static void main(String[] args) {
 
    try {
      File file = new File("");
      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
      Clip clip = AudioSystem.getClip();
      clip.open(stream);
      clip.start();
 
      // sleep to allow enough time for the clip to play
      Thread.sleep(500);
 
      stream.close();
 
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}


// public class AudioInputStream{



// public void AudioInputStream(InputStream stream, AudioFormat format, long length){
// 	}

// }
