/**
 * Formulari.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serveiWebSOAP;

public class Formulari  implements java.io.Serializable {
    private serveiWebSOAP.Caracteristica[] caracteristiques;

    private java.lang.String codiTipoLocal;

    private java.lang.String idioma;

    public Formulari() {
    }

    public Formulari(
           serveiWebSOAP.Caracteristica[] caracteristiques,
           java.lang.String codiTipoLocal,
           java.lang.String idioma) {
           this.caracteristiques = caracteristiques;
           this.codiTipoLocal = codiTipoLocal;
           this.idioma = idioma;
    }


    /**
     * Gets the caracteristiques value for this Formulari.
     * 
     * @return caracteristiques
     */
    public serveiWebSOAP.Caracteristica[] getCaracteristiques() {
        return caracteristiques;
    }


    /**
     * Sets the caracteristiques value for this Formulari.
     * 
     * @param caracteristiques
     */
    public void setCaracteristiques(serveiWebSOAP.Caracteristica[] caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public serveiWebSOAP.Caracteristica getCaracteristiques(int i) {
        return this.caracteristiques[i];
    }

    public void setCaracteristiques(int i, serveiWebSOAP.Caracteristica _value) {
        this.caracteristiques[i] = _value;
    }


    /**
     * Gets the codiTipoLocal value for this Formulari.
     * 
     * @return codiTipoLocal
     */
    public java.lang.String getCodiTipoLocal() {
        return codiTipoLocal;
    }


    /**
     * Sets the codiTipoLocal value for this Formulari.
     * 
     * @param codiTipoLocal
     */
    public void setCodiTipoLocal(java.lang.String codiTipoLocal) {
        this.codiTipoLocal = codiTipoLocal;
    }


    /**
     * Gets the idioma value for this Formulari.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this Formulari.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Formulari)) return false;
        Formulari other = (Formulari) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.caracteristiques==null && other.getCaracteristiques()==null) || 
             (this.caracteristiques!=null &&
              java.util.Arrays.equals(this.caracteristiques, other.getCaracteristiques()))) &&
            ((this.codiTipoLocal==null && other.getCodiTipoLocal()==null) || 
             (this.codiTipoLocal!=null &&
              this.codiTipoLocal.equals(other.getCodiTipoLocal()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma())));
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
        if (getCaracteristiques() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCaracteristiques());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCaracteristiques(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodiTipoLocal() != null) {
            _hashCode += getCodiTipoLocal().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Formulari.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://serveiWebSOAP/", "formulari"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caracteristiques");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caracteristiques"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://serveiWebSOAP/", "caracteristica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiTipoLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiTipoLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idioma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idioma"));
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
