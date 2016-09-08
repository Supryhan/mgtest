package ua.ch.mgtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ch.mgtest.dao.ContactDao;
import ua.ch.mgtest.dao.SequenceDao;
import ua.ch.mgtest.model.Contact;

import java.util.List;

@Service
public class ContactService {
	@Autowired
	private SequenceDao sequenceDao;
	@Autowired
	private ContactDao contactDao;

	public void add(Contact contact) {
//		contact.setId(sequenceDao.getNextSequenceId(Contact.COLLECTION_NAME));
		contactDao.save(contact);
	}

	public void update(Contact contact) {
		contactDao.save(contact);
	}

	public Contact get(Long id) {
		return contactDao.get(id);
	}

	public List<Contact> getAll() {
		return contactDao.getAll();
	}

	public void remove(Long id) {
		contactDao.remove(id);
	}
}