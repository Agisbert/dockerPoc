package org.w00tdevs.messaging.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author agisbert
 *
 */
@SpringBootApplication
@EnableConfigServer
public class MessageServiceConfigApp {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MessageServiceConfigApp.class, args);
	}
}