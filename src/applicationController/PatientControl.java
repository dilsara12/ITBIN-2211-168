/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationController;

import applicationDAO.Patientdao;
import applicationModel.Patientmodel;
import applicationView.PatientView;
import javax.swing.JOptionPane;

/**
 *
 * @author Ckavi
 */
public class PatientControl {
    
      private final PatientView view;
            private  Patientdao dao;
            
            public PatientControl(PatientView view) {
            this.view = view;
            this.dao = new Patientdao(); 
        }
            
                  public void delete(int id) {
                try {
                    dao.delete(id);
                        //view.refreshTableData(); // Optional: Update table data after successful deletion (implementation depends on your table model)
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, "Error deleting user: " + e.getMessage());
                }
            }
             
                  
             public void update(Patientmodel user) {
     
        try {
            dao.update(user);
            //view.refreshTableData(); // Optional: Update table data after successful deletion (implementation depends on your table model)
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error deleting user: " + e.getMessage());
        }
    }
              
                public void search(String keyword) {
        
    try {
            dao.search(keyword);
            //view.refreshTableData(); // Optional: Update table data after successful deletion (implementation depends on your table model)
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error deleting user: " + e.getMessage());
        }
    }
    
}
