package org.w00tdevs.messaging.recipient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w00tdevs.messaging.domain.Message;
import org.w00tdevs.messaging.recipient.service.MessageService;

/**
 * @author agisbert
 *
 */
@RestController
public class MessageController {
	
	/** The message service. */
	@Autowired
	private MessageService messageService;

	/**
	 * Post message.
	 *
	 * @param message
	 *            the message
	 * @return the boolean
	 */
	@RequestMapping(path = "/messages", method = RequestMethod.POST)
	public Boolean postMessage(@RequestBody Message message) {
		messageService.printMessage(message);
		return true;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	@RequestMapping(path = "/messages", method = RequestMethod.GET)
	public Boolean getMessage() {
		return true;
	}
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	@RequestMapping(path = "/health", method = RequestMethod.GET)
	public Boolean getRoot() {
		return true;
	}
}
