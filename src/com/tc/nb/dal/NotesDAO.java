package com.tc.nb.dal;

import java.io.IOException;
import java.util.List;

import com.tc.nb.entity.Note;

public interface NotesDAO {
    List<Note> load() throws IOException;
    void save(Note note) throws IOException;
}

