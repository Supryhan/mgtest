package ua.ch.mgtest.service;

import java.util.List;
import java.util.concurrent.Future;

public interface NetworkScanService {

	void saveDestinations(List<String> destinations);

	Future<List<String>> getDestinations();

}
