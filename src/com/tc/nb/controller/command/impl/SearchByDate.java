package com.tc.nb.controller.command.impl;

import java.util.Date;

import com.tc.nb.controller.command.Command;
import com.tc.nb.service.NotesFindService;
import com.tc.nb.service.ServiceProvider;
import com.tc.nb.service.exception.ServiceException;
import com.tc.nb.view.impl.ResultDisplay;

public class SearchByDate implements Command {

	@Override
	public String execute(String request) {
		Date startDate = null;
		Date finalDate = null;
		String responce = null;

		ResultDisplay onTheScreen = new ResultDisplay();

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NotesFindService findService = serviceProvider.getFindService();

		try {
			onTheScreen.notepadOutputToConsole(findService.findByDate(startDate, finalDate));
			responce = "Search completed";
		} catch (ServiceException e) {
			responce = "Search query error";
		}

		return responce;
	}

}
