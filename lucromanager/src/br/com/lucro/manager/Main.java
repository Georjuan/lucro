package br.com.lucro.manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import br.com.lucro.manager.service.FileCieloService;
import br.com.lucro.manager.util.CdiContext;
import br.com.lucro.manager.util.Properties;

public class Main {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		CdiContext context = CdiContext.INSTANCE;
		
		FileCieloService service = context.getBean(FileCieloService.class);
		
		String f = Properties.getProperty(Properties.FILES_CIELO_CHARSET);
		System.out.println(f);
		
		
		try {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Welcome LucroManager!");
			System.out.println("\nEnter path files location: ");
			
			String path  = "/media/WINDOWS/Cielo"; // br.readLine().trim();
			
			service.setPath(path);
			service.processFiles();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		System.exit(0);
	}

}
