import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    GameLife g;
    public static JButton btnStart;
    public static JButton btnRestart;

    public ButtonPanel(GameLife gameLife) {
        this.g = gameLife;
        setLayout(null);

        btnStart = new JButton("Start");
        btnStart.setBounds(10,10,180,25);
        add(btnStart);

        btnRestart = new JButton("Restart");
        btnRestart.setBounds(10,55,180,25);
        add(btnRestart);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               g.startGame();
                btnStart.setEnabled( false );
                btnRestart.setEnabled( false );
            }
        });
        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.restartGame();
            }
        });


    }
}
