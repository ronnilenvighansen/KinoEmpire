package kino.model;

import kino.dao.EmployeeDao;

/**
 * Created by clint on 21-03-2017.
 */
public class Login {
private EmployeeDao employeeDao = new EmployeeDao();
private Employee e;
private Boolean existingUser = false;

    public Login(){}

    public Boolean checkLogin(String username, String password)
    {
        e = employeeDao.checkForEmployee(username,password);
        if(e.getID() != 0 )
        {
            existingUser = true;
        }
        return existingUser;
    }

    public Employee getEmployee()
    {
        return this.e;
    }
}
