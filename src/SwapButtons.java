import javax.swing.*;

public class SwapButtons {

    public void swap (JButton emptyButton, JButton clickedButton) {
        emptyButton.setText(clickedButton.getText());
        clickedButton.setText(" ");
        emptyButton.setVisible(true);
        clickedButton.setVisible(false);
    }
}
