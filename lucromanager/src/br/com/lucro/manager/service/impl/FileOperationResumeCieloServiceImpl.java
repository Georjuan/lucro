/**
 * 
 */
package br.com.lucro.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import br.com.lucro.manager.dao.FileOperationResumeCieloDAO;
import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileOperationResumeCielo;
import br.com.lucro.manager.service.FileOperationResumeCieloService;

/**
 * @author "Georjuan Taylor"
 *
 */
public class FileOperationResumeCieloServiceImpl implements FileOperationResumeCieloService {

	@Inject
	private FileOperationResumeCieloDAO dao;
	
	/* (non-Javadoc)
	 * @see br.com.lucro.manager.service.FileOperationResumeCieloService#processOperation(java.lang.String)
	 */
	@Override
	public FileOperationResumeCielo processOperation(String line, FileHeaderCielo fileHeaderCielo) throws Exception {
		FileOperationResumeCielo operationResume = new FileOperationResumeCielo();
		
		Pattern search = Pattern.compile("^(\\d{1})(\\d{10})(\\d{7})(.{2})(.{1})(.{2})(\\d{2})(\\d{6})(\\d{6})(\\d{6})([\\+\\-]{1})(\\d{13})([\\+\\-]{1})(\\d{13})([\\+\\-]{1})(\\d{13})([\\+\\-]{1})(\\d{13})(\\d{4})(\\d{5})(.{14})(\\d{2})(\\d{6})(\\d{2})(\\d{6})(.{1})(\\d{6})(.{2})(\\d{13})(.{1})(\\d{9})([\\+\\-]{1})(\\d{13})(\\d{3})(\\d{22})(\\d{4})(\\d{5})(\\d{4})(.{2})(.{8})(\\d{3})");
	    Matcher matcher = search.matcher(line);
		
		if(!matcher.find()) throw new Exception("Dados não correnpondem ao padrão especificado!");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		
		operationResume.setEstablishmentNumber(matcher.group(2));
		operationResume.setFinancialOperationNumber(matcher.group(3));
		operationResume.setParcel(matcher.group(4).trim().isEmpty() ? null : Integer.parseInt(matcher.group(4)));
		operationResume.setFiller(matcher.group(5).trim().isEmpty() ? null : matcher.group(5));
		operationResume.setPlan(matcher.group(6).trim().isEmpty() ? null : matcher.group(6));
		operationResume.setTypeTransactionId(Integer.parseInt(matcher.group(7)));		
		operationResume.setTransferDate(dateFormat.parse(matcher.group(8)));
		operationResume.setPaymentForecastDate(dateFormat.parse(matcher.group(9)));
		operationResume.setSentBankDate(dateFormat.parse(matcher.group(10)));		
		operationResume.setGrossValue((Double.parseDouble(matcher.group(12)) / (double)100) * (matcher.group(11).equals("-")?-1:1));
		operationResume.setFeeValue((Double.parseDouble(matcher.group(14)) / (double)100) * (matcher.group(13).equals("-")?-1:1));
		operationResume.setRejectedValue((Double.parseDouble(matcher.group(16)) / (double)100) * (matcher.group(15).equals("-")?-1:1));
		operationResume.setNetValue((Double.parseDouble(matcher.group(18)) / (double)100) * (matcher.group(17).equals("-")?-1:1));
		operationResume.setBankPayment(matcher.group(19));
		operationResume.setBankAgencyPayment(matcher.group(20));
		operationResume.setBankAccountPayment(matcher.group(21));
		operationResume.setPaymentStatusId(Integer.parseInt(matcher.group(22)));
		operationResume.setAcceptedSales(Integer.parseInt(matcher.group(23)));
		operationResume.setRejectedSales(Integer.parseInt(matcher.group(25)));
		operationResume.setResaleAccelerationIndicator(matcher.group(26).trim().isEmpty() ? null : matcher.group(26));
		operationResume.setCatchTransactionDate(dateFormat.parse(matcher.group(27)));
		operationResume.setAdjustmentSourceId(matcher.group(28).trim().isEmpty() ? null : Integer.parseInt(matcher.group(28)));
		operationResume.setComplementaryValue(Double.valueOf(matcher.group(29)) / (double)100);
		operationResume.setFinancialProductIdentifier(matcher.group(30).trim().isEmpty() ? null : matcher.group(30));
		operationResume.setFinancialOperationNumber(matcher.group(31));
		operationResume.setAnticipatedGrossValue((Double.valueOf(matcher.group(33)) / (double)100) * (matcher.group(32).equals("-")?-1:1));
		operationResume.setCardFlagId(Integer.parseInt(matcher.group(34)));
		operationResume.setOperationResumeNumber(matcher.group(35));
		operationResume.setFeePercent(Double.valueOf(matcher.group(36)) / (double)100);
		operationResume.setTransactionFeeValue(Double.valueOf(matcher.group(37)) / (double)100);
		operationResume.setWarrantyFeeValue(Double.valueOf(matcher.group(38)) / (double)100);
		operationResume.setCatchMethodId(matcher.group(39).trim().isEmpty() ? null : Integer.parseInt(matcher.group(39)));
		operationResume.setTerminalNumber(matcher.group(40));
		operationResume.setProductId(Integer.parseInt(matcher.group(41)));
		operationResume.setHeader(fileHeaderCielo);
				
		if(!dao.exists(operationResume)) dao.create(operationResume);
		
		return operationResume;
	}

}
