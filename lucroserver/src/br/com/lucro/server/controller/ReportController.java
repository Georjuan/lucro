package br.com.lucro.server.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.lucro.server.model.AverageTicket;
import br.com.lucro.server.model.AverageTicket.ENUM_AVERAGE_PERIOD;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.SalesConciliation;
import br.com.lucro.server.model.SoldValueByFlag;
import br.com.lucro.server.model.SoldValueByPaymentMethod;
import br.com.lucro.server.model.WebResponse;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.service.ReportService;
import br.com.lucro.server.util.DateTimeUtils;
import br.com.lucro.server.util.Utils;
import br.com.lucro.server.util.enums.EnumWebResponse;

@RestController
@RequestMapping(value="/app/report")
public class ReportController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@ResponseBody
	@RequestMapping(value = "/sales_conciliation", method = RequestMethod.GET)
	public WebResponse getSalesConciliation(@RequestParam("company_id") Integer companyId,
		                                       @RequestParam("start_date") String startDate,
		                                       @RequestParam("end_date") String endDate) throws WebResponseException, Exception {
		
		logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
				request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(request.getParameterMap())));
		
		//Get application context
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());

		//Format parameters
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Format date parameters
		if(companyId==null) 
			throw new WebResponseException("Parametro invalido: company_id", EnumWebResponse.INVALID_PARAM);
		
		Date periodStart = DateTimeUtils.parseDateURL(startDate, "start_date");
		
		Date periodEnd = DateTimeUtils.parseDateURL(endDate, "end_date");
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Create web response object
		WebResponse web = new WebResponse();
		
		//Get bean service
		ReportService reportService = ctx.getBean(ReportService.class);
		
		//Search data
		List<SalesConciliation> report = reportService.getSalesConciliation(
					new Company(companyId),
					periodStart,
					periodEnd
				);
		
		//Create successful response
		web.setMessage(EnumWebResponse.OK.name());
		web.setStatus(EnumWebResponse.OK);
		//Create map response
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		mapResponse.put("report", report);
		//Set map response
		web.setResponse(mapResponse);
		
		return web;
	}
	
	@ResponseBody
	@RequestMapping(value = "/sold_value_by_flag", method = RequestMethod.GET)
	public WebResponse getSoldValueByFlag(@RequestParam("company_id") Integer companyId,
			                                       @RequestParam("start_date") String startDate,
			                                       @RequestParam("end_date") String endDate) throws WebResponseException, Exception {
		
		logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
				request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(request.getParameterMap())));
		
		//Get application context
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());

		//Format parameters
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Format date parameters
		if(companyId==null) 
			throw new WebResponseException("Parametro invalido: company_id", EnumWebResponse.INVALID_PARAM);
		
		Date periodStart = DateTimeUtils.parseDateURL(startDate, "start_date");
		
		Date periodEnd = DateTimeUtils.parseDateURL(endDate, "end_date");
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Create web response object
		WebResponse web = new WebResponse();
		
		//Get bean service
		ReportService reportService = ctx.getBean(ReportService.class);
		
		//Search data
		List<SoldValueByFlag> report = reportService.getSoldValueByFlag(
					new Company(companyId),
					periodStart,
					periodEnd
				);
		
		//Create successful response
		web.setMessage(EnumWebResponse.OK.name());
		web.setStatus(EnumWebResponse.OK);
		//Create map response
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		mapResponse.put("report", report);
		//Set map response
		web.setResponse(mapResponse);
		
		return web;
	}
	
	@ResponseBody
	@RequestMapping(value = "/sold_value_by_payment_method", method = RequestMethod.GET)
	public WebResponse getSoldValueByPaymentMethod(@RequestParam("company_id") Integer companyId,
			                                       @RequestParam("start_date") String startDate,
			                                       @RequestParam("end_date") String endDate) throws WebResponseException, Exception {
		
		logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
				request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(request.getParameterMap())));
		
		//Get application context
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());

		//Format parameters
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Format date parameters
		if(companyId==null) 
			throw new WebResponseException("Parametro invalido: company_id", EnumWebResponse.INVALID_PARAM);
		
		Date periodStart = DateTimeUtils.parseDateURL(startDate, "start_date");
		
		Date periodEnd = DateTimeUtils.parseDateURL(endDate, "end_date");
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Create web response object
		WebResponse web = new WebResponse();
		
		//Get bean service
		ReportService reportService = ctx.getBean(ReportService.class);
		
		//Search data
		SoldValueByPaymentMethod report = reportService.getSoldValueByPaymentMethod(
					new Company(companyId),
					periodStart,
					periodEnd
				);
		
		//Create successful response
		web.setMessage(EnumWebResponse.OK.name());
		web.setStatus(EnumWebResponse.OK);
		//Create map response
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		mapResponse.put("report", report);
		//Set map response
		web.setResponse(mapResponse);
		
		return web;
	}
	
	@ResponseBody
	@RequestMapping(value = "/average_ticket", method = RequestMethod.GET)
	public WebResponse getAverageTicket(@RequestParam("company_id") Integer companyId,
			                                       @RequestParam("period") String period,
			                                       @RequestParam("quantity") Integer quantity) throws WebResponseException, Exception {
		
		logger.info(String.format("Request for '%s' - From: %s:%d - Parameters: %s", request.getServletPath(),
				request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(request.getParameterMap())));
		
		//Get application context
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());

		//Format parameters
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Format date parameters
		if(companyId==null) 
			throw new WebResponseException("Parametro invalido: company_id", EnumWebResponse.INVALID_PARAM);
		
		ENUM_AVERAGE_PERIOD periodEnum = ENUM_AVERAGE_PERIOD.valueOf(period);
		if(periodEnum==null) 
			throw new WebResponseException("Parametro invalido: period", EnumWebResponse.INVALID_PARAM);
		
		if(quantity==null) 
			throw new WebResponseException("Parametro invalido: quantity", EnumWebResponse.INVALID_PARAM);
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Create web response object
		WebResponse web = new WebResponse();
		
		//Get bean service
		ReportService reportService = ctx.getBean(ReportService.class);
		
		//Search data
		List<AverageTicket> report = reportService.getAverageTicket(
					new Company(companyId),
					periodEnum,
					quantity
				);
		
		//Create successful response
		web.setMessage(EnumWebResponse.OK.name());
		web.setStatus(EnumWebResponse.OK);
		//Create map response
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		mapResponse.put("report", report);
		//Set map response
		web.setResponse(mapResponse);
		
		return web;
	}

}