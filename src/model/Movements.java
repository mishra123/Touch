package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Movements implements Serializable{
	private int EpassId;
	
	private Date date;
	private List times;

	public Movements(){
		
	}
	
	public Movements(int epassId, Date date, List times) {
		super();
		EpassId = epassId;
		this.date = date;
		this.times = times;
	}

	public int getEpassId() {
		return EpassId;
	}
	public void setEpassId(int epassId) {
		EpassId = epassId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setTimes(List times) {
		this.times = times;
	}
	public List getTimes() {
		return times;
	}
}
