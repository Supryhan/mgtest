package ua.ch.mgtest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import ua.ch.mgtest.model.Uri;

import java.util.List;

@Repository
public class UriDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void saveAll(List<Uri> uriList) {
        uriList.forEach(uri -> mongoOperations.save(uri));
    }

    public List<Uri> getAll() {
        return mongoOperations.findAll(Uri.class);
    }

}
