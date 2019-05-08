/**
 * Caracteristica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serveiWebSOAP;

public class Caracteristica  implements java.io.Serializable {
    private java.lang.String clau;

    private java.lang.String idioma;

    private java.lang.String nivell;

    private java.lang.String nomCaracteristica;

    private java.lang.String tipo;

    private java.lang.String valor;

    public Caracteristica() {
    }

    public Caracteristica(
           java.lang.String clau,
           java.lang.String idioma,
           java.lang.String nivell,
           java.lang.String nomCaracteristica,
           java.lang.String tipo,
           java.lang.String valor) {
           this.clau = clau;
           this.idioma = idioma;
           this.nivell = nivell;
           this.nomCaracteristica = nomCaracteristica;
           this.tipo = tipo;
           this.valor = valor;
    }


    /**
     * Gets the clau value for this Caracteristica.
     * 
     * @return clau
     */
    public java.lang.String getClau() {
        return clau;
    }


    /**
     * Sets the clau value for this Caracteristica.
     * 
     * @param clau
     */
    public void setClau(java.lang.String clau) {
        this.clau = clau;
    }


    /**
     * Gets the idioma value for this Caracteristica.
     * 
     * @return idioma
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this Caracteristica.
     * 
     * @param idioma
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the nivell value for this Caracteristica.
     * 
     * @return nivell
     */
    public java.lang.String getNivell() {
        return nivell;
    }


    /**
     * Sets the nivell value for this Caracteristica.
     * 
     * @param nivell
     */
    public void setNivell(java.lang.String nivell) {
        this.nivell = nivell;
    }


    /**
     * Gets the nomCaracteristica value for this Caracteristica.
     * 
     * @return nomCaracteristica
     */
    public java.lang.String getNomCaracteristica() {
        return nomCaracteristica;
    }


    /**
     * Sets the nomCaracteristica value for this Caracteristica.
     * 
     * @param nomCaracteristica
     */
    public void setNomCaracteristica(java.lang.String nomCaracteristica) {
        this.nomCaracteristica = nomCaracteristica;
    }


    /**
     * Gets the tipo value for this Caracteristica.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this Caracteristica.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the valor value for this Caracteristica.
     * 
     * @return valor
     */
    public java.lang.String getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this Caracteristica.
     * 
     * @param valor
     */
    public void setValor(java.lang.String valor) {
        this.valor = valor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Caracteristica)) return false;
        Caracteristica other = (Caracteristica) obj;
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
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.nivell==null && other.getNivell()==null) || 
             (this.nivell!=null &&
              this.nivell.equals(other.getNivell()))) &&
            ((this.nomCaracteristica==null && other.getNomCaracteristica()==null) || 
             (this.nomCaracteristica!=null &&
              this.nomCaracteristica.equals(other.getNomCaracteristica()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.valor==null && other.getValor()==null) || 
             (this.valor!=null &&
              this.valor.equals(other.getValor())));
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
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getNivell() != null) {
            _hashCode += getNivell().hashCode();
        }
        if (getNomCaracteristica() != null) {
            _hashCode += getNomCaracteristica().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getValor() != null) {
            _hashCode += getValor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Caracteristica.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://serveiWebSOAP/", "caracteristica"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clau");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clau"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivell");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nivell"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomCaracteristica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomCaracteristica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
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
