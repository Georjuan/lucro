/**
 * @author taylor
 */
package br.com.lucro.server.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.lucro.server.controller.dto.AuthenticationDTO;
import br.com.lucro.server.model.Authentication;
import br.com.lucro.server.model.Authentication.EnumAccessType;
import br.com.lucro.server.model.User;
import br.com.lucro.server.model.WebResponse;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.service.AuthenticationService;
import br.com.lucro.server.service.UserService;
import br.com.lucro.server.util.Utils;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * @author taylor
 *
 */
@RestController
@RequestMapping(value="/auth")
public class AuthController {

		@Autowired
		private HttpSession session;
		
		@Autowired
		private HttpServletRequest request;
		
		private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
		
		@ResponseBody
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public WebResponse getAverageTicket(@RequestBody AuthenticationDTO authParameters) throws WebResponseException, Exception {
			
			logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
					request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(new Object[]{authParameters})));
			
			//Get application context
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
			
			//Create web response object
			WebResponse web = new WebResponse();
			
			//Get bean service
			AuthenticationService authenticationService = ctx.getBean(AuthenticationService.class);
			
			//Get bean service
			UserService userService = ctx.getBean(UserService.class);
			
			Authentication auth = new Authentication(authParameters.getUsername(), 
														authParameters.getPassword(), request.getRemoteAddr(), EnumAccessType.LOGIN);
			
			//Log in user
			Authentication authentication = authenticationService.auth(auth);
			
			if(authentication == null){				
				throw new WebResponseException("Usuário ou senha inválidos", EnumWebResponse.AUTHENTICATION_ERROR);				
			}
			
			//Get user data
			User user = userService.getUser(new User(authentication.getUsername()));

			if(user.getCompany()!=null)user.getCompany().setUser(null);
			
			//Create successful response
			web.setMessage(EnumWebResponse.OK.name());
			web.setStatus(EnumWebResponse.OK);
			//Create map response
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			mapResponse.put("authentication", authentication);
			mapResponse.put("user", user);
			//Set map response
			web.setResponse(mapResponse);
			
			return web;
		}

}
