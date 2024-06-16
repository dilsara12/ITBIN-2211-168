/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationDAO;

import DBConnection.DBConection;
import applicationModel.Patientmodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Ckavi
 */
public class Patientdao {
    
     public void add(Patientmodel patient ) {
         System.out.println(patient.getPatientname());
        
        
         String sql;
        sql = "INSERT INTO patientstbl (PatientName,PatientGender,PatientAddress,PatientPhone,PatientDoB) VALUES(?,?,?,?,?)";
        try{
            Connection connection = DBConection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, patient.getPatientname());
            stmt.setString(2, patient.getGender());
            
            stmt.setString(3, patient.getPatientaddress());
            stmt.setString(4, patient.getPatientphone());
            stmt.setString(5, patient.getPatientdate());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
       public List<String[]> getUserDetails() {
    List<String[]> userData = new ArrayList<>();

    String getData = "SELECT * FROM patientstbl";

    try  {
         Connection connection = DBConection.getConnection();
         PreparedStatement pst = connection.prepareStatement(getData);
         ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        String[] user = new String[6]; // Assuming username and password
        
        user[0] = String.valueOf(rs.getInt("PatientNumber")); 
        user[1] = rs.getString("PatientName");
        user[2] = rs.getString("PatientGender");
       
        user[3] = rs.getString("PatientAddress");
        user[4] = rs.getString("PatientPhone");
        user[5] = rs.getString("PatientDoB");
        
        userData.add(user);       
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userData;
    
  }
       
        public void delete(int id) throws SQLException {
        String deleteQuery = "DELETE FROM patientstbl WHERE PatientNumber = '"+id+"'";
        try{
            Connection connection = DBConection.getConnection();
            PreparedStatement pst = connection.prepareStatement(deleteQuery);
         
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(new JFrame(),"DATA Deleted Successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
    }

    }
        
  
            
             public  List<String[]>  search(String keyword){
        
         List<String[]> userData = new ArrayList<>();
         
         
        String getData = "SELECT * FROM patientstbl WHERE Patient Number LIKE ?";
        
        try{
            
           Connection connection = DBConection.getConnection();
        PreparedStatement pst = connection.prepareStatement(getData);
        pst.setString(1, "%" + keyword + "%"); // Set value for parameter 1

        ResultSet rs = pst.executeQuery();
            
              while (rs.next()) {
        String[] user = new String[7]; // Assuming username and password
        
        user[0] = String.valueOf(rs.getInt("Patient Number")); 
        user[1] = rs.getString("Patient Name");
        user[2] = rs.getString("Patient Gender");
        user[3] = rs.getString("gender");
        user[4] = rs.getString("Patient Address");
        user[5] = rs.getString("Patient Phone");
        user[6] = rs.getString("Patient DoB");
        
        
        userData.add(user);
       
      }
            
        }catch (SQLException e) {
             e.printStackTrace();
        }
         return userData;
    
    
}
 public void update( Patientmodel patient){
        String sql = "UPDATE Patientstbl SET PatientName = ?, PatientGender = ?, PatientAddress = ?, PatientPhone = ?, PatientDoB = ? WHERE PatientNumber  = ?";
        try{
            Connection connection = DBConection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,patient.getPatientname());
            stmt.setString(2,patient.getGender());
            stmt.setString(3,patient.getPatientaddress());
            stmt.setString(4,patient.getPatientphone());
            stmt.setString(5,patient.getPatientdate());
            
            stmt.setInt(6,patient.getPatientnumber());
            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(new JFrame(),"DATA Updated Successfully ");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
             
             
             
             
}
