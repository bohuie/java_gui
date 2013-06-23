import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundClipTest extends JFrame 
{
  // Constructor
  public SoundClipTest() 
  {
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setTitle( "Test Sound Clip" );
    setSize( 300, 200 );
    setVisible( true );
   
    try 
    {
      // Open an audio input stream.
      URL url = getClass().getClassLoader().getResource( "beep-02.wav" );
      AudioInputStream audioIn = AudioSystem.getAudioInputStream( url );

      // Get a sound clip resource.
      Clip clip = AudioSystem.getClip();

      // Open audio clip and load samples from the audio input stream.
      clip.open( audioIn );
      clip.start();
    } 
    catch( UnsupportedAudioFileException e ) 
    {
         e.printStackTrace();
    } 
    catch( IOException e ) 
    {
         e.printStackTrace();
    } 
    catch( LineUnavailableException e ) 
    {
         e.printStackTrace();
    }
  }
   
  public static void main( String[] args ) 
  {
      new SoundClipTest();
  }
}
