package model;

import java.io.Serializable;
public class NursingHome implements Serializable{
	private int epassId;
	private String name;
	private String address;
	private String contactName;
	private String contactNumber;
	
	public NursingHome(){
		
	}
	
	public NursingHome(int epassId, String name, String address,
			String contactName, String contactNumber) {
		super();
		this.epassId = epassId;
		this.name = name;
		this.address = address;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}
	
	public int getEpassId() {
		return epassId;
	}
	public void setEpassId(int epassId) {
		this.epassId = epassId;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
