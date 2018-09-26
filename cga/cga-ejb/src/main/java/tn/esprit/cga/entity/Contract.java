package tn.esprit.cga.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity

public class Contract implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date startDate;
	private Date endDate;
	private Date dateSending = new Date();
	
	private float costContract ;
	private String etat="waiting";
	
	@OneToOne
	private Policy policy;
	@ManyToOne
	private Insured insured;
	@OneToMany(mappedBy="contract", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<Vehicle> vehicles;

	public Insured getInsured() {
		return insured;
	} 

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Contract(int id, Date startDate, Date endDate, Policy policy, Insured insured) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.policy = policy;
		this.insured = insured;
	}

	public Contract(Date startDate, Date endDate, Policy policy, Insured insured) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.policy = policy;
		this.insured = insured;
	}

	public Contract() {
		super();
	}

	public Contract(Date startDate, Date endDate, float costContract) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.costContract = costContract;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public float getCostContract() {
		
		return costContract;
	}

	public void setCostContract(float costContract) {
		this.costContract = costContract;
	}

	public Date getDateSending() {
		return dateSending;
	}

	public void setDateSending(Date dateSending) {
		this.dateSending = dateSending;
	}

	
   
}
