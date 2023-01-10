package com.tc.nb.view.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.tc.nb.entity.Note;
import com.tc.nb.view.Inputs;

public class ConsoleInput implements Inputs {

	private final Scanner scanner = new Scanner(System.in);
	private final DateFormat format = new SimpleDateFormat("E MMM d k:mm:ss z yyyy", Locale.ENGLISH);

	@Override
	public String searchedContent() {
		System.out.println("Enter the requested text:");
		return scanner.nextLine();
	}

	@Override
	public Date desiredDates() {
		System.out.println("Enter date:");
		try {
			return format.parse(scanner.nextLine());
		} catch (ParseException e) {
			System.out.println("Invalid date format");
			return null;
		}
	}

	@Override
	public Note noteToSave() {
		System.out.println("Enter a title:");
		String header = scanner.nextLine();
		System.out.println("Enter the contents:");
		String content = scanner.nextLine();
		Note note = new Note(header, content);
		return note;
	}
}
