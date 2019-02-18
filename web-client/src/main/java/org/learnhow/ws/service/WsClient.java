package org.learnhow.ws.service;

import org.learnhow.ws.schema.GetCountryRequest;
import org.learnhow.ws.schema.GetCountryResponse;
import org.learnhow.ws.schema.GetUserRequest;
import org.learnhow.ws.schema.GetUserResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class WsClient extends WebServiceGatewaySupport{
	
	private static final String URI = "http://127.0.0.1:8080/ws/";
	
	public GetCountryResponse getCountry(String name) {
		GetCountryRequest request = new GetCountryRequest();
		request.setName(name);
		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive(URI + "countries.wsdl",request);
		
		return response;
	}
	
	public GetUserResponse getUser(String name) {
		GetUserRequest request = new GetUserRequest();
		request.setName(name);
		GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
				.marshalSendAndReceive(URI + "users.wsdl", request);
		return response;
	}
		
}
