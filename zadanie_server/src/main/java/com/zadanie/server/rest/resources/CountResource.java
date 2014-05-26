package com.zadanie.server.rest.resources;

import java.util.Date;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.zadanie.server.bean.CounterEJB;
import com.zadanie.server.entity.ConnectionsCount;



@Path("/count")
public class CountResource {
	
	@EJB
    private CounterEJB counterEJB;
	
	@POST
	@Consumes("application/json")
	@Path("/add")
	public void addCount(ConnectionsCount count){
		System.out.println(count.toString());
		
		if(count.getCreationTime() == null){
			count.setCreationTime(new Date());
		}
		
		counterEJB.addCount(count);			
		
	}

}
