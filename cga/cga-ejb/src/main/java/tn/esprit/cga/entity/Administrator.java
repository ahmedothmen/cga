package tn.esprit.cga.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity
@DiscriminatorValue("administrator")
public class Administrator extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Administrator(){}

	public Administrator(String lastName, String firstName, String password,String email, String role) {
		super(lastName, firstName,password, email, role);
		// TODO Auto-generated constructor stub
	}


	@OneToMany
	private List<User> users;
	@OneToMany
	private List<InsuredHistory> insuredHistories;
    @OneToMany
	private List<Statistics> statistics;

    
    
	public List<InsuredHistory> getInsuredHistories() {
		return insuredHistories;
	}


	public void setInsuredHistories(List<InsuredHistory> insuredHistories) {
		this.insuredHistories = insuredHistories;
	}


	public List<Statistics> getStatistics() {
		return statistics;
	}


	public void setStatistics(List<Statistics> statistics) {
		this.statistics = statistics;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
   
}
