package com.tc.nb.view;

import java.util.List;

import com.tc.nb.entity.Note;

public interface View {

	void notepadOutputToConsole(List<Note> note);
}
