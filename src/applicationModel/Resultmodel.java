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
public class Resultmodel {
    private int resultnumber;
    private int patientnumber;
    private int testcode;
    private String result;
    private String cost;
     private String resultdate;
     
     
   public Resultmodel(){
    
    
    
}
   public Resultmodel(int resultnumber,int patientnumber,int testcode,String result,String cost,String resultdate)
   {
        this.resultnumber= resultnumber;
        this.patientnumber= patientnumber;
        this.testcode= testcode;
        this.result= result;
        this.cost= cost;
        this.resultdate= resultdate;
        
          
   
   
   
   
   
   }

    public void setResultnumber(int resultnumber) {
        this.resultnumber = resultnumber;
    }

    public void setPatientnumber(int patientnumber) {
        this.patientnumber = patientnumber;
    }

    public void setTestcode(int testcode) {
        this.testcode = testcode;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setResultdate(String resultdate) {
        this.resultdate = resultdate;
    }

    public int getResultnumber() {
        return resultnumber;
    }

    public int getPatientnumber() {
        return patientnumber;
    }

    public int getTestcode() {
        return testcode;
    }

    public String getResult() {
        return result;
    }

    public String getCost() {
        return cost;
    }

    public String getResultdate() {
        return resultdate;
    }
   
   
   
    
    
    
    
    
}
