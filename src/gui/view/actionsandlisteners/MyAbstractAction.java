package gui.view.actionsandlisteners;

import controller.StudentController;

import gui.view.*;
import gui.view.center.DepartmentsTable;
import gui.view.center.ProfessorsTable;
import gui.view.center.StudentsTable;
import gui.view.center.SubjectTable;
import gui.view.dialog.add.AddProfessor;
import gui.view.dialog.add.AddStudent;
import gui.view.dialog.add.AddSubject;
import gui.view.dialog.edit.EditSubject;
import gui.view.dialog.edit.profesor.ChangeProfessorDialog;
import gui.view.dialog.edit.student.ChangeStudentDialog;
import model.*;
import serial.Serialization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyAbstractAction extends AbstractAction implements ScaleImage {


	private static final long serialVersionUID = 2525487053356975101L;
	private String name;


	public ImageIcon scaleImg(ImageIcon ic) {

		Image scaleImage = ic.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		return new ImageIcon(scaleImage);
	}

	public MyAbstractAction(String s) {
		name = s;
		switch (s) {
			case "New":
				putValue(Action.NAME, "New");
				putValue(MNEMONIC_KEY, KeyEvent.VK_N);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/21.png")));
				break;
			case "Save":
				putValue(Action.NAME, "Save");
				putValue(MNEMONIC_KEY, KeyEvent.VK_S);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/save.png")));
				break;
			case "Studenti":
				putValue(Action.NAME, "Studenti");
				putValue(MNEMONIC_KEY, KeyEvent.VK_1);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/student.png")));
				break;
			case "Close":
				putValue(Action.NAME, "Close");
				putValue(MNEMONIC_KEY, KeyEvent.VK_C);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/close.jpg")));
				break;
			case "Edit":
				putValue(Action.NAME, "Edit");
				putValue(MNEMONIC_KEY, KeyEvent.VK_E);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/edit1.png")));
				break;
			case "Delete":
				putValue(Action.NAME, "Delete");
				putValue(MNEMONIC_KEY, KeyEvent.VK_D);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/delete.jpg")));
				break;

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (name.equals("New")) {
			AddStudent addStudent = new AddStudent();

			switch (CentralBox.getInstance().getSelectedIndex()) {
				case 0:
					addStudent.setVisible(true);
					break;
			}
		} else if (name.equals("Studenti")) {
			CentralBox.getInstance().setSelectedIndex(0);
		}
	
		else if (name.equals("Delete")) {
			switch (CentralBox.getInstance().getSelectedIndex()) {
				case 0:
					int rowSelected = StudentsTable.getInstance().getSelectedRow();
					if (rowSelected < 0) {
						JOptionPane.showMessageDialog(MainWindow.getInstance(), "Niste odabrali studenta", "Upozorenje", 0, null);
						return;
					}
					int choice = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Upozorenje", "Da li ste sigurni?", 0);
					if (choice == JOptionPane.YES_OPTION) {
						StudentController.getInstance().deleteStudent(rowSelected);
					}
					break;
			}
		}

		else if (name.equals("Edit")) {
			switch (CentralBox.getInstance().getSelectedIndex()) {
				case 0:
					if (StudentsTable.getInstance().getSelectedIndexinTable() == -1) {
						JOptionPane.showMessageDialog(MainWindow.getInstance(), "Niste izabrali studenta za izmenu", "Upozorenje", 0, null);
					} else {
						Student student = StudentController.getInstance().getStudentByIndex(StudentsTable.getInstance().getSelectedIndex());
						ChangeStudentDialog changeStudentDialog = new ChangeStudentDialog(student);
						changeStudentDialog.setVisible(true);
					}
					break;
			}
		}

	}
}


