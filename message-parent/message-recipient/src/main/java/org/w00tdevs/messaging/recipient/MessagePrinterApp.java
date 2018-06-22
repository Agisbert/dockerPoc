package org.w00tdevs.messaging.recipient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author agisbert
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MessagePrinterApp {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MessagePrinterApp.class, args);
	}

}
