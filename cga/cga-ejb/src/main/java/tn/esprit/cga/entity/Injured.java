package tn.esprit.cga.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Injured
 *
 */
@Entity

public class Injured implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String profession;
	private String  kinshipWithTheVictimOrTheDriverDegree;
	private String injuriesNatureAndSeverity;
	private String SituationAtTheTomeOfTheAccident;
	private String whereFirstCareOrHospitalizationHaveBeenDone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getKinshipWithTheVictimOrTheDriverDegree() {
		return kinshipWithTheVictimOrTheDriverDegree;
	}
	public void setKinshipWithTheVictimOrTheDriverDegree(String kinshipWithTheVictimOrTheDriverDegree) {
		this.kinshipWithTheVictimOrTheDriverDegree = kinshipWithTheVictimOrTheDriverDegree;
	}
	public String getInjuriesNatureAndSeverity() {
		return injuriesNatureAndSeverity;
	}
	public void setInjuriesNatureAndSeverity(String injuriesNatureAndSeverity) {
		this.injuriesNatureAndSeverity = injuriesNatureAndSeverity;
	}
	public String getSituationAtTheTomeOfTheAccident() {
		return SituationAtTheTomeOfTheAccident;
	}
	public void setSituationAtTheTomeOfTheAccident(String situationAtTheTomeOfTheAccident) {
		SituationAtTheTomeOfTheAccident = situationAtTheTomeOfTheAccident;
	}
	public String getWhereFirstCareOrHospitalizationHaveBeenDone() {
		return whereFirstCareOrHospitalizationHaveBeenDone;
	}
	public void setWhereFirstCareOrHospitalizationHaveBeenDone(String whereFirstCareOrHospitalizationHaveBeenDone) {
		this.whereFirstCareOrHospitalizationHaveBeenDone = whereFirstCareOrHospitalizationHaveBeenDone;
	}
	
	
   
}
