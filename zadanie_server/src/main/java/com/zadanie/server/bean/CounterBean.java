package com.zadanie.server.bean;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;

import com.zadanie.server.entity.ConnectionsCount;
import com.zadanie.server.message.client.MessageClient;
import com.zadanie.server.ws.client.WSClient;

@Stateless
public class CounterBean implements CounterEJB {

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory factory;

	@Resource(name = "java:jboss/exported/jms/queue/test")
	private Queue countQueue;	

	@Override
	public void addCount(ConnectionsCount count) {

		if (factory != null && countQueue != null)
			try {
				MessageClient.sendMessage(count, countQueue, factory);
			} catch (JMSException e) {
				throw new RuntimeException("can not send message",e);
			}
		else{
			throw new RuntimeException("Not defined factory or queue");
		}

		if (count != null && count.getIp() != null && count.getCount() != null)
			WSClient.callExtCounter(count.getCount(), count.getIp());

	}

}
