import javax.swing.*;

public class SwapButtons {

    private JButton emptyButton;
    public SwapButtons(JButton emptyButton) {
        this.emptyButton = emptyButton;
    }

    public void swap (JButton clickedButton) {
        this.emptyButton.setText(clickedButton.getText());
        clickedButton.setText(" ");
        this.emptyButton.setVisible(true);
        clickedButton.setVisible(false);

        this.emptyButton = clickedButton;

    }
}
