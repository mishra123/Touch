package PatientDao;

import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import model.Movements;
import model.NursingHome;
import model.PatientDetail;

@Path("/WebService")
public class PatientDao {
	String databaseUrl = "";
	String userName = "";
	String password = "";
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rsNursingHome = null;
	ResultSet rsMovements = null;
	Connection conn = null;
	NursingHome nh = null;
	PatientDetail p = null;
	Movements m = null;
	List times=null;

	@GET
	@Path("/Patients/{EPass_Id}")
	@Produces("application/xml")
	public PatientDetail getPatient(@PathParam("Epaas_Id") int epassId, Date todaysDate){
		try{
			Class.forName("com.mysql.jdbc.Driver");		
			conn = DriverManager.getConnection(databaseUrl, userName, password);
			if(conn!=null){
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from Patient where epassId="+epassId+"");
			rsNursingHome = stmt.executeQuery("Select * from NursingHome where epassId= "+epassId+"");
			rsMovements = stmt.executeQuery("Select * from movements where epassId = "+epassId +" AND the date = "+todaysDate);
			}
			// Here we set up the patient's detail to return it as an Patient detail object.
					p.setContactPersonName(rs.getString("Contact_Name"));
					p.setContactPersonnumber(rs.getInt("Contact_Number"));
					p.setDoctorPrescriptions(rs.getString("Doctor_Prescribed_TIme"));
					p.setePasId(rs.getInt("EPass_Id"));
					p.setLastMovedTime(rs.getDate("Last_Moved"));
					nh.setEpassId(nh.getEpassId());
				    nh.setName(nh.getName());
				    nh.setAddress(nh.getAddress());
				    nh.setContactName(nh.getContactName());
				    nh.setContactNumber(nh.getContactNumber());
				    p.setNursingHome(nh);
				    
				    while(rsMovements.next()){
				    	times.add(rsMovements.getString("Times"));
				    }
				    m.setTimes(times);
				    p.setMovementSheet(times);
				    
		}
		catch(Exception e){
			System.out.println("Exception occured while accessing patient's details: " +e.getMessage());
		}
		return p;
	}
	
	@POST 
	@Path("/addPatientData")
	@Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean addPatientData(PatientDetail p, NursingHome nh, Movements m){
		try{
			Class.forName("com.mysql.jdbc.Driver");		
			conn = DriverManager.getConnection(databaseUrl, userName, password);
			if(conn!=null){
			stmt = conn.createStatement();
			String insertIntoPatientTable = "Insert Into Patient where EPass_Id="+p.getePasId();
			PreparedStatement preparedStmt = conn.prepareStatement(insertIntoPatientTable);
			preparedStmt.setInt(1, p.getePasId());
			preparedStmt.setString(2, p.getContactPersonName());
			preparedStmt.setString(3, p.getDoctorPrescriptions());
			preparedStmt.setInt(4, p.getContactPersonnumber());
			preparedStmt.setDate(5, (java.sql.Date) p.getLastMovedTime());
			preparedStmt .executeUpdate();
			String insertIntoNursingHomeTable = "Insert Into NursingHome where EPass_Id="+p.getePasId();
			PreparedStatement preparedStmtNH = conn.prepareStatement(insertIntoNursingHomeTable);
			preparedStmtNH.setInt(1, nh.getEpassId());
			preparedStmtNH.setString(2, nh.getAddress());
			preparedStmtNH.setString(3, nh.getContactName());
			preparedStmtNH.setString(4, nh.getContactNumber());
			preparedStmtNH.setString(5, nh.getName());
			preparedStmtNH.executeUpdate();
			String insertIntoMovementsTable = "Insert Into NursingHome where EPass_Id="+p.getePasId();
			PreparedStatement preparedStmtMovements = conn.prepareStatement(insertIntoMovementsTable);
			preparedStmtMovements.setInt(1, p.getePasId());
			preparedStmtMovements.setDate(2, (java.sql.Date) m.getDate());
			preparedStmtMovements.setString(3, (String)m.getTimes());
			preparedStmtMovements.executeUpdate();
				}
			// Here we set up the patient's detail to return it as an Patient detail object.
					p.setContactPersonName(rs.getString("Contact_Name"));
					p.setContactPersonnumber(rs.getInt("Contact_Number"));
					p.setDoctorPrescriptions(rs.getString("Doctor_Prescribed_TIme"));
					p.setePasId(rs.getInt("EPass_Id"));
					p.setLastMovedTime(rs.getDate("Last_Moved"));
					nh.setEpassId(nh.getEpassId());
				    nh.setName(nh.getName());
				    nh.setAddress(nh.getAddress());
				    nh.setContactName(nh.getContactName());
				    nh.setContactNumber(nh.getContactNumber());
				    p.setNursingHome(nh);
				    
				    while(rsMovements.next()){
				    	times.add(rsMovements.getString("Times"));
				    }
				    m.setTimes(times);
				    p.setMovementSheet(times);
				    
		}
		catch(Exception e){
			System.out.println("Exception occured while accessing patient's details: " +e.getMessage());
		}
		return p;
	}
	
}
