/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

/**
 *
 * @author multi
 */
public class Sound extends Thread {

    private javax.swing.Timer timer;
    private Clip clip;
    private ArrayList<File> files;
    private int loopDuration=180000;
    private boolean isContinuos=false;
   private boolean isPlay=false;
    private double duration;

    public Sound() {
        initComponents();

    }

    private void initComponents() {
        //Sounds
        files = new ArrayList();
        files.add(new File("src/Som/BoxCat Games   CPU Talk.wav"));
        files.add(1, new File("src/Som/smw_coin.wav"));
        files.add(2, new File("src/Som/smw_kick.wav"));
        
//         timer = new Timer(1000, new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    effectSound();
//                    Thread.sleep(1000);
//                } catch (LineUnavailableException ex) {
//                    Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (UnsupportedAudioFileException ex) {
//                    Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });

        
    }
    public void setFile(int indice) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream ais = AudioSystem.getAudioInputStream((files.get(indice)));
        this.clip = AudioSystem.getClip();
        this.clip.open(ais);
        duration = (clip.getMicrosecondLength()*1000);
        System.out.println("Duration "+duration);

    }

    public void effectSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        for(int i=0;i<duration;i=i+20){
         this.clip.start();
        }
        this.clip.stop();
    
    }
    public void backGraundSound() throws IOException{
        //isContinuos=true;
        this.clip.loop(clip.LOOP_CONTINUOUSLY);
        
        
//        try {
//         this.clip.loop(clip.LOOP_CONTINUOUSLY);
//            Thread.sleep(loopDuration);
//        } 
//        catch (InterruptedException ex) {
//            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }

   
    public void run() {
        try {
            
            backGraundSound();
             Thread.sleep(loopDuration);
//
//        try {
//            if(isContinuos==true) {
//            //playContinous();
//                
//            Thread.sleep(loopDuration);}
//
//         
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//catch (LineUnavailableException ex) {
//            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedAudioFileException ex) {
//            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (IOException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getDelay() {
        return loopDuration;
    }

    public void setDelay(int delay) {
        this.loopDuration = delay;
    }

    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException, Throwable {
        Sound som = new Sound();
        som.setFile(1);
        //som.backGraundSound();
        for(int i=0;i<4;i++){
        som.effectSound();
        Sound som2 = new Sound();
           som2.setFile(1);
        som2.effectSound();
        
        }
         //som.start();
        //som.start();
        
        
        
    }

}
