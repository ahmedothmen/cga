package tn.esprit.cga.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import tn.esprit.cga.entity.Contract;
import tn.esprit.cga.entity.Insured;
import tn.esprit.cga.entity.Policy;
import tn.esprit.cga.entity.Vehicle;
import tn.esprit.cga.interfaces.ContractInterface;

@Stateless
@LocalBean

public class ContractService implements ContractInterface {
	@PersistenceContext(unitName="cga-ejb")
	EntityManager em;
	@Override
	public void addContract(Contract c) {
		
			em.persist(c);
			em.flush();
		

	}

	@Override
	public void updateContract(Contract contract) {
		
contract.setEtat("Accepted");
em.merge(contract);
	}
	public void updateContract2(Contract contract) {
		
contract.setEtat("Refused");
em.merge(contract);
	}

	@Override
	public List<Contract> getAllContract() {
	
		 TypedQuery<Contract> query = em.createQuery("SELECT c from Contract c where c.etat='Waiting'",Contract.class);
List<Contract>  l=query.getResultList();
			return l;
	}
	public List<Contract> getAllContractAccepted() {
		
		 TypedQuery<Contract> query = em.createQuery("SELECT c from Contract c where c.etat='Accepted'",Contract.class);
List<Contract>  l=query.getResultList();
			return l;
	}

	@Override
	public List<Contract> getContractbyUser() {
		
		return null;
	}

	@Override
	public void deleteContract(int idContract) {
		Contract emp = em.find(Contract.class, idContract);
		em.remove(emp);
		em.flush();		
	}

	@Override
	public void affecterContratAUser(int contratId, int UserId) {
		Insured insured =  em.find(Insured.class, UserId);
		Contract contrat = em.find(Contract.class, contratId);
		contrat.setInsured(insured);
		em.merge(contrat);		
	}

	@Override
	public void affecterPoliceAContrat(int contratId, int PoliceId) {
Policy police = em.find(Policy.class, PoliceId)	;
Contract contrat = em.find(Contract.class, contratId);
contrat.setPolicy(police);
em.merge(contrat);	
	}

	@Override
	public void affecterVehicleAContract(int vehiculeid, int contractid) {
		Vehicle vehicle = em.find(Vehicle.class, vehiculeid);
		Contract contract = em.find(Contract.class, contractid);
vehicle.setContract(contract);
em.merge(vehicle);	
		
	}
	public List<Contract> getMyContract(int insured_id) {
		Insured i = em.find(Insured.class, insured_id);		
		 TypedQuery<Contract> query = em.createQuery("SELECT c from Contract c where c.insured=:insured",Contract.class);
List<Contract>  l=query.setParameter("insured", i).getResultList();
			return l;
	}
	public long nombreofContract(){
		Query query=em.createQuery("Select count(c.insured) from Contract c where c.etat='Accepted'");
		long nombre =(long)query.getSingleResult();
		System.out.print(nombre);
return 	nombre;

	}
	public List<Contract>  bestclient(){
		TypedQuery<Contract> query=em.createQuery("Select DISTINCT c from Contract c where c.etat='Accepted' GROUP BY c.insured ORDER BY COUNT(c.insured) DESC",Contract.class);
	List<Contract>	c = query.setMaxResults(1).getResultList();

	return c;}

public float MaxCost(){
	Query query=em.createQuery("Select MAX(c.costContract) from Contract c where c.etat='Accepted'");
	float nombre =(float)query.getSingleResult();
return 	nombre;
}
public List<Vehicle> MyVehicle(int insured_id){
	Insured i = em.find(Insured.class, insured_id);		

	List<Vehicle> cars = em.createQuery("SELECT v from Vehicle v where v.insured=:insured and v.contract IS NULL",Vehicle.class).setParameter("insured", i).getResultList();

		return cars;
}

	
	

}
