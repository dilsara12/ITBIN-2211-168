/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationDAO;

import DBConnection.DBConection;
import applicationModel.Patientmodel;
import applicationModel.Testmodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Supeshala
 */
public class TestDAO {
    public void add(Testmodel Test ) {
         //System.out.println(patient.getPatientname());
        
        
         String sql;
        sql = "INSERT INTO testtbl (TestName,TestCost) VALUES(?,?)";
        try{
            Connection connection = DBConection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, Test.getTestname());
            stmt.setString(2, Test.getCost());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
       public List<String[]> getUserDetails() {
    List<String[]> userData = new ArrayList<>();

    String getData = "SELECT * FROM testtbl";

    try  {
         Connection connection = DBConection.getConnection();
         PreparedStatement pst = connection.prepareStatement(getData);
         ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        String[] user = new String[3]; // Assuming username and password
        
        user[0] = String.valueOf(rs.getInt("TestCode")); 
        user[1] = rs.getString("TestName");
        user[2] = rs.getString("TestCost");
       
        
        
        userData.add(user);       
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userData;
    
  }
       
        public void delete(int id) throws SQLException {
        String deleteQuery = "DELETE FROM testtbl WHERE TestCode = '"+id+"'";
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
         
         
        String getData = "SELECT * FROM testtbl WHERE testcode LIKE ?";
        
        try{
            
           Connection connection = DBConection.getConnection();
        PreparedStatement pst = connection.prepareStatement(getData);
        pst.setString(1, "%" + keyword + "%"); // Set value for parameter 1

        ResultSet rs = pst.executeQuery();
            
              while (rs.next()) {
        String[] user = new String[3]; // Assuming username and password
        
        user[0] = String.valueOf(rs.getInt("TestCode")); 
        user[1] = rs.getString("TestName");
        user[2] = rs.getString("TestCost");
        
        
        
        userData.add(user);
       
      }
            
        }catch (SQLException e) {
             e.printStackTrace();
        }
         return userData;
    
    
}
 public void update( Testmodel Test){
        String sql = "UPDATE testtbl SET TestName = ?, TestCost = ? WHERE TestCode  = ?";
        try{
            Connection connection = DBConection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,Test.getTestname());
            stmt.setString(2,Test.getCost());
            
            
            stmt.setInt(3,Test.getTestcode());
            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(new JFrame(),"DATA Updated Successfully ");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
             
             
             
          
    
}
