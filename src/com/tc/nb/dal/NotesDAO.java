package com.tc.nb.dal;

import java.util.List;

import com.tc.nb.entity.Note;

public interface NotesDAO {
    List<Note> load();
    void save(Note note);
}

