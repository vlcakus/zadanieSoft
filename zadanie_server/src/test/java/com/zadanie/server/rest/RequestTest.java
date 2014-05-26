package com.zadanie.server.rest;

import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.zadanie.server.bean.CountMDB;
import com.zadanie.server.bean.CounterBean;
import com.zadanie.server.bean.CounterEJB;
import com.zadanie.server.entity.ConnectionsCount;
import com.zadanie.server.message.client.MessageClient;
import com.zadanie.server.rest.resources.CountResource;
import com.zadanie.server.rest.webapp.ApplicationConfig;
import com.zadanie.server.ws.client.AddCount;
import com.zadanie.server.ws.client.WSClient;

@RunWith(Arquillian.class)
public class RequestTest {

	private static final String URL = "http://localhost:8080/test/resources/count/add";

	@Deployment
	public static WebArchive createDeployment() {

		// jar pre server
		JavaArchive server = ShrinkWrap
				.create(JavaArchive.class, "server.jar")
				.addClasses(CounterBean.class, CounterEJB.class,
						ConnectionsCount.class, WSClient.class,
						MessageClient.class, CountMDB.class)
				.addPackage(AddCount.class.getPackage());

		// vytvorenie war.
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(CountResource.class, ApplicationConfig.class)
				.addAsLibrary(server)
				.addAsResource("test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@Test
	public void testGetCustomerByIdUsingClientRequest() throws Exception {

		ClientRequest request = new ClientRequest(URL);
		request.accept("application/json");

		String input = "{\"ip\":\"100.26.34.11\",\"count\":250}";
		request.body("application/json", input);
		ClientResponse<String> response = request.post(String.class);
		int status = response.getStatus();		
		assertEquals(204, status);

	}

}
