package org.w00tdevs.messaging.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author agisbert
 *
 */
@SpringBootApplication
public class MessageSenderApp {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MessageSenderApp.class, args);
	}

}
