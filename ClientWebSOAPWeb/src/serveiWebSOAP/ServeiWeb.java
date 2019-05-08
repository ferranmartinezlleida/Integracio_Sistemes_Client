/**
 * ServeiWeb.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serveiWebSOAP;

public interface ServeiWeb extends java.rmi.Remote {
    public serveiWebSOAP.Local[] getLocalsByVerified(java.lang.String arg0, long arg1) throws java.rmi.RemoteException;
    public boolean baixaLocal(java.lang.String arg0) throws java.rmi.RemoteException;
    public serveiWebSOAP.Formulari getFormulariByLocalType(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean verifyLocal(java.lang.String arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException;
    public serveiWebSOAP.Local getLocalByAdressOrName(java.lang.String arg0, java.lang.String arg1, int arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
    public java.lang.String getVerifiedByNameAddress(java.lang.String arg0, java.lang.String arg1, int arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public serveiWebSOAP.Caracteristica getCaracteristicaByNomCaracteristicaCa(java.lang.String arg0) throws java.rmi.RemoteException;
    public serveiWebSOAP.Caracteristica[] getCaracteristica(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
