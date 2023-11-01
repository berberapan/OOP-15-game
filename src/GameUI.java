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
    String statusGameOn = "Status: Game on";
    private final int squareValue = 4;

    GameUI() {
        gameStatusLabel.setForeground(Color.WHITE);
        gameStatusLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        northPanel.add(gameStatusLabel);

        northPanel.setBorder(new EmptyBorder(10,0,10,0));
        northPanel.setBackground(Color.RED);
        newGameButton.setFont(new Font("Verdana", Font.BOLD, 12));
        newGameButton.setBackground(Color.WHITE);
        newGameButton.setFocusPainted(false);
        northPanel.add(newGameButton);

        southPanel.setLayout(new GridLayout(this.squareValue,this.squareValue));
        southPanel.setBackground(Color.red);

        ButtonCreation bc = new ButtonCreation(this.squareValue);

        addButtonsToGui(bc.getButtonList(), southPanel);
        ButtonPosition index = new ButtonPosition();
        JButton emptyButton = (JButton) southPanel.getComponent(index.emptyIndex(southPanel));
        addActionToButtons(southPanel, emptyButton);

        newGameButton.addActionListener(new NewButtonShuffle(this));

        platform.add(northPanel, BorderLayout.NORTH);
        platform.add(southPanel, BorderLayout.SOUTH);
        platform.setBorder(new EmptyBorder(0, 15, 15, 15));
        platform.setBackground(Color.RED);
        add(platform);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void addButtonsToGui(ArrayList<JButton> buttonList, JPanel buttonPanel) {
        for (JButton button : buttonList) {
            buttonPanel.add(button);
            button.setPreferredSize(new Dimension(60, 60));
            button.setFocusPainted(false);
        }
    }
    public void addActionToButtons(JPanel buttonPanel, JButton empty) {
        ButtonPosition index = new ButtonPosition();
        WinningCondition win = new WinningCondition();
        SwapButtons swapper = new SwapButtons(empty);

        for (Component component : buttonPanel.getComponents()) {
            JButton button = (JButton) component;
            button.addActionListener(e -> {
                if (new EligibilityCheck().isButtonEligible(index.emptyIndex(southPanel),
                        index.buttonIndex(southPanel, (JButton) e.getSource()), squareValue)) {
                    swapper.swap((JButton) e.getSource());
                    if (win.isGameWon(southPanel, gameStatusLabel)) {
                        win.displayWinMessage();}}});
        }
    }

    public int getSquareValue() {
        return squareValue;
    }
}
