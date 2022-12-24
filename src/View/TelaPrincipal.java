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
public class TelaPrincipal {
 private JFrame window;
 public TelaPrincipal(){
 criarJanela();
 }
 
 public void criarJanela(){
window = new JFrame();
window.setSize(700,700);
window.setTitle("Bricker Game");
window.setLocationRelativeTo(null);
ImageIcon imagem= new ImageIcon("src/Imagens/BrickerGame.png");
window.setIconImage(imagem.getImage());
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setVisible(true);
window.setResizable(false);

}
 
 public void addGamePlay(){
 GamePlay gameplay = new GamePlay();
 window.add(gameplay);
 }
    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
