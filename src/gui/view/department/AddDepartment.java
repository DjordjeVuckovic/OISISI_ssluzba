package gui.view.department;

import controller.DepartmentController;
import gui.view.MainWindow;
import model.Department;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class AddDepartment extends JDialog {
    @Serial
    private static final long serialVersionUID = -3203087255380944579L;
    private JTextField txtFieldName;
    private JTextField txtFieldId;

    public AddDepartment() {
        super(MainWindow.getInstance(), "Dodavanje katedre");
        this.setSize(430,500);
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setLocationRelativeTo(MainWindow.getInstance());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initDepartment();
    }
    private void initDepartment(){
        Dimension cellDim = new Dimension(200, 20);
        setLayout(new BorderLayout());
        JLabel lbName = new JLabel("Ime *");
        lbName.setToolTipText("Unesite ime Katedre");
        lbName.setPreferredSize(cellDim);
        txtFieldName = new JTextField();
        txtFieldName.setToolTipText("Ime je niz karaktera");
        txtFieldName.setPreferredSize(cellDim);
        txtFieldName.setName("txtName");
        JPanel panelN = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelN.add(lbName);
        panelN.add(txtFieldName);

        JLabel lbId = new JLabel("Sifra*");
        lbId.setToolTipText("Unesite sifru katedre");
        lbId.setPreferredSize(cellDim);
        txtFieldId = new JTextField();
        txtFieldId.setToolTipText("Unesite sifru katedre");
        txtFieldId.setPreferredSize(cellDim);
        txtFieldId.setName("txtIdD");
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(lbId);
        panel1.add(txtFieldId);
        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panel1);
        CentralPanel.add(panelN);
        this.add(CentralPanel);
        JButton add = new JButton("Dodaj");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Department department = new Department();
                department.setName(txtFieldName.getText());
                department.setId(txtFieldId.getText());
                DepartmentController.getInstance().addDepartment(department);
                dispose();
            }

        });
        JButton can = new JButton("Odustani");
        can.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel but = new JPanel(new FlowLayout(FlowLayout.CENTER));
        but.add(add);
        but.add(can);
        this.add(but,BorderLayout.SOUTH);
    }

}
