package com.praswish;

import java.sql.SQLException;

public interface EmployeeImpl {

    boolean addEmployee(Employee emp) throws ClassNotFoundException, SQLException;
    boolean editEmployee(Employee emp) throws ClassNotFoundException, SQLException;
    boolean deleteEmployee(int id) throws ClassNotFoundException,SQLException;
    Employee returnEmployee(int id) throws ClassNotFoundException,SQLException;
}
