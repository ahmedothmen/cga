package tn.esprit.cga.presentation.mbeans;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import tn.esprit.cga.entity.Insurance;
import tn.esprit.cga.entity.Policy;
import tn.esprit.cga.interfaces.PolicyServiceLocal;



@ManagedBean
@RequestScoped
public class PolicyAddBean {
private float cost ;
private String description;
private String wording ;
private Insurance insur;
private List<Insurance> ListInsurance;
private int  idIn;
private int PLIDToBeUpdated;
private Policy pol;
@EJB
private PolicyServiceLocal policyServiceLocal;


public String modifier(Policy pl){
	 this.setCost(pl.getCost());
	  this.setDescription(pl.getDescription());
	  this.setWording(pl.getWording());
	   this.setInsur(pl.getInsurance());
	  
	   this.setPLIDToBeUpdated(pl.getId());;
	   return "Update";


}

public String miseAjourPolicy (){
	
	 policyServiceLocal.updatePolicy(new Policy(this.getPLIDToBeUpdated(),this.getWording(),this.getCost(),this.getDescription(),this.getInsur()));
   
   return  "ManagePolicy?faces-redirect=true";

}

public String VerfAdd(){

	Policy p = new Policy ();
	p.setCost(cost);
	p.setDescription(description);
    p.setWording(wording);
    insur=policyServiceLocal.searchInById(idIn);

    p.setInsurance(insur);
    
    policyServiceLocal.addPolicy(p);
	
	return "AddPolicyy?faces-redirect=true";}


@PostConstruct
public void init() {
	
   ListInsurance=policyServiceLocal.findAllInsurance();

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
public String getWording() {
	return wording;
}
public void setWording(String wording) {
	this.wording = wording;
}





public Insurance getInsur() {
	return insur;
}





public void setInsur(Insurance insur) {
	this.insur = insur;
}





public List<Insurance> getListInsurance() {
	return ListInsurance;
}





public void setListInsurance(List<Insurance> listInsurance) {
	ListInsurance = listInsurance;
}


public int getIdIn() {
	return idIn;
}


public void setIdIn(int idIn) {
	this.idIn = idIn;
}



public int getPLIDToBeUpdated() {
	return PLIDToBeUpdated;
}



public void setPLIDToBeUpdated(int pLIDToBeUpdated) {
	PLIDToBeUpdated = pLIDToBeUpdated;
}

public Policy getPol() {
	return pol;
}

public void setPol(Policy pol) {
	this.pol = pol;
}






}
