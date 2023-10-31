import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class NewButtonShuffle implements ActionListener {
    private final GameUI ui;

    public NewButtonShuffle (GameUI ui) {
        this.ui = ui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonCreation bc = new ButtonCreation(ui.getSquareValue());
        ButtonPosition index = new ButtonPosition();
        ui.gameStatusLabel.setText(ui.statusGameOn);
        ui.gameStatusLabel.setForeground(Color.WHITE);
        ui.southPanel.removeAll();
        ui.southPanel.revalidate();
        ui.southPanel.repaint();
        ArrayList<JButton> newList = bc.getButtonList();
        Collections.shuffle(newList);
        ui.addButtonsToGui(newList, ui.southPanel);
        JButton newEmptyButton = (JButton) ui.southPanel.getComponent(index.emptyIndex(ui.southPanel));
        ui.addActionToButtons(ui.southPanel, newEmptyButton);
    }
}

