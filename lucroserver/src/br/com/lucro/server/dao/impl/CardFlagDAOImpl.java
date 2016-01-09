package br.com.lucro.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.lucro.server.dao.CardFlagDAO;
import br.com.lucro.server.model.CardFlag;
import br.com.lucro.server.model.CardFlag_;

@Repository
public class CardFlagDAOImpl implements CardFlagDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CardFlagDAOImpl.class);
	
	@Autowired
	private DAOManager dao;	
	
	public CardFlagDAOImpl() {
	}

	@Override
	public CardFlag create(CardFlag object) throws Exception {
		return null;
	}

	@Override
	public CardFlag select(CardFlag flag) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<CardFlag> query = criteria.createQuery(CardFlag.class);
		
		Root<CardFlag> root = query.from(CardFlag.class);
		
		query.where(
			criteria.equal(root.get(CardFlag_.id), flag.getId())
		);
		
		List<CardFlag> flags = dao.getEntityManager().createQuery(query).getResultList();
		
		return flags.size() > 0 ? flags.get(0) : null;
	}

	@Override
	public CardFlag update(CardFlag object) throws Exception {
		return null;
	}

	@Override
	public CardFlag delete(CardFlag object) throws Exception {
		return null;
	}

	@Override
	public boolean exists(CardFlag object) throws Exception {
		return false;
	}

	@Override
	public List<CardFlag> selectAll() throws Exception {
		EntityManager entityManager = dao.getEntityManager();
		
		//Get query
		Query query = entityManager.createNamedQuery("CardFlag.findAll", CardFlag.class);
		
		//Run query
		List<?> values = query.getResultList();
		
		List<CardFlag> report = new ArrayList<>();
		for(Object value : values) report.add((CardFlag) value);
		
		return report;
	}

}
