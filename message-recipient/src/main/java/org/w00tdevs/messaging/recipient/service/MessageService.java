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
	 * @return the boolean
	 */
	void printMessage(Message message);

}
