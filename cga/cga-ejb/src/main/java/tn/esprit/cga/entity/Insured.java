package tn.esprit.cga.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Insured
 *
 */
@Entity
@DiscriminatorValue("insured")

public class Insured extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int driverLicenseNumber;
	private Date delivredIn;
	private String cin1;
	private String cin2;
	@OneToOne(mappedBy="insured",targetEntity=Address.class)
	private Address address;
	
	@OneToMany(mappedBy="insured",targetEntity=Report.class)
	private List<Report> reports;
	
	@OneToMany(mappedBy="insured",targetEntity=Vehicle.class)
	private List<Vehicle> vehicles;
	
	@OneToMany(mappedBy=("insured"),targetEntity=Claim.class)
	private List<Claim> claims;
	
	@OneToMany(mappedBy="insured",targetEntity=Contract.class)
    private List<Contract> contracts;

	

	public Insured() {
		// TODO Auto-generated constructor stub
	}

	public Insured( String firstName, String lastName, String password,String email, String role,int driverLicenseNumber, Date delivredIn, String cin1, String cin2, Address address) {
		super(lastName, firstName,password, email, role);
		this.driverLicenseNumber = driverLicenseNumber;
		this.delivredIn = delivredIn;
		this.cin1 = cin1;
		this.cin2 = cin2;
		this.address = address;
	}
	
	public Insured( String firstName, String lastName, String password,String email,String role,int driverLicenseNumber ,int id) {
		super(lastName, firstName,password, email, role);
		this.id=id;
		this.driverLicenseNumber=driverLicenseNumber;
	}


	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public int getDriverLicenseNumber() {
		return driverLicenseNumber;
	}

	public void setDriverLicenseNumber(int driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}

	public Date getDelivredIn() {
		return delivredIn;
	}

	public void setDelivredIn(Date delivredIn) {
		this.delivredIn = delivredIn;
	}

	public String getCin1() {
		return cin1;
	}

	public void setCin1(String cin1) {
		this.cin1 = cin1;
	}

	public String getCin2() {
		return cin2;
	}

	public void setCin2(String cin2) {
		this.cin2 = cin2;
	}

	public Address getAddress() {
		if(address==null){
			address = new Address();
		}
		
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    
	
	
	
	
	
	
	
   
}
