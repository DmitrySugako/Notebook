package com.tc.nb.service;

import java.util.Date;

import com.tc.nb.entity.Note;
import com.tc.nb.service.exception.ServiceException;

public interface DataChecking {

	boolean dateIsNotNull (Date date) throws ServiceException;
	boolean contentIsNotNull (String content) throws ServiceException;
	boolean noteIsNotNull (Note note) throws ServiceException;
	
}
