package br.com.lucro.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.lucro.manager.model.Acquirer;

public class Main {

	public static void main(String[] args) {
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lucromanager");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		Acquirer acquirer = new Acquirer();
		acquirer.setName("CIELO");
		
		em.persist(acquirer);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
