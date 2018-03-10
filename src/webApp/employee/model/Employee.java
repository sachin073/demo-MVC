package webApp.employee.model;

/**
 * Created by sachin on 25/2/18.
 */

public class Employee {

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int empID;
    private String name;


    public Employee(int empID,String name){
        this.name=name;
        if (empID==0){
            empID= (int) Math.ceil(Math.random()*10);
        }
        this.empID=empID;
    }



}
