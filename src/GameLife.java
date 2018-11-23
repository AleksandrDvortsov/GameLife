import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameLife extends JPanel {

    private int matrixSize = 50;
    private boolean[][] lefeMatrix;
    private int SPEED_LIFE = 100;
    private int CELL_SIZE = 10;
    boolean GAME_LOOP = true;

    public GameLife() {
        lefeMatrix = new boolean[matrixSize][matrixSize];
        createMatrixLefe();

    }

    public void startGame(){
        GAME_LOOP = true;
        lifeDevelopment();
    }

    public void restartGame(){
        GAME_LOOP = false;
        createMatrixLefe();
        repaint();
        ButtonPanel.btnStart.setEnabled(true);
    }

    private void lifeDevelopment() {
        Controller controller = new Controller();
        controller.setCountMatrix(matrixSize);

        Thread run = new Thread(new Runnable() {
            @Override
            public void run() {
                while (GAME_LOOP) {

                    controller.setOldMatrix(lefeMatrix);
                    lefeMatrix = controller.getOldMatrix();

                    if ( lefeMatrix == null ){
                        GAME_LOOP = false;
                        lefeMatrix = new boolean[matrixSize][matrixSize];
                        JOptionPane.showMessageDialog(null, "Все закончилось/или зависло");
                        ButtonPanel.btnRestart.setEnabled(true);
                        repaint();
                        System.out.println("stop GAME");
                    }else {
                        repaint();
                    }

                    try {
                        Thread.sleep(SPEED_LIFE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        run.start();
    }

    private void createMatrixLefe() {
        Random random = new Random();

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                lefeMatrix[i][j] = random.nextBoolean();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (lefeMatrix == null) {
            System.out.println("matrix - NULL !");
        } else {
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (lefeMatrix[i][j]) {
                        g.setColor(Color.WHITE);
                        g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    } else {
                        g.setColor(Color.BLACK);
                        g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }

                }
            }
        }
    }
}
