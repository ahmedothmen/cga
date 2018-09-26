package tn.esprit.cga.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Statement
 *
 */
@Entity

public class Statement implements Serializable {

	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	private List<Injured> injured;
	
	private String assuredName;
	private String job;
	private String phoneNumber;
	private String accidentCircumstance;
	private boolean recordNationalGuard;
	private boolean policeReport;
	private String brigadeOrPoliceStation;
	private boolean usualDriver;
	private Date driverBirthDate;
	private boolean insuredEmplyoee;
	private String ifNotEmployeeMentionOther;
	
	private String vehicleUsualGarage;
	private String reasonsForTraveling;
	private String garageWhereVehicleGoingToBeVisible;
	private Date when;
	private String callEventually;
	private String mentionNumberIntheSeriesTypeIfVehicleStolen;
	private String nameAndAddressCredirAgencyIfVehicleIsPledged;
	private float grossWeightIfHeavyWeight;
	private String otherVehicleImmatriculationNumberIfVehicleWasHitchedToAnotherVehicle;
	private String otherVehicleGrosSWeightIfVehicleWasHitchedToAnotherVehicle;
	private String otherVehicleInsuranceNameIfVehicleWasHitchedToAnotherVehicle;
	private String otherVehicleInsurancePolicyNumber;
	
	private String otherMatrialDamage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Injured> getInjured() {
		return injured;
	}

	public void setInjured(List<Injured> injured) {
		this.injured = injured;
	}

	public String getAssuredName() {
		return assuredName;
	}

	public void setAssuredName(String assuredName) {
		this.assuredName = assuredName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccidentCircumstance() {
		return accidentCircumstance;
	}

	public void setAccidentCircumstance(String accidentCircumstance) {
		this.accidentCircumstance = accidentCircumstance;
	}

	public boolean isRecordNationalGuard() {
		return recordNationalGuard;
	}

	public void setRecordNationalGuard(boolean recordNationalGuard) {
		this.recordNationalGuard = recordNationalGuard;
	}

	public boolean isPoliceReport() {
		return policeReport;
	}

	public void setPoliceReport(boolean policeReport) {
		this.policeReport = policeReport;
	}

	public String getBrigadeOrPoliceStation() {
		return brigadeOrPoliceStation;
	}

	public void setBrigadeOrPoliceStation(String brigadeOrPoliceStation) {
		this.brigadeOrPoliceStation = brigadeOrPoliceStation;
	}

	public boolean isUsualDriver() {
		return usualDriver;
	}

	public void setUsualDriver(boolean usualDriver) {
		this.usualDriver = usualDriver;
	}

	public Date getDriverBirthDate() {
		return driverBirthDate;
	}

	public void setDriverBirthDate(Date driverBirthDate) {
		this.driverBirthDate = driverBirthDate;
	}

	public boolean isInsuredEmplyoee() {
		return insuredEmplyoee;
	}

	public void setInsuredEmplyoee(boolean insuredEmplyoee) {
		this.insuredEmplyoee = insuredEmplyoee;
	}

	public String getIfNotEmployeeMentionOther() {
		return ifNotEmployeeMentionOther;
	}

	public void setIfNotEmployeeMentionOther(String ifNotEmployeeMentionOther) {
		this.ifNotEmployeeMentionOther = ifNotEmployeeMentionOther;
	}

	public String getVehicleUsualGarage() {
		return vehicleUsualGarage;
	}

	public void setVehicleUsualGarage(String vehicleUsualGarage) {
		this.vehicleUsualGarage = vehicleUsualGarage;
	}

	public String getReasonsForTraveling() {
		return reasonsForTraveling;
	}

	public void setReasonsForTraveling(String reasonsForTraveling) {
		this.reasonsForTraveling = reasonsForTraveling;
	}

	public String getGarageWhereVehicleGoingToBeVisible() {
		return garageWhereVehicleGoingToBeVisible;
	}

	public void setGarageWhereVehicleGoingToBeVisible(String garageWhereVehicleGoingToBeVisible) {
		this.garageWhereVehicleGoingToBeVisible = garageWhereVehicleGoingToBeVisible;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public String getCallEventually() {
		return callEventually;
	}

	public void setCallEventually(String callEventually) {
		this.callEventually = callEventually;
	}

	public String getMentionNumberIntheSeriesTypeIfVehicleStolen() {
		return mentionNumberIntheSeriesTypeIfVehicleStolen;
	}

	public void setMentionNumberIntheSeriesTypeIfVehicleStolen(String mentionNumberIntheSeriesTypeIfVehicleStolen) {
		this.mentionNumberIntheSeriesTypeIfVehicleStolen = mentionNumberIntheSeriesTypeIfVehicleStolen;
	}

	public String getNameAndAddressCredirAgencyIfVehicleIsPledged() {
		return nameAndAddressCredirAgencyIfVehicleIsPledged;
	}

	public void setNameAndAddressCredirAgencyIfVehicleIsPledged(String nameAndAddressCredirAgencyIfVehicleIsPledged) {
		this.nameAndAddressCredirAgencyIfVehicleIsPledged = nameAndAddressCredirAgencyIfVehicleIsPledged;
	}

	public float getGrossWeightIfHeavyWeight() {
		return grossWeightIfHeavyWeight;
	}

	public void setGrossWeightIfHeavyWeight(float grossWeightIfHeavyWeight) {
		this.grossWeightIfHeavyWeight = grossWeightIfHeavyWeight;
	}

	public String getOtherVehicleImmatriculationNumberIfVehicleWasHitchedToAnotherVehicle() {
		return otherVehicleImmatriculationNumberIfVehicleWasHitchedToAnotherVehicle;
	}

	public void setOtherVehicleImmatriculationNumberIfVehicleWasHitchedToAnotherVehicle(
			String otherVehicleImmatriculationNumberIfVehicleWasHitchedToAnotherVehicle) {
		this.otherVehicleImmatriculationNumberIfVehicleWasHitchedToAnotherVehicle = otherVehicleImmatriculationNumberIfVehicleWasHitchedToAnotherVehicle;
	}

	public String getOtherVehicleGrosSWeightIfVehicleWasHitchedToAnotherVehicle() {
		return otherVehicleGrosSWeightIfVehicleWasHitchedToAnotherVehicle;
	}

	public void setOtherVehicleGrosSWeightIfVehicleWasHitchedToAnotherVehicle(
			String otherVehicleGrosSWeightIfVehicleWasHitchedToAnotherVehicle) {
		this.otherVehicleGrosSWeightIfVehicleWasHitchedToAnotherVehicle = otherVehicleGrosSWeightIfVehicleWasHitchedToAnotherVehicle;
	}

	public String getOtherVehicleInsuranceNameIfVehicleWasHitchedToAnotherVehicle() {
		return otherVehicleInsuranceNameIfVehicleWasHitchedToAnotherVehicle;
	}

	public void setOtherVehicleInsuranceNameIfVehicleWasHitchedToAnotherVehicle(
			String otherVehicleInsuranceNameIfVehicleWasHitchedToAnotherVehicle) {
		this.otherVehicleInsuranceNameIfVehicleWasHitchedToAnotherVehicle = otherVehicleInsuranceNameIfVehicleWasHitchedToAnotherVehicle;
	}

	public String getOtherVehicleInsurancePolicyNumber() {
		return otherVehicleInsurancePolicyNumber;
	}

	public void setOtherVehicleInsurancePolicyNumber(String otherVehicleInsurancePolicyNumber) {
		this.otherVehicleInsurancePolicyNumber = otherVehicleInsurancePolicyNumber;
	}

	public String getOtherMatrialDamage() {
		return otherMatrialDamage;
	}

	public void setOtherMatrialDamage(String otherMatrialDamage) {
		this.otherMatrialDamage = otherMatrialDamage;
	}
	


	

		
	
   
}
