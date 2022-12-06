package com.tc.nb.entity;

import java.util.Date;
import java.util.Objects;

public class Note {
	private String header;
	private Date dateOfCreation;
	private String noteContent;

	public Note() {
	}

	public Note(String header, String noteContent) {
		this.header = header;
		this.noteContent = noteContent;
		dateOfCreation = new Date();
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfCreation, header, noteContent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(dateOfCreation, other.dateOfCreation) && Objects.equals(header, other.header)
				&& Objects.equals(noteContent, other.noteContent);
	}

	@Override
	public String toString() {
		return "Note [header=" + header + ", dateOfCreation=" + dateOfCreation + ", noteContent=" + noteContent + "]";
	}

}