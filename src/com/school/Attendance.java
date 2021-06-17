/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school;

/**
 *
 * @author Win8.1
 */
public class Attendance {

   private String attendance;
   private String date;

    public Attendance( String date,String attendance) {
        this.attendance = attendance;
        this.date=date;
    }
   

   

    public String getAttendance() {
        return attendance;
        // TODO code application logic here
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    /*String getStudentID(String cls){
    return studentID;
    }*/
    public void setDate(String date) {
        this.date = date;
    }
    
     public String toString() {
        // stringify Flight class
        String result= "" + this.getDate()+
                ""+this.getAttendance();
       /*int i;
       for(i=0;i<attendance.length;i++){
           result=result+","+attendance[i]+",";
       }*/
        return result;
    } 

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        // TODO code application logic here
    }*/
}
