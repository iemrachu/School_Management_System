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
public class Teacher {
    private final String teacherId;
    private final String firstname;
    private final String lastname;
    private final String dateofbirth;
    private final String mobilenumber;
    private final String emailID;
    private final String gender;
    private final String qualification;
    private final String experience;
    private final String specialization;
    
    public Teacher(String firstname,String lastname,String dateofbirth,String mobilenumber,String gender,String emailID,String designation,String teacherId,String qualification,String experience)  
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.emailID = emailID;
        this.teacherId = teacherId;
        this.mobilenumber = mobilenumber;
        this.gender = gender;
        this.qualification = qualification;
        this.experience = experience;
        this.specialization = designation;
    }
    public String getFirstname()
    {
        return firstname;
    }
    public String getLastname()
    {
        return lastname;
    }
    public String getteacherId()
    {
        return teacherId;
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
     public String getqualification()
    {
        return qualification;
    }
    public String getexperience()
    {
        return experience;
    }
    public String getspecialization()
    {
        return specialization;
    }
    @Override
    public String toString()
    {
        return this.getFirstname()+","+this.getLastname()+","+this.getdateofbirth()+","+this.getmobilenumber()+","+this.getgender()+","+this.getemailID()+","+this.getspecialization()+","+this.getteacherId()+","+this.getqualification()+","+this.getexperience();
    }
}
