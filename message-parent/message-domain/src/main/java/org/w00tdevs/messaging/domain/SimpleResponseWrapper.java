package org.w00tdevs.messaging.domain;

import lombok.ToString;

/**
 * @author agisbert
 *
 */
/**
 * @author agisbert
 *
 * @param <T>
 */
/**
 * @author agisbert
 *
 * @param <T>
 */
@ToString(includeFieldNames = true)
public class SimpleResponseWrapper<T> {

	/** The result. */
	private T result;
	

	/**
	 * Instantiates a new simple response wrapper.
	 *
	 * @param result
	 *            the result
	 */
	public SimpleResponseWrapper(T result) {
		super();
		this.result = result;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result
	 *            the new result
	 */
	public void setResult(T result) {
		this.result = result;
	}

	
}
