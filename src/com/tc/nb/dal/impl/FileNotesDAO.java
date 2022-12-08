package com.tc.nb.dal.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private List<Note> notes = new ArrayList<Note>();

	public FileNotesDAO() {
		// read from file and init list
	}

	@Override
	public List<Note> load() {
		List<String> tempNotes = new ArrayList<String>();
		try {
			try (BufferedReader br = new BufferedReader(
					new FileReader("D:\\Workspaces\\Notebook\\src\\resources\\note.txt"))) {
				String line;
				while ((line = br.readLine()) != null) {
					tempNotes.add(line);
				}
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		
		for (int i = 0; i < tempNotes.size() - 1; i++) {
			Note note = new Note();
			note.setHeader(tempNotes.get(i));
			i++;
			try {
				note.setDateOfCreation(format.parse(tempNotes.get(i)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			i++;
			note.setNoteContent(tempNotes.get(i));
			i++;
			notes.add(note);

		}
		return notes;

	}

	@Override
	public void save(Note note) throws IOException {
		notes.add(note);
		try {
			FileWriter wFile = new FileWriter("\src\resources\note.txt", true);
			wFile.write(note.getHeader() + "\n\r");
			wFile.write(note.getDateOfCreation().toString() + "\n\r");
			wFile.write(note.getNoteContent() + "\n\r");
			wFile.close();
		} catch (IOException e) {
			throw new IOException(e);
		}
		// save all list in file
	}

}
