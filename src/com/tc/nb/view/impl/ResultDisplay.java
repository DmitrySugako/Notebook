package com.tc.nb.view.impl;

import java.util.List;

import com.tc.nb.entity.Note;
import com.tc.nb.view.View;

public class ResultDisplay implements View {

	@Override
	public void notepadOutputToConsole(List<Note> note) {
		if (note.isEmpty()) {
			System.out.println("Data not found");
		} else
			for (Note n : note) {
				System.out.println(n.getHeader());
				System.out.println(n.getDateOfCreation());
				System.out.println(n.getNoteContent());
			}
	}
}
