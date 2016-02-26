package br.com.lucro.server.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Mail address operations
 * @author taylor
 *
 */
public class MailUtils {

	public static String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";	
	
	/**
	 * Check if the email address is valid
	 * @param email
	 * @return
	 */
	public static boolean isValid(String email){
		try {
			if(email == null || email.isEmpty()) return false;
			
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			
			return true;
		} catch (AddressException e) {
			return false;
		}
	}

}
