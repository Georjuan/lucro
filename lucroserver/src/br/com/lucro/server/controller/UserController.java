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

import br.com.lucro.server.controller.dto.CompanyDTO;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.WebResponse;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.service.CompanyService;
import br.com.lucro.server.util.Utils;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * @author taylor
 *
 */
@RestController
@RequestMapping(value="/app/user")
public class UserController {

		@Autowired
		private HttpSession session;
		
		@Autowired
		private HttpServletRequest request;
		
		private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
		@ResponseBody
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		public WebResponse createUser(@RequestBody CompanyDTO companyParameters) throws WebResponseException, Exception {
			
			logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
					request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(new Object[]{companyParameters})));
			
			//Get application context
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
			
			//Create web response object
			WebResponse web = new WebResponse();
			
			//Get bean service
			CompanyService companyService = ctx.getBean(CompanyService.class);
			
			//Create company
			Company company = companyService.saveCompany(companyParameters.toCompany());
			
			//Create successful response
			web.setMessage(EnumWebResponse.OK.name());
			web.setStatus(EnumWebResponse.OK);
			//Create map response
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			mapResponse.put("company", company);
			//Set map response
			web.setResponse(mapResponse);
			
			return web;
		}

}
