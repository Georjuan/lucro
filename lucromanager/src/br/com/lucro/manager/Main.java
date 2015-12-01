package br.com.lucro.manager;

import br.com.lucro.manager.dao.DAOManager;
import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileOperationResumeCielo;
import br.com.lucro.manager.service.FileHeaderCieloService;
import br.com.lucro.manager.service.FileOperationResumeCieloService;
import br.com.lucro.manager.util.CdiContext;

public class Main {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CdiContext context = CdiContext.INSTANCE;
		
		FileHeaderCieloService service = context.getBean(FileHeaderCieloService.class);
		FileOperationResumeCieloService service2 = context.getBean(FileOperationResumeCieloService.class);
		
		DAOManager daoManager = null;
		try {			
			daoManager = context.getBean(DAOManager.class);
			daoManager.beginTransaction();
			
			//Header
			String line = "010641350022015082720150827201508270006224CIELO04P                    001                                                                       ";		
			FileHeaderCielo fileHeaderCielo = service.processHeader(line);			
			//
			//Operation resume
			line = "110641350025150825     01150825150826150826+0000000000200-0000000000006+0000000000000+0000000000194034104325000000002192120100000111000000 150826  0000000000000 000000000+000000000000000215237505016259000000000319000000000  38777795011               ";
			FileOperationResumeCielo fileOperationResume = service2.processOperation(line, fileHeaderCielo);
			//
			
			//Commit and close
			daoManager.commitTransaction();		
			daoManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(daoManager!=null) daoManager.rollbackTransaction();
		}		
		
		System.exit(0);
	}

}
