package ua.ch.mgtest.dao;

import org.springframework.stereotype.Repository;
import ua.ch.mgtest.model.Uri;

import java.util.List;

@Repository
public interface UriDao {

	void saveAll(List<Uri> uriList);

	List<Uri> getAll();

}
