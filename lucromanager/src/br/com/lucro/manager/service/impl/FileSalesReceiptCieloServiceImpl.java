/**
 * 
 */
package br.com.lucro.manager.service.impl;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lucro.manager.dao.FileSalesReceiptCieloDAO;
import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileSalesReceiptCielo;
import br.com.lucro.manager.service.FileSalesReceiptCieloService;

/**
 * @author "Georjuan Taylor"
 *
 */
public class FileSalesReceiptCieloServiceImpl implements FileSalesReceiptCieloService {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FileSalesReceiptCieloServiceImpl.class);
	
	@Inject
	private FileSalesReceiptCieloDAO dao;
	
	/* (non-Javadoc)
	 * @see br.com.lucro.manager.service.FileSalesReceiptCieloService#processReceipt(java.lang.String)
	 */
	@Override
	public FileSalesReceiptCielo processReceipt(String line, FileHeaderCielo fileHeaderCielo) throws Exception {
		FileSalesReceiptCielo receipt = new FileSalesReceiptCielo();
		
		Pattern search = Pattern.compile("^(\\d{1})(\\d{10})(\\d{7})(.{19})(\\d{8})([\\+\\-]{1})(\\d{13})(\\d{2})(\\d{2})(.{3})(.{6})(.{20})(.{6})(\\d{13})(\\d{2})(\\d{13})(\\d{13})(\\d{9})(\\d{4})(.{8})(.{2})(.{20})(\\d{6})(.{29})(.{1})");
	    Matcher matcher = search.matcher(line);
		
		if(!matcher.find()) throw new Exception("Dados não correnpondem ao padrão especificado!");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss");
		
		receipt.setEstablishmentNumber(matcher.group(2));
		receipt.setOperationResumeLotNumber(matcher.group(3));
		receipt.setCardNumber(matcher.group(4));
		receipt.setSaleAdjustDate(dateFormat.parse(matcher.group(5)));
		receipt.setPaymentValue((Double.parseDouble(matcher.group(7)) / (double)100) * (matcher.group(6).equals("-")?-1:1));
		receipt.setPaymentSplit(Integer.parseInt(matcher.group(8)));
		receipt.setPaymentSplitSize(Integer.parseInt(matcher.group(9)));
		receipt.setRejectionReasonId(matcher.group(10).trim().isEmpty() ? null : Integer.parseInt(matcher.group(10)));
		receipt.setAuthorizationCode(matcher.group(11));
		receipt.setTid(matcher.group(12).trim().isEmpty() ? null : matcher.group(12));
		receipt.setNsu(matcher.group(13));
		receipt.setComplementaryValue(Double.valueOf(matcher.group(14)) / (double)100);
		receipt.setCardNumbersSize(Integer.parseInt(matcher.group(15)));
		receipt.setInstallmentsValue(matcher.group(16).trim().isEmpty() ? null : (Double.valueOf(matcher.group(16)) / (double)100));
		receipt.setNextInstallmentValue(matcher.group(17).trim().isEmpty() ? null : (Double.valueOf(matcher.group(17)) / (double)100));
		receipt.setInvoiceNumber(matcher.group(18));
		receipt.setCardOriginId(matcher.group(19).trim().isEmpty() ? null : Integer.parseInt(matcher.group(19)));
		receipt.setTerminalNumber(matcher.group(20));
		receipt.setIdentifierDepartureTaxInputValue(matcher.group(21).trim().isEmpty() ? null : matcher.group(21));
		receipt.setRequestCode(matcher.group(22).trim().isEmpty() ? null : matcher.group(22));
		receipt.setTransactionTime(
					(matcher.group(23).trim().isEmpty() || matcher.group(23).equals("000000")) ? 
					null : 
					new Time(timeFormat.parse(matcher.group(23)).getTime()) 
				);
		receipt.setTransactionNumber(matcher.group(24));
		receipt.setHeader(fileHeaderCielo);
		
		if(!dao.exists(receipt)){
			dao.create(receipt);
		}else{
			receipt = dao.select(receipt);
		}
		
		return receipt;
	}

}
