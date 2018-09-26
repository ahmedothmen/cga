package tn.esprit.cga.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehicle
 *
 */
@Entity
public class Vehicle implements Serializable {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String numchassis;
	private String marque;
	private String model;
	private String color;
	private int horsepower;
	private String immatriculation;
	private Type type;
	
	private Date dateachat;
	@ManyToOne
	private Contract contract;

	@ManyToOne
	private Insured insured;

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	
//	
//	
//	public Date getDateachat() {
//		return dateachat;
//	}
//
//	public void setDateachat(Date dateachat) {
//		this.dateachat = dateachat;
//	}

	public Date getDateachat() {
		return dateachat;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public void setDateachat(Date dateachat) {
		this.dateachat = dateachat;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumchassis() {
		return numchassis;
	}

	public void setNumchassis(String numchassis) {
		this.numchassis = numchassis;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	

	public Vehicle() {
		super();
	}

	public Vehicle(int id, String numchassis, String marque, String model, String color, int horsepower,
			String immatriculation,Type type,Date dateachat) {
//		,Insured insured
		super();
		this.id = id;
		this.numchassis = numchassis;
		this.marque = marque;
		this.model = model;
		this.color = color;
		this.horsepower = horsepower;
		this.immatriculation = immatriculation;
		this.type=type;
		this.dateachat=dateachat;
	}

	public Vehicle(String numchassis, String marque, String model, String color, int horsepower, String immatriculation,
			Type type,Integer id) {
		super();
		this.numchassis = numchassis;
		this.marque = marque;
		this.model = model;
		this.color = color;
		this.horsepower = horsepower;
		this.immatriculation = immatriculation;
		this.type = type;
		this.id=id;

	}

	
	
	
	
   
}
