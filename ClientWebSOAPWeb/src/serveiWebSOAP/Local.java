/**
 * Local.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serveiWebSOAP;

public class Local  implements java.io.Serializable {
    private java.lang.String clau;

    private java.lang.String codiCarrer;

    private java.lang.String codiTipoLocal;

    private serveiWebSOAP.Formulari form;

    private java.lang.String nomCarrer;

    private java.lang.String nomLocal;

    private java.lang.String nomVia;

    private int numero;

    private java.lang.String observacions;

    public Local() {
    }

    public Local(
           java.lang.String clau,
           java.lang.String codiCarrer,
           java.lang.String codiTipoLocal,
           serveiWebSOAP.Formulari form,
           java.lang.String nomCarrer,
           java.lang.String nomLocal,
           java.lang.String nomVia,
           int numero,
           java.lang.String observacions) {
           this.clau = clau;
           this.codiCarrer = codiCarrer;
           this.codiTipoLocal = codiTipoLocal;
           this.form = form;
           this.nomCarrer = nomCarrer;
           this.nomLocal = nomLocal;
           this.nomVia = nomVia;
           this.numero = numero;
           this.observacions = observacions;
    }


    /**
     * Gets the clau value for this Local.
     * 
     * @return clau
     */
    public java.lang.String getClau() {
        return clau;
    }


    /**
     * Sets the clau value for this Local.
     * 
     * @param clau
     */
    public void setClau(java.lang.String clau) {
        this.clau = clau;
    }


    /**
     * Gets the codiCarrer value for this Local.
     * 
     * @return codiCarrer
     */
    public java.lang.String getCodiCarrer() {
        return codiCarrer;
    }


    /**
     * Sets the codiCarrer value for this Local.
     * 
     * @param codiCarrer
     */
    public void setCodiCarrer(java.lang.String codiCarrer) {
        this.codiCarrer = codiCarrer;
    }


    /**
     * Gets the codiTipoLocal value for this Local.
     * 
     * @return codiTipoLocal
     */
    public java.lang.String getCodiTipoLocal() {
        return codiTipoLocal;
    }


    /**
     * Sets the codiTipoLocal value for this Local.
     * 
     * @param codiTipoLocal
     */
    public void setCodiTipoLocal(java.lang.String codiTipoLocal) {
        this.codiTipoLocal = codiTipoLocal;
    }


    /**
     * Gets the form value for this Local.
     * 
     * @return form
     */
    public serveiWebSOAP.Formulari getForm() {
        return form;
    }


    /**
     * Sets the form value for this Local.
     * 
     * @param form
     */
    public void setForm(serveiWebSOAP.Formulari form) {
        this.form = form;
    }


    /**
     * Gets the nomCarrer value for this Local.
     * 
     * @return nomCarrer
     */
    public java.lang.String getNomCarrer() {
        return nomCarrer;
    }


    /**
     * Sets the nomCarrer value for this Local.
     * 
     * @param nomCarrer
     */
    public void setNomCarrer(java.lang.String nomCarrer) {
        this.nomCarrer = nomCarrer;
    }


    /**
     * Gets the nomLocal value for this Local.
     * 
     * @return nomLocal
     */
    public java.lang.String getNomLocal() {
        return nomLocal;
    }


    /**
     * Sets the nomLocal value for this Local.
     * 
     * @param nomLocal
     */
    public void setNomLocal(java.lang.String nomLocal) {
        this.nomLocal = nomLocal;
    }


    /**
     * Gets the nomVia value for this Local.
     * 
     * @return nomVia
     */
    public java.lang.String getNomVia() {
        return nomVia;
    }


    /**
     * Sets the nomVia value for this Local.
     * 
     * @param nomVia
     */
    public void setNomVia(java.lang.String nomVia) {
        this.nomVia = nomVia;
    }


    /**
     * Gets the numero value for this Local.
     * 
     * @return numero
     */
    public int getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this Local.
     * 
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }


    /**
     * Gets the observacions value for this Local.
     * 
     * @return observacions
     */
    public java.lang.String getObservacions() {
        return observacions;
    }


    /**
     * Sets the observacions value for this Local.
     * 
     * @param observacions
     */
    public void setObservacions(java.lang.String observacions) {
        this.observacions = observacions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Local)) return false;
        Local other = (Local) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clau==null && other.getClau()==null) || 
             (this.clau!=null &&
              this.clau.equals(other.getClau()))) &&
            ((this.codiCarrer==null && other.getCodiCarrer()==null) || 
             (this.codiCarrer!=null &&
              this.codiCarrer.equals(other.getCodiCarrer()))) &&
            ((this.codiTipoLocal==null && other.getCodiTipoLocal()==null) || 
             (this.codiTipoLocal!=null &&
              this.codiTipoLocal.equals(other.getCodiTipoLocal()))) &&
            ((this.form==null && other.getForm()==null) || 
             (this.form!=null &&
              this.form.equals(other.getForm()))) &&
            ((this.nomCarrer==null && other.getNomCarrer()==null) || 
             (this.nomCarrer!=null &&
              this.nomCarrer.equals(other.getNomCarrer()))) &&
            ((this.nomLocal==null && other.getNomLocal()==null) || 
             (this.nomLocal!=null &&
              this.nomLocal.equals(other.getNomLocal()))) &&
            ((this.nomVia==null && other.getNomVia()==null) || 
             (this.nomVia!=null &&
              this.nomVia.equals(other.getNomVia()))) &&
            this.numero == other.getNumero() &&
            ((this.observacions==null && other.getObservacions()==null) || 
             (this.observacions!=null &&
              this.observacions.equals(other.getObservacions())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getClau() != null) {
            _hashCode += getClau().hashCode();
        }
        if (getCodiCarrer() != null) {
            _hashCode += getCodiCarrer().hashCode();
        }
        if (getCodiTipoLocal() != null) {
            _hashCode += getCodiTipoLocal().hashCode();
        }
        if (getForm() != null) {
            _hashCode += getForm().hashCode();
        }
        if (getNomCarrer() != null) {
            _hashCode += getNomCarrer().hashCode();
        }
        if (getNomLocal() != null) {
            _hashCode += getNomLocal().hashCode();
        }
        if (getNomVia() != null) {
            _hashCode += getNomVia().hashCode();
        }
        _hashCode += getNumero();
        if (getObservacions() != null) {
            _hashCode += getObservacions().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Local.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://serveiWebSOAP/", "local"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clau");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clau"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiCarrer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiCarrer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiTipoLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiTipoLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("form");
        elemField.setXmlName(new javax.xml.namespace.QName("", "form"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://serveiWebSOAP/", "formulari"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomCarrer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomCarrer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomVia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomVia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observacions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "observacions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
