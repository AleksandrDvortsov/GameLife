import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{


    public Frame(){
        setLayout(null);
        setBounds(500, 5, 800, 600);
        setTitle("Game Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);

        Panel panel = new Panel(this);
        add(panel);

        setVisible(true);
    }
}
