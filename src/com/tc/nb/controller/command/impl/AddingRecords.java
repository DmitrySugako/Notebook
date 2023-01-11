package com.tc.nb.controller.command.impl;

import com.tc.nb.controller.command.Command;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesCreateService;

import com.tc.nb.service.ServiceProvider;
import com.tc.nb.service.exception.ServiceException;

public class AddingRecords implements Command {

	@Override
	public String execute(String request) {
		String responce = null;
		Note note = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NotesCreateService createService = serviceProvider.getCreateService();

		try {
			createService.add(note);
			responce = "Record added successfully";
		} catch (ServiceException e) {
			responce = "Entry error";
		}
		return responce;
	}

}
