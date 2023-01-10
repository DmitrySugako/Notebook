package com.tc.nb.view;

import java.util.Date;

import com.tc.nb.entity.Note;

public interface Inputs {

	String searchedContent();

	Date desiredDates();

	Note noteToSave();
}
