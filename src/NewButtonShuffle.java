import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class NewButtonShuffle extends JFrame implements ActionListener {
    JPanel southPanel = new JPanel();
    ArrayList<JButton> buttonList = new ArrayList<>();
    JButton numberButton = new JButton();
    JButton emptySpaceButton = new JButton();

    public NewButtonShuffle(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        southPanel.removeAll();
        southPanel.revalidate();
        southPanel.repaint();

        buttonList.clear();

        southPanel.setLayout(new GridLayout(4, 4));

        for (int i = 1; i <= 15; i++) {
            numberButton = new JButton(String.valueOf(i));
            numberButton.setBackground(Color.WHITE);
            numberButton.setFont(new Font("Verdana", Font.BOLD, 18));
            buttonList.add(numberButton);
        }

        buttonList.add(emptySpaceButton);
        emptySpaceButton.setBackground(Color.RED);
        emptySpaceButton.setBorder(null);

        Collections.shuffle(buttonList);

        for (JButton button : buttonList) {
            southPanel.add(button);
            button.setPreferredSize(new Dimension(60, 60));
            button.setFocusPainted(false);
        }

        southPanel.revalidate();
        southPanel.repaint();
    }
}
