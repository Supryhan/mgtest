package ua.ch.mgtest.service;

import ua.ch.mgtest.model.Contact;

import java.util.List;

public interface ContactService {

	 void add(Contact contact);

	void update(Contact contact);

	Contact get(String id);

	List<Contact> getAll();

	void remove(String id);
}