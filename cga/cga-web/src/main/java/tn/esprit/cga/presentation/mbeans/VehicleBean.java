package tn.esprit.cga.presentation.mbeans;

//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import tn.esprit.cga.entity.*;
import tn.esprit.cga.services.VehicleService;
@ManagedBean
@SessionScoped
public class VehicleBean {
	private String numchassis;
	private String marque;
	private String model;
	private String color;
	private int horsepower;
	private String immatriculation;
	private Type type;
	private Date dateachat;
	private Vehicle vehicle;
	private VehiclesATTT vehiculeattt;
	private List<Vehicle>vehicles;
	private HashSet<Vehicle>vehiclehash;
	private HashSet<VehiclesATTT>vatthash;
	private String oldnumChassis;
	private int vehicleID;
	
	

	 public int getVehicleID() {
		return vehicleID;
	}



	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}



	private List< Vehicle>  filteredcar= new ArrayList< Vehicle>() ;

	
	//private VehiclesATTT vattt;
	private String numchassisAttt;
	private List<VehiclesATTT>vattt;
	private Integer VehicleIdUpdated;

	


	public List<Vehicle> getFilteredcar() {
		return filteredcar;
	}



	public void setFilteredcar(List<Vehicle> filteredcar) {
		this.filteredcar = filteredcar;
	}



	public Integer getVehicleIdUpdated() {
		return VehicleIdUpdated;
	}



	public void setVehicleIdUpdated(Integer vehicleIdUpdated) {
		VehicleIdUpdated = vehicleIdUpdated;
	}



	public List<VehiclesATTT> getVattt() {
		return vattt;
	}



	public void setVattt(List<VehiclesATTT> vattt) {
		this.vattt = vattt;
	}



	public Vehicle getVehicle() {
		return vehicle;
	}

	

	



	public Date getDateachat() {
		return dateachat;
	}



	public void setDateachat(Date dateachat) {
		this.dateachat = dateachat;
	}



	public String getNumchassisAttt() {
		return numchassisAttt;
	}

	public void setNumchassisAttt(String numchassisAttt) {
		this.numchassisAttt = numchassisAttt;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}



	@EJB
	VehicleService vehicleservice;
	
	public void addVehicle(){
	//VehiclesATTT l=vehicleservice.CompareChassisVehicle(vehicle.getNumchassis());
		
	//System.out.println(l);	
	     //  if(l.getNumchassis().equals(vehicle.getNumchassis())){
	//if(Collections.disjoint(vehicles, vattt) ){
		//if ((vehicle.getNumchassis())==immatriculation.CompareChassisVehicle(l)){
		
		//if((vehicle.getNumchassis()).equals(vehiculeattt.getNumchassis())){
		if(vehicles.contains(vattt)){
			System.out.println("no record found for this vehicle !!!");
	}
		else{
			vehicleservice.AddVehicle(new Vehicle(horsepower, numchassis, marque, model, color, horsepower, immatriculation, type,dateachat));
			System.out.println("Vehicle added !!!");
		
		}
//	
	}
	
	
	public List<Vehicle> getVehicles(){
		vehicles=vehicleservice.getVehicleJPQL();
		return vehicles;
	}
	public List<Vehicle> getMyVehicleByInsuredId(){
		
	vehicles =	vehicleservice.getVehicleByIdAssure(1);
	return vehicles;
	}
	
	public void SupprimerVehicle(int vehicleID){
		vehicleservice.deleteVehicleById(vehicleID);
		
	}
	public void modifier(Vehicle vehicle){
		this.setMarque(vehicle.getMarque());
		this.setModel(vehicle.getModel());
		this.setColor(vehicle.getColor());
		this.setHorsepower(vehicle.getHorsepower());
		this.setNumchassis(vehicle.getNumchassis());
		this.setImmatriculation(vehicle.getImmatriculation());
		this.setVehicleIdUpdated(vehicle.getId());
		
		
	}
//	 public void onDateSelect(SelectEvent event) {
//	        FacesContext facesContext = FacesContext.getCurrentInstance();
//	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
//	    }
//	     
//	    public void click() {
//	        RequestContext requestContext = RequestContext.getCurrentInstance();
//	         
//	        requestContext.update("form:display");
//	        requestContext.execute("PF('dlg').show()");
//	    }
	public void mettreAjourVehicle(){
		vehicleservice.updateVehicle(new Vehicle(numchassis, marque, model, color, horsepower, immatriculation, type,VehicleIdUpdated)); 
	}
	public void ConfirmDelete(){

		addMessage("successfull", "Your vehicle has been deleted succesfully !!!");
		
	}
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	
	public String TreatVehicleDemande(String Newnumchassis,String Oldnumchassis )
	{
		
	vattt=vehicleservice.getAllVehicles(Newnumchassis);//ijib m tabe att les vehcule b num chassis en parameter
	//vehicles=vehicleservice.matriculation(Oldnumchassis);
		
		if (vattt.size() !=0)
		{	
		//ajout
			addVehicle();
			System.out.println("vehicle added");
        //return "/pages/Demande/valideList?faces-redirect=true";
		}
		else
		{
			//ajout
			FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage(" Invalide Demande"));
//			return "/pages/Demande/invalideList?faces-redirect=true";
		}
		return Newnumchassis;
	}



	public VehiclesATTT getVehiculeattt() {
		return vehiculeattt;
	}



	public void setVehiculeattt(VehiclesATTT vehiculeattt) {
		this.vehiculeattt = vehiculeattt;
	}



	public HashSet<Vehicle> getVehiclehash() {
		return vehiclehash;
	}



	public void setVehiclehash(HashSet<Vehicle> vehiclehash) {
		this.vehiclehash = vehiclehash;
	}



	public HashSet<VehiclesATTT> getVatthash() {
		return vatthash;
	}



	public void setVatthash(HashSet<VehiclesATTT> vatthash) {
		this.vatthash = vatthash;
	}



	public String getOldnumChassis() {
		return oldnumChassis;
	}



	public void setOldnumChassis(String oldnumChassis) {
		this.oldnumChassis = oldnumChassis;
	}



	public VehicleService getVehicleservice() {
		return vehicleservice;
	}



	public void setVehicleservice(VehicleService vehicleservice) {
		this.vehicleservice = vehicleservice;
	}



	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
	
	
}
