package tn.esprit.cga.interfaces;


import tn.esprit.cga.entity.Administrator;
import tn.esprit.cga.entity.Expert;
import tn.esprit.cga.entity.InsuranceAgent;
import tn.esprit.cga.entity.Insured;
import tn.esprit.cga.entity.User;




public interface UserServiceRemote {
	public User getUserByEmailAndPassword( String email,String password);
	public int addInsured(Insured insured);
	public int addInsuranceAgent(InsuranceAgent insuranceAgent);
	public int addExpert(Expert expert);
	public int updateInsured(Insured insured);
	public Insured getInsuredById(int id);
	public Administrator getAdminById(int id);
	public InsuranceAgent getAgent(int id);
	public Expert getExpert(int id);
	public Expert getExpertById(int id);
	public InsuranceAgent getIAById(int id);
	
}
