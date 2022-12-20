package com.tc.nb.main;




import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.dal.impl.FileNotesDAO;
import com.tc.nb.entity.Note;

public class Main {

	public static void main(String[] args) throws DAOException {
		FileNotesDAO notes= new FileNotesDAO();
		Note note1=new Note("Katya","Yes");
		notes.save(note1);
		System.out.println (notes.load());
		Note note2=new Note("Hardy","Gaff");
		notes.save(note2);
		System.out.println (notes.load());

	}

}
