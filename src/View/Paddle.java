/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author multi
 */
public class Paddle implements KeyListener {

    private int width = new MainScreen("").getWindowsWidth();
    private int height = new MainScreen("").getWindowsHeight();
    private int playerX = (int) (width / 2); //in this case 350
    private int paddlewidth = (int) (width * 0.2);
    private int SpeedPuddle = (int) (width * 0.028);
    private boolean play = false;

    public Paddle() {
    }

    public void draw(Graphics g) {
        //paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerX, (height - 80), paddlewidth, 15);    
    }

    //Move the puddle
    public void moveLeft() {
        play = true;
        if (playerX <= 0) {
            playerX = 0;
        } else {
            playerX -= SpeedPuddle;
        }

    }

    public void moveRight() {
        play = true;
        if (playerX >= (width - paddlewidth)) {
            playerX = (width - paddlewidth);
        } else {
            playerX += SpeedPuddle;
        }

    }
    
    //Getters and Setters
    public int getPlayerX() {
        return playerX;
    }
    public int getPaddlewidth() {
        return paddlewidth;
    }

    public int getSpeedPuddle() {
        return SpeedPuddle;
    }

    public void setSpeedPuddle(int SpeedPuddle) {
        this.SpeedPuddle = SpeedPuddle;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
    
    
//Events
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }
     
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
