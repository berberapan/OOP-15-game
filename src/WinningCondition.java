import javax.swing.*;
import java.awt.*;

public class WinningCondition {

    public boolean isGameWon(JPanel panel) {
        for (int i = 0; i <= panel.getComponentCount() - 2; i++) {
            JButton button = (JButton) panel.getComponent(i);
            if (!button.getText().equals(String.format("%d", i+1))) {
                return false;
            };
        } return true;
    }
    public void displayWinMessage() {
        JLabel label = new JLabel("\nYou won!\n", SwingConstants.CENTER);
        label.setFont(new Font("Verdana", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, " ", JOptionPane.PLAIN_MESSAGE);
    }
}
