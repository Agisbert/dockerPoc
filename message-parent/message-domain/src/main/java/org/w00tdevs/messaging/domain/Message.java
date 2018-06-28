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

	/** The printed. */
	private Boolean printed;
	
	/** The printed by. */
	private String printedBy;


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

	/**
	 * Gets the printed.
	 *
	 * @return the printed
	 */
	public Boolean getPrinted() {
		return printed;
	}

	/**
	 * Sets the printed.
	 *
	 * @param printed
	 *            the new printed
	 */
	public void setPrinted(Boolean printed) {
		this.printed = printed;
	}

	/**
	 * Gets the printed by.
	 *
	 * @return the printed by
	 */
	public String getPrintedBy() {
		return printedBy;
	}

	/**
	 * Sets the printed by.
	 *
	 * @param printedBy
	 *            the new printed by
	 */
	public void setPrintedBy(String printedBy) {
		this.printedBy = printedBy;
	}

}
