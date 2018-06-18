package org.w00tdevs.messaging.sender.service;

import org.w00tdevs.messaging.domain.Message;

/**
 * @author agisbert
 *
 */
public interface MessageService {


	/**
	 * Send message.
	 *
	 * @param msg
	 *            the msg
	 * @return the boolean
	 */
	public Boolean sendMessage(Message msg);

}
