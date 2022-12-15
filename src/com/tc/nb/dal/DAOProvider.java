package com.tc.nb.dal;

import com.tc.nb.dal.impl.FileNotesDAO;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private NotesDAO notesDAO = new FileNotesDAO();
	
	
	private DAOProvider() {}
	
	public NotesDAO getNotesDAO()  {
		return notesDAO;
	} 
	
	public static DAOProvider getInstance() {
		return instance;
	}

}
