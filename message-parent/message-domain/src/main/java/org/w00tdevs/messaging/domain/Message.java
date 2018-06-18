package org.w00tdevs.messaging.domain;

import lombok.ToString;

/**
 * @author agisbert
 *
 */
@ToString(includeFieldNames = true)
public class Message {

	/** The message. */
	private String message;

	/** The attempt. */
	private Integer attempt;

	/** The sender. */
	private String sender;

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the attempt.
	 *
	 * @return the attempt
	 */
	public Integer getAttempt() {
		return attempt;
	}

	/**
	 * Sets the attempt.
	 *
	 * @param attempt
	 *            the new attempt
	 */
	public void setAttempt(Integer attempt) {
		this.attempt = attempt;
	}

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender
	 *            the new sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}



}
