package com.tc.nb.dal.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private List<Note> notes = new ArrayList<Note>();

	public FileNotesDAO() {
		for (int i = 0; i < readingAFile().size() - 1; i++) {
			Note note = new Note();
			note.setHeader(readingAFile().get(i));
			i++;
			try {
				note.setDateOfCreation(convertTextToDate(readingAFile().get(i)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			i++;
			note.setNoteContent(readingAFile().get(i));
			notes.add(note);
		}
		// read from file and init list
	}

	private List<String> readingAFile() {
		List<String> tempNotes = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(
				new FileReader("resources\\note.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				tempNotes.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempNotes;
	}

	private Date convertTextToDate(String lineToConvert) throws ParseException {
		DateFormat format = new SimpleDateFormat("E MMM d k:mm:ss z yyyy", Locale.ENGLISH);
		return format.parse(lineToConvert);
	}

	@Override
	public List<Note> load() {
		return notes;

	}

	@Override
	public void save(Note note) throws IOException {
		notes.add(note);
		try (FileWriter wFile = new FileWriter("resources\\note.txt", true)) {
			wFile.write("\n" + note.getHeader());
			wFile.write("\n" + note.getDateOfCreation().toString());
			wFile.write("\n" + note.getNoteContent());
		} catch (IOException e) {
			throw new IOException(e);
		}
		// save all list in file
	}

}