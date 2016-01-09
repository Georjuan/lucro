package br.com.lucro.server.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucro.server.service.UtilService;
import br.com.lucro.server.util.DateTimeUtils;

@RestController
@RequestMapping(value="/")
public class HomeController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView model) {
		logger.info("Welcome Lucro Server! The client IP is {} and locale is {}.", request.getRemoteAddr(), locale);
		model.setViewName("home");		
		return model;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView getVersion(ModelAndView model) throws IOException{
		//Get application context
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.session.getServletContext());
			
		//Util service
		UtilService utilService = ctx.getBean(UtilService.class);
		
		//Read manifest file
		ServletContext application = ctx.getServletContext();
		InputStream inputStream = application.getResourceAsStream("/META-INF/MANIFEST.MF");		
		Manifest manifest = new Manifest(inputStream);
		Attributes attr = manifest.getMainAttributes();
		
		//Get time
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
		Timestamp databaseTime = null;
		try {
			databaseTime = utilService.getDBTime();
		} catch (Exception e) {
			logger.error("Get db time error", e.getMessage(), e);
		}
		
		model.setViewName("about");
		model.addObject("serverTime", dateFormat.format(Calendar.getInstance(DateTimeUtils.getTimeZone()).getTime()));
		model.addObject("dbTime", dateFormat.format(databaseTime));
		model.addObject("appVersion", attr.getValue("Build-Label"));
		model.addObject("buildHash", attr.getValue("Build-Hash"));
		model.addObject("buildBy", attr.getValue("Built-By"));
		model.addObject("buildOS", attr.getValue("Build-OS"));
		model.addObject("buildJava", attr.getValue("Build-Java"));
		model.addObject("buildJdk", attr.getValue("Build-Jdk"));		
		model.addObject("buildTime", attr.getValue("Build-Time"));
		
		return model;
	}
	
}
