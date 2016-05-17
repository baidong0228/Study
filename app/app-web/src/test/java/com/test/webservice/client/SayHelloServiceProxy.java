package com.test.webservice.client;


public class SayHelloServiceProxy implements com.test.webservice.client.SayHelloService {
  private String _endpoint = null;
  private com.test.webservice.client.SayHelloService sayHelloService = null;
  
  public SayHelloServiceProxy() {
    _initSayHelloServiceProxy();
  }
  
  public SayHelloServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSayHelloServiceProxy();
  }
  
  private void _initSayHelloServiceProxy() {
    try {
      sayHelloService = (new com.test.webservice.client.SayHelloServiceServiceLocator()).getSayHelloServicePort();
      if (sayHelloService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sayHelloService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sayHelloService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sayHelloService != null)
      ((javax.xml.rpc.Stub)sayHelloService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.test.webservice.client.SayHelloService getSayHelloService() {
    if (sayHelloService == null)
      _initSayHelloServiceProxy();
    return sayHelloService;
  }
  
  public java.lang.String getValue(java.lang.String arg0) throws java.rmi.RemoteException{
    if (sayHelloService == null)
      _initSayHelloServiceProxy();
    return sayHelloService.getValue(arg0);
  }
  
  
}