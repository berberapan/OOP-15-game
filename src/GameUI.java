import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameUI extends JFrame {
    BorderLayout layout = new BorderLayout();
    JPanel platform = new JPanel(layout);
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JLabel gameStatusLabel = new JLabel("Game Status: Game on");
    JButton newGameButton = new JButton("New Game");

    ArrayList<JButton> buttonList = new ArrayList<>();

    JButton numberButton = new JButton();

    GameUI() {
        northPanel.add(gameStatusLabel);
        northPanel.add(newGameButton);

        southPanel.setLayout(new GridLayout(4,4));

        //lägger in siffrorna i ArrayList med siffror från 1-15
        for (int i = 1; i <= 15; i++) {
            numberButton = new JButton(String.valueOf(i));
            buttonList.add(numberButton);
        }

        //slumpar siffrorna så det hamnar i slumpmässig ordning
        Collections.shuffle(buttonList);

        //adderar listan i GUI med fast storlek på knapparna
        for (JButton button : buttonList) {
            southPanel.add(button);
            numberButton.setPreferredSize(new Dimension(60, 60));
        }

        platform.add(northPanel, BorderLayout.NORTH);
        platform.add(southPanel, BorderLayout.SOUTH);

        add(platform);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
