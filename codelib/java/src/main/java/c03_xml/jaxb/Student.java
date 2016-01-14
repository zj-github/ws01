package c03_xml.jaxb;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Root")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8317239764136972094L;

	private String name;

	private String country;
	
	private String birthDate;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
}