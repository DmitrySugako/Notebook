package com.tc.nb.service.impl;

import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesCreateService;
import com.tc.nb.service.exception.ServiceException;

public class NotesCreateServiceImpl implements NotesCreateService {

	private final static DAOProvider provider = DAOProvider.getInstance();
	private final static NotesDAO notesDAO = provider.getNotesDAO();
	private final static DataCheckingImpl checking = new DataCheckingImpl();

	@Override
	public void add(Note note) throws ServiceException {
		if (checking.noteIsNotNull(note)) {
			try {
				notesDAO.save(note);
			} catch (DAOException e) {
				throw new ServiceException("Failed to add note", e);
			}
		} else
			throw new ServiceException("Unable to add null data");
	}
}