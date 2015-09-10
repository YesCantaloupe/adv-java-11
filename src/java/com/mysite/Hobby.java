/* Hobby.java */
package com.mysite;

import java.io.Serializable;
import java.util.Date;

public class Hobby implements Serializable {
    
    private long hobbyID;
    private String name="Enter Name";
    private String description="Enter Description";
    private Date created_date;
    
    public long getHobbyID(){
        return hobbyID;
    }
    
    public void setHobbyID(long hobbyID){
        this.hobbyID=hobbyID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description=description;
    }
    
    public Date getCreated_date(){
        return created_date;
    }
    
    public void setCreated_date(Date created_date){
        this.created_date=created_date;
    }
}
