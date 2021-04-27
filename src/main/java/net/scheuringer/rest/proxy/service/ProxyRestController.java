package net.scheuringer.rest.proxy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.scheuringer.rest.proxy.data.RestCaller;

@RestController
@RequestMapping("proxy")
public class ProxyRestController {

	@Autowired
	RestCaller restCaller;
	
	@GetMapping("/ticker/{symbol}")
	public String getTicker(@PathVariable("symbol") String symbol) {
		
		return restCaller.getExternalDataAsString(symbol);
		
	}
	
}
