package net.scheuringer.rest.proxy.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCaller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getExternalDataAsString(String symbol) {
		String url = "https://api.kraken.com/0/public/Ticker?pair=" + symbol;
		
		String jsonData = restTemplate.getForObject(url, String.class);
		
		return jsonData ;
	}
	
	
}
