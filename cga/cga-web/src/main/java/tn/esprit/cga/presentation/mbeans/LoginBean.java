package tn.esprit.cga.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import tn.esprit.cga.entity.Administrator;
import tn.esprit.cga.entity.Expert;
import tn.esprit.cga.entity.InsuranceAgent;
import tn.esprit.cga.entity.Insured;
import tn.esprit.cga.entity.User;
import tn.esprit.cga.services.UserService;


@ManagedBean
@SessionScoped
public class LoginBean {


	private String login;
	private String password;
	private User user;
	private boolean loggedIn;
	private Insured insured;
	private Administrator admin;
	private Expert expert;
	private InsuranceAgent agent;
	private static User usersession;
	
	@EJB
	UserService userService;
	
	public String doLogin(){
		String navigateTo = "null";
		user = userService.getUserByEmailAndPassword(login, password);
		usersession=user;
		if (user.getRole().equals("insured")){
			insured = userService.getInsuredById(user.getId());
		
		}
		if(user.getRole().equals("administrator")){
			admin = userService.getAdminById(user.getId());
		}
        if(user.getRole().equals("expert")){
        	expert = userService.getExpert(user.getId());
		}
        if(user.getRole().equals("insuranceAgent")){
        	agent = userService.getAgent(user.getId());
            }
		//&& emp.getRole()==Role.administrateur
	if(user!=null ){
		System.out.println("********************* C'est bon ");
		navigateTo="indexLogin?faces-redirect=true";
		loggedIn=true;	
	}else{
	
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad confidential"));
	}
	return navigateTo;
	}
	
	public String doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login2?faces-redirect=true";
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(Insured user) {
		this.user = user;
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

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public InsuranceAgent getAgent() {
		return agent;
	}

	public void setAgent(InsuranceAgent agent) {
		this.agent = agent;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static User getUsersession() {
		return usersession;
	}

	public static void setUsersession(User usersession) {
		LoginBean.usersession = usersession;
	}
	
	
	
	
}