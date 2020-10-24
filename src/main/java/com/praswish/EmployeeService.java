package com.praswish;

import java.sql.*;

public class EmployeeService implements EmployeeImpl{


    String url ="jdbc:mysql://localhost:3306/emis";
    String dbUser ="root";
    String dbPass ="nepal123";
    public EmployeeService() throws SQLException {
    }

    @Override
    public boolean addEmployee(Employee emp) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,dbUser,dbPass);
        Statement st = con.createStatement();
        String sql ="INSERT INTO employee (name,address,email,dob,salary) VALUES ("
                +"'" + emp.getName() + "','" + emp.getAddress() + "','" + emp.getEmail()
                +"','" + emp.getDob() +"', "+emp.getSalary()  +")";
        st.executeUpdate(sql);
        return true;
    }

    @Override
    public boolean editEmployee(Employee emp) throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,dbUser,dbPass);
            Statement st = con.createStatement();
            String sql ="Update employee set name = '" + emp.getName()
                    + "', address = '"+ emp.getAddress()
                    + "', email = '"+ emp.getEmail()
                    + "', dob = '"+ emp.getDob()
                    + "', salary = "+ emp.getSalary()
                    + "WHERE id = " + emp.getId();
            System.out.println(sql);
            st.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,dbUser,dbPass);
        Statement st = con.createStatement();
        try{
            String sql ="delete from employee where id = " + id;
            st.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public Employee returnEmployee(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,dbUser,dbPass);
        Statement st = con.createStatement();
        try{
            ResultSet rs = st.executeQuery("select * from employee where id = " + id);
            if (rs.next()){
                Employee emp=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3)
                , rs.getString(4),rs.getString(5),rs.getDouble(6));
                return emp;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
