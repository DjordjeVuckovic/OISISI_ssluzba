package gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.DepartmentController;
import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
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
import gui.view.dialog.edit.profesor.ChangeProfessorDialog;
import gui.view.dialog.edit.profesor.EditProfessor;
import gui.view.dialog.edit.student.ChangeStudentDialog;
import gui.view.dialog.edit.student.EditStudent;
import gui.view.search.SearchStudent;
import model.Department;
import model.Professor;
import model.Student;
import model.Subject;

public class Toolbar extends JToolBar implements ScaleImage {

	private static final long serialVersionUID = 1209699209668701828L;
	private SearchStudent searchStudent = new SearchStudent();
	private JTextField searchTextField = new JTextField();

	public ImageIcon scaleImg(ImageIcon ic) {

		Image scaleImage = ic.getImage().getScaledInstance(32, 32,Image.SCALE_DEFAULT);
		return new ImageIcon(scaleImage);
	}

	public Toolbar() {


		super(SwingConstants.HORIZONTAL);


		JButton btnNew = new JButton();
		btnNew.setToolTipText("Kreiraj entitet");
		btnNew.setIcon(scaleImg(new ImageIcon("img/add1.png")));
		btnNew.setBackground(Color.WHITE);
		btnNew.setBorderPainted(false);
		btnNew.setFocusPainted(false);
		
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (CentralBox.getInstance().getSelectedIndex()) {
				case 0:
					AddStudent addStudent= new AddStudent();
					addStudent.setVisible(true);
					break;
				case 1:
					AddSubject addSubject = new AddSubject();
					addSubject.setVisible(true);
					break;
				case 2:
					AddProfessor addProfessor = new AddProfessor();
					addProfessor.setVisible(true);
					break;
				case 3:
					AddDepartment addDepartment=  new AddDepartment();
					addDepartment.setVisible(true);
				}
			}
		});
		
		addSeparator();
		add(btnNew);
		addSeparator();


		
		
		JButton btnNew1 = new JButton();
		btnNew1.setToolTipText("Izmeni entitet");
		btnNew1.setIcon(scaleImg(new ImageIcon("img/ch.png")));
		btnNew1.setBackground(Color.WHITE);
		btnNew1.setBorderPainted(false);
		btnNew1.setFocusPainted(false);
		
		btnNew1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
					break;
				case 3:
					if (DepartmentsTable.getInstance().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(MainWindow.getInstance(), "Niste izabrali katedru za izmenu", "Upozorenje", 0, null);
						return;
					} else {
						Department dep = DepartmentController.getInstance().getDepById(DepartmentsTable.getInstance().getSelectedIndex());
						EditDepartment editDepartment = new EditDepartment(dep);
						editDepartment.setVisible(true);
					}
					break;
			}
		}
		});
		
		add(btnNew1);
		addSeparator();

		JButton btnNew2 = new JButton();
		btnNew2.setToolTipText("Obrisi entitet");
		btnNew2.setIcon(scaleImg(new ImageIcon("img/trash1.png")));
		btnNew2.setBackground(Color.WHITE);
		btnNew2.setBorderPainted(false);
		btnNew2.setFocusPainted(false);
		add(btnNew2);
		addSeparator();

		btnNew2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
				case 3:
					int rowSelectedk = DepartmentsTable.getInstance().getSelectedRow();
					if (rowSelectedk < 0) {
						JOptionPane.showMessageDialog(MainWindow.getInstance(), "Niste odabrali katedru", "Upozorenje", 0, null);
						return;
					}
					int choicek = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Upozorenje", "Da li ste sigurni?", 0);
					if (choicek == JOptionPane.YES_OPTION) {
						DepartmentController.getInstance().deleteDepartment(rowSelectedk);
					}
					break;
			}
		}
		});
		
		
		
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		add(Box.createHorizontalStrut(screenSize.width/2));



		searchTextField.setMaximumSize(new Dimension(screenSize.width,27));
		LineBorder lineBorder1 = new LineBorder(Color.BLACK);
		searchTextField.setBorder(lineBorder1);
        JButton searchB = new JButton(scaleImg(new ImageIcon("img/sr.png")));
        searchB.setToolTipText("Pretraga");
        searchB.setBackground(Color.WHITE);
		searchB.setBorderPainted(false);
		searchB.setFocusPainted(false);
		add(searchTextField);
		add(searchB);
		searchB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CentralBox.getInstance().getSelectedIndex()==0){
					searchStudent.searchStudents(searchTextField.getText());
				}
			}
		});
	}
	
}
