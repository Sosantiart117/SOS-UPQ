package rockola;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Reproductor {

  public Cancion Cancion; 

  private boolean Playing;
  private boolean stoped;
  private Clip song;
  private long stopPoint;
  private boolean loop;
  private AudioInputStream audioIn;

  public Reproductor(){
    this.Cancion = null;
    this.Playing = false;
    this.stopPoint = 0;
    this.loop = false;
    this.stoped = false;
  }

  public boolean isReproduciendo(){
    return Playing ;
  }

  public void setCancion(Cancion s){
    this.Cancion = s;
  }

  public boolean pause() throws LineUnavailableException, IOException{
    stopPoint = this.song.getMicrosecondPosition();
    this.song.stop();
    this.Playing = false;
    this.stoped = true;
    return true;
  }

  public boolean play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    if(!this.Cancion.hasFile()) return false;
    audioIn = 
      AudioSystem.getAudioInputStream(this.Cancion.getFile());
    this.song = AudioSystem.getClip();
    this.song.open(audioIn);
    if(this.stoped){
      this.song.setMicrosecondPosition(stopPoint);
      this.stoped = false;
    }
    this.Playing = true;
    this.song.start();
    return true;
  }

  public boolean loop() {
    if(loop)
      song.loop(Clip.LOOP_CONTINUOUSLY);
    else
      song.loop(0);
    return true;

  }

  public void end() {
    this.loop = false;
    this.Playing = false;
    this.stopPoint = 0;
    if(this.Cancion.hasFile())
      this.song.stop();
    this.Cancion = null;
  }

  public boolean hasCancion() {
    return this.Cancion != null;
  }

}

