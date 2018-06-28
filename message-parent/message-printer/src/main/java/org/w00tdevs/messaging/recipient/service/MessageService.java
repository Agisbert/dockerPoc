package org.w00tdevs.messaging.recipient.service;

import org.w00tdevs.messaging.domain.Message;

/**
 * @author agisbert
 *
 */
public interface MessageService {

	
	/**
	 * Prints the message.
	 *
	 * @param message
	 *            the message
	 * @return the message
	 */
	Message printMessage(Message message);

	/**
	 * Prints the dummy message.
	 *
	 * @return the message
	 */
	Message printDummyMessage();

}
