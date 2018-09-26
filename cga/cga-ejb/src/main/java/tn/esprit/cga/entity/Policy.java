package tn.esprit.cga.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Policy
 *
 */
@Entity

public class Policy implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String wording; //libelle
	private float cost;
	private String description;
	 @ManyToOne
	private Insurance insurance;

	
	public Policy(int id, String wording, float cost, String description, Insurance insurance) {
		super();
		this.id = id;
		this.wording = wording;
		this.cost = cost;
		this.description = description;
		this.insurance = insurance;
	}

	
	
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(String wording, float cost, String description, Insurance insurance) {
		super();
		
		this.wording = wording;
		this.cost = cost;
		this.description = description;
		this.insurance = insurance;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
     
	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}



	




   






}
