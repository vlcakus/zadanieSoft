package com.zadanie.server.bean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.zadanie.server.entity.ConnectionsCount;


@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })

public class CountMDB implements MessageListener {
	
	
	@PersistenceContext
    EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Override
	public void onMessage(Message m) {
		ObjectMessage om = (ObjectMessage) m;		
		try {
			ConnectionsCount cc = (ConnectionsCount) om.getObject();
			em.persist(cc);			
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
		
		
	}

}
