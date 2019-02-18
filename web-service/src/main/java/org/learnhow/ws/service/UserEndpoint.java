package org.learnhow.ws.service;

import org.learnhow.ws.schema.GetUserRequest;
import org.learnhow.ws.schema.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
	
	public static final String NAMESPACE_URI = "http://learnhow.org/ws/schema";

	@Autowired
	private UserRespository userRespository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart="getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
		GetUserResponse response = new GetUserResponse();
		response.setUser(userRespository.findUser(request.getName()));
		return response;
	}
	
}
