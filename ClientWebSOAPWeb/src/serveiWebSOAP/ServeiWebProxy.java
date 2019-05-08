package serveiWebSOAP;

public class ServeiWebProxy implements serveiWebSOAP.ServeiWeb {
  private String _endpoint = null;
  private serveiWebSOAP.ServeiWeb serveiWeb = null;
  
  public ServeiWebProxy() {
    _initServeiWebProxy();
  }
  
  public ServeiWebProxy(String endpoint) {
    _endpoint = endpoint;
    _initServeiWebProxy();
  }
  
  private void _initServeiWebProxy() {
    try {
      serveiWeb = (new serveiWebSOAP.ServeiWebServiceLocator()).getServeiWebPort();
      if (serveiWeb != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serveiWeb)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serveiWeb)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serveiWeb != null)
      ((javax.xml.rpc.Stub)serveiWeb)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public serveiWebSOAP.ServeiWeb getServeiWeb() {
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb;
  }
  
  public serveiWebSOAP.Local[] getLocalsByVerified(java.lang.String arg0, long arg1) throws java.rmi.RemoteException{
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb.getLocalsByVerified(arg0, arg1);
  }
  
  public boolean baixaLocal(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb.baixaLocal(arg0);
  }
  
  public serveiWebSOAP.Formulari getFormulariByLocalType(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb.getFormulariByLocalType(arg0, arg1);
  }
  
  public boolean verifyLocal(java.lang.String arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException{
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb.verifyLocal(arg0, arg1, arg2);
  }
  
  public serveiWebSOAP.Local getLocalByAdressOrName(java.lang.String arg0, java.lang.String arg1, int arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb.getLocalByAdressOrName(arg0, arg1, arg2, arg3, arg4);
  }
  
  public java.lang.String getVerifiedByNameAddress(java.lang.String arg0, java.lang.String arg1, int arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb.getVerifiedByNameAddress(arg0, arg1, arg2, arg3);
  }
  
  public serveiWebSOAP.Caracteristica getCaracteristicaByNomCaracteristicaCa(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb.getCaracteristicaByNomCaracteristicaCa(arg0);
  }
  
  public serveiWebSOAP.Caracteristica[] getCaracteristica(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (serveiWeb == null)
      _initServeiWebProxy();
    return serveiWeb.getCaracteristica(arg0, arg1);
  }
  
  
}