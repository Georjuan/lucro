package br.com.lucro.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lucro.manager.dao.FileHeaderCieloDAO;
import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.service.FileHeaderCieloService;

public class FileHeaderCieloServiceImpl implements FileHeaderCieloService {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FileHeaderCieloServiceImpl.class);
	
	@Inject
	private FileHeaderCieloDAO dao;
	
	/* (non-Javadoc)
	 * @see br.com.lucro.manager.service.FileHeaderCieloService#processHeader(java.lang.String)
	 */
	@Override
	public FileHeaderCielo processHeader(String line) throws Exception {
		FileHeaderCielo header = new FileHeaderCielo();
		
		Pattern search = Pattern.compile("^(\\d{1})(\\d{10})(\\d{8})(\\d{8})(\\d{8})(\\d{7})(\\w{5})(\\d{2})(\\w{1})([\\w\\s]{20})(\\w{3})");
	    Matcher matcher = search.matcher(line);
		
		if(!matcher.find()) throw new Exception("Dados não correnpondem ao padrão especificado!");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		header.setEstablishmentNumber(matcher.group(2));
		header.setProcessDate(dateFormat.parse(matcher.group(3)));
		header.setStartDate(dateFormat.parse(matcher.group(4)));
		header.setEndDate(dateFormat.parse(matcher.group(5)));
		header.setFileNumber(matcher.group(6));		
		header.setTypeExtractOptionId(Integer.parseInt(matcher.group(8)));
		header.setVan(matcher.group(9));
		header.setMailbox(matcher.group(10).trim().isEmpty() ? null : matcher.group(10));
		header.setLayoutVersion(matcher.group(11));
		
		if(!dao.exists(header)){
			dao.create(header);
		}else{
			header = dao.select(header);
		}
		
		return header;
	}

}
