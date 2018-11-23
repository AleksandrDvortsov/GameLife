import java.awt.*;

public class Cell {

    int firstX;
    int firstY;
    Color colorCell;

    public void init ( int x, int y, Color color ){
        this.firstX = x;
        this.firstY = y;
        this.colorCell = color;
    }
    public void draw( Graphics2D graphics2D ){
        graphics2D.setColor(colorCell);
        graphics2D.fillRect(firstX,firstY,10,10);
    }
}
