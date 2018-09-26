package tn.esprit.cga.presentation.mbeans;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.cga.entity.Injured;
import tn.esprit.cga.entity.Insurance;
import tn.esprit.cga.entity.Policy;
import tn.esprit.cga.interfaces.PolicyServiceLocal;


@ManagedBean
@RequestScoped
public class PolicyManaged {
	private float cost ;
	private String description;
	private String wording ;
    private float nbrePolicy ;
	private Policy selecTedPolicy ;
	private List<Injured> listInjured ;
	private List<Injured> listInjuredEx ;
	private List<Insurance> ListInsurance;
	private int nbreJourRest;
	private List<Policy> topPolicy ;
	public Policy getSelecTedPolicy() {
		return selecTedPolicy;
	}
	public void setSelecTedPolicy(Policy selecTedPolicy) {
		this.selecTedPolicy = selecTedPolicy;
	}


  public String passToUpdate (Policy p){
	  
	return "Update";  
  }


	private Insurance in ;
   private int id ;
private List<Policy> policys;
   
   
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
public Insurance getIn() {
	return in;
}
public void setIn(Insurance in) {
	this.in = in;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}





@EJB
private PolicyServiceLocal policyServiceLocal;

@PostConstruct
public void init() {
	
	policys = new ArrayList<>();
	policys = policyServiceLocal.findAll();
  /*  listInjured=policyServiceLocal.ListInsuredWithoutContrat(); */
  /*  listInjuredEx=policyServiceLocal.ListInsuredWithContratExpired();*/
 /*  topPolicy=policyServiceLocal.top4Policy();*/
  /* ListInsurance=policyServiceLocal.findAllInsurance();*/
 /*  nbreJourRest=policyServiceLocal.alertDateExperied(1);*/
}

public String afficherPolicy (){
	
 return  "ClientPolicy?faces-redirect=true";
	
	
}



public List<Policy> getPolicys() {
	return policys;
}
public void setPolicys(List<Policy> policys) {
	this.policys = policys;
}
public String ListPolicy ()
{
	 policyServiceLocal.findAll();
return "ViewPolicy";
}

public String DeletePolicy (int id){

	 policyServiceLocal.deletePolicy(id);
	 return  "ManagePolicy?faces-redirect=true";
}
public float getNbrePolicy() {
	return nbrePolicy;
}
public void setNbrePolicy(float nbrePolicy) {
	this.nbrePolicy = nbrePolicy;
}

public float calculer (int id ){

return policyServiceLocal.countPolicy(id);
}
public List<Injured> getListInjured() {
	return listInjured;
}
public void setListInjured(List<Injured> listInjured) {
	this.listInjured = listInjured;
}
public List<Injured> getListInjuredEx() {
	return listInjuredEx;
}
public void setListInjuredEx(List<Injured> listInjuredEx) {
	this.listInjuredEx = listInjuredEx;
}
public List<Policy> getTopPolicy() {
	return topPolicy;
}
public void setTopPolicy(List<Policy> topPolicy) {
	this.topPolicy = topPolicy;
}
public List<Insurance> getListInsurance() {
	return ListInsurance;
}
public void setListInsurance(List<Insurance> listInsurance) {
	ListInsurance = listInsurance;
}
public int getNbreJourRest() {
	return nbreJourRest;
}
public void setNbreJourRest(int nbreJourRest) {
	this.nbreJourRest = nbreJourRest;
}

}
