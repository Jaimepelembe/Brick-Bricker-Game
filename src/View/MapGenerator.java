/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

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
    
    public MapGenerator(int row, int column){
        map= new int[row][column];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
            map[i][j]=1;
            }
        }
        brickWidth= (int) (width/column);
        brickHeight=(int)(height*0.3)/row;        
    }
    
}
