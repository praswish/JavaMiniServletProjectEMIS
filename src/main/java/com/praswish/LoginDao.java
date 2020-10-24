package com.praswish;


import java.sql.*;

public class LoginDao {

    public boolean checklogin(String uname, String pwd){

        String url ="jdbc:mysql://localhost:3306/emis";
        String dbUser ="root";
        String dbPass ="nepal123";
        String sql = "SELECT * FROM credential WHERE email=? AND password =?";


        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,dbUser,dbPass);
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,uname);
            st.setString(2,pwd);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean changePassword(String uname, String pwd, String newpwd){
        String url ="jdbc:mysql://localhost:3306/emis";
        String dbUser ="root";
        String dbPass ="nepal123";
        String sql = "UPDATE credential SET password = '" + newpwd +
                "' WHERE email='" + uname + "' AND password ='" + pwd + "'";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,dbUser,dbPass);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println(st);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
    public boolean checkUser(String uname){
        String url ="jdbc:mysql://localhost:3306/emis";
        String dbUser ="root";
        String dbPass ="nepal123";
        String sql = "SELECT * FROM credential WHERE email=?";


        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,dbUser,dbPass);
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,uname);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(String uname, String pwd){

        String url ="jdbc:mysql://localhost:3306/emis";
        String dbUser ="root";
        String dbPass ="nepal123";
        String sql ="INSERT INTO credential(email,password,login_date,status) VALUES ( '"+ uname +
                "' ,'" + pwd +"' ,'2020-10-18',true)" ;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,dbUser,dbPass);
            Statement st = con.createStatement();
            st.execute(sql);
            System.out.println(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
