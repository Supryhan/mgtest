package ua.ch.mgtest.dao;

import org.springframework.stereotype.Repository;
import ua.ch.mgtest.model.Contact;

import java.util.List;

@Repository
public interface ContactDao {

	void save(Contact contact);

	Contact get(String id);

	List<Contact> getAll();

	void remove(String id);
}
