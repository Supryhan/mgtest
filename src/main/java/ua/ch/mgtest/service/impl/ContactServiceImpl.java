package ua.ch.mgtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ch.mgtest.dao.ContactDao;
import ua.ch.mgtest.model.Contact;
import ua.ch.mgtest.service.ContactService;

import java.util.List;

@Async
@Service
public class ContactServiceImpl implements ContactService {

//	@Autowired
//	private SequenceDao sequenceDao;

	@Autowired
	private ContactDao contactDao;

	@Override
	@Transactional
	public void add(Contact contact) {
//		contact.setId(sequenceDao.getNextSequenceId(Contact.COLLECTION_NAME));
		contact.setId(null);
		contactDao.save(contact);
	}

	@Override
	@Transactional
	public void update(Contact contact) {
		contactDao.save(contact);
	}

	@Override
	@Transactional
	public Contact get(String id) {
		return contactDao.get(id);
	}

	@Override
	@Transactional
	public List<Contact> getAll() {
		return contactDao.getAll();
	}

	@Override
	@Transactional
	public void remove(String id) {
		contactDao.remove(id);
	}
}