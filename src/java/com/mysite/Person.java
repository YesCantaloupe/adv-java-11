/* Hobby.java */
package com.mysite;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    
    private long personID;
    private String name="Enter Name";
    private String nickname="Enter Nickname";
    private Date created_date;
    
    public long getPersonID(){
        return personID;
    }
    
    public void setPersonID(long personID){
        this.personID=personID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getNickname(){
        return nickname;
    }
    
    public void setNickname(String nickname){
        this.nickname=nickname;
    }
    
    public Date getCreated_date(){
        return created_date;
    }
    
    public void setCreated_date(Date created_date){
        this.created_date=created_date;
    }
}
