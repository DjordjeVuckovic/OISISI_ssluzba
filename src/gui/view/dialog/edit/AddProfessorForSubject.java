package gui.view.dialog.edit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import controller.ProfessorController;
import gui.view.dialog.MyButton;
import model.BazaProfesora;
import model.Professor;

public class AddProfessorForSubject extends JDialog {

	private static final long serialVersionUID = 8561976962718904066L;

	private TabelaOdabirProf tabelaOdabirProf;

	private Professor Professor = null;

	public AddProfessorForSubject(Frame parent) {
		super(parent, "Izaberite Profesora", true);

		setSize(350,300);
		setResizable(false);
		setLocationRelativeTo(null); 	
		setLayout(new BorderLayout());

		JPanel pang = new JPanel();
		JPanel panMyButtons = new JPanel(new FlowLayout(10,10,10));
		JPanel panl= new JPanel();
		JPanel pand = new JPanel();

		pang.setPreferredSize(new Dimension(30,30));
		panMyButtons.setPreferredSize(new Dimension(50,50));
		panl.setPreferredSize(new Dimension(10,10));
		pand.setPreferredSize(new Dimension(10,10));

		JPanel centralniPanel = new JPanel(new BorderLayout());
		centralniPanel.setBackground(Color.white);

		tabelaOdabirProf = new TabelaOdabirProf();
		JScrollPane panelProfessoriScrollPane = new JScrollPane(tabelaOdabirProf);
		centralniPanel.add(panelProfessoriScrollPane,BorderLayout.CENTER);
		azurirajPrikazTabeleProfessora("POCETNA", 0);



		MyButton btnConfirm = new MyButton("Potvrdi");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int iProf = getSelectedRow();

				Professor = ProfessorController.getInstance().getProfesor(iProf);
				dispose();
			}
		});

		MyButton btnDecline = new MyButton("Odustani");
		btnDecline.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		panMyButtons.add(Box.createHorizontalStrut(52));
		panMyButtons.add(btnConfirm);
		panMyButtons.add(Box.createHorizontalStrut(10));
		panMyButtons.add(btnDecline);



		add(pang, BorderLayout.NORTH);
		add(panMyButtons, BorderLayout.SOUTH);
		add(panl, BorderLayout.WEST);
		add(pand, BorderLayout.EAST);

		add(centralniPanel, BorderLayout.CENTER);

		setVisible(true);
	}



	
	private class TabelaOdabirProf extends JTable{
		private static final long serialVersionUID = -3805554009583860187L;
		//dodavanje svih klasa
		public TabelaOdabirProf() {
			setRowSelectionAllowed(true);
			setColumnSelectionAllowed(true);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			setModel(new AbstractTableProfessoriOdabir());
		}
		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
			// System.out.println(row + " " + column);
			Component c = super.prepareRenderer(renderer, row, column);

			if (isRowSelected(row)) {
				c.setBackground(Color.LIGHT_GRAY);
			} else {
				c.setBackground(Color.WHITE);
			}
			return c;
		}

	}

	public class AbstractTableProfessoriOdabir extends AbstractTableModel{

		private static final long serialVersionUID = 2335644876350909315L;

		@Override
		public int getColumnCount() {
			return 1;
		}

		@Override
		public int getRowCount() {
			return BazaProfesora.getInstance().getProfessors().size();
		}

		@Override
		public String getValueAt(int arg0, int arg1) {
			String prof = BazaProfesora.getInstance().getValueAt(arg0,0)+" "+
					      BazaProfesora.getInstance().getValueAt(arg0,1);
			return prof; 
		}
		@Override
		public String getColumnName(int column) {
			return "Ime i Prezime";
		}

	}

	public void azurirajPrikazTabeleProfessora(String akcija, int vrednost) {
		AbstractTableProfessoriOdabir model = (AbstractTableProfessoriOdabir) tabelaOdabirProf.getModel();
		model.fireTableDataChanged();
		validate();
	}

	public int getSelectedRow() {
		return tabelaOdabirProf.getSelectedRow();
	}

	public Professor getSelectedProf() {
		return Professor;
	}



}

