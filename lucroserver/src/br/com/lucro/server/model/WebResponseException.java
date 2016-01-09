/**
 * 
 */
package br.com.lucro.server.model;

import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * @author Georjuan Taylor
 *
 */
public class WebResponseException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private EnumWebResponse responseType;
	
	/**
	 * @param message
	 */
	public WebResponseException(String message, EnumWebResponse responseType) {
		super(message);
		this.responseType = responseType;
	}

	/**
	 * @param cause
	 */
	public WebResponseException(Throwable cause, EnumWebResponse responseType) {
		super(cause);
		this.responseType = responseType;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WebResponseException(String message, Throwable cause, EnumWebResponse responseType) {
		super(message, cause);
		this.responseType = responseType;
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public WebResponseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace, EnumWebResponse responseType) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.responseType = responseType;
	}

	/**
	 * @return The {@link #responseType}
	 */
	public EnumWebResponse getResponseType() {
		return this.responseType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		String e = super.getMessage();
		e = e.replaceAll("(\\r)?(\\n)+"," ").replaceAll("(\\s)+", " ");
		return e;
	}
	
	

}
