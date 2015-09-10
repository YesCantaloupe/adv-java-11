/* DeleteBean.java */
package com.mysite;

import java.io.Serializable;
import java.sql.*;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;

@Named(value = "deleteBean")
@RequestScoped

public class DeleteBean implements Serializable{
    
    @Resource(lookup = "java:jboss/datasources/MySQLDS")
    private DataSource dp;
    
    Hobby hobby = new Hobby();
    
    public Hobby getHobby(){
        return hobby;
    }
    
    public void setHobby(Hobby hobby){
        this.hobby=hobby;
    }
    
    public void performDelete() throws SQLException {
        if (dp==null){
            throw new SQLException("Cannot access data pool");
        }
        try (Connection con=dp.getConnection()){
            if(con==null){
                throw new SQLException("Cannot establish connection to database");
            }
            String sql="delete from hobby where hobby_id = ?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, (int)hobby.getHobbyID());
            
            int result=stmt.executeUpdate();
            if(result>0){
                System.out.println(" Record Deleted");
            } else{
                System.out.println(" Record not Deleted");
            }
        }
    }
}
