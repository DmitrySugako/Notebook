package com.tc.nb.dal.impl;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO  {

	private List<Note> notes = new ArrayList<Note>();

	public FileNotesDAO() {
		// read from file and init list
	}

	@Override
	public List<Note> load() {
		return notes;
	}

	@Override
	public void save(Note note) {
		notes.add(note);
		FileWriter wFile = new FileWriter("D:\\Workspaces\\Notebook\\src\\resources\\note.txt");
		wFile.write(notes.toString());
		// save all list in file
	}

}