/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Sound;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author multi
 */
public class Ball implements ActionListener {

    private int width = new MainScreen("").getWindowsWidth();
    private int height = new MainScreen("").getWindowsHeight();
    private int ballSize;
    private int ballposX = (width / 2);
    private int ballposY = (height / 2);
    private int ballXdir = -2;
    private int ballYdir = -3;
    private Color ballColor = Color.RED;
    private Paddle paddle;
    private MapGenerator map;
    private int score = 0;
    private Sound effectSound;

    public Ball()throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        initComponents();
    }

    private void initComponents() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
   
    
    paddle = new Paddle();
    ballSize = (int) (paddle.getPaddlewidth() * 0.2);
    
    }
    public void draw(Graphics g) {
        // Ball
        g.setColor(ballColor);
        g.fillOval(ballposX, ballposY, ballSize, ballSize);
    }

    // Move the Ball
    public void moveBall(Paddle paddle) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (ballposX <= 0 || ballposX >= (width - ballSize - 8)) {
            ballXdir = -(ballXdir);
        }

        // Verify the colison of the ball with the paddle
        Rectangle ballRect = new Rectangle(ballposX, ballposY, ballSize, ballSize);
        Rectangle paddleRect = new Rectangle(paddle.getPlayerX(), (height - 80), paddle.getPaddlewidth(), 15);

        if (ballposY <= 0 || ballRect.intersects(paddleRect)) {
            ballYdir = -(ballYdir);
        }

        // Brick Breaking by ball
        brickBreaking(ballRect);

        ballposX += ballXdir;
        ballposY += ballYdir;
    }

    // Brick breaking by ball
    public void brickBreaking(Rectangle ballRect) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        for (int i = 0; i < map.map.length; i++) {

            for (int j = 0; j < map.map[0].length; j++) {

                if (map.map[i][j] > 0) {
                    int brickWidth = map.brickWidth;
                    int brickHeight = map.brickHeight;
                    int brickposX = j * brickWidth + 3;
                    int brickposY = i * brickHeight + 2;

                    Rectangle brickRect = new Rectangle(brickposX, brickposY, brickWidth, brickHeight);
                    if (ballRect.intersects(brickRect)) {
                        map.setBrick(0, i, j);
                        map.setTotalBricks(map.getTotalBricks() - 1);
                        score += 5;
                        changeDirectionBall(brickposX, brickWidth);
                    }

                }

            }

        }

    }

    /**
     * Muda a direçâo da bola ao atingir um tijolo
     *
     * @param brickposX Posiçâo X da bola
     * @param width     Comprimento do tijolo
     */
    public void changeDirectionBall(int brickposX, int width) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        
        if (ballposX + ballSize <= brickposX || ballposX + 1 >= brickposX + width) {
            ballXdir = -(ballXdir);
        } else {
            ballYdir = -(ballYdir);
        }
//        //Sound Effect of Collision
//        effectSound= new Sound();
//        effectSound.setFile(1);
//        effectSound.effectSound();
//        
    }

    public void setMap(MapGenerator map) {
        this.map = map;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBallposY() {
        return ballposY;
    }

    public void setBallposY(int ballposY) {
        this.ballposY = ballposY;
    }

    public int getBallposX() {
        return ballposX;
    }

    public void setBallposX(int ballposX) {
        this.ballposX = ballposX;
    }

    public int getBallXdir() {
        return ballXdir;
    }

    public void setBallXdir(int ballXdir) {
        this.ballXdir = ballXdir;
    }

    public int getBallYdir() {
        return ballYdir;
    }

    public void setBallYdir(int ballYdir) {
        this.ballYdir = ballYdir;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
