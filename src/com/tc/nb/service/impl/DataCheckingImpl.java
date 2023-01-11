package com.tc.nb.service.impl;

import java.util.Date;

import com.tc.nb.entity.Note;
import com.tc.nb.service.DataChecking;
import com.tc.nb.service.exception.ServiceException;

public class DataCheckingImpl implements DataChecking {

	@Override
	public boolean dateIsNotNull(Date date) throws ServiceException {
		if (date != null) {
			return true;
		}
		throw new ServiceException("Received date is null");
	}

	@Override
	public boolean contentIsNotNull(String content) throws ServiceException {
		if (content != null) {
			return true;
		}
		throw new ServiceException("Received content is null");
	}

	@Override
	public boolean noteIsNotNull(Note note) throws ServiceException {
		if (note != null) {
			return true;
		}
		throw new ServiceException("Received note is null");
	}
}
