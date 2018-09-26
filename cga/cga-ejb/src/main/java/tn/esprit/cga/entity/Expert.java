package tn.esprit.cga.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expert
 *
 */
@Entity
@DiscriminatorValue("expert")
public class Expert extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String expertiseLevel;
	private String phoneNumber;
	
	public Expert(){}

	public Expert(String lastName, String firstName, String password,String email, String role, String expertiseLevel,
			String phoneNumber) {
		super(lastName, firstName, password,email, role);
		this.expertiseLevel = expertiseLevel;
		this.phoneNumber = phoneNumber;
	}

	@OneToMany
	private List<Claim> claims;

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public String getExpertiseLevel() {
		return expertiseLevel;
	}

	public void setExpertiseLevel(String expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
   
}
