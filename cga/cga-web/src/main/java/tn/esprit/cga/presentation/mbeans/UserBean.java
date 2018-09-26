package tn.esprit.cga.presentation.mbeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.CriteriaBuilder.In;

import tn.esprit.cga.entity.Expert;
import tn.esprit.cga.entity.InsuranceAgent;
import tn.esprit.cga.entity.Insured;
import tn.esprit.cga.services.UserService;

@ManagedBean
@SessionScoped
public class UserBean {

	private int id;
	private String lastName;
	private String firstName;
	private String password;
	private String email;
	private String role;
	private int driverLicenseNumber;
	private Date delivredIn;
	private Insured insured;
	private InsuranceAgent ia;
	private Expert expert;
	
	
	@EJB
    UserService userService;
	private boolean loggedIn;
    
	
	public String addInsured(){
		
		String navigateTo = "null";
		int i = 0;
		i = userService.addInsured(new Insured(lastName, firstName,password, email, role, driverLicenseNumber, null, null,null, null));
		

		//&& emp.getRole()==Role.administrateur
	if(i!=0 ){
		navigateTo="/login2?faces-redirect=true";
		loggedIn=true;	
	}else{
		
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("veuillez remplir tout les champs"));
	}
	return navigateTo;
	}

	public String modifier(Insured insured)
	{
		
	if(insured!=null){
		
		this.setLastName(insured.getLastName());
		this.setFirstName(insured.getFirstName());
		this.setPassword(insured.getPassword());
		this.setEmail(insured.getEmail());
		this.setDriverLicenseNumber(insured.getDriverLicenseNumber());
		this.setId(insured.getId());
	}
		return "updateInsured?faces-redirect=true";		
		
	}
	
	public String updateInsured()
	{
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$"+id);
		userService.updateInsured(new Insured(firstName, lastName, password, email, "insured",driverLicenseNumber,id));
		this.insured=userService.getInsuredById(id);
		return "/profile?faces-redirect=true";
		
	}
	
	public String toProfile(int idP){
		
		String role = userService.getUserById(idP).getRole();
		String navigateTo=null;
		if(role.equals("insured")){
			this.insured=userService.getInsuredById(idP);
			navigateTo="/profile?faces-redirect=true";
		}
		if(role.equals("insuranceAgent")){
			this.ia=userService.getIAById(idP);
			navigateTo="/profileAgent?faces-redirect=true";
		}
		if(role.equals("expert")){
			this.expert=userService.getExpertById(idP);
			navigateTo="/profileExpert?faces-redirect=true";
		}
		
		return navigateTo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getDriverLicenseNumber() {
		return driverLicenseNumber;
	}

	public void setDriverLicenseNumber(int driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}

	public Date getDelivredIn() {
		return delivredIn;
	}

	public void setDelivredIn(Date delivredIn) {
		this.delivredIn = delivredIn;
	}





	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	public InsuranceAgent getIa() {
		return ia;
	}

	public void setIa(InsuranceAgent ia) {
		this.ia = ia;
	}

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}
	
	
}
