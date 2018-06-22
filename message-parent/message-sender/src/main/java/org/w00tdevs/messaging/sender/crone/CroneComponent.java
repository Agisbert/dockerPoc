package org.w00tdevs.messaging.sender.crone;

import java.util.Scanner;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w00tdevs.messaging.domain.Message;
import org.w00tdevs.messaging.sender.service.MessageService;

/**
 * @author agisbert
 *
 */
@Component
public class CroneComponent {

	/** The message service. */
	@Autowired
	private MessageService messageService;

	@Value("${spring.application.name}")
	private String appName;
	
	private int messageNumber;
	
	
	/**
	 * Key board input.
	 */
	@Scheduled(fixedDelay = 5000)
	public void keyBoardInput() {
		Scanner sc = new Scanner(System.in);
		try {
			while(true) {
				if(sc.hasNextInt()) {
					int t = sc.nextInt();
					IntStream.range(0, t).forEach(index -> this.sendMessage(index));
				}
			}
		}finally {			
			sc.close();
		}
	}
	
	private void sendMessage(int value) {
		Message msg = new Message();
		msg.setMessage("Dummy message " + ++messageNumber);
		msg.setSender("Dummy sender " + appName);
		msg.setAttempt(0);	
		this.messageService.sendMessage(msg);
	}
}
