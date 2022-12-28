/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 *
 * @author multi
 */
public class MapGenerator {
    public int map[][] ;
    public int brickWidth;
    public int brickHeight;
    private int width= new MainScreen("").getWindowsWidth();
    private int height= new MainScreen("").getWindowsHeight();
    private int row;
    private Color StrokeColor=new GamePlay("").getBackground();
    private Color mapColor=Color.cyan;
    private int totalBricks;
    
    /**
     * Cria o esquema do mapa
     * @param row -Indica o numero de linhas
     * @param column - Indica o numero de colunas
     */
    
    public MapGenerator(int row, int column){
        map= new int[row][column];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
            map[i][j]=1;
            }
        }
        this.row=row;
        brickWidth= (int) (width/column);
        brickHeight=(int)(height*0.15)/row;  
        totalBricks=row*column;
    }
    
    /**
     * Metodo que mostra ou oculta um tijolo;
     * @param value  1 para Visivel e 2 para invisivel
     * @param i Coordenada i da matriz;
     * @param j Coordenada j da matriz;
     */
    public void setBrick(int value, int i, int j){
    map[i][j]=value;
    }
    
    /**
     * Desenha os rectângulos no mapa 
     * @param g -Objecto da classe Graphics2D 
     */
    public void draw(Graphics2D g){
    
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]>0){
                g.setColor(mapColor);
                g.fillRect(j*brickWidth+3, i*brickHeight+25, brickWidth, brickHeight);

                //Create the separator of bricks
                g.setColor(StrokeColor);
                g.setStroke(new BasicStroke(row));
                g.drawRect(j*brickWidth+4, i*brickHeight+25, brickWidth, brickHeight);
                }
            }
        }
        
    }

    public Color getMapColor() {
        return mapColor;
    }

    public void setMapColor(Color mapColor) {
        this.mapColor = mapColor;
    }

    public int getTotalBricks() {
        return totalBricks;
    }

    public void setTotalBricks(int totalBricks) {
        this.totalBricks = totalBricks;
    }
    
    
    
}
