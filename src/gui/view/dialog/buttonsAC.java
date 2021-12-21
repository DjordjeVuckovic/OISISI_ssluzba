package gui.view.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class buttonsAC {
    public JButton acceptButton;
    public JButton cancelButton;
    public JPanel middlePanel = new JPanel();
    public JPanel buttonPanel = new JPanel();
    public JPanel buttons = new JPanel();
    public buttonsAC(String acceptButtonName,String cancelButtonName) {
        middlePanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.WHITE);
        buttons.setBackground(Color.WHITE);
        acceptButton = new JButton(acceptButtonName);
        acceptButton.setMnemonic(KeyEvent.VK_S);
        cancelButton = new JButton(cancelButtonName);
        cancelButton.setMnemonic(KeyEvent.VK_Q);

        acceptButton.setForeground(Color.BLACK);
        acceptButton.setBackground(new Color(51, 153, 255));
        BoxLayout box1 = new BoxLayout(buttons, BoxLayout.Y_AXIS);
        buttons.setLayout(box1);

        BoxLayout box2 = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
        buttonPanel.setLayout(box2);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(acceptButton);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttons.add(buttonPanel);
        buttons.add(new JLabel(" "));

        //this.add(buttons, BorderLayout.SOUTH);

        middlePanel.setLayout(new GridBagLayout());
        //this.add(middlePanel, BorderLayout.CENTER);
    }
}
