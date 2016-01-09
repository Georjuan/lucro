package br.com.lucro.server.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.lucro.server.model.WebResponse;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * This controller manage and handle any exceptions from the base package
 * @author Georjuan Taylor
 *
 */
@ControllerAdvice(basePackages="br.com.lucro.server")
public class ExceptionController {

	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	private static final Logger logger = Logger.getLogger(ExceptionController.class);
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(WebResponseException.class)
	public WebResponse handleError(WebResponseException exception) {
		//Log
	    logError(exception);	
	    
	    //Create web response object
		WebResponse web = new WebResponse();
		web.setDatetime(Calendar.getInstance().getTime());
		web.setStatus(exception.getResponseType());
		web.setMessage(exception.getMessage());
		
	    return web;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public WebResponse handleError(Exception exception) {
		//Log
		logError(exception);
		
	    //Create web response object
		WebResponse web = new WebResponse();
		web.setDatetime(Calendar.getInstance().getTime());
		web.setStatus(EnumWebResponse.ERROR);
		web.setMessage(exception.getMessage());
		
	    return web;
	}
	
	private void logError(Exception e){
		try{
			Class<?> eClass = Class.forName(e.getStackTrace()[0].getClassName());
			
			if(eClass.getPackage().getName().startsWith("br.com.expark.webcontrol")){
				//It's exception from this project, just log
				
				//From here
				logger.error("Request: " + request.getRequestURL() + " raised: " + e);
			}else{
				//It's exception from external library, log from external library, and from here
				
				//From external
				LoggerFactory.getLogger(Class.forName(e.getStackTrace()[0].getClassName()))
					.error("Request: " + request.getRequestURL() + " raised: " + e);
				
				//From here
				logger.error("Request: " + request.getRequestURL() + " raised: " + e);
			}			
		}catch(Exception ex){
			logger.error(e.getMessage());
		}
	}
	
	private void logError(WebResponseException e){
		try{
			Class<?> eClass = Class.forName(e.getStackTrace()[0].getClassName());
			
			if(eClass.getPackage().getName().startsWith("br.com.expark.webcontrol")){
				//It's exception from this project, just log
				
				//From here
				logger.error("Request: " + request.getRequestURL() + " raised: " + e.getResponseType() + " - " + e);
			}else{
				//It's exception from external library, log from external library, and from here
				
				//From external
				LoggerFactory.getLogger(Class.forName(e.getStackTrace()[0].getClassName()))
					.error("Request: " + request.getRequestURL() + " raised: " + e.getResponseType() + " - " + e);
				
				//From here
				logger.error("Request: " + request.getRequestURL() + " raised: " + e.getResponseType() + " - " + e);
			}			
		}catch(Exception ex){
			logger.error(e.getMessage());
		}
	}

}
