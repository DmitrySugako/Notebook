package com.tc.nb.service;

import java.util.Date;
import java.util.List;

import com.tc.nb.entity.Note;

public interface NotesFindService {
	
	List<Note> findByContent(String content) throws Exception;
	List<Note> findByDate(Date date) throws Exception;

}