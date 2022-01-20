package gui.view.department;

import gui.view.MainWindow;
import gui.view.dialog.MyDialog;
import model.Department;
import model.Professor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EditDepartment extends MyDialog {
    private final JButton addBoss;
    private JTextField txtFieldName;
    private JTextField txtFieldId;
    private JTextField txtFieldBoss;
    private Department department;
    private EditDepartment editDepartment;
    private Professor boss;

    public EditDepartment(Department department) {
        super(MainWindow.getInstance(), "Postavljanje sefa(izmena) katedre");
        this.department=department;
        editDepartment = this;
        Dimension cellDim = new Dimension(200, 30);
        setLayout(new BorderLayout());
        JLabel lbName = new JLabel("Ime*");
        lbName.setPreferredSize(cellDim);
        txtFieldName = new JTextField();
        txtFieldName.setPreferredSize(cellDim);
        txtFieldName.setName("txtName");
        txtFieldName.setEditable(false);
        JPanel panelN = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelN.add(lbName);
        panelN.add(txtFieldName);

        JLabel lbId = new JLabel("Šifra*");
        lbId.setPreferredSize(cellDim);
        txtFieldId = new JTextField();
        txtFieldId.setPreferredSize(cellDim);
        txtFieldId.setName("txtId");
        txtFieldId.setEditable(false);
        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelS.add(lbId);
        panelS.add(txtFieldId);

        JLabel lbBoss = new JLabel("Postavljanje šefa*");
        lbBoss.setPreferredSize(new Dimension(170,30));
        txtFieldBoss = new JTextField();
        txtFieldBoss.setPreferredSize(new Dimension(150,30));
        txtFieldBoss.setEditable(false);
        JPanel panelF = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelF.add(lbBoss);
        panelF.add(txtFieldBoss);

        addBoss = new JButton();
        addBoss.setPreferredSize(new Dimension(60,30));
        addBoss.setIcon(new ImageIcon("img"+ File.separator+"img.png"));
        initFields();
        addBoss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBossDialog addBosDialog = new AddBossDialog(editDepartment);
                boss = addBosDialog.getSelectedBoss();
                if(boss != null){
                    txtFieldBoss.setText(boss.getIdNumber()+"-"+boss.getName()+"-"+boss.getSurname());
                    department.setDirector(boss);
                    addBoss.setEnabled(false);
                }
            }
        });
        panelF.add(addBoss);
        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panelS);
        CentralPanel.add(panelN);
        CentralPanel.add(panelF);
        JButton closeBt = new JButton("Zatvori Dialog");
        closeBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel panel1 = new JPanel();
        panel1.add(closeBt);
        CentralPanel.add(panel1);
        this.add(CentralPanel);

    }
    private void initFields(){
        txtFieldName.setText(department.getName());
        txtFieldId.setText(department.getId());
        if(department.getDirector() != null){
            txtFieldBoss.setText(department.getDirector().getIdNumber()+"-"+department.getDirector().getName()+"-"+department.getDirector().getSurname());
        }
        else{
            txtFieldBoss.setText("");
            addBoss.setEnabled(true);
        }
    }


}
