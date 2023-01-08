/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author multi
 */
public class MainScreen implements ActionListener {

    private static JFrame window;
    private int windowsWidth = 800;
    private int windowsHeight = 700;
    private static int score = 0;
    private JPanel pPrincipal;
    private JPanel pComponentes;
    private boolean on = false;

    public MainScreen() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        CreateWindow();
    }

    public MainScreen(String str) {
    }

    ;

    // Will create the main screen of the play
    private void CreateWindow() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        window = new JFrame();
        window.setSize(windowsWidth, windowsHeight);
        window.setTitle("Brick Breaker Game");
        window.setLocationRelativeTo(null);
        ImageIcon image = new ImageIcon("src/Imagens/BrickerGame.png");
        window.setIconImage(image.getImage());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        addGamePlay();
        window.setVisible(true);
    }

    private void addGamePlay()throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        GamePlay gameplay = new GamePlay();
        window.add(gameplay);
    }

    public int getWindowsWidth() {
        return windowsWidth;
    }

    public int getWindowsHeight() {
        return windowsHeight;
    }

    public void setScore(int Score) {
        this.score = Score;
    }

    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        new MainScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
