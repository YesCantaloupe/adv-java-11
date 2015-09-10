/* ReadBean.java */
package com.mysite;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;

@Named(value = "readBean")
@RequestScoped

public class ReadBean implements Serializable{
    
    @Resource(lookup = "java:jboss/datasources/MySQLDS")
    private DataSource dp;
       
    public List<Hobby> performRead() throws SQLException {
        if (dp==null){
            throw new SQLException("Cannot access data pool");
        }
        List<Hobby> list;
        try (Connection con=dp.getConnection()){
            if(con==null){
                throw new SQLException("Cannot establish connection to database");
            }
            PreparedStatement ps=con.prepareStatement(
                    "select hobby_id, hobby_name, description, created_date from hobby");
            ResultSet result = ps.executeQuery();
            list=new ArrayList<>();
            while (result.next()){
                Hobby per=new Hobby();
                per.setHobbyID(result.getInt("hobby_id"));
                per.setName(result.getString("hobby_name"));
                per.setDescription(result.getString("description"));
                per.setCreated_date(result.getDate("created_date"));
                list.add(per);
            }
        }
        return list;
    }
}
