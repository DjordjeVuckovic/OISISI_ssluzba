package gui.view;

import model.*;
import serial.Serialization;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyWindowListener implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {


    }

    @Override
    public void windowClosing(WindowEvent e) {
        JFrame frame = (JFrame) e.getComponent();

        String message = "Do you want to save changes?";
        Object[] options = {"Yes","No"};
        int option = JOptionPane.showOptionDialog(null, message, "Closing App", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (option == JOptionPane.YES_OPTION) {
            BazaPodataka base = new BazaPodataka(BazaStudenata.getInstance().getStudents(), BazaProfesora.getInstance().getProfessors(), BazaPredmeta.getInstance().getSubjects(), BazaKatedri.getInstance().getDepartments());
            try {
                Serialization.writeToFile(base);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
            else if(option == JOptionPane.NO_OPTION){
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
            else {
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
