
package com.zadanie.server.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zadanie.server.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCount_QNAME = new QName("http://client.ws.server.zadanie.com/", "addCount");
    private final static QName _AddCountResponse_QNAME = new QName("http://client.ws.server.zadanie.com/", "addCountResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zadanie.server.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCountResponse }
     * 
     */
    public AddCountResponse createAddCountResponse() {
        return new AddCountResponse();
    }

    /**
     * Create an instance of {@link AddCount }
     * 
     */
    public AddCount createAddCount() {
        return new AddCount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.ws.server.zadanie.com/", name = "addCount")
    public JAXBElement<AddCount> createAddCount(AddCount value) {
        return new JAXBElement<AddCount>(_AddCount_QNAME, AddCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.ws.server.zadanie.com/", name = "addCountResponse")
    public JAXBElement<AddCountResponse> createAddCountResponse(AddCountResponse value) {
        return new JAXBElement<AddCountResponse>(_AddCountResponse_QNAME, AddCountResponse.class, null, value);
    }

}
