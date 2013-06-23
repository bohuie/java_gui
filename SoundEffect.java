import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
   
// http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html

/**
 * This enum encapsulates all the sound effects of a game, so as to separate
 * the sound playing codes from the game codes.
 * 1. Define all your sound effect names and the associated wave file.
 * 2. To play a specific sound, simply invoke SoundEffect.SOUND_NAME.play().
 * 3. You might optionally invoke the static method SoundEffect.init() to
 * pre-load all the sound files, so that the play is not paused while loading
 * the file for the first time.
 * 4. You can use the static variable SoundEffect.volume to mute the sound.
 */

public enum SoundEffect 
{
  EAT( "laser-01.wav" ),
  OHNO( "alien-noise-01.wav" ),
  CHEER( "cheer-01.wav" ),
  SONG( "Move Forward86.wav" );

  // nested class for specifying volume
  public static enum Volume
  {
    MUTE, LOW, MEDIUM, HIGH
  }

  public static Volume vol = Volume.LOW;

  // each sound effect has its own clip, loaded with its own sound file
  private Clip soundclip;

  // constructor to build each elem of the enum with its own sound file
  SoundEffect( String filename )
  {
    try 
    {
      // use URL (instead of file) to read from disk and JAR
      URL url = getClass().getClassLoader().getResource( filename ); 

      // setup audio input stream piped from sound file
      AudioInputStream audioIn = AudioSystem.getAudioInputStream( url );

      // get a sound clip resource
      soundclip = AudioSystem.getClip();

      // open audio clip and load samples from the audio input stream
      soundclip.open( audioIn );
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
   
  // play or re-play sound effect from beginning
  public void play()
  {
    if( vol != Volume.MUTE )
    {
      if( soundclip.isRunning() )
        soundclip.stop();
      soundclip.setFramePosition( 0 );    // rewind to beginning
      soundclip.start();
    }
  }

  public void playloop() 
  {
    if( vol != Volume.MUTE )
    {
      if( soundclip.isRunning() )
        soundclip.stop();
      soundclip.setFramePosition( 0 );    // rewind to beginning
      soundclip.loop( Clip.LOOP_CONTINUOUSLY );
    }
  }

  // optional static method to pre-load all the sound files
  static void init()
  {
    values();  // calls the constructor for all the elements
  }
}
