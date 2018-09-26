package tn.esprit.cga.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity

public class Address implements Serializable {

	
	private static final long serialVersionUID = 1L;

	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String address;
	private String city;
	private String government;
	private Integer postalCode;
   
	@OneToOne
	private Insured insured;

	public Address(){}
	public Address(String address, String city, String government, Integer postalCode) {
		super();
		this.address = address;
		this.city = city;
		this.government = government;
		this.postalCode = postalCode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGovernment() {
		return government;
	}
	public void setGovernment(String government) {
		this.government = government;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	
	
}
