/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author multi
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;


public class Music {
        File MusicBackGround;
        File MusicCollision;
   

    public Music() {
        MusicBackGround = new File("src/Music/BoxCat Games - CPU Talk.wav");
        MusicCollision = new File("src/Music/smw_coin.wav");
    }
    

    
 
    public void PlayMusic(String answer) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        //Answer
        //P -Play
        //R - Restart 
        //Q- Quit
        //S- Stop
        Scanner scanner= new Scanner(System.in);
        AudioInputStream audio = AudioSystem.getAudioInputStream(MusicBackGround);
        Clip clip=AudioSystem.getClip();
        clip.open(audio);
        while(!answer.equalsIgnoreCase("Q")){
        switch(answer){
            case ("P"): clip.start();
            break;
            case("R"): clip.setMicrosecondPosition(0); break;
            case ("S"): clip.stop();break;
            default:JOptionPane.showMessageDialog(null, "Opcao Invalida");
                   
        }
            
        }

}

    public void MusicColision() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
       Scanner scanner= new Scanner(System.in);
       AudioInputStream audio = AudioSystem.getAudioInputStream(MusicCollision);
       Clip clip=AudioSystem.getClip();
       clip.open(audio);
       double seconds=clip.getMicrosecondLength();
       while(seconds>0){
       clip.start();
       seconds=seconds-0.1;
       }
    }


    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
       // new Music().PlayMusic("P");
        new Music().MusicColision();
        
    }
 
}

