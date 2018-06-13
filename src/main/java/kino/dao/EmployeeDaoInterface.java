package kino.dao;

import kino.model.Employee;

/**
 * Created by ronnilenvighansen on 16/03/2017.
 */
public interface EmployeeDaoInterface {
    public void createEmployee(String employee_name, String username, String admin_status, String password);
    public void deleteEmployee(int id_employee);
    public void updateEmployee(Employee employee);
}
