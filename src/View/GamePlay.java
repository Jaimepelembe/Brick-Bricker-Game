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
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Pelembe,Jaime
 */
public class GamePlay extends JPanel implements ActionListener, KeyListener {

    private boolean play = false;
    private boolean nextLevel = false;
    private Timer timer;
    private int delay = 8;
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
        //Black canvas
        g.setColor(background);
        g.fillRect(1, 1, (width - 8), (height - 8)); // (1,1,692,592)

        //Border
        g.setColor(Color.yellow);
        g.fillRect(0, 0, (width - 8), 3);//UP
        g.fillRect(0, 3, 3, (height - 8));//Left
        g.fillRect((width - 19), 3, 3, (height - 8));//Rigth

        //paddle
        paddle.draw(g);

        //Bricks
        map.draw((Graphics2D) g);

        //Ball
        ball.draw(g);
        ball.setMap(map);

        Score(g);

        //Game Over
        if (ball.getBallposY() >= height) {
            gameOver(g);
        }

        //You won
        YouWon(g);

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

    public void Level2() {
        ball.setBallposX(width / 2);
        ball.setBallposY(height / 2);
        ball.setBallXdir(-4);
        ball.setBallYdir(-4);
        map = new MapGenerator(4, 8);
        map.setMapColor(Color.MAGENTA);
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
        g.drawString("Press Enter to Restart!", x + 20, y3);

    }

    public void YouWon(Graphics g) {
        if (map.getTotalBricks() <= 0) {
            paddle.setPlay(false);
            paddle.setPlayerX(0);
            ball.setBallXdir(0);
            ball.setBallYdir(0);
            nextLevel = true;

            g.setColor(Color.blue);
            g.setFont(new Font("arial", Font.BOLD, 50));
            int x = (width / 2) - 250;
            int y1 = (height / 2) - 100;
            int y2 = (height / 2) - 40;
            int y3 = (height / 2) + 15;
            int y4 = (height / 2) + 60;
            g.drawString("You Win!", x + 70, y1);

            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 50));
            g.drawString("Your Score: " + ball.getScore(), x + 20, y2);

            g.setColor(Color.YELLOW);
            g.setFont(new Font("arial", Font.BOLD, 30));
            g.drawString("Press Space to Go the next Level", x + 20, y4);

            g.setColor(Color.orange);
            g.drawString("Press Enter to Restart", x + 20, y3);

        }

    }

    public void Score(Graphics g) {
        if (paddle.isPlay()) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("calibre", Font.BOLD, 25));
            g.drawString("Score: " + ball.getScore(), width / 2, 22);
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

        paddle.keyPressed(e);//Movements of the puddle

        //Restar the game
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !paddle.isPlay()) {
            RestartGame();
            ball.setScore(0);
        }

        //Go to nexte Level
        if (e.getKeyCode() == KeyEvent.VK_SPACE && nextLevel) {
            Level2();
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
