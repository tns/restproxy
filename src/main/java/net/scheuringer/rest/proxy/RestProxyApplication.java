package net.scheuringer.rest.proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestProxyApplication {
	
	private static final String PROXY_SERVER_HOST = "proxy.wuestenrot.at";
	
	private static final String PROXY_USERNAME = "user";
	
	private static final String PROXY_PASSWORD = "pwd";
	
	private static final int PROXY_SERVER_PORT = 3125;
	
	private static final boolean PROXY_ON = true;
	
	

  public static void main(String[] args) {
    SpringApplication.run(RestProxyApplication.class, args);
  }
  
  @Bean
  public RestTemplate create() {
	  if (PROXY_ON) {
		  System.setProperty("https.proxyUser", PROXY_USERNAME);
		  System.setProperty("https.proxyPassword", PROXY_PASSWORD);
		  
		  System.setProperty("http.proxyUser", PROXY_USERNAME);
		  System.setProperty("http.proxyPassword", PROXY_PASSWORD);
		  
		  Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(PROXY_SERVER_HOST, PROXY_SERVER_PORT));
		  SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		  requestFactory.setProxy(proxy);
		  
		  RestTemplate restTemplate = new RestTemplate(requestFactory);
	  	  return restTemplate;  
	  }

	  return new RestTemplate();
  }

}