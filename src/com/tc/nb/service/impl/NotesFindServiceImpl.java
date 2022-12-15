package com.tc.nb.service.impl;


import java.util.Date;
import java.util.List;

import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesFindService;
import com.tc.nb.service.exception.ServiceException;

public class NotesFindServiceImpl implements NotesFindService {

	@Override
	public List<Note> findByContent(String content) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		try {
			List<Note> sourceList = notesDAO.load();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return null;
	}

	@Override
	public List<Note> findByDate(Date date) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		try {
			List<Note> sourceList = notesDAO.load();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return null;
	}

}
