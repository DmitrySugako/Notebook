package com.tc.nb.dal;

import java.util.List;

import com.tc.nb.entity.Note;

public interface NotesDAO {
	List<Note> load() throws Exception;

	void save(Note note) throws Exception;
}
