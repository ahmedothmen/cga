package tn.esprit.cga.services;


import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

import tn.esprit.cga.entity.Administrator;
import tn.esprit.cga.entity.Expert;
import tn.esprit.cga.entity.InsuranceAgent;
import tn.esprit.cga.entity.Insured;
import tn.esprit.cga.entity.User;
import tn.esprit.cga.interfaces.UserServiceRemote;


@Stateful
@LocalBean
public class UserService implements UserServiceRemote {

	@PersistenceContext(unitName="cga-ejb")
	EntityManager em;
	
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		
		TypedQuery<User> query = em.createQuery("Select e from User e "
		          + "where e.email=:email and e.password=:password",User.class);
			
			
			query.setParameter("email", email);
			query.setParameter("password", password);
			
			User user= null;
			
			try{
				user = query.getSingleResult();
			}catch(NoResultException e){
				//Logger.info("Aucun user trouve avec email :" + email);
			
				System.out.println("Aucun utilisateur trouve avec email :" + email + " " + password);
			}
			
			return user;
	}

	@Override
	public int addInsured(Insured insured) {
		em.persist(insured);
		return insured.getId();
		
	}

	@Override
	public int addInsuranceAgent(InsuranceAgent insuranceAgent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addExpert(Expert expert) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateInsured(Insured insured) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$"+insured.getId());
		Query query =  em.createQuery("update User u set firstName=:firstName,lastName=:lastName,email=:email,driverLicenseNumber=:driverLicenseNumber "
	                                       +"where u.id=:id");
	query.setParameter("firstName", insured.getFirstName());
	query.setParameter("lastName", insured.getLastName());
	query.setParameter("email", insured.getEmail());
	query.setParameter("driverLicenseNumber", insured.getDriverLicenseNumber());
	query.setParameter("id", insured.getId());
	int modified= query.executeUpdate();
	System.out.println("$$££££££££££"+modified);
	return modified;
		
	}

	@Override
	public Insured getInsuredById(int id) {
		
		return em.find(Insured.class,id);
	}
	
	@Override
	public Expert getExpertById(int id) {
		
		return em.find(Expert.class,id);
	}
	
	@Override
	public InsuranceAgent getIAById(int id) {
		
		return em.find(InsuranceAgent.class,id);
	}

	@Override
	public Administrator getAdminById(int id) {
		
		return em.find(Administrator.class,id);
	}

	@Override
	public InsuranceAgent getAgent(int id) {
		return em.find(InsuranceAgent.class,id);
	}

	@Override
	public Expert getExpert(int id) {
		return em.find(Expert.class,id);
	}

	public User getUserById(int idP) {
		// TODO Auto-generated method stub
		return em.find(User.class,idP);
	}

}
