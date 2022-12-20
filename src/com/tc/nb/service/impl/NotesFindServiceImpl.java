package com.tc.nb.service.impl;

import java.util.ArrayList;
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

		List<Note> searchResults = new ArrayList<Note>();
		content = content.trim();

		try {
			List<Note> sourceList = notesDAO.load();
			for (Note note : sourceList) {
				if (note.getNoteContent().contains(content)) {
					searchResults.add(note);
				}
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		if (searchResults.isEmpty()) {
			return null;
		} else {
			return searchResults;
		}
	}

	@Override
	public List<Note> findByDate(Date startDate, Date endDate) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		List<Note> searchResults = new ArrayList<Note>();

		try {
			List<Note> sourceList = notesDAO.load();
			for (Note note : sourceList) {
				if (startDate.equals(endDate) && startDate.equals(note.getDateOfCreation())) {
					searchResults.add(note);
					
				} else if (note.getDateOfCreation().after(startDate) && note.getDateOfCreation().before(endDate)) {
					searchResults.add(note);
				}
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		if (searchResults.isEmpty()) {
			return null;
		} else {
			return searchResults;
		}
	}

}
