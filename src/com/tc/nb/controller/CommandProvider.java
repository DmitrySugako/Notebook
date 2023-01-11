package com.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;

import com.tc.nb.controller.command.Command;
import com.tc.nb.controller.command.impl.AddingRecords;
import com.tc.nb.controller.command.impl.ContentSearch;
import com.tc.nb.controller.command.impl.SearchByDate;
import com.tc.nb.controller.command.impl.WrongRequest;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.CONTENT_SEARCH, new ContentSearch());
		repository.put(CommandName.SEARCH_BY_DATE, new SearchByDate());
		repository.put(CommandName.ADDING_RECORDS, new AddingRecords());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
