import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {

    Frame frame;


    public Panel( Frame frame ) {
        this.frame = frame;
        setLayout(null);

        GameLife gameLife = new GameLife();
        gameLife.setBounds(250,25,500,500);
        gameLife.setBackground(Color.CYAN);
        add(gameLife);

        ButtonPanel btnPanel = new ButtonPanel(gameLife);
        btnPanel.setBounds(25,25,200,100);
        add(btnPanel);

        setBounds(5, 5, 770, 550);
        setBackground(Color.LIGHT_GRAY);
    }

}
