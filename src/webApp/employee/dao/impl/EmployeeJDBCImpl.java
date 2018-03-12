package webApp.employee.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import webApp.DatabaseConfig;
import webApp.employee.dao.EmployeeDao;
import webApp.employee.model.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sachin on 25/2/18.
 */


@Configuration
@Component
public class EmployeeJDBCImpl implements EmployeeDao {

    public DataSource dataSource;

    public EmployeeJDBCImpl(){
    }

    @Autowired
    public EmployeeJDBCImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }


    @Override
    public Employee getEmployee(int empID) {

        String sql = "Select * from EMPLOYEE " +
                " WHERE EMP_ID=?";
        Connection conn = null;
        Employee emp=null;
        try {
            System.out.println(dataSource);
            if (dataSource==null){
                DatabaseConfig ds = new DatabaseConfig();

                dataSource = ds.getDataSource();
            }
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, empID);
            ResultSet rs = ps.getResultSet();
            ps.close();
            if (rs !=null){
                emp.setEmpID(rs.getInt("ID"));
                emp.setName(rs.getString("NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
        return emp;
    }

    @Override
    public int insert(Employee employee) {

        String sql = "INSERT INTO EMPLOYEE " +
                "(ID, NAME) VALUES (?, ?)";
        Connection conn = null;

        try {
            System.out.println(dataSource);
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employee.getEmpID());
            ps.setString(2, employee.getName());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }


        return 0;
    }
}
