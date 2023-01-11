package com.tc.nb.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesFindService;
import com.tc.nb.service.exception.ServiceException;

public class NotesFindServiceImpl implements NotesFindService {

	private final static DAOProvider provider = DAOProvider.getInstance();
	private final static NotesDAO notesDAO = provider.getNotesDAO();
	private final static DataCheckingImpl checking = new DataCheckingImpl();

	@Override
	public List<Note> findByContent(String content) throws ServiceException {

		List<Note> searchResults = new ArrayList<Note>();
		content = content.trim();

		try {
			List<Note> sourceList = notesDAO.load();
			if (checking.contentIsNotNull(content)) {
				for (Note note : sourceList) {
					if (note.getNoteContent().contains(content)) {
						searchResults.add(note);
					}
				}
			}
			if (searchResults.isEmpty()) {
				return Collections.emptyList();
			} else {
				return searchResults;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Note> findByDate(Date startDate, Date endDate) throws ServiceException {

		List<Note> searchResults = new ArrayList<Note>();

		try {
			List<Note> sourceList = notesDAO.load();
			if (checking.dateIsNotNull(startDate) && checking.dateIsNotNull(endDate)) {
				for (Note note : sourceList) {
					if (startDate.equals(endDate) && startDate.equals(note.getDateOfCreation())) {
						searchResults.add(note);
					} else if (note.getDateOfCreation().after(startDate) && note.getDateOfCreation().before(endDate)) {
						searchResults.add(note);
					}
				}
			}
			if (searchResults.isEmpty()) {
				return Collections.emptyList();
			} else {
				return searchResults;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
