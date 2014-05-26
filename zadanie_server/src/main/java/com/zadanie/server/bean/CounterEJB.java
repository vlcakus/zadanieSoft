package com.zadanie.server.bean;

import javax.ejb.Local;

import com.zadanie.server.entity.ConnectionsCount;

@Local
public interface CounterEJB {
	
	public void addCount(ConnectionsCount count);

}
