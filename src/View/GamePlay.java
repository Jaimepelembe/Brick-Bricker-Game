/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Pelembe,Jaime
 */
public class GamePlay extends JPanel implements ActionListener, KeyListener {

    private boolean play = false;
    // private boolean nextLevel = false;
    private int level = 2;
    private Timer timer;
    private int delay = 1;
    private int width = new MainScreen("").getWindowsWidth();
    private int height = new MainScreen("").getWindowsHeight();
    private MapGenerator map;
    private Paddle paddle;
    private Ball ball;
    private Color background = Color.black;

    public GamePlay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();
        paddle = new Paddle();
        ball = new Ball();
        map = new MapGenerator(3, 7);

    }

    public GamePlay(String str) {

    }

    public void paint(Graphics g) {
        // Black canvas
        g.setColor(background);
        g.fillRect(1, 1, (width - 8), (height - 8)); // (1,1,692,592)

        // Border
        g.setColor(Color.yellow);
        g.fillRect(0, 0, (width - 8), 3);// UP
        g.fillRect(0, 3, 3, (height - 8));// Left
        g.fillRect((width - 19), 3, 3, (height - 8));// Rigth

        // paddle
        paddle.draw(g);

        // Bricks
        map.draw((Graphics2D) g);

        // Ball
        ball.draw(g);
        ball.setMap(map);

        ScoreAndLevel(g);

        // Game Over
        if (ball.getBallposY() >= height) {
            gameOver(g);
        }

        // You won
        if (verifyEndLevel()) {
            YouWon(g);
        }

    }

    public void Level2() {
        ball.setBallposX(width / 2);
        ball.setBallposY(height / 2);
        ball.setBallXdir(-4);
        ball.setBallYdir(-4);
        map = new MapGenerator(4, 8);
        map.setMapColor(Color.MAGENTA);
        paddle.setPlayerX(width / 2);
        paddle.setSpeedPuddle((int) (width * 0.030));
    }

    public void Level3() {
        ball.setBallposX(width / 2);
        ball.setBallposY(height / 2);
        ball.setBallXdir(-5);
        ball.setBallYdir(-5);
        map = new MapGenerator(5, 9);
        map.setMapColor(Color.ORANGE);
        paddle.setPlayerX(width / 2);
        paddle.setSpeedPuddle((int) (width * 0.038));
    }

    public void Level4() {
        ball.setBallXdir(width / 2);
        ball.setBallYdir(height / 2);
        ball.setBallXdir(-6);
        ball.setBallYdir(-6);
        map = new MapGenerator(6, 10);
        map.setMapColor(Color.YELLOW);
        paddle.setPlayerX(width / 2);
        paddle.setSpeedPuddle((int) (width * 0.048));
    }

    public void RestartGame() {
        ball.setBallposX(width / 2);
        ball.setBallposY(height / 2);
        ball.setBallXdir(-3);
        ball.setBallYdir(-3);
        ball.setScore(0);
        map = new MapGenerator(3, 7);
        paddle.setPlayerX(width / 2);

    }

    public void gameOver(Graphics g) {
        paddle.setPlay(false);
        paddle.setPlayerX(0);
        ball.setBallXdir(0);
        ball.setBallYdir(0);

        g.setColor(Color.red);
        g.setFont(new Font("arial", Font.BOLD, 50));
        int x = (width / 2) - 250;
        int y1 = (height / 2) - 100;
        int y2 = (height / 2) - 40;
        int y3 = (height / 2) + 15;
        g.drawString("GAME OVER MAN!", x, y1);

        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 50));
        g.drawString("Your Score: " + ball.getScore(), x + 70, y2);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.drawString("Press SPACE to Restart!", x + 20, y3);

    }

    public boolean verifyEndLevel() {
        if (map.getTotalBricks() <= 0) {
            return true;
        }
        return false;
    }

    public void YouWon(Graphics g) {
        paddle.setPlay(false);
        paddle.setPlayerX(0);
        ball.setBallXdir(0);
        ball.setBallYdir(0);
        // nextLevel = true;

        g.setColor(Color.blue);
        g.setFont(new Font("arial", Font.BOLD, 50));
        int x = (width / 2) - 250;
        int y1 = (height / 2) - 100;
        int y2 = (height / 2) - 40;
        int y3 = (height / 2) + 15;

        g.drawString("You Win!", x + 70, y1);

        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 50));
        g.drawString("Your Score: " + ball.getScore(), x + 20, y2);

        if (level < 4) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font("arial", Font.BOLD, 30));
            g.drawString("Press ENTER to GO Level " + level, x + 20, y3);
        }
    }

    public void ScoreAndLevel(Graphics g) {
        if (paddle.isPlay()) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("calibre", Font.BOLD, 25));
            g.drawString("Score: " + ball.getScore(), width / 2, 22);

            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("calibre", Font.BOLD, 22));
            g.drawString("Level: " + (level - 1), 250, 22);
        }

    }

    public Color getBackground() {
        return background;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (paddle.isPlay()) {
            ball.moveBall(paddle);
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Movements of the puddle
        paddle.keyPressed(e);

        // Restar the game
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !paddle.isPlay() && !verifyEndLevel()) {
            RestartGame();
            level = 2;
            ball.setScore(0);
        }

        // Go to next Level
        // Level 2
        if (e.getKeyCode() == KeyEvent.VK_ENTER && verifyEndLevel() && level == 2) {
            level = 3;
            Level2();

        }

        // Level 3
        if (e.getKeyCode() == KeyEvent.VK_ENTER && verifyEndLevel() && level == 3) {
            level = 4;
            Level3();
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && verifyEndLevel() && level == 4) {
            Level4();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
