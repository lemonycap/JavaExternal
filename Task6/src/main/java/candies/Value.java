//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.20 at 12:05:34 PM MSK 
//


package candies;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Value complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Value">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="protein" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="carb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Value", propOrder = {
    "protein",
    "fat",
    "carb"
})
public class Value {

    @XmlElement(required = true)
    protected String protein;
    @XmlElement(required = true)
    protected String fat;
    @XmlElement(required = true)
    protected String carb;

    /**
     * Gets the value of the protein property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtein() {
        return protein;
    }

    /**
     * Sets the value of the protein property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtein(String value) {
        this.protein = value;
    }

    /**
     * Gets the value of the fat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFat() {
        return fat;
    }

    /**
     * Sets the value of the fat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFat(String value) {
        this.fat = value;
    }

    /**
     * Gets the value of the carb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarb() {
        return carb;
    }

    /**
     * Sets the value of the carb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarb(String value) {
        this.carb = value;
    }

}
