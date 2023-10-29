import javax.swing.*;

public class SwapButtons {

    private JButton nextEmptyButton;
    public SwapButtons(JButton nextEmptyButton) {
        this.nextEmptyButton = nextEmptyButton;
    }

    public void swap (JButton clickedButton) {
        this.nextEmptyButton.setText(clickedButton.getText());
        clickedButton.setText(" ");
        this.nextEmptyButton.setVisible(true);
        clickedButton.setVisible(false);

        this.nextEmptyButton = clickedButton;

    }
}
