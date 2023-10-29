import javax.swing.*;

public class ButtonPosition {

    public int emptyIndex (JPanel buttonPanel) {
        int emptyButtonIndex = -1;
        for (int i = 0; i < buttonPanel.getComponentCount(); i++) {
            JButton button = (JButton) buttonPanel.getComponent(i);
            if (button.getText().equals(" ")) {
                emptyButtonIndex = i;
            }
        } return emptyButtonIndex;
    }
}
