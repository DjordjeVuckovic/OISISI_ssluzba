package gui.view;

import gui.view.dialog.MyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HelpDialog extends MyDialog {
    public HelpDialog() {
        super(MainWindow.getInstance(), "Help Dialog");
        setSize(650,650);
        setResizable(false);
        Dimension dim1 = new Dimension(10,10);

        JPanel leviPanel = new JPanel();
        leviPanel.setPreferredSize(dim1);
        JPanel desniPanel = new JPanel();
        desniPanel.setPreferredSize(dim1);
        JPanel gornjiPanel = new JPanel();
        gornjiPanel.setPreferredSize(dim1);
        JPanel donjiPanel = new JPanel();
        donjiPanel.setPreferredSize(dim1);

        JPanel velikiCentralniPanel = new JPanel();
        velikiCentralniPanel.setLayout(new BorderLayout());

        velikiCentralniPanel.add(leviPanel,BorderLayout.WEST);
        velikiCentralniPanel.add(desniPanel,BorderLayout.EAST);
        velikiCentralniPanel.add(gornjiPanel,BorderLayout.NORTH);
        velikiCentralniPanel.add(donjiPanel,BorderLayout.SOUTH);

        JPanel manjiCentralniPanel = new JPanel();
        manjiCentralniPanel.setLayout(new BorderLayout());
        manjiCentralniPanel.setBackground(Color.white);
        velikiCentralniPanel.add(manjiCentralniPanel,BorderLayout.CENTER);

        File f = new File("src/HelpDialog.txt");
        BufferedReader in = null;
        String strHelp = "";
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
            String line = "";
            try {
                while( (line=in.readLine()) != null ) {
                    strHelp += line+"\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        JTextArea taHelp = new JTextArea(strHelp);
        taHelp.setEditable(false);
        taHelp.setLineWrap(true);
        JScrollPane scrollHelp = new JScrollPane(taHelp,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        manjiCentralniPanel.add(scrollHelp, BorderLayout.CENTER);

        JPanel panelZatvori = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelZatvori.setBackground(new Color(255,255,255));
        JButton bZatvori = new JButton("Zatvori");
        bZatvori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        panelZatvori.add(bZatvori);
        add(panelZatvori, BorderLayout.SOUTH);
        add(velikiCentralniPanel,BorderLayout.CENTER);
    }
}
