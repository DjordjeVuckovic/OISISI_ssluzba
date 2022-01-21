package gui.view;

import gui.view.dialog.MyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutDialog extends MyDialog {
    private static final long serialVersionUID = -3968963718257174797L;
    private String infoProj;
    private String query1;
    private String query2;

    public AboutDialog() {
        super(MainWindow.getInstance(),"About Dialog");
        setResizable(false);

        JPanel leviPanel = new JPanel();
        leviPanel.setPreferredSize(new Dimension(10,10));
        JPanel desniPanel = new JPanel();
        desniPanel.setPreferredSize(new Dimension(10,10));
        JPanel gornjiPanel = new JPanel();
        gornjiPanel.setPreferredSize(new Dimension(10,10));
        add(leviPanel,BorderLayout.WEST);
        add(desniPanel,BorderLayout.EAST);
        add(gornjiPanel,BorderLayout.NORTH);


        JPanel glAPanel = new JPanel();
        BoxLayout boxACentar = new BoxLayout(glAPanel, BoxLayout.Y_AXIS);
        glAPanel.setLayout(boxACentar);



        infoProj = "Projekat iz predmeta OISISI\n"+
                "Razvijanje Informacionog Sistema za studentsku službu Fakulteta Tehnkickih Nauka."+
                "Aplikacija olakšava evidenciju studenata FTN-a kao i njihov uspeh na ispitima."+
                "Vodi se evidencija o Profesorima,Predmetima i Katedrama koji postoje na FTN-u.";
        infoProj += "\n\n\nAlati koji su korišćeni za realizaciju projekta su Java JDK17 i Swing Biblioteka.";

        JTextArea textAProj = new JTextArea(infoProj,10,34);
        textAProj.setPreferredSize(new Dimension(250,250));
        textAProj.setEditable(false);
        textAProj.setLineWrap(true);
        JScrollPane scrollAboutProj = new JScrollPane(textAProj,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAboutProj.setPreferredSize(new Dimension(250,250));


        query1 = "Đorđe Vučković, rođen 20.11.2000 u Novom Sadu. Student PRNI smera na FTN-u.";

        query2 = "Dusan Vukovic, rođen 20.10.2000 u Novom Sadu.Student PRNI smera na FTN-u.";



        StudentPanel milicaPan = new StudentPanel("img/student.jpg", query1,1);
        StudentPanel rastislavPan = new StudentPanel("img/student.jpg", query2,2);


        glAPanel.add(scrollAboutProj);
        glAPanel.add(Box.createVerticalStrut(40));
        glAPanel.add(milicaPan);
        glAPanel.add(Box.createVerticalStrut(10));
        glAPanel.add(rastislavPan);
        glAPanel.add(Box.createVerticalStrut(10));

        add(glAPanel, BorderLayout.CENTER);

        // donji deo panela sluzi samo za zatvaranje ovog dialoga
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

    }

    // dodatna klasa
    private class StudentPanel extends JPanel{

        private static final long serialVersionUID = 2608967519922237774L;

        public StudentPanel(String fimg, String biografija, int orjentacija) {
            setLayout(new BorderLayout());
            setPreferredSize(new Dimension(100,100));
            setBackground(new Color(255,255,255));

            JButton img = new JButton();
            img.setIcon(new ImageIcon(fimg));
            img.setContentAreaFilled(false);
            img.setMargin(new Insets(10,10,10,10));
            img.setBorderPainted(false);

            JTextArea txt = new JTextArea(biografija);
            txt.setEditable(false);
            txt.setLineWrap(true);

            if(orjentacija == 1) {
                add(img,BorderLayout.WEST);
                add(txt,BorderLayout.CENTER);
            }else {
                add(img,BorderLayout.EAST);
                add(txt,BorderLayout.CENTER);
            }


        }
    }
}
