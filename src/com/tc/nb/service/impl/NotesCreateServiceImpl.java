package com.tc.nb.service.impl;

import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesCreateService;
import com.tc.nb.service.exception.ServiceException;

public class NotesCreateServiceImpl implements NotesCreateService {

	@Override
	public void add(Note n) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		try {
			notesDAO.save(n);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

}