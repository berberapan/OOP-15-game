import javax.swing.*;
import java.awt.*;

public class GameUI extends JFrame {
    JPanel platform = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();

    JLabel gameStatusLabel = new JLabel("Game Status: Game on");

    JButton newGameButton = new JButton("New Game");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");

    GameUI() {
        add(platform);

        platform.add(northPanel, BorderLayout.NORTH);
        platform.add(southPanel, BorderLayout.SOUTH);

        northPanel.add(gameStatusLabel);
        northPanel.add(newGameButton);

        southPanel.setLayout(new GridLayout(4,4));
        southPanel.add(button1);
        southPanel.add(button2);
        southPanel.add(button3);
        southPanel.add(button4);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
