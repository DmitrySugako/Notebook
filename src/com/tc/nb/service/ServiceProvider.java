package com.tc.nb.service;

import com.tc.nb.service.impl.NotesCreateServiceImpl;
import com.tc.nb.service.impl.NotesFindServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private final NotesCreateService createService = new NotesCreateServiceImpl();
	private final NotesFindService findService = new NotesFindServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public NotesCreateService getCreateService() {
		return createService;
	}

	public NotesFindService getFindService() {
		return findService;
	}
}
