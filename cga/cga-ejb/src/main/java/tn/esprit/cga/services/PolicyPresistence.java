package tn.esprit.cga.services;



import java.util.ArrayList;
import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.cga.entity.Contract;
import tn.esprit.cga.entity.Injured;
import tn.esprit.cga.entity.Insurance;
import tn.esprit.cga.entity.Policy;
import tn.esprit.cga.interfaces.PolicyServiceLocal;


@Stateless
public class PolicyPresistence implements PolicyServiceLocal {
	@PersistenceContext(unitName="cga-ejb")
	private EntityManager em;
	@Override
	public boolean addPolicy(Policy policy) {
		if (policy!=null){
		System.out.println("d5alet lel persiste");
			em.persist(policy);
		}
		
		return false;
	}

	@Override
	public boolean deletePolicy(int id) {
	if (id>0){
		
		em.remove(searchById(id));
		return true ;
		}
		return false;
	}

	@Override
	public List<Policy> findAll() {
		
		return em.createQuery("from Policy", Policy.class).getResultList();
	}

	@Override
	public Policy updatePolicy(Policy policy) {
		
	    return em.merge( policy);
	
	}

	@Override
	public Policy searchById( int id) {
		
		return em.find(Policy.class, id);
	}

	@Override
	public float countPolicy(int id) {
		
		return em.createQuery("select count(c.policy.id) FROM Contract c ,Policy p where c.policy.id= p.id and p.id="+id,Long.class).getSingleResult();
	}

	@Override
	public List<Injured> ListInsuredWithContratExpired() {
		
		return em.createQuery("Select i FROM Injured i, Contract c where i.id=c.insured.id and c.endDate<CURRENT_DATE ORDER BY c.endDate DESC ",Injured .class).getResultList();

	}

	@Override
	public List<Injured> ListInsuredWithoutContrat() {
		return em.createQuery("Select i FROM Injured i where i.id not in (Select c.insured.id From Contract c)",Injured .class).getResultList();

	}

	@Override
	public int alertDateExperied(int id) {
		
		return em.createQuery("Select DATEDIFF(CURRENT_DATE,c.endDate) FROM Injured i, Contract c where i.id = c.insured.id  and i.id="+id,Integer .class).getSingleResult();

	}

	@Override
	public List<Policy> top4Policy() {
	List<Policy>l=em.createQuery("select p FROM Contract c ,Policy p where c.policy.id= p.id GROUP BY c.policy.id  ORDER BY count(c.policy.id) DESC",Policy.class).getResultList();
	List<Policy>list = new ArrayList<Policy>();
	for (int i=0 ; i<4;i++)	{
 list.add(l.get(i));
	
	}
	return list;
	
	}

	@Override
	public List<Insurance> findAllInsurance() {
		
		return em.createQuery("from Insurance", Insurance.class).getResultList();

	}

	@Override
	public Insurance searchInById(int id) {
		return em.find(Insurance.class, id);
	}

	
	


}
