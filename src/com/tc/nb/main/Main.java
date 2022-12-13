package com.tc.nb.main;


import java.io.IOException;
import java.text.ParseException;

import com.tc.nb.dal.impl.FileNotesDAO;
import com.tc.nb.entity.Note;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		FileNotesDAO notes= new FileNotesDAO();
		Note note1=new Note("Katya","Yes");
		notes.save(note1);
		System.out.println (notes.load());
		Note note2=new Note("Hardy","Gaff");
		notes.save(note2);
		System.out.println (notes.load());

	}

}
