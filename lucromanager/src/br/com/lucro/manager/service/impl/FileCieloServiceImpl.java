/**
 * 
 */
package br.com.lucro.manager.service.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.Charset;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.google.common.io.Files;

import br.com.lucro.manager.dao.DAOManager;
import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileOperationResumeCielo;
import br.com.lucro.manager.model.FileOperationResumeOutstandingBalanceCielo;
import br.com.lucro.manager.model.FileOutstandingBalanceByFlagCielo;
import br.com.lucro.manager.model.FileSalesReceiptCielo;
import br.com.lucro.manager.service.FileCieloService;
import br.com.lucro.manager.service.FileHeaderCieloService;
import br.com.lucro.manager.service.FileOperationResumeCieloService;
import br.com.lucro.manager.service.FileOperationResumeOutstandingBalanceCieloService;
import br.com.lucro.manager.service.FileOutstandingBalanceByFlagCieloService;
import br.com.lucro.manager.service.FileSalesReceiptCieloService;
import br.com.lucro.manager.util.Properties;

/**
 * @author "Georjuan Taylor"
 *
 */
public class FileCieloServiceImpl implements FileCieloService {

	private static final Logger logger = Logger.getLogger(FileCieloServiceImpl.class);
	
	//Path to directory where are the Cielo files
	private String path;
	
	//DAO manager
	@Inject
	private DAOManager daoManager;
	
	//Process file header
	@Inject
	private FileHeaderCieloService serviceFileHeader;	
	
	//Process Operation Resume data
	@Inject
	private FileOperationResumeCieloService serviceFileOperationResume;	
	
	//Process Operation Resume Outstanding Balance data
	@Inject
	private FileOperationResumeOutstandingBalanceCieloService serviceFileOperationResumeOutstandingBalance;
	
	//Process Outstanding Balance by card flag data
	@Inject
	private FileOutstandingBalanceByFlagCieloService serviceOutstandingBalanceByFlag;
		
	//Process Sales Receipt data
	@Inject
	private FileSalesReceiptCieloService serviceSalesReceipt;
	
	/* (non-Javadoc)
	 * @see br.com.lucro.manager.service.FileCieloService#setPath(java.lang.String)
	 */
	@Override
	public void setPath(String path) throws Exception {
		File filePath = new File(path);
		
		if(!filePath.exists()) throw new Exception("Path files not found!");
		
		if(!(filePath.canRead() && filePath.canWrite())) throw new Exception("Not allowed to read/write in the specified path!");
		
		this.path = filePath.getAbsolutePath();
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.service.FileCieloService#processFiles()
	 */
	@Override
	public void processFiles() throws Exception {
		
		//Find files
		//*****************************************************************************************************
				
		File directory = new File(this.path);

		logger.info(String.format("Loading files in directory [%s]...", directory.getAbsolutePath()));
		
    	File[] txtFiles = directory.listFiles(new FilenameFilter() {			
			@Override
			public boolean accept(File dir, String filename) {
				return filename.toLowerCase().endsWith(".txt");
			}
		});
    	
    	logger.info(String.format("Found %d files to process.", txtFiles.length));
    	
    	//Loop over each file and process the content
		//*****************************************************************************************************
    	
    	for(File txtFile : txtFiles){
    		
    		try{
    		
	    		logger.info(String.format("\nProcessing file [%s]...", txtFile.getAbsoluteFile()));	
	    		
	    		//Each line from the file
	    		List<String> lines = Files.readLines(txtFile, Charset.forName(Properties.getProperty(Properties.FILES_CIELO_CHARSET)));
	    		
	    		//Full file content
	    		String fileContent = String.join("\n", lines);
	    		
	    		logger.debug(String.format("Found %d lines", lines.size()));
	    		
	    		//Open transaction to start save data in database
	    		daoManager.beginTransaction();
	    		
	    		//File header
	    		FileHeaderCielo fileHeader = null;
	    		
	    		//Loop over each file line
	    		for(String line : lines){
	    			
	    			//Ignore empty lines
	    			if(line.trim().isEmpty()) return;
	    			
	    			logger.debug(String.format("Processing content [%s]...", line));					
					
	    			//The first char in the line says the content type
	    			switch (line.charAt(0)) {
	    				case '0':					
	    					{
	    						logger.debug(String.format("**HEADER**"));
	    						fileHeader = processHeader(line, fileContent);
	    					}
	    					break;
	    				case '1':					
	    					{
	    						logger.debug(String.format("**OPERATION RESUME**"));
	    						processOperationResume(line, fileHeader);
	    					}
	    				break;
	    				case '2':					
	    					{
	    						logger.debug(String.format("**SALES RECEIPT**"));
	    						processSalesReceipt(line, fileHeader);
	    					}
	    				break;
	    				case '3':					
	    					{
	    						logger.debug(String.format("**OPERATION RESUME OUTSTANDING BALANCE**"));
	    						processOperationResumeOutstandingBalance(line, fileHeader);
	    					}
    					break;
	    				case '4':					
	    					{
	    						logger.debug(String.format("**OUTSTANDING BALANCE BY FLAG**"));
	    						processOutstandingBalanceByFlag(line, fileHeader);
	    					}
						break;
	    				case '9':					
	    					{
	    						logger.debug(String.format("**EOF**"));
	    						//End of file
	    						processEOF(line, fileHeader);
	    						//Finish file
	    						fileHeader = null;
	    					}
	    				break;
	    				default:
	    					{
	    						logger.error(String.format("Register type [%d] unknown!\nFile process canceled!"));
	    						throw new Exception("Unknown register type!");
	    					}	    					
	    			}
					
					logger.debug(String.format("Processed!"));
					
	    		}
	    	
	    		//Commit transaction (file full processed)
	    		daoManager.commitTransaction();
	    		
	    		logger.info(String.format("File processed in success!\n"));
	    		
	    		//Remove file
	    		if(!txtFile.delete()){
	    			logger.info(String.format("Could not remove the file: %s\n", txtFile.getAbsolutePath()));
	    		}
	    		
    		}catch(Exception e){
    			//Log error
    			logger.error(e.getMessage(), e);    			
    			//Process error, cancel process
    			daoManager.rollbackTransaction();   
    			//Log error
    			logger.error("File process canceled! Moving to next file...");
    		}

    	}
    	
    	logger.info(String.format("All files processed in success!\n"));
    	
    	//Close connection
		daoManager.close();		
	}
	
	/**
	 * Process file Header line
	 * @param line
	 */
	private FileHeaderCielo processHeader(String line, String file) throws Exception {
		if(line == null || line.trim().isEmpty()) throw new Exception("Line content is invalid!");
		
		FileHeaderCielo fileHeader = serviceFileHeader.processHeader(line, file);
		
		return fileHeader;
	}
	
	/**
	 * Process file Operation Resume line
	 * @param line
	 */
	private FileOperationResumeCielo processOperationResume(String line, FileHeaderCielo fileHeader) throws Exception {
		if(line == null || line.trim().isEmpty()) throw new Exception("Line content is invalid!");
		
		if(fileHeader == null || fileHeader.getId()==null || fileHeader.getId().longValue() <= 0) throw new Exception("Header file is invalid!");
		
		FileOperationResumeCielo operationResume = serviceFileOperationResume.processOperation(line, fileHeader);
		
		return operationResume;
	}
	
	/**
	 * Process file Sales Receipt line
	 * @param line
	 */
	private FileSalesReceiptCielo processSalesReceipt(String line, FileHeaderCielo fileHeader) throws Exception {
		if(line == null || line.trim().isEmpty()) throw new Exception("Line content is invalid!");
		
		if(fileHeader == null || fileHeader.getId()==null || fileHeader.getId().longValue() <= 0) throw new Exception("Header file is invalid!");
		
		FileSalesReceiptCielo salesReceipt = serviceSalesReceipt.processReceipt(line, fileHeader);
		
		return salesReceipt;				
	}
	
	/**
	 * Process file Operation Resume Outstanding Balance line
	 * @param line
	 */
	private FileOperationResumeOutstandingBalanceCielo processOperationResumeOutstandingBalance(String line, FileHeaderCielo fileHeader) throws Exception {
		if(line == null || line.trim().isEmpty()) throw new Exception("Line content is invalid!");
		
		if(fileHeader == null || fileHeader.getId()==null || fileHeader.getId().longValue() <= 0) throw new Exception("Header file is invalid!");
		
		FileOperationResumeOutstandingBalanceCielo outstandingBalance = serviceFileOperationResumeOutstandingBalance.processOperation(line, fileHeader);
		
		return outstandingBalance;				
	}
	
	/**
	 * Process file Outstanding Balance By Flag line
	 * @param line
	 */
	private FileOutstandingBalanceByFlagCielo processOutstandingBalanceByFlag(String line, FileHeaderCielo fileHeader) throws Exception {
		if(line == null || line.trim().isEmpty()) throw new Exception("Line content is invalid!");
		
		if(fileHeader == null || fileHeader.getId()==null || fileHeader.getId().longValue() <= 0) throw new Exception("Header file is invalid!");
		
		FileOutstandingBalanceByFlagCielo outstandingBalance = serviceOutstandingBalanceByFlag.processOperation(line, fileHeader);
		
		return outstandingBalance;				
	}
	
	/**
	 * Process End of File
	 * @param line
	 */
	private void processEOF(String line, FileHeaderCielo fileHeader) throws Exception {
		if(line == null || line.trim().isEmpty()) throw new Exception("Line content is invalid!");
		
		if(fileHeader == null || fileHeader.getId()==null || fileHeader.getId().longValue() <= 0) throw new Exception("Header file is invalid!");
		
		//Nothing to do here!
	}

}
