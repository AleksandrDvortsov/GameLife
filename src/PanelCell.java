import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCell extends JPanel {

    ArrayList<Cell> listCell;
    Color clr;

    public PanelCell() {
        setLayout(null);
        setBackground(Color.yellow);

        listCell = new ArrayList<>();

        allCell();

        gameLife();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gg = (Graphics2D) g;
        for (Cell shapes : listCell) {

//            listCell.get(0).colorCell = Color.red;
//            System.out.println(listCell.get(0).colorCell + " - 777");

            shapes.draw(gg);
        }
    }

    public void randomColor() {
        if (Math.round(Math.random()) > 0) {
            clr = Color.white;
        } else {
            clr = Color.black;
        }
    }

    public void allCell() {
        int x = 5;
        int y = 5;
        for (int i = 0; i < 2400; i++) {

            randomColor();

            Cell cell = new Cell();

            if (listCell.size() == 0) {
                cell.init(x, y, clr);
                listCell.add(cell);
            } else {
                if (x > 480) {
                    y = y + 10;
                    x = -5;

                } else {
                    x = x + 10;
                    cell.init(x, y, clr);
                    listCell.add(cell);
                }
            }

        }
    }

    public void gameLife() {

        Thread run = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //ДЕЛАЕМ
//                        System.out.println("test timer");
//                        for (int i = 0; i < listCell.size(); i++) {
////                            if ( listCell.get(i).colorCell == Color.white ){
////                                listCell.get(i).colorCell = Color.black;
////                            }
////                            else {
////                                listCell.get(i).colorCell = Color.white;
////                            }
////                        }
                        controller();
                        repaint();
                        Thread.sleep(2000); //1000 - 1 сек
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });
        run.start(); // заводим
    }

    public void controller() {

        int count = 0;
        int k = 2;
        for (int i = 0; i < listCell.size(); i++) {
            if (listCell.get(k).colorCell == Color.white) {
                System.out.println(k + " - k  W H I T E");
                if (listCell.get(k + 1).colorCell == Color.black) {
                    count++;
                }
                if (listCell.get(k - 1).colorCell == Color.black) {
                    count++;
                }

                break;

            }
        }
        System.out.println(count + " - Counter");

    }
}
