import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ButtonCreation {

    private final int square;
    public ButtonCreation(int square) {
       this.square = square;
    }
    public ArrayList<JButton> createUnshuffledButtons() {
        ArrayList<JButton> buttonList = new ArrayList<>();
        for (int i = 1; i <= (Math.pow(this.square,2)); i++) {
            JButton button = new JButton();
            button.setBackground(Color.WHITE);
            button.setFont(new Font("Verdana", Font.BOLD, 18));
            button.setText(String.valueOf(i));
            if (i == Math.pow(this.square,2)) {
                button.setText(" ");
                button.setVisible(false);
            }
            buttonList.add(button);
        }
        return buttonList;
    }

    public void shuffleButtons(ArrayList<JButton> buttons) {
        Collections.shuffle(buttons);
        while(!solvableCombination(buttons)) {
            Collections.shuffle(buttons);
        }
    }

    // Logic found here: https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/
    public boolean solvableCombination(ArrayList<JButton> buttons) {
        int emptyIndex = -1;
        int inversion = 0;
        boolean isEmptyInEvenRow = false;
        boolean isSquareEven = this.square % 2 == 0;
        boolean notSolvable = false;
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals(" "))
                emptyIndex = i;
            for (int j = i; j < buttons.size(); j++) {
                if (!buttons.get(j).getText().equals(" ") && !buttons.get(i).getText().equals(" ")) {
                    int a = Integer.parseInt(buttons.get(j).getText());
                    int b = Integer.parseInt(buttons.get(i).getText());
                    if (b > a) {
                        inversion++;
                    }
                }
            }
        }
        for (int i = (this.square*this.square)-1; i >= 0; i -= 2*this.square) {
            if (i >= emptyIndex && emptyIndex <= i - this.square) {
                isEmptyInEvenRow = true;
                break;
            }
        } if (isSquareEven) {
            if (isEmptyInEvenRow && inversion % 2 != 0) {
                return true;
            } else if (!isEmptyInEvenRow && inversion % 2 == 0) {
                return true;
            } else {
                if (!notSolvable) {
                    JLabel notSolvableLabel = new JLabel("\nNot solvable!\n", SwingConstants.CENTER);
                    notSolvableLabel.setFont(new Font("Verdana", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, notSolvableLabel, " ", JOptionPane.PLAIN_MESSAGE);
                }
                return false;
            }
        } else {
            if (inversion % 2 == 0) {
                return true;
            } else {
                if (!notSolvable) {
                    JLabel notSolvableLabel = new JLabel("\nNot solvable!\n", SwingConstants.CENTER);
                    notSolvableLabel.setFont(new Font("Verdana", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, notSolvableLabel, " ", JOptionPane.PLAIN_MESSAGE);
                }
                return false;
            }
        }
    }
}