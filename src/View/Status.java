/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author multi
 */
public class Status  implements ActionListener{
private int lives=3;
private int score=0;
private int level=1;
private int highScore;
private boolean play=false;
public Status(){
    
}
//
//public void paint(Graphics g){
//g.setColor(Color.BLACK);
//g.setFont(new Font("arial",Font.BOLD,20));
//g.drawString("Lives"+lives, 10, 10);
//
////g.drawString("Score"+score, 40, 10);
//
//}


public void updateScreen(JFrame window){
window.setVisible(true);
}


public JPanel painelStatus(){
GridBagConstraints gbc = new GridBagConstraints();
JPanel panel = new JPanel(new GridBagLayout());
panel.setBackground(Color.white);
gbc.insets = new Insets(0, 0, 0, 20);
gbc.gridx = 0;
gbc.gridy = 0;
panel.add(new JLabel("Lives: "+ lives),gbc);

gbc.gridx = 1;
gbc.gridy = 0;
panel.add(new JLabel("Level: "+ level),gbc);

gbc.gridx = 2;
gbc.gridy = 0;
panel.add(new JLabel("Score: "+ score),gbc);

return panel;}

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
    

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(play){
 
    }
    }


}
