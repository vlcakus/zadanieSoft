package com.zadanie.server.ws.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

public class WSClient {

	//@WebServiceRef(wsdlLocation = "http://localhost:8088/mockWService?wsdl")
	//private static WServiceService service;

	public static int callExtCounter(int count, String ip) {
		
		
		QName qname = new QName("http://client.ws.server.zadanie.com", "WServiceService");
		WServiceService service = null;
		try {
			service = new WServiceService(new URL("http://localhost:8088/mockWService?wsdl"), qname);
			service.getWServicePort();
			WService wsService = service.getWServicePort();
			return wsService.addCount(count, ip);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
