package org.learnhow.ws.service;

import org.learnhow.ws.schema.GetCountryResponse;
import org.learnhow.ws.schema.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@Autowired
	private WsClient wsClient;
	
	@RequestMapping("/getCountry")
	public Object getCountry() {
		GetCountryResponse response = wsClient.getCountry("Poland");
		return response.getCountry();
	}
	
	@RequestMapping("/getUser")
	public Object getUser() {
		GetUserResponse response = wsClient.getUser("liuyifei");
		return response.getUser();
	}
	
}
