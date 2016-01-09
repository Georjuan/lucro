/**
 * @author taylor
 */
package br.com.lucro.server.service.security;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.lucro.server.model.Authentication;
import br.com.lucro.server.model.Authentication.EnumAccessType;
import br.com.lucro.server.model.WebResponse;
import br.com.lucro.server.service.AuthenticationService;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * Intercepter handled for requests configured in servlet-context.xml
 * <br>This will authenticate any requests before process the requested function
 * @author Georjuan Taylor
 *
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//Web response
		WebResponse webResponse = new WebResponse();
		
		try{			
			//Get application context
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
			
			//Authentication
			AuthenticationService authManager = ctx.getBean(AuthenticationService.class);
			
			String auth = request.getHeader("Authorization");
			
			if(auth!=null && auth.startsWith("Basic ") && auth.length() > 20){
				
				//Read session header
				auth = auth.replace("Basic ", "");
				auth = new String(Base64.getDecoder().decode(auth));
				
				//Get parameters
				String username = auth.split(":")[0];
				String session = auth.split(":")[1];
				
				//TODO: Receber senha em formato MD5
				//Create authentication object
				Authentication authentication = new Authentication(username, session, EnumAccessType.SESSION);					
				
				//Authentication
				if((authentication = authManager.auth(authentication)) == null){
					
					//Authentication error
					webResponse.setStatus(EnumWebResponse.AUTHENTICATION_ERROR);
					webResponse.setMessage("Autenticação inválida na requisição.");
					
				}else{
					//Authentication OK
					return super.preHandle(request, response, handler);
				}

			}else{
				webResponse.setStatus(EnumWebResponse.AUTHENTICATION_ERROR);
				webResponse.setMessage("Autenticação inválida na requisição.");
			}			
			
			//Authentication error
			responseUnauthorized(webResponse, response);
			//Cancel process
			return false;
			
		}catch(Exception e){
			//Log
			logger.error(e.getMessage(), e);
			//Append response error
			webResponse.setMessage(e.getMessage());
			//Authentication error
			responseUnauthorized(webResponse, response);
			//Cancel process
			return false;
		}
		
	}
	
	/**
	 * Print the response as unauthorized access 
	 * @param webResponse
	 * @param response
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 */
	private void responseUnauthorized(WebResponse webResponse, HttpServletResponse response) throws JsonProcessingException, IOException{
		//Build response
		response.setContentType("application/json;charset=UTF-8");
		//response.setHeader("WWW-Authenticate", String.format("Basic realm=\"%s\"", webResponse.getMessage()));
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, webResponse.getMessage());
	}
	
}