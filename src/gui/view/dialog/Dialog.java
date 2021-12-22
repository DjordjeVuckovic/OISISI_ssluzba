package gui.view.dialog;

import gui.view.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Dialog extends JDialog {
    private final Frame parent;



    public Dialog(Frame parent,String windowName) {
        super(parent, windowName, true);
        this.parent=parent;
        this.setBackground(Color.WHITE);
        this.setResizable(false);

        this.setSize(500, 500);
        setResizable(false);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


}
