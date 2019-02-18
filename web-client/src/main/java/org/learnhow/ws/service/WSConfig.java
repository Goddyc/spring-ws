package org.learnhow.ws.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WSConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("org.learnhow.ws.schema");
		return marshaller;
	}
	
	@Bean
	public WsClient wsClient(Jaxb2Marshaller marshaller) {
		WsClient wsClient = new WsClient();
		//wsClient.setDefaultUri("http://127.0.0.1:8080/ws/countries.wsdl");
		wsClient.setMarshaller(marshaller);
		wsClient.setUnmarshaller(marshaller);
		return wsClient;
	}
	
}
