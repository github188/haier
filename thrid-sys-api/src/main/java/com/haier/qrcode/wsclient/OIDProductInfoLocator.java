/**
 * OIDProductInfoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.haier.qrcode.wsclient;

public class OIDProductInfoLocator extends org.apache.axis.client.Service implements OIDProductInfo {

    public OIDProductInfoLocator() {
    }


    public OIDProductInfoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OIDProductInfoLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OIDProductInfoSoap
    private String OIDProductInfoSoap_address = "http://oid.haier.com/OIDProductInfo.asmx";

    public String getOIDProductInfoSoapAddress() {
        return OIDProductInfoSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String OIDProductInfoSoapWSDDServiceName = "OIDProductInfoSoap";

    public String getOIDProductInfoSoapWSDDServiceName() {
        return OIDProductInfoSoapWSDDServiceName;
    }

    public void setOIDProductInfoSoapWSDDServiceName(String name) {
        OIDProductInfoSoapWSDDServiceName = name;
    }

    public OIDProductInfoSoap getOIDProductInfoSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OIDProductInfoSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOIDProductInfoSoap(endpoint);
    }

    public OIDProductInfoSoap getOIDProductInfoSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            OIDProductInfoSoapStub _stub = new OIDProductInfoSoapStub(portAddress, this);
            _stub.setPortName(getOIDProductInfoSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOIDProductInfoSoapEndpointAddress(String address) {
        OIDProductInfoSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (OIDProductInfoSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                OIDProductInfoSoapStub _stub = new OIDProductInfoSoapStub(new java.net.URL(OIDProductInfoSoap_address), this);
                _stub.setPortName(getOIDProductInfoSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("OIDProductInfoSoap".equals(inputPortName)) {
            return getOIDProductInfoSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "OIDProductInfo");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "OIDProductInfoSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("OIDProductInfoSoap".equals(portName)) {
            setOIDProductInfoSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
