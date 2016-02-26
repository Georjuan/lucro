/**
 * 
 */
package br.com.lucro.server.util;

import java.lang.reflect.Field;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/**
 * @author Georjuan Taylor
 *
 */
public abstract class Utils {

	/**
	 * Copy objects with same fields
	 * @param entityFrom
	 * @param entityTo
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
	public static <T1 extends Object, T2 extends Object>  void copy(T1 entityFrom, T2 entityTo) throws IllegalAccessException, NoSuchFieldException {
		Class<? extends Object> copy1 = entityFrom.getClass();
		Class<? extends Object> copy2 = entityTo.getClass();

		Field[] fromFields = copy1.getDeclaredFields();
		@SuppressWarnings("unused")
		Field[] toFields = copy2.getDeclaredFields();

		Object value = null;

		for (Field field : fromFields){
		    Field field1 = copy2.getDeclaredField(field.getName());
		    System.out.println(field.getName());
		    value = field.get(entityFrom);
		    field1.set(entityTo, value);
		}
	}

	/** Format received parameters in request to map */
	//TODO Change the parameter type to Map
	public static String getMapParam(Map<?,?> parameters) {
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yyyy HH:mm:ss Z");
        Gson gson = gsonBuilder.create();
		
		JsonElement json = gson.toJsonTree(parameters);

		return json.toString();
	}
	
	/** Format received parameters in request to JSON */
	public static String getMapParam(Object parameters[]) {
		GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss Z");
		
		StringBuffer buffer = new StringBuffer();
        
		for(Object parameter : parameters) buffer.append(gsonBuilder.create().toJson(parameter) + "\n");

		return buffer.toString().trim();
	}

}
