package ua.ch.mgtest.service;

import java.util.List;

public interface NetworkScanService {

	void saveDestinations(List<String> destinations);

	List<String> getDestinations();

}
