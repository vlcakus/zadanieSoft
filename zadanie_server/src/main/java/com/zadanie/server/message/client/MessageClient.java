package com.zadanie.server.message.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import com.zadanie.server.entity.ConnectionsCount;

public final class MessageClient {

	private MessageClient() {
	}

	public static void sendMessage(final ConnectionsCount count,
			final Queue countQueue, final ConnectionFactory factory) throws JMSException {
		Connection connection = null;
		try {
			connection = factory.createConnection("test", "test123");
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Message m = session.createObjectMessage(count);			
			MessageProducer producer = session.createProducer(countQueue);
			connection.start();
			producer.send(m);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
		finally{
			if(connection != null)
				connection.close();
		}

	}

}
