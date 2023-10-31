import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonCreation {

    private int squareValue;
    private ArrayList<JButton> buttonList = new ArrayList<>();

    public ButtonCreation(int square) {
        JButton button = new JButton();
        this.squareValue = square;
        for (int i = 1; i <= (Math.pow(square,2)); i++) {
            button = new JButton(String.valueOf(i));
            button.setBackground(Color.WHITE);
            button.setFont(new Font("Verdana", Font.BOLD, 18));
            if (i == Math.pow(square,2)) {
                button.setText(" ");
                button.setVisible(false);
            }
            buttonList.add(button);
        }
    }

    public int getSquareValue() {
        return squareValue;
    }

    public void setSquareValue(int squareValue) {
        this.squareValue = squareValue;
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(ArrayList<JButton> buttonList) {
        this.buttonList = buttonList;
    }
}
