package com.tc.nb.dal;

import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.dal.impl.FileNotesDAO;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();

	private NotesDAO notesDAO;

	private DAOProvider() {
		try {
			notesDAO = new FileNotesDAO();
		} catch (DAOException e) {
			throw new RuntimeException("Provider not created");
		}
	}

	public NotesDAO getNotesDAO() {
		return notesDAO;
	}

	public static DAOProvider getInstance() {
		return instance;
	}

}
