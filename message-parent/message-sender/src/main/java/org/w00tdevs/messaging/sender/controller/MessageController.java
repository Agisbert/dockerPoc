package org.w00tdevs.messaging.sender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w00tdevs.messaging.domain.Message;
import org.w00tdevs.messaging.sender.service.MessageService;

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
	 * Gets sent messages. Should be a post, easier to be a get... Leave me alone.
	 *
	 * @param messages
	 *            the messages
	 * @return the boolean
	 */
	@RequestMapping(path = "/messages", method = RequestMethod.GET)
	public Message[] postMessage(@RequestParam(name = "messages", defaultValue = "1") Integer messages) {
		List<Message> messageResponses = messageService.sendRandomMessages(messages);
		return messageResponses.toArray(new Message[messageResponses.size()]);
	}


}
