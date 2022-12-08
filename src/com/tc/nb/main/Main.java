package com.tc.nb.main;


import com.tc.nb.dal.impl.FileNotesDAO;

public class Main {

	public static void main(String[] args) {
		FileNotesDAO note= new FileNotesDAO();
		note.load();

	}

}
