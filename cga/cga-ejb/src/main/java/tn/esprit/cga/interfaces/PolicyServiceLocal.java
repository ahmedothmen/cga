package tn.esprit.cga.interfaces;



import java.util.List;


import javax.ejb.Local;

import tn.esprit.cga.entity.Injured;
import tn.esprit.cga.entity.Insurance;
import tn.esprit.cga.entity.Policy;

@Local
public interface PolicyServiceLocal {
boolean addPolicy (Policy policy) ;
boolean deletePolicy (int id) ;
List <Policy> findAll ();
Policy updatePolicy (Policy policy);
Policy searchById(int id);
float countPolicy (int id);
List<Injured> ListInsuredWithContratExpired ();
List <Injured>  ListInsuredWithoutContrat ();
int alertDateExperied (int id );
List<Policy> top4Policy();
List<Insurance> findAllInsurance();
Insurance searchInById(int id);
}
