package br.com.lucro.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.lucro.manager.dao.FileOutstandingBalanceByFlagCieloDAO;
import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileOutstandingBalanceByFlagCielo;
import br.com.lucro.manager.service.FileOutstandingBalanceByFlagCieloService;

public class FileOutstandingBalanceByFlagCieloServiceImpl implements FileOutstandingBalanceByFlagCieloService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(FileOutstandingBalanceByFlagCieloServiceImpl.class);
	
	@Inject
	private FileOutstandingBalanceByFlagCieloDAO dao;

	@Override
	public FileOutstandingBalanceByFlagCielo processOperation(String line, FileHeaderCielo fileHeaderCielo) throws Exception {
		FileOutstandingBalanceByFlagCielo balance = new FileOutstandingBalanceByFlagCielo();
		
		Pattern search = Pattern.compile("^(\\d{1})(\\d{10})(\\d{6})(.{10})(\\d{3})(\\d{5})([\\+\\-]{1})(\\d{15})([\\+\\-]{1})(\\d{15})([\\+\\-]{1})(\\d{15})([\\+\\-]{1})(\\d{15})([\\+\\-]{1})(\\d{15})");
	    Matcher matcher = search.matcher(line);
		
		if(!matcher.find()) throw new Exception("Dados não correnpondem ao padrão especificado!");
		
		balance.setHeader(fileHeaderCielo);
		balance.setEstablishmentNumber(matcher.group(2));
		balance.setReferenceDate(new SimpleDateFormat("MMyyyy").parse(matcher.group(3)));
		balance.setPlatformType(matcher.group(4).trim());
		balance.setCardFlagId(Integer.parseInt(matcher.group(5)));
		balance.setBranchesSize(Integer.parseInt(matcher.group(6)));		
		balance.setGrossValue((Double.parseDouble(matcher.group(8)) / (double)100) * (matcher.group(7).equals("-")?-1:1));
		balance.setNetValue((Double.parseDouble(matcher.group(10)) / (double)100) * (matcher.group(9).equals("-")?-1:1));
		balance.setAnticipatedValue((Double.parseDouble(matcher.group(12)) / (double)100) * (matcher.group(11).equals("-")?-1:1));
		balance.setToCompensateValue((Double.parseDouble(matcher.group(14)) / (double)100) * (matcher.group(13).equals("-")?-1:1));
		balance.setCededValue((Double.parseDouble(matcher.group(16)) / (double)100) * (matcher.group(15).equals("-")?-1:1));
				
		if(!dao.exists(balance)){
			dao.create(balance);
		}else{
			balance = dao.select(balance);
		}
		
		return balance;
	}

}
