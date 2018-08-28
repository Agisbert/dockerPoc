package org.w00tdevs.messaging.sender.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w00tdevs.messaging.domain.Message;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author agisbert
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	/** The client. */
	@Autowired
	private RestTemplate client;

	@Value("${message-sender.signature}")
	private String signature;
	
	@Value("${message-printer.path}")
	private String path;


	/* (non-Javadoc)
	 * @see org.w00tdevs.messaging.sender.service.MessageService#sendMessage(org.w00tdevs.messaging.domain.Message)
	 */
	@HystrixCommand(fallbackMethod = "recoverSendMessage")
	public Message sendMessage(Message msg) {
		Message response = null;
		try{			
			response = client.postForObject("http://message-printer/" + path, msg, Message.class);
		}catch (RuntimeException e) {
			msg.setAttempt(msg.getAttempt() + 1);
			System.out.println("Error invoking service ->"  + "\n" + msg.toString() + "\n" + e.getMessage());
			throw e;
		}
		return response;
	}


	/* (non-Javadoc)
	 * @see org.w00tdevs.messaging.sender.service.MessageService#sendRandomMessages(java.lang.Integer)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "recoverRandomMessages")
	public List<Message> sendRandomMessages(Integer messages) {
		return IntStream.range(0, messages).mapToObj(index -> createRandomMessage(index)).map(msg -> this.sendMessage(msg)).collect(Collectors.toList());
	}


	/**
	 * Creates the random message.
	 *
	 * @param index
	 *            the index
	 * @return the message
	 */
	private Message createRandomMessage(Integer index) {
		Message msg = new Message();
		msg.setAttempt(0);
		msg.setPrinted(false);
		msg.setSender(signature);
		msg.setMessage(msg.getSender() + " " + index);
		return msg;
	}

	/**
	 * Recover send message.
	 *
	 * @param msg
	 *            the msg
	 * @return the boolean
	 */
	public Message recoverSendMessage(Message msg) {
		System.out.println("Message not delivered " + msg);
		return msg;
	}

	/**
	 * Recover send message.
	 *
	 * @param msg
	 *            the msg
	 * @return the boolean
	 */
	public List<Message> recoverRandomMessages(Integer messages) {
		return null;
	}

}
