package com.tc.nb.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.impl.FileNotesDAO;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesFindService;

public class NotesFindServiceImpl implements NotesFindService {

	@Override
	public List<Note> findByContent(String content) {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		try {
			List<Note> sourceList = notesDAO.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Note> findByDate(Date date) {

		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		try {
			List<Note> sourceList = notesDAO.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
