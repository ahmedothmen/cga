package tn.esprit.cga.presentation.mbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.flow.builder.ReturnBuilder;
import javax.mail.MessagingException;

import tn.esprit.cga.entity.Contract;
import tn.esprit.cga.entity.Insured;
import tn.esprit.cga.entity.Policy;
import tn.esprit.cga.entity.Vehicle;
import tn.esprit.cga.services.ContractService;
import tn.esprit.cga.services.sendMailComfirmation;
@ManagedBean
@SessionScoped
@ViewScoped
public class ContractBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date startDate;
	private Date endDate;
	private Policy policy;
	private List<Contract> contracts;
	private List<Vehicle> vehicles;
	private int id;
	
	private Insured insured;
	private Contract selectedContract;
	private Date dateSinding;
	private float costContract;
private long nombre;
private Vehicle vehicle;
private List<Vehicle> vehiclenom;
private Vehicle selectedcar;
	public float getCostContract() {
		
		return costContract;
	}
	public void setCostContract(float costContract) {
		this.costContract = costContract;
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
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
@EJB
ContractService contractservice ;
public void addContract(){
	Contract contract= new Contract(startDate, endDate, costContract);
	contractservice.addContract(contract);
	contractservice.affecterContratAUser(contract.getId(), LoginBean.getUsersession().getId());
	contractservice.affecterPoliceAContrat(contract.getId(),1);
	contractservice.affecterVehicleAContract(selectedcar.getId(), contract.getId());
}
public List<Contract> getAllContract(){
	contracts =contractservice.getAllContract();
	return contracts;
}
public List<Contract> getMyContract(){
	contracts =contractservice.getMyContract(2);
	return contracts;
}
public List<Contract> getContractAccepted(){
	contracts =contractservice.getAllContractAccepted();
	return contracts;
}


public Insured getInsured() {
	return insured;
}
public void setInsured(Insured insured) {
	this.insured = insured;
}
public Contract getSelectedContract() {
	return selectedContract;
}
public void setSelectedContract(Contract selectedContract) {
	this.selectedContract = selectedContract;
}
public void Accept(Contract c){
	 contractservice.updateContract(c);
}
public void Refused(Contract c){
	 contractservice.updateContract2(c);
}
public int progess(String etat){
	int i;
	if (etat.equalsIgnoreCase("Accepted")){
		 i=100;
		
	}else if(etat.equalsIgnoreCase("Refused")) {
		 i=100;
	}
	else  {i=50;}
		return i;}
public Date getDateSinding() {
	return dateSinding;
}
public void setDateSinding(Date dateSinding) {
	this.dateSinding = dateSinding;
}
public float calculercost(){
	
long duree =(long) endDate.getTime()-startDate.getTime();
float jr = TimeUnit.DAYS.convert(duree, TimeUnit.MILLISECONDS);

costContract = jr * 2;
return costContract;}

public void envoyermail(String mailI) throws MessagingException{
	sendMailComfirmation mail = new sendMailComfirmation(mailI, "votre contract est confirmé consulter votre interface de vos contracts ."
);
}
public void totalcontract(){
	nombre = (contractservice.nombreofContract());
	 
}
public List<Contract> Best(){
	contracts = contractservice.bestclient();
	return contracts;
}
public void MaxCost(){
	costContract= contractservice.MaxCost();
}
public long getNombre() {
	return nombre;
}
public void setNombre(long nombre) {
	this.nombre = nombre;
}
public void Save() {
    addMessage("Confirmation", "Your Contract is succefly sending");
addContract();
}
 
public void addMessage(String summary, String detail) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    FacesContext.getCurrentInstance().addMessage(null, message);
}
public List<Vehicle> myCar(){
	vehiclenom = contractservice.MyVehicle(2);
	return vehiclenom;
}
public List<Vehicle> getVehicles() {
	return vehicles;
}
public void setVehicles(List<Vehicle> vehicles) {
	this.vehicles = vehicles;
}
public Vehicle getVehicle() {
	return vehicle;
}

public List<Vehicle> getVehiclenom() {
	return vehiclenom;
}
public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}
public void setVehiclenom(List<Vehicle> vehiclenom) {
	this.vehiclenom = vehiclenom;
}
public Vehicle getSelectedcar() {
	return selectedcar;
}
public void setSelectedcar(Vehicle selectedcar) {
	this.selectedcar = selectedcar;
}

}


