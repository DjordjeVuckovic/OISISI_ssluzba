package gui.view.dialog;

import javax.swing.*;
import java.awt.*;

public class MyDialog extends JDialog {
    private final Frame parent;

    public MyDialog(Frame parent, String windowName) {
        super(parent, windowName, true);
        this.parent=parent;
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setModal(true);
        this.setSize(500, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


}
