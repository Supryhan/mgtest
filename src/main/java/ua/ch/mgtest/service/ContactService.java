package ua.ch.mgtest.service;

import ua.ch.mgtest.model.Contact;

import java.util.List;
import java.util.concurrent.Future;

public interface ContactService {

	 void add(Contact contact);

	void update(Contact contact);

	Future<Contact> get(String id);

	Future<List<Contact>> getAll();

	void remove(String id);
}