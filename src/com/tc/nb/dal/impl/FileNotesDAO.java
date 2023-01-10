package com.tc.nb.dal.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private final List<Note> notes = new ArrayList<Note>();

	private static final String DATA_PATH = "\\resources\\note.txt";
	private static int INDEX = 0;

	public FileNotesDAO() throws DAOException {
		try {
			while (INDEX < readingAFile().size() - 1) {
				Note note = new Note();
				note.setHeader(readingAFile().get(INDEX));
				INDEX++;
				note.setDateOfCreation(convertTextToDate(readingAFile().get(INDEX)));
				INDEX++;
				note.setNoteContent(readingAFile().get(INDEX));
				notes.add(note);
				INDEX++;
			}
		} catch (ParseException e) {
			throw new RuntimeException("Critical error! Database corruption.", e);
		} catch (FileNotFoundException e) {
			throw new DAOException("File not found.", e);
		} catch (IOException e) {
			throw new DAOException("Data access error.", e);
		}
	}

	private List<String> readingAFile() throws FileNotFoundException, IOException {
		List<String> tempNotes = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH))) {
			String line;
			while ((line = br.readLine()) != null) {
				tempNotes.add(line);
			}
			return tempNotes;
		}
	}

	private final DateFormat format = new SimpleDateFormat("E MMM d k:mm:ss z yyyy", Locale.ENGLISH);

	private Date convertTextToDate(String lineToConvert) throws ParseException {
		return format.parse(lineToConvert);
	}

	@Override
	public List<Note> load() throws DAOException {
		return notes;
	}

	@Override
	public void save(Note note) throws DAOException {
		notes.add(note);
		try (FileWriter wFile = new FileWriter(DATA_PATH, true)) {
			wFile.write("\n" + note.getHeader());
			wFile.write("\n" + note.getDateOfCreation().toString());
			wFile.write("\n" + note.getNoteContent());
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}
}