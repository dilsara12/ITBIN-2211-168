/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationController;

import applicationDAO.Patientdao;
import applicationDAO.TestDAO;
import applicationModel.Patientmodel;
import applicationModel.Testmodel;
import applicationView.PatientView;
import applicationView.Tview;
import applicationView.Tview;
import javax.swing.JOptionPane;

/**
 *
 * @author Supeshala
 */
public class TestController {
    private final Tview view;
            private  TestDAO dao;
            
            public TestController(Tview view) {
            this.view = view;
            this.dao = new TestDAO(); 
        }
            
                  public void delete(int id) {
                try {
                    dao.delete(id);
                        //view.refreshTableData(); // Optional: Update table data after successful deletion (implementation depends on your table model)
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, "Error deleting user: " + e.getMessage());
                }
            }
             
                  
             public void update(Testmodel user) {
     
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
