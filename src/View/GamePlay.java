/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import java.awt.Color;
import java.awt.Graphics;
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
    private int Bricks = 21;//Total number of brick
    private Timer timer;
    private int delay = 1;
    private int width = new MainScreen("").getWindowsWidth();
    private int height = new MainScreen("").getWindowsHeight();
    private int ballposX = (width / 2);
    private int ballposY = (height / 2);
    private int ballXdir = -3;
    private int ballYdir = -4;
    private int playerX = (int) (width / 2); //in this case 350
    private Color ballColor = Color.RED;
    private int paddlewidth = (int) (width * 0.2);
    private int ballSize = (int) (paddlewidth * 0.2);
    private int SpeedPuddle = (int) (width * 0.028);

    public GamePlay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        //Black canvas
        g.setColor(Color.black);
        g.fillRect(1, 1, (width - 8), (height - 8)); // (1,1,692,592)

        //Border
        g.setColor(Color.yellow);
        g.fillRect(0, 0, (width - 8), 3);//UP
        g.fillRect(0, 3, 3, (height - 8));//Left
        g.fillRect((width - 19), 3, 3, (height - 8));//Rigth

        //paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerX, (height - 80), paddlewidth, 15);

        //Ball
        g.setColor(ballColor);
        g.fillOval(ballposX, ballposY, ballSize, ballSize);

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

    //Move the Ball
    public void moveBall(){
    if(ballposX<=0){
    ballXdir=-(ballXdir);
    }
    
    if(ballposX>=(width-ballSize-8)){
   ballXdir=-(ballXdir);
   }
   
    if(ballposY<=0){
    ballYdir=-(ballYdir);
    }
    
    //Verify the colison of the ball with the paddle
    Rectangle ballRect= new Rectangle(ballposX,ballposY,ballSize,ballSize);
    Rectangle paddleRect = new Rectangle(playerX,(height-80),paddlewidth,15);
    
    if(ballRect.intersects(paddleRect)){
    ballYdir=-(ballYdir);
    }
    
    ballposX+=ballXdir;
    ballposY+=ballYdir;
    }
    
    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(play){
            moveBall();
        
        }
        repaint();
    }

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
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
