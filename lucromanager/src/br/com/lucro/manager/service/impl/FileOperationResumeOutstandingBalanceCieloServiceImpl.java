package br.com.lucro.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.lucro.manager.dao.FileOperationResumeOutstandingBalanceCieloDAO;
import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileOperationResumeOutstandingBalanceCielo;
import br.com.lucro.manager.service.FileOperationResumeOutstandingBalanceCieloService;

public class FileOperationResumeOutstandingBalanceCieloServiceImpl implements FileOperationResumeOutstandingBalanceCieloService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(FileOperationResumeOutstandingBalanceCieloServiceImpl.class);
	
	@Inject
	private FileOperationResumeOutstandingBalanceCieloDAO dao;
	
	@Override
	public FileOperationResumeOutstandingBalanceCielo processOperation(String line, FileHeaderCielo fileHeaderCielo) throws Exception {
		FileOperationResumeOutstandingBalanceCielo balance = new FileOperationResumeOutstandingBalanceCielo();
		
		Pattern search = Pattern.compile("^(\\d{1})(\\d{10})(\\d{7})(\\d{6})(.{10})(.{21})(\\d{3})(\\d{3})(\\d{8})(\\d{8})(\\d{8})(\\d{8})([\\+\\-]{1})(\\d{15})([\\+\\-]{1})(\\d{15})([\\+\\-]{1})(\\d{15})([\\+\\-]{1})(\\d{15})([\\+\\-]{1})(\\d{15})(.{1})(.{1})(.{2})(.{2})([\\+\\-]{1})(\\d{15})(\\d{3})([\\+\\-]{1})(\\d{15})(\\d{22})");
	    Matcher matcher = search.matcher(line);
		
		if(!matcher.find()) throw new Exception("Dados não correnpondem ao padrão especificado!");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		balance.setHeader(fileHeaderCielo);
		balance.setEstablishmentNumber(matcher.group(2));
		balance.setOperationResumeLotNumber(matcher.group(3));
		balance.setReferenceDate(new SimpleDateFormat("MMyyyy").parse(matcher.group(4)));
		balance.setPlatformType(matcher.group(5).trim());
		balance.setReleaseType(matcher.group(6).trim().isEmpty() ? null : matcher.group(6).trim());
		balance.setCardFlagId(Integer.parseInt(matcher.group(7)));
		balance.setSalesReceiptSize(Integer.parseInt(matcher.group(8)));
		balance.setTransferDate(dateFormat.parse(matcher.group(9)));
		balance.setCatchDate((matcher.group(10).trim().isEmpty() || Integer.parseInt(matcher.group(10))==0) ? null : dateFormat.parse(matcher.group(10)));
		balance.setPaymentForecastDate(dateFormat.parse(matcher.group(11)));
		balance.setPaymentDate((matcher.group(12).trim().isEmpty() || Integer.parseInt(matcher.group(12))==0) ? null : dateFormat.parse(matcher.group(12)));	
		balance.setGrossValue((Double.parseDouble(matcher.group(14)) / (double)100) * (matcher.group(13).equals("-")?-1:1));
		balance.setNetValue((Double.parseDouble(matcher.group(16)) / (double)100) * (matcher.group(15).equals("-")?-1:1));
		balance.setAnticipatedValue((Double.parseDouble(matcher.group(18)) / (double)100) * (matcher.group(17).equals("-")?-1:1));
		balance.setToCompensateValue((Double.parseDouble(matcher.group(20)) / (double)100) * (matcher.group(19).equals("-")?-1:1));
		balance.setCededValue((Double.parseDouble(matcher.group(22)) / (double)100) * (matcher.group(21).equals("-")?-1:1));
		balance.setCurrency(matcher.group(23));
		balance.setCededIndicator(matcher.group(24).trim().isEmpty() ? null : matcher.group(24));
		balance.setPaymentSplitSize(Integer.parseInt(matcher.group(25)));
		balance.setPaymentPendingParcelsSize(Integer.parseInt(matcher.group(26)));
		balance.setNegotiatedValue((Double.parseDouble(matcher.group(28)) / (double)100) * (matcher.group(27).equals("-")?-1:1));
		balance.setNegotiatedParcelsSize(Integer.parseInt(matcher.group(29)));
		balance.setPendingPaymentValue((Double.parseDouble(matcher.group(31)) / (double)100) * (matcher.group(30).equals("-")?-1:1));
		balance.setOperationResumeNumber(matcher.group(32));
		
		if(!dao.exists(balance)){
			dao.create(balance);
		}else{
			balance = dao.select(balance);
		}
		
		return balance;
	}

}
