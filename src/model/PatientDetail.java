package model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Patient")
public class PatientDetail implements Serializable{
	private int ePasId;
	private NursingHome nursingHome;
	private String contactPersonName;
	private int contactPersonnumber;
	private Date lastMovedTime;
	private List<Date> movementSheet;
	private String doctorPrescriptions;
	
	public PatientDetail(){
		
	}
	
	public PatientDetail(int ePasId, NursingHome nursingHome,
			String contactPersonName, int contactPersonnumber,
			Date lastMovedTime, List<Date> movementSheet,
			String doctorPrescriptions) {
		super();
		this.ePasId = ePasId;
		this.nursingHome = nursingHome;
		this.contactPersonName = contactPersonName;
		this.contactPersonnumber = contactPersonnumber;
		this.lastMovedTime = lastMovedTime;
		this.movementSheet = movementSheet;
		this.doctorPrescriptions = doctorPrescriptions;
	}
	public int getePasId() {
		return ePasId;
	}
	@XmlElement
	public void setePasId(int ePasId) {
		this.ePasId = ePasId;
	}
	public NursingHome getNursingHome() {
		return nursingHome;
	}
	@XmlElement
	public void setNursingHome(NursingHome nursingHome) {
		this.nursingHome = nursingHome;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	@XmlElement
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public int getContactPersonnumber() {
		return contactPersonnumber;
	}
	@XmlElement
	public void setContactPersonnumber(int contactPersonnumber) {
		this.contactPersonnumber = contactPersonnumber;
	}
	public Date getLastMovedTime() {
		return lastMovedTime;
	}
	@XmlElement
	public void setLastMovedTime(Date lastMovedTime) {
		this.lastMovedTime = lastMovedTime;
	}
	public List<Date> getMovementSheet() {
		return movementSheet;
	}
	@XmlElement
	public void setMovementSheet(List<Date> movementSheet) {
		this.movementSheet = movementSheet;
	}
	public String getDoctorPrescriptions() {
		return doctorPrescriptions;
	}
	@XmlElement
	public void setDoctorPrescriptions(String doctorPrescriptions) {
		this.doctorPrescriptions = doctorPrescriptions;
	}
	@Override
	   public boolean equals(Object object){
	      if(object == null){
	         return false;
	      }else if(!(object instanceof PatientDetail)){
	         return false;
	      }else {
	         PatientDetail pat = (PatientDetail)object;
	         if(ePasId == pat.getePasId()
	            && nursingHome.equals(pat.getNursingHome())
	            && contactPersonnumber == pat.getContactPersonnumber()
	            && lastMovedTime.equals(pat.getLastMovedTime())
	            && movementSheet.equals(pat.getMovementSheet())
	            && doctorPrescriptions.equals(pat.getDoctorPrescriptions())
	            && contactPersonName.equals(pat.getContactPersonName())
	           
	         ){
	            return true;
	         }			
	      }
	      return false;
	   }	

}
