package org.w00tdevs.messaging.recipient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w00tdevs.messaging.domain.Message;

/**
 * @author agisbert
 *
 */
@Service
public class MessageServiceImpl implements MessageService {
	
	/** The signature. */
	@Value("${message-printer.signature}")
	private String signature;

	/* (non-Javadoc)
	 * @see org.w00tdevs.messaging.recipient.service.MessageService#printMessage(org.w00tdevs.messaging.domain.Message)
	 */
	@Override
	public Message printMessage(Message message) {
		System.out.println("---");
		System.out.println("Message -> " + message.getMessage());
		System.out.println("Attempt -> " + message.getAttempt());
		System.out.println("Sender -> " + message.getSender());
		message = signMessage(message);
		return message;
	}


	/* (non-Javadoc)
	 * @see org.w00tdevs.messaging.recipient.service.MessageService#printDummyMessage()
	 */
	@Override
	public Message printDummyMessage() {
		Message message = createDummyMessage();
		return printMessage(message);
	}


	private Message createDummyMessage() {
		Message message = new Message();
		message.setMessage("Dummy message");
		message.setAttempt(-1);
		message.setSender(signature);
		return message;
	}

	
	/**
	 * Sign message.
	 *
	 * @param message
	 *            the message
	 * @return the message
	 */
	private Message signMessage(Message message) {
		message.setPrinted(true);
		message.setPrintedBy(signature);
		return message;
	}


}
