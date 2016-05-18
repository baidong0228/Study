/**
 * SayHelloServiceService.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.test.webservice.client;


public interface SayHelloServiceService extends javax.xml.rpc.Service {
    public java.lang.String getSayHelloServicePortAddress();

    public com.test.webservice.client.SayHelloService getSayHelloServicePort() throws javax.xml.rpc.ServiceException;

    public com.test.webservice.client.SayHelloService getSayHelloServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
