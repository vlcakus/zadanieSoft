package com.zadanie.server.rest.resources;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class WService {
	
	@WebMethod
	public int addCount(@WebParam(name="count") Integer count, @WebParam(name="ip") String ip ){		
		return 0;
	}
	

}
