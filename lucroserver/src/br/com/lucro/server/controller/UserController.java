/**
 * @author taylor
 */
package br.com.lucro.server.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author taylor
 *
 */
@RestController
@RequestMapping(value="/app/user")
public class UserController {

		@SuppressWarnings("unused")
		@Autowired
		private HttpSession session;
		
		@Autowired
		private HttpServletRequest request;
		
		private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView home(Locale locale, ModelAndView model) {
			logger.info("Welcome Lucro Server! The client IP is {} and locale is {}.", request.getRemoteAddr(), locale);
			model.setViewName("home");		
			return model;
		}

}
