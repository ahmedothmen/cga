package tn.esprit.cga.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: InsuranceAgent
 *
 */
@Entity
@DiscriminatorValue("insuranceAgent")
public class InsuranceAgent extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	
	@OneToMany
	private List<Endorsement> endorsements;
	@OneToMany
	private List<VehiclesATTT> vehiclesA3T;
	@OneToMany
	private List<VehiclesWreck> vehiclesWreck;
	@OneToMany
	private List<Policy> policies;
	@OneToMany
	private List<Claim> claims ;
	@OneToOne
	private Insurance insurance;
	public List<Endorsement> getEndorsements() {
		return endorsements;
	}
	public void setEndorsements(List<Endorsement> endorsements) {
		this.endorsements = endorsements;
	}
	public List<VehiclesATTT> getVehiclesA3T() {
		return vehiclesA3T;
	}
	public void setVehiclesA3T(List<VehiclesATTT> vehiclesA3T) {
		this.vehiclesA3T = vehiclesA3T;
	}
	public List<VehiclesWreck> getVehiclesWreck() {
		return vehiclesWreck;
	}
	public void setVehiclesWreck(List<VehiclesWreck> vehiclesWreck) {
		this.vehiclesWreck = vehiclesWreck;
	}
	public List<Policy> getPolicies() {
		return policies;
	}
	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	
   
}
