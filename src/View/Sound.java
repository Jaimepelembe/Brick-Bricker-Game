/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author multi
 */
public class Sound {
 Clip clip;
 URL soundURL[]= new URL[10];
 
 public Sound(){
 soundURL[0]=getClass().getResource("src/Music/BoxCat Games - CPU Talk.wav");//Background
 soundURL[1]=getClass().getResource("src/Music/smw_blargg.wav");//Game Over 
 soundURL[2]=getClass().getResource("src/Music/smw_kick.wav"); //Break Breaking
 soundURL[3]=getClass().getResource("src/Music/smw_coin.wav");//You win
 }
 public void setFile(int i) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
 AudioInputStream audio= AudioSystem.getAudioInputStream(soundURL[i]);
 clip=AudioSystem.getClip();
 clip.open(audio);
 
 }
 
}
