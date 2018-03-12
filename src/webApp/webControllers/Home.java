package webApp.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import webApp.employee.dao.impl.EmployeeJDBCImpl;
import webApp.employee.model.Employee;

/**
 * Created by sachin on 24/2/18.
 */

@Controller
public class Home {


    @RequestMapping(value = "/home" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String showHome(){
        return "home";
    }

    EmployeeJDBCImpl employeeJDBC;

    @Autowired
    public void setEmployeeJDBC(EmployeeJDBCImpl employeeJDBC) {
        this.employeeJDBC = employeeJDBC;
    }

    @RequestMapping(value = "/home/insertEmp",method = RequestMethod.POST)
    public String  insertEmployee(@RequestParam("ID") String id, @RequestParam("Name") String name){

        Employee employee= new Employee(Integer.parseInt(id),name);
        employeeJDBC.insert(employee);
        return "redirect:/home";
    }



    @RequestMapping(value = "/home/insertEmpUnwire",method = RequestMethod.POST)
    public String  insertEmployeeStatic(@RequestParam("ID") String id, @RequestParam("Name") String name){

        Employee employee= new Employee(Integer.parseInt(id),name);
        EmployeeJDBCImpl employeeJDBC= new EmployeeJDBCImpl();
        employeeJDBC.insert(employee);
        return "redirect:/home";
    }


    //rest and utils method using msg converter as other way is too clunky
    @RequestMapping(value = "/restEmp" , method = RequestMethod.GET)
    public @ResponseBody Employee getEmpByID(@RequestParam("ID") int id){
        //return employeeJDBC.getEmployee(id);
        return new Employee(1,"sachin");
    }


    @RequestMapping(value = "/simpleJSP", method = RequestMethod.GET)
    public String simpleTile(){
        return "tileJSP";
    }



}
