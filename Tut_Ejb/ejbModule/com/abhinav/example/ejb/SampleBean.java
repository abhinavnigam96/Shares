package com.abhinav.example.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.abhinav.entity.Actor;

/**
 * Session Bean implementation class SampleBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SampleBean implements SampleBeanLocal {
	@PersistenceContext(unitName = "tut_PU")
	private EntityManager entityManager;

	public SampleBean() {
		// TODO Auto-generated constructor stub
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String getHelloEjb(String name) {
		// TODO Auto-generated method stub

		Actor actor = new Actor();
		actor.setFirstName(name);
		actor.setLastName(name);

		entityManager.persist(actor);
		return "hello" + name;
	}

}
