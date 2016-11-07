package ua.ch.mgtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ch.mgtest.dao.UriDao;
import ua.ch.mgtest.model.Uri;
import ua.ch.mgtest.service.NetworkScanService;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

@Async
@Service
public class NetworkScanServiceImpl implements NetworkScanService {

	@Autowired
	private UriDao uriDao;

	@Override
	@Transactional
	public void saveDestinations(List<String> destinations) {
		List<Uri> uriList = new LinkedList<>();
		destinations.forEach(destination -> uriList.add(new Uri(destination)));
		uriDao.saveAll(uriList);
	}

	@Override
	@Transactional
	public Future<List<String>> getDestinations() {
		List<String> destinationList = new LinkedList<>();
		uriDao.getAll().forEach(destination -> destinationList.add(destination.getUri()));
		return new AsyncResult<>(destinationList);
	}

}
