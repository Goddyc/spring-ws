package org.learnhow.ws.service;

import org.learnhow.ws.schema.GetCountryRequest;
import org.learnhow.ws.schema.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CounrtyEndpoint {

	private static final String NAMESPACE_URI = "http://learnhow.org/ws/schema";
	
	@Autowired
	private CountryRepository countryRepository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));
		
		return response;
	}
	
}
