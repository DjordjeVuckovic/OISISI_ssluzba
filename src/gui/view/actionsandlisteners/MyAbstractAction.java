package gui.view.actionsandlisteners;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.DepartmentController;
import controller.ProfessorController;

import controller.StudentController;
import controller.SubjectController;
import gui.view.CentralBox;
import gui.view.MainWindow;
import gui.view.ScaleImage;
import gui.view.center.DepartmentsTable;
import gui.view.center.ProfessorsTable;
import gui.view.center.StudentsTable;
import gui.view.center.SubjectTable;
import gui.view.department.AddDepartment;
import gui.view.department.EditDepartment;
import gui.view.dialog.add.AddProfessor;
import gui.view.dialog.add.AddStudent;
import gui.view.dialog.add.AddSubject;
import gui.view.dialog.edit.EditSubject;

import gui.view.dialog.edit.student.ChangeStudentDialog;

import gui.view.dialog.edit.profesor.ChangeProfessorDialog;
import gui.view.dialog.edit.student.ChangeStudentDialog;
import model.Department;
import model.Professor;

import model.Student;
import model.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
			case "Predmeti":
				putValue(Action.NAME, "Predmeti");
				putValue(MNEMONIC_KEY, KeyEvent.VK_2);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/subject.png")));
				break;
			case "Profesori":
				putValue(Action.NAME, "Profesori");
				putValue(MNEMONIC_KEY, KeyEvent.VK_3);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/prof.png")));
				break;
			case "Katedre":
				putValue(Action.NAME, "Katedre");
				putValue(MNEMONIC_KEY, KeyEvent.VK_3);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/dep.jpg")));
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
			case "Help":
				putValue(Action.NAME, "Help");
				putValue(MNEMONIC_KEY, KeyEvent.VK_H);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/help.png")));
				break;
			case "About":
				putValue(Action.NAME, "About");
				putValue(MNEMONIC_KEY, KeyEvent.VK_A);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
				putValue(SMALL_ICON, scaleImg(new ImageIcon("img/about.png")));
				break;

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (name.equals("New")) {
			AddStudent addStudent = new AddStudent();
			AddSubject addSubject = new AddSubject();
			AddProfessor addProfessor = new AddProfessor();

			switch (CentralBox.getInstance().getSelectedIndex()) {
				case 0:
					addStudent.setVisible(true);
					break;
				case 1:
					addSubject.setVisible(true);

					break;
				case 2:
					addProfessor.setVisible(true);
					break;
				case 3:
					AddDepartment addDepartment=  new AddDepartment();
					addDepartment.setVisible(true);
			}
		} else if (name.equals("Studenti")) {
			CentralBox.getInstance().setSelectedIndex(0);
		}

		else if (name.equals("Katedre")) {
			CentralBox.getInstance().setSelectedIndex(3);
		} else if (name.equals("Profesori")) {
			CentralBox.getInstance().setSelectedIndex(2);

		} else if (name.equals("Predmeti")) {
			CentralBox.getInstance().setSelectedIndex(1);
		}
		//else if(name.equals("Save")){
		//
		//}
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
				case 1:
					//delete sub
					break;
				case 2:
					int rowSelectedp = ProfessorsTable.getInstance().getSelectedRow();
					if (rowSelectedp < 0) {
						JOptionPane.showMessageDialog(MainWindow.getInstance(), "Niste odabrali profesora", "Upozorenje", 0, null);
						return;
					}
					int choicep = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Upozorenje", "Da li ste sigurni?", 0);
					if (choicep == JOptionPane.YES_OPTION) {
						ProfessorController.getInstance().deleteProfessor(rowSelectedp);
					}
					break;
			}
		}


		//else if(name.equals("Close")) {
		//exit;
		//}
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
				case 1:
					if (SubjectTable.getInstance().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(MainWindow.getInstance(), "Niste izabrali premet za izmenu", "Upozorenje", 0, null);
					} else {
						Subject subject = SubjectController.getInstance().findSubjectById(SubjectTable.getInstance().getSelectedId());
						EditSubject editSubject = new EditSubject(subject.getIdS());
						editSubject.setVisible(true);

					}
					break;
				case 2:
					if (ProfessorsTable.getInstance().getSelectedIndexinTable() == -1) {
						JOptionPane.showMessageDialog(MainWindow.getInstance(), "Niste izabrali profesora za izmenu", "Upozorenje", 0, null);
					} else {
						Professor profesor = ProfessorController.getInstance().getProfessorById(ProfessorsTable.getInstance().getSelectedIndex());
						ChangeProfessorDialog changeProfessorDialog = new ChangeProfessorDialog(profesor);
						changeProfessorDialog.setVisible(true);

					}
				case 3:
					if (DepartmentsTable.getInstance().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(MainWindow.getInstance(), "Niste izabrali katedru za izmenu", "Upozorenje", 0, null);
					} else {
						Department dep = DepartmentController.getInstance().getDepById(DepartmentsTable.getInstance().getSelectedIndex());
						EditDepartment editDepartment = new EditDepartment(dep);
						editDepartment.setVisible(true);
					}
					break;
			}
		}

	}
}


