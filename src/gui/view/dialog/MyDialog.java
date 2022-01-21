package gui.view.dialog;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class MyDialog extends JDialog {

    @Serial
    private static final long serialVersionUID = 333220301151622460L;
    public final Frame parent;


    public MyDialog(Frame parent, String windowName) {
        super(parent, windowName, true);
        this.parent=parent;
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setSize(550, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


}
