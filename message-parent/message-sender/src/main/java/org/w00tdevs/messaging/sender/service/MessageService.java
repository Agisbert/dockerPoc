package org.w00tdevs.messaging.sender.service;

import java.util.List;

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
	 * @return the message
	 */
	Message sendMessage(Message msg);

	
	/**
	 * Send random messages.
	 *
	 * @param msg
	 *            the msg
	 * @return the list
	 */
	List<Message> sendRandomMessages(Integer messages);
}
