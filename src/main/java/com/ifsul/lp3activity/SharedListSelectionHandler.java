package com.ifsul.lp3activity;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SharedListSelectionHandler implements ListSelectionListener {
	private UserRepository ur;
	private CarRepository cr;
	private JList<User> list;
	
	public SharedListSelectionHandler(UserRepository ur, CarRepository cr, JList<User> list) {
		this.ur = ur;
		this.cr= cr;
		this.list = list;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		
		// TODO Auto-generated method stub
	    if (e.getValueIsAdjusting() == false) {
	    	
	    	int index = lsm.getMaxSelectionIndex();
	    	
	    	if(index>=0) {
	    		
	    		User selected = this.list.getSelectedValue();
	    		CarFrame cf = new CarFrame(ur, cr, selected);
	    	}

	    }
	}
	

}
