package org.learnhow.ws.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.learnhow.ws.schema.Country;
import org.learnhow.ws.schema.Currency;
import org.learnhow.ws.schema.Language;
import org.springframework.stereotype.Component;

@Component
public class CountryRepository {
	
	private static final Map<String, Country> countries = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		
		Language language = new Language();

		Country country = new Country();
		country.setName("Spain");
		country.setCapital("Madrid");
		country.setCurrency(Currency.EUR);
		country.setPopulation(46704314);
		language.setName("spanish");
		country.setLanguage(language);
		countries.put(country.getName(), country);

		country = new Country();
		country.setName("Poland");
		country.setCapital("Warsaw");
		country.setCurrency(Currency.PLN);
		country.setPopulation(38186860);
		language.setName("polish");
		country.setLanguage(language);
		countries.put(country.getName(), country);
		
		country = new Country();
		country.setName("United Kingdom");
		country.setCapital("London");
		country.setCurrency(Currency.GBP);
		country.setPopulation(63705000);
		language.setName("english");
		country.setLanguage(language);
		countries.put(country.getName(), country);
	}
	
	public Country findCountry(String name) {
		return countries.get(name);
	}
}
