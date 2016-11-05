package ua.ch.mgtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ch.mgtest.dao.UriDao;
import ua.ch.mgtest.model.Uri;

import java.util.LinkedList;
import java.util.List;

@Service
public class NetworkScanService {

	@Autowired
	private UriDao uriDao;

	@Transactional
	public void saveDestinations(List<String> destinations) {
		List<Uri> uriList = new LinkedList<>();
		destinations.forEach(destination -> uriList.add(new Uri(destination)));
		uriDao.saveAll(uriList);
	}

	@Transactional
	public List<String> getDestinations() {
		List<String> destinationList = new LinkedList<>();
		uriDao.getAll().forEach(destination -> destinationList.add(destination.getUri()));
		return destinationList;
	}

}
