package br.com.lucro.manager;

import br.com.lucro.manager.dao.FileHeaderDAO;
import br.com.lucro.manager.util.CdiContext;

public class Main {
	
	public static void main(String[] args) {
		CdiContext context = CdiContext.INSTANCE;
		
		FileHeaderDAO dao = context.getBean(FileHeaderDAO.class);
		
		System.out.println("Hi!");
		
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lucromanager");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		Acquirer acquirer = new Acquirer();
		acquirer.setName("CIELO");
		
		em.persist(acquirer);

		em.getTransaction().commit();

		em.close();
		emf.close();
		*/
	}

}
