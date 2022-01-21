package gui.view.center;

import javax.swing.AbstractListModel;

import model.BazaProfesora;

public class AbstractListProfessors extends AbstractListModel<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7254484288779343278L;

	public AbstractListProfessors() {
    }
    
	@Override
	public Object getElementAt(int i) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getValueAtProf1(i);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getProfessors().size();
	}

}
