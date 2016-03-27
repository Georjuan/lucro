/**
 * @author taylor
 */
package br.com.lucro.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.lucro.server.controller.dto.CompanyAcquirerDTO;
import br.com.lucro.server.model.Acquirer;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.CompanyAcquirer;
import br.com.lucro.server.model.WebResponse;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.service.CompanyAcquirerService;
import br.com.lucro.server.util.Utils;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * @author taylor
 *
 */
@RestController
@RequestMapping(value="/app/acquirer")
public class AcquirerController {

		@Autowired
		private HttpSession session;
		
		@Autowired
		private HttpServletRequest request;
		
		private static final Logger logger = LoggerFactory.getLogger(AcquirerController.class);
		
		@ResponseBody
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public WebResponse createAcquirer(@RequestParam("cnpj") String cnpj) throws WebResponseException, Exception {
			
			logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
					request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(request.getParameterMap())));
			
			//Get application context
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
			
			//Create web response object
			WebResponse web = new WebResponse();
			
			//Get bean service
			CompanyAcquirerService companyAcquirerService = ctx.getBean(CompanyAcquirerService.class);

			//Create acquirer
			List<CompanyAcquirer> acquirers = companyAcquirerService.getAcquirers(new Company(cnpj));

			//remove company data
			acquirers.forEach(acquirer -> acquirer.setCompany(null));

			//set acquirer name
			acquirers.forEach(acquirer -> acquirer.setAcquirer(Acquirer.getAcquirer(acquirer.getId().getAcquirer())));

			//Create successful response
			web.setMessage(EnumWebResponse.OK.name());
			web.setStatus(EnumWebResponse.OK);
			//Create map response
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			mapResponse.put("acquirers", acquirers);
			//Set map response
			web.setResponse(mapResponse);
			
			return web;
		}
		
		@ResponseBody
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		public WebResponse createAcquirer(@RequestBody CompanyAcquirerDTO acquirerParameters) throws WebResponseException, Exception {
			
			logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
					request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(new Object[]{acquirerParameters})));
			
			//Get application context
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
			
			//Create web response object
			WebResponse web = new WebResponse();
			
			//Get bean service
			CompanyAcquirerService companyAcquirerService = ctx.getBean(CompanyAcquirerService.class);
			
			//Create acquirer
			CompanyAcquirer acquirer = companyAcquirerService.saveAcquirer(acquirerParameters.toAcquirer());
			
			//Remove user data
			if(acquirer.getCompany()!=null)acquirer.getCompany().setUser(null);
			
			//set acquirer name
			acquirer.setAcquirer(Acquirer.getAcquirer(acquirer.getId().getAcquirer()));
			
			//Create successful response
			web.setMessage(EnumWebResponse.OK.name());
			web.setStatus(EnumWebResponse.OK);
			//Create map response
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			mapResponse.put("acquirer", acquirer);
			//Set map response
			web.setResponse(mapResponse);
			
			return web;
		}
		
		@ResponseBody
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public WebResponse deleteAcquirer(@RequestBody CompanyAcquirerDTO acquirerParameters) throws WebResponseException, Exception {
			
			logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
					request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(new Object[]{acquirerParameters})));
			
			//Get application context
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
			
			//Create web response object
			WebResponse web = new WebResponse();
			
			//Get bean service
			CompanyAcquirerService companyAcquirerService = ctx.getBean(CompanyAcquirerService.class);
			
			//Delete acquirer
			companyAcquirerService.deleteAcquirer(acquirerParameters.toAcquirer());
			
			//Create successful response
			web.setMessage(EnumWebResponse.OK.name());
			web.setStatus(EnumWebResponse.OK);
			//Create map response
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			mapResponse.put("acquirer", null);
			//Set map response
			web.setResponse(mapResponse);
			
			return web;
		}
		
		@ResponseBody
		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public WebResponse updateAcquirer(@RequestBody CompanyAcquirerDTO acquirerParameters) throws WebResponseException, Exception {
			
			logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
					request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(new Object[]{acquirerParameters})));
			
			//Get application context
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
			
			//Create web response object
			WebResponse web = new WebResponse();
			
			//Get bean service
			CompanyAcquirerService companyAcquirerService = ctx.getBean(CompanyAcquirerService.class);
logger.info("A");
			//Update acquirer
			CompanyAcquirer acquirer = companyAcquirerService.updateAcquirer(acquirerParameters.toAcquirer());
logger.info("B");			
			//Remove user data
			if(acquirer.getCompany()!=null)acquirer.getCompany().setUser(null);
logger.info("C");
			//set acquirer name
			acquirer.setAcquirer(Acquirer.getAcquirer(acquirer.getId().getAcquirer()));
logger.info("D");
			//Create successful response
			web.setMessage(EnumWebResponse.OK.name());
			web.setStatus(EnumWebResponse.OK);
			//Create map response
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			mapResponse.put("acquirer", acquirer);
			//Set map response
			web.setResponse(mapResponse);
			
			return web;
		}

}
