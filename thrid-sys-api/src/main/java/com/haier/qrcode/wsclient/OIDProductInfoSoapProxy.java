package com.haier.qrcode.wsclient;

public class OIDProductInfoSoapProxy implements OIDProductInfoSoap {
  private String _endpoint = null;
  private OIDProductInfoSoap oIDProductInfoSoap = null;
  
  public OIDProductInfoSoapProxy() {
    _initOIDProductInfoSoapProxy();
  }
  
  public OIDProductInfoSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initOIDProductInfoSoapProxy();
  }
  
  private void _initOIDProductInfoSoapProxy() {
    try {
      oIDProductInfoSoap = (new OIDProductInfoLocator()).getOIDProductInfoSoap();
      if (oIDProductInfoSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)oIDProductInfoSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)oIDProductInfoSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (oIDProductInfoSoap != null)
      ((javax.xml.rpc.Stub)oIDProductInfoSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public OIDProductInfoSoap getOIDProductInfoSoap() {
    if (oIDProductInfoSoap == null)
      _initOIDProductInfoSoapProxy();
    return oIDProductInfoSoap;
  }
  
  public String getProductInfo(String userName, String pwd, String oidContent) throws java.rmi.RemoteException{
    if (oIDProductInfoSoap == null)
      _initOIDProductInfoSoapProxy();
    return oIDProductInfoSoap.getProductInfo(userName, pwd, oidContent);
  }
  
  
}