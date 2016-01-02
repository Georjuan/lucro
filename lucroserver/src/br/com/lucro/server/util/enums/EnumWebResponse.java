/**
 * 
 */
package br.com.lucro.server.util.enums;

/**
 * Web response status enum
 * @author Georjuan Taylor
 */
public enum EnumWebResponse {
	UNKNOWN(0), OK(1), ERROR(2), INVALID_PARAM(3), AUTHENTICATION_ERROR(4), DATA_INTEGRITY_ERROR(5), DUPLICATED_DATA(6);
	
	//Store the corresponding 'int' value to enum
	private int value;
	
	/** Construct sets corresponding 'int' value to enum */
	EnumWebResponse(int value){this.value = value;}
		
	/** Cast a {@code int} value to corresponding {@code EnumWebResponse} value */ 
	public static EnumWebResponse valueOf(int value) {
		for(EnumWebResponse device : EnumWebResponse.values()){
			if(device.getValue() == value) return device;
		}
		return EnumWebResponse.UNKNOWN;
	}
	
	/** Cast a {@code EnumWebResponse} value to corresponding {@code int} value */
	public int getValue(){
		return this.value;
	}
}
