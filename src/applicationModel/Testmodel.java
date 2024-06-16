/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationModel;

/**
 *
 * @author user
 */
public class Testmodel {
    
    
    private int testcode;
    private String testname;
    private String cost;
    
    public Testmodel()
            
            {
           
            
            
            }
            
       public Testmodel(int testcode,String testname,String cost)
   {
        
        this.testcode= testcode;
        this.testname= testname;
        this.cost= cost;
        
   }

    public void setTestcode(int testcode) {
        this.testcode = testcode;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getTestcode() {
        return testcode;
    }

    public String getTestname() {
        return testname;
    }

    public String getCost() {
        return cost;
    }
       
       
       
    
    
    
       
   
     
    
    
    
    
    
    
}
