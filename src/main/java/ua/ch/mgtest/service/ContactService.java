package ua.ch.mgtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ch.mgtest.dao.ContactDao;
import ua.ch.mgtest.dao.SequenceDao;
import ua.ch.mgtest.model.Contact;

import java.util.List;

@Service
public class ContactService {

//	@Autowired
//	private SequenceDao sequenceDao;

	@Autowired
	private ContactDao contactDao;

	@Transactional
	public void add(Contact contact) {
//		contact.setId(sequenceDao.getNextSequenceId(Contact.COLLECTION_NAME));
		contactDao.save(contact);
	}

	@Transactional
	public void update(Contact contact) {
		contactDao.save(contact);
	}

	@Transactional
	public Contact get(String id) {
		return contactDao.get(id);
	}

	@Transactional
	public List<Contact> getAll() {
		return contactDao.getAll();
	}

	@Transactional
	public void remove(Long id) {
		contactDao.remove(id);
	}
}