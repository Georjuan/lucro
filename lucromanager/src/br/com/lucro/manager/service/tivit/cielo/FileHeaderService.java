package br.com.lucro.manager.service.tivit.cielo;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import br.com.lucro.manager.dao.FileHeaderDAO;
import br.com.lucro.manager.model.tivit.cielo.FileHeader;

public class FileHeaderService {
	
	@Inject
	private FileHeaderDAO dao;

	/**
	 * Read line data, format and save data into data base
	 * @param line
	 * @throws Exception
	 */
	public void readFileFile(String line) throws Exception{
		FileHeader header = new FileHeader();
		
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
		header.setVan(header.getVan().equals("I") ? "GXS Brasil (Interchange)" : (header.getVan().equals("P") ? "TIVIT (Proceda)" : header.getVan()));
		
		dao.insert(header);		
	}
}
