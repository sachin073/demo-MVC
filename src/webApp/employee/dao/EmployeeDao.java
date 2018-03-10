package webApp.employee.dao;

import webApp.employee.model.Employee;

/**
 * Created by sachin on 25/2/18.
 */
public interface EmployeeDao {

    public int insert(Employee employee);

    public Employee getEmployee(int empID);



}
