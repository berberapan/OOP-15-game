import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    JButton emptySpaceButton = new JButton();

    GameUI() {
        //speltitel
        gameStatusLabel.setForeground(Color.WHITE);
        gameStatusLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        northPanel.add(gameStatusLabel);

        //nytt spel-knapp
        northPanel.setBorder(new EmptyBorder(10,0,10,0));
        northPanel.setBackground(Color.RED);
        newGameButton.setFont(new Font("Verdana", Font.BOLD, 12));
        newGameButton.setBackground(Color.WHITE);
        newGameButton.setFocusPainted(false);
        northPanel.add(newGameButton);

        int hGap = 2;
        int vGap = 2;

        int squareValue = 4;

        southPanel.setLayout(new GridLayout(squareValue,squareValue,hGap,vGap));
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

        //slumpar siffrorna så det hamnar i slumpmässig ordning
        Collections.shuffle(buttonList);

        ButtonPosition index = new ButtonPosition();

        //adderar listan i GUI med fast storlek på knapparna
        for (JButton button : buttonList) {
            southPanel.add(button);
            button.setPreferredSize(new Dimension(60, 60));
            button.setFocusPainted(false);
        }
        JButton emptyButton = (JButton) southPanel.getComponent(index.emptyIndex(southPanel));
        SwapButtons swapper = new SwapButtons(emptyButton);


        for (Component component : southPanel.getComponents()) {
            JButton buttonAction = (JButton) component;
            buttonAction.addActionListener(e -> { if (new EligibilityCheck().isButtonEligible
                    (index.emptyIndex(southPanel),
                            index.buttonIndex(southPanel
                                    ,(JButton) e.getSource())
                            , squareValue )) {
                swapper.swap((JButton) e.getSource());}});
        }


        platform.add(northPanel, BorderLayout.NORTH);
        platform.add(southPanel, BorderLayout.SOUTH);
        platform.setBorder(new EmptyBorder(0, 15, 15, 15));
        platform.setBackground(Color.RED);

        add(platform);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Test av metod. Att ta bort senare
        System.out.println(new ButtonPosition().emptyIndex(southPanel));
    }
}
