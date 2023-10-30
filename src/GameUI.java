import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class GameUI extends JFrame{
    BorderLayout layout = new BorderLayout();
    JPanel platform = new JPanel(layout);
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JLabel gameStatusLabel = new JLabel("Welcome");
    JButton newGameButton = new JButton("New Game");

    ArrayList<JButton> buttonList = new ArrayList<>();

    JButton numberButton = new JButton();
    JButton emptySpaceButton = new JButton();

    NewButtonShuffle nbs = new NewButtonShuffle(southPanel, gameStatusLabel);

    GameUI() {

        gameStatusLabel.setForeground(Color.WHITE);
        gameStatusLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        northPanel.add(gameStatusLabel);

        //ny spel-knapp
        northPanel.setBorder(new EmptyBorder(10,0,10,0));
        northPanel.setBackground(Color.RED);
        newGameButton.setFont(new Font("Verdana", Font.BOLD, 12));
        newGameButton.setBackground(Color.WHITE);
        newGameButton.setFocusPainted(false);

        northPanel.add(newGameButton);

        int squareValue = 4;

        southPanel.setLayout(new GridLayout(squareValue,squareValue));
        southPanel.setBackground(Color.red);


        //lägger in siffrorna i ArrayList med siffror från 1-15
        for (int i = 1; i <= (squareValue*squareValue)-1; i++) {
            numberButton = new JButton(String.valueOf(i));
            numberButton.setBackground(Color.WHITE);
            numberButton.setFont(new Font("Verdana", Font.BOLD, 18));
            buttonList.add(numberButton);
        }

        buttonList.add(emptySpaceButton);
        emptySpaceButton.setVisible(false);
        emptySpaceButton.setBorder(null);
        emptySpaceButton.setText(" ");
        emptySpaceButton.setBackground(Color.WHITE);
        emptySpaceButton.setFont(new Font("Verdana", Font.BOLD, 18));

        ButtonPosition index = new ButtonPosition();

        //adderar listan i GUI med fast storlek på knapparna
        for (JButton button : buttonList) {
            southPanel.add(button);
            button.setPreferredSize(new Dimension(60, 60));
            button.setFocusPainted(false);
        }
        JButton emptyButton = (JButton) southPanel.getComponent(index.emptyIndex(southPanel));
        SwapButtons swapper = new SwapButtons(emptyButton);
        WinningCondition win = new WinningCondition();


        for (Component component : southPanel.getComponents()) {
            JButton buttonAction = (JButton) component;
            buttonAction.addActionListener(e -> { if
            (new EligibilityCheck().isButtonEligible(index.emptyIndex(southPanel),
                            index.buttonIndex(southPanel,(JButton) e.getSource()), squareValue ))
            {swapper.swap((JButton) e.getSource()); if (win.isGameWon(southPanel))
            {win.displayWinMessage();}}});
        }


        platform.add(northPanel, BorderLayout.NORTH);
        platform.add(southPanel, BorderLayout.SOUTH);
        platform.setBorder(new EmptyBorder(0, 15, 15, 15));
        platform.setBackground(Color.RED);

        //startar spelet genom att shuffle
        newGameButton.addActionListener(nbs);

        add(platform);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
