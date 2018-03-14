package webApp.employee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by sachin on 25/2/18.
 */

@Document
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

    @Id
    private int empID;

    @Field("EMP_NAME")
    private String name;


    public Employee(int empID,String name){
        this.name=name;
        if (empID==0){
            empID= (int) Math.ceil(Math.random()*10);
        }
        this.empID=empID;
    }



}
