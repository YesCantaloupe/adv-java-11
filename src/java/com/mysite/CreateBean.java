/* CreateBean.java */
package com.mysite;

import java.io.Serializable;
import java.sql.*;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;

@Named(value = "createBean")
@RequestScoped

public class CreateBean implements Serializable{
    
    @Resource(lookup = "java:jboss/datasources/MySQLDS")
    private DataSource dp;
    
    Hobby hobby = new Hobby();
    
    public Hobby getHobby(){
        return hobby;
    }
    
    public void setHobby(Hobby hobby){
        this.hobby=hobby;
    }
    
    public void performCreate() throws SQLException {
        if (dp==null){
            throw new SQLException("Cannot access data pool");
        }
        try (Connection con=dp.getConnection()){
            if(con==null){
                throw new SQLException("Cannot establish connection to database");
            }
            java.util.Date date_now = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date_now.getTime());
            String sql="insert into hobby values (NULL, ?, ?, ?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, hobby.getName());
            stmt.setString(2, hobby.getDescription());
            stmt.setDate(3,sqlDate);
            
            int result=stmt.executeUpdate();
            if(result>0){
                System.out.println(" Record Inserted");
            } else{
                System.out.println(" Record not Inserted");
            }
        }
    }
}
