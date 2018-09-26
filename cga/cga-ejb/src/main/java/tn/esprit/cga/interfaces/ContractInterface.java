package tn.esprit.cga.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.cga.entity.Contract;
@Remote
public interface ContractInterface {
public void addContract(Contract c);
public void updateContract(Contract c);
public List<Contract> getAllContract();
public List<Contract> getContractbyUser();
public void deleteContract(int idContract);
public void affecterContratAUser(int contratId, int UserId);
public void affecterPoliceAContrat(int contratId, int PoliceId);
public void affecterVehicleAContract(int vehiculeid, int contractid);


}
