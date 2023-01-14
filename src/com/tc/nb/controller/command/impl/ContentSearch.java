package com.tc.nb.controller.command.impl;

import com.tc.nb.controller.command.Command;
import com.tc.nb.service.NotesFindService;
import com.tc.nb.service.ServiceProvider;
import com.tc.nb.service.exception.ServiceException;
import com.tc.nb.view.impl.ResultDisplay;

public class ContentSearch implements Command {

	@Override
	public String execute(String request) {
		String searchedContent = null;
		String responce = null;

		ResultDisplay onTheScreen = new ResultDisplay();

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NotesFindService findService = serviceProvider.getFindService();

		try {
			onTheScreen.notepadOutputToConsole(findService.findByContent(searchedContent));
			responce = "Search completed";
		} catch (ServiceException e) {
			responce = "Search query error";
		}

		return responce;
	}

}
