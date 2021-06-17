/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school;

/**
 *
 * @author Rachna
 */
public class Student {
    private final String studentId;
    private final String firstname;
    private final String lastname;
    private final String dateofbirth;
    private final String mobilenumber;
    private final String emailID;
    private final String gender;
    private final String Class;
    
    public Student(String studentId,String Class,String firstname,String lastname,String dateofbirth,String gender,String mobilenumber,String emailID)  
    {
        this.Class = Class;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.emailID = emailID;
        this.studentId = studentId;
        this.mobilenumber = mobilenumber;
        this.gender = gender; 
    }
    public String getFirstname()
    {
        return firstname;
    }
    public String getLastname()
    {
        return lastname;
    }
    public String getstudentId()
    {
        return studentId;
    }
    public String getemailID()
    {
        return emailID;
    }
    public String getdateofbirth()
    {
        return dateofbirth;
    }
    public String getmobilenumber()
    {
        return mobilenumber;
    }
    public String getgender()
    {
        return gender;
    }
    public String getclass()
    {
        return Class;
    }
    @Override
    public String toString()
    {
        return this.getstudentId()+","+this.getclass()+","+this.getFirstname()+","+this.getLastname()+","+this.getdateofbirth()+","+this.getgender()+","+this.getmobilenumber()+","+this.getemailID();
    }

}
