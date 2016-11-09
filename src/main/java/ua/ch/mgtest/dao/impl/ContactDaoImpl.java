package ua.ch.mgtest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ua.ch.mgtest.model.Contact;

import java.util.List;

@Repository
public class ContactDaoImpl {
	@Autowired
	private MongoOperations mongoOperations;

	public void save(Contact contact) {
		mongoOperations.save(contact);
	}

	public Contact get(String id) {
		return mongoOperations.findOne(Query.query(Criteria.where("_id").is(id)), Contact.class);
	}

	public List<Contact> getAll() {
		return mongoOperations.findAll(Contact.class);
	}

	public void remove(String id) {
		mongoOperations.remove(Query.query(Criteria.where("_id").is(id)), Contact.class);
	}
}
