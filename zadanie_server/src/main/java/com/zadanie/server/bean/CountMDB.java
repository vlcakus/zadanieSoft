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
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
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
	
	
	
	/*
	 * (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 * Messge listener, pre dany pripad odchytavanie velkej exception staci,
	 * 
	 */
	@Override
	public void onMessage(Message m) {
		ObjectMessage om = (ObjectMessage) m;		
		try {
			ConnectionsCount cc = (ConnectionsCount) om.getObject();			
			utx.begin();					
			em.persist(cc);		
			utx.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		finally{
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 
		}
		
	}

}
