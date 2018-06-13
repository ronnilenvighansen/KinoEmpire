package kino.dao;

import kino.model.Employee;
import kino.utility.SQLConnection;
import java.sql.*;
/**
 * Created by ronnilenvighansen on 16/03/2017.
 */
public class EmployeeDao implements EmployeeDaoInterface {

    private Connection connection;

    public EmployeeDao() {
        connection = SQLConnection.getConnection();
    }

    public void createEmployee(String name_employee, String username, String admin_status, String password) {
        try {
            PreparedStatement prepstat = connection.prepareStatement(
                    "INSERT INTO employee(name_employee, username, admin_status, password) VALUES (?,?,?,?)");
            prepstat.setString(1, name_employee);
            prepstat.setString(2, username);
            prepstat.setString(3, admin_status);
            prepstat.setString(4, password);
            prepstat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteEmployee(int id_employee) {
        try {
            PreparedStatement prepstat = connection.prepareStatement("DELETE FROM employee WHERE id_employee = ?");
            prepstat.setInt(1, id_employee);
            prepstat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            PreparedStatement prepstat = connection.prepareStatement(("UPDATE employee SET name_employee = ?, username = ?, admin_status = ?, password = ?"));
            prepstat.setString(1, employee.getName());
            prepstat.setString(2, employee.getUsername());
            prepstat.setString(3, employee.getStatus());
            prepstat.setString(4, employee.getPassword());
            prepstat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Employee checkForEmployee(String username, String password) {
        Employee e = new Employee();
        try {
            PreparedStatement prepstat = connection.prepareStatement(("SELECT * FROM employee WHERE username = ? and password = ?;"));
            prepstat.setString(1, username);
            prepstat.setString(2, password);
            ResultSet rs = prepstat.executeQuery();

            if (rs.next()) {
                e.setID(rs.getInt("id_employee"));
                e.setName(rs.getString("name_employee"));
                e.setUsername(rs.getString("username"));
                e.setStatus(rs.getString("admin_status"));
                e.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return e;
    }
}
