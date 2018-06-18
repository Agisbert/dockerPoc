package org.w00tdevs.messaging.sender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w00tdevs.messaging.domain.Message;

/**
 * @author agisbert
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	/** The client. */
	@Autowired
	private RestTemplate client;


	/* (non-Javadoc)
	 * @see org.w00tdevs.messaging.sender.service.MessageService#sendMessage(org.w00tdevs.messaging.domain.Message)
	 */
	//	@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000))
	public Boolean sendMessage(Message msg) {
		try{			
			client.postForObject("http://message-printer/messages", msg, Boolean.class);
		}catch (RuntimeException e) {
			msg.setAttempt(msg.getAttempt() + 1);
			System.out.println("Error invoking service ->"  + "\n" + msg.toString() + "\n" + e.getMessage());
			throw e;
		}
		return true;
	}
	
	/**
	 * Recover send message.
	 *
	 * @param msg
	 *            the msg
	 * @return the boolean
	 */
	@Recover
	public Boolean recoverSendMessage(Message msg) {
		System.out.println("Message not delivered " + msg);
		return false;
	}

}
