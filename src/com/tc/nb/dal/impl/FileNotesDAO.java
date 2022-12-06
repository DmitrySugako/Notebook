package com.tc.nb.dal.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private List<Note> notes = new ArrayList<Note>();

	public FileNotesDAO() throws Exception {
		FileReader rFile = new FileReader("C:\\Workspac\\Notebook\\src\\resources\\note.txt");
		try (Scanner scan = new Scanner(rFile)) {
			try {
				while (scan.hasNextLine()) {
					
					System.out.println(scan.nextLine());
				
				}
				rFile.close();
			} catch (IOException e) {

			}
		}

		// read from file and init list
	}

	@Override
	public List<Note> load() {
		return notes;
	}

	@Override
	public void save(Note note) throws Exception {
		notes.add(note);
		try {
			FileWriter wFile = new FileWriter("C:\\Workspac\\Notebook\\src\\resources\\note.txt");
			wFile.write(notes.toString());
			wFile.close();
		} catch (IOException e) {
			throw new IOException(e);
		}

	}
	// save all list in file

}