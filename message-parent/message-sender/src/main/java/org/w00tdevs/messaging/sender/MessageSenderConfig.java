package org.w00tdevs.messaging.sender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * @author agisbert
 *
 */
@Configuration
@EnableScheduling
@EnableCircuitBreaker
@EnableDiscoveryClient
@RibbonClient(name = "message-printer", configuration = MessagePrinterConfig.class)
public class MessageSenderConfig {

	/** The user. */
	@Value("${message-printer.user}")
	private String user;

	/** The pass. */
	@Value("${message-printer.pass}")
	private String pass;

	/**
	 * Client.
	 *
	 * @param restTemplateBuilder
	 *            the rest template builder
	 * @return the rest template
	 */
	@Bean
	@LoadBalanced
	public RestTemplate client(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate client = new RestTemplate();
		client.getInterceptors().add(0, new BasicAuthorizationInterceptor(user, pass));
		return client;
	}
}
