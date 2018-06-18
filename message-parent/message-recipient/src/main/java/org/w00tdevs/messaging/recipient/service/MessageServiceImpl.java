package org.w00tdevs.messaging.recipient.service;

import org.springframework.stereotype.Service;
import org.w00tdevs.messaging.domain.Message;

/**
 * @author agisbert
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	/* (non-Javadoc)
	 * @see org.w00tdevs.messaging.recipient.service.MessageService#printMessage(org.w00tdevs.messaging.domain.Message)
	 */
	@Override
	public void printMessage(Message message) {
		System.out.println("---");
		System.out.println("Message -> " + message.getMessage());
		System.out.println("Attempt -> " + message.getAttempt());
		System.out.println("Sender -> " + message.getSender());
	}


}
