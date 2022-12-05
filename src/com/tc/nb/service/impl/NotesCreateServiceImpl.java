package com.tc.nb.service.impl;


import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesCreateService;

public class NotesCreateServiceImpl implements NotesCreateService{
	
	@Override
	public void add(Note n) {
		
        DAOProvider provider = DAOProvider.getInstance();
		
        NotesDAO notesDAO = provider.getNotesDAO();
        
        notesDAO.save(n);

	}

}