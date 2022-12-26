/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author multi
 */
public class MainScreen {
 private JFrame window;
 private int windowsWidth=700;
 private int windowsHeight=600;
 
 public MainScreen(){
CreateWindow();
 }
 public MainScreen(String str){
 };
 
 // Will create the main screen of the play
private void CreateWindow(){
window = new JFrame();
window.setSize(windowsWidth,windowsHeight);
window.setTitle("Brick Breaker Game");
window.setLocationRelativeTo(null);
ImageIcon image= new ImageIcon("src/Imagens/BrickerGame.png");
window.setIconImage(image.getImage());
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setResizable(false);

addGamePlay();

window.setVisible(true);


}
 
private void addGamePlay(){
 GamePlay gameplay = new GamePlay();
 window.add(gameplay);
 }

    public int getWindowsWidth() {
        return windowsWidth;
    }

    

    public int getWindowsHeight() {
        return windowsHeight;
    }

 
 
 
 
    public static void main(String[] args) {
        new MainScreen();
    }
}
