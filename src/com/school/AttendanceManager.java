/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school;
//import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Win8.1
 */


public class AttendanceManager {
    
     //String[] studentID;
     private List<Attendance> attendanceList;
     String value,response;
     String id;
     
      public boolean init(String filename) {
        boolean result = false;
       this.attendanceList.add(new Attendance("3/2/2021","1,0,1,1,0"));
       this.attendanceList.add(new Attendance("7/2/2021","1,0,0,1,1"));
        result = true;
        return true;
    }
    

    public AttendanceManager() {
         this.attendanceList = new ArrayList<Attendance>();
         //this.id=idd;
         
    }
   
    public void setFile(String value){
        this.value=value;
    }
   
     
     public List<Attendance> getAttendanceDetails() {
        List<Attendance> result = null;
        
        result = Collections.unmodifiableList(this.attendanceList);
        return result;
    }
     
      public boolean addAttendance(Attendance newAttendance) throws IOException {
        
          
        boolean result = false;
        File file = null;
        if(value == "1"){
                file= new File("Class1.csv");
                if(!file.exists()){
                    file.createNewFile();
                }
            }else if(value == "2"){
               file= new File("Class2.csv");
                if(!file.exists()){
                    file.createNewFile();
                } 
            }else if(value == "3"){
                file= new File("Class3.csv");
                if(!file.exists()){
                    file.createNewFile();
                }
            }else if(value == "4"){
                file= new File("Class4.csv");
                if(!file.exists()){
                    file.createNewFile();
                }
            }else if(value == "5"){
                file= new File(".csv");
                if(!file.exists()){
                    file.createNewFile();
                }
            }
        
        this.attendanceList.add(newAttendance);
        System.out.println("added " + newAttendance.toString());
        FileWriter fw= new FileWriter(file,true);
        BufferedWriter bw= new BufferedWriter(fw);
             bw.write(newAttendance.toString());
             //JOptionPane.showMessageDialog(AttendanceUI, "Attendance Marked successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
         
             //Logger.getLogger(AttendanceManager.class.getName()).log(Level.SEVERE, null, ex);
             //JOptionPane.showMessageDialog(AttendanceUI, "ERROR","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        bw.newLine();
        bw.close();
        fw.close();
            
        result = true;
        
        return result;
    }
      
      public String viewAttendance(String response){
          
        BufferedReader reader;
        int val, cls,roll,sum,len;
        val=Integer.parseInt(response);
        
        
        cls=val/100;
        
        if(cls<1 || cls>5){
            //JOptionPane.showMessageDialog(null, "Invalid ID!!");
            JOptionPane.showMessageDialog(null, "INVALID ID","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        roll=val%100;
        String filepath="";
        
        if(cls==1){
            len=0;
            filepath = "1.csv";
            String line="";
            try {
                BufferedReader br= new BufferedReader(new FileReader(filepath));
                while( (line = br.readLine() )!= null){
                    len++;
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(roll>len){
                //JOptionPane.showMessageDialog(null, "Invalid ID");
                JOptionPane.showMessageDialog(null, "INVALID ID","ERROR",JOptionPane.ERROR_MESSAGE);

            }
            
        }
        
        //System.out.print(roll);
        if(cls==1){
            filepath="Class1.csv";
        
            sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                //System.out.println(fields.);
                if(fields.length>roll){
                    sum = sum + Integer.parseInt(fields[roll]);
                }
                else{
                    continue;
                }
                
                
            }
                //System.out.print(sum);
                
                String msg="<html>StudentID= "+response+"<br><br>"
                        +"No of days present= "+sum+"<br><br>"
                        +"Total working days= "+len+"<b+r>";
                
                JOptionPane.showMessageDialog(null, msg);
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else if(cls==2){
            filepath="2.csv";
             sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                if(fields.length>roll){
                    sum = sum + Integer.parseInt(fields[roll]);
                }
                else{
                    continue;
                }
            }
                System.out.print(sum);
                
                String msg="<html>StudentID= "+response+"<br><br>"
                        +"No of days present= "+sum+"<br><br>"
                        +"Total working days= "+len+"<br>";
                
                JOptionPane.showMessageDialog(null, msg);
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(cls==3){
            filepath="Class3.csv";
             sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                if(fields.length>roll){
                    sum = sum + Integer.parseInt(fields[roll]);
                }
                else{
                    continue;
                }
            }
                System.out.print(sum);
                
                String msg="<html>StudentID= "+response+"<br><br>"
                        +"No of days present= "+sum+"<br><br>"
                        +"Total working days= "+len+"<br>";
                
                JOptionPane.showMessageDialog(null, msg);
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(cls==4){
            filepath="Class4.csv";
             sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                if(fields.length>roll){
                    sum = sum + Integer.parseInt(fields[roll]);
                }
                else{
                    continue;
                }
            }
                System.out.print(sum);
                
                String msg="<html>StudentID= "+response+"<br><br>"
                        +"No of days present= "+sum+"<br><br>"
                        +"Total working days= "+len+"<br>";
                
                JOptionPane.showMessageDialog(null, msg);
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(cls==5){
            filepath="Class5.csv";
             sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                if(fields.length>roll){
                    sum = sum + Integer.parseInt(fields[roll]);
                }
                else{
                    continue;
                }
            }
                System.out.print(sum);
                
                String msg="<html>StudentID= "+response+"<br><br>"
                        +"No of days present= "+sum+"<br><br>"
                        +"Total working days= "+len+"<br>";
                
                JOptionPane.showMessageDialog(null, msg);
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
          return "";
      }
      
    
    /*void mark(int studentID){
        
    }
    
    void selectCls(){
        
    }*/
    public static void maink(String idd) {
//        String id;
//        this.id
        // instantiate Manager
        AttendanceManager mgr = new AttendanceManager();
        
        // initialise
        mgr.init("Class1.csv");
        
        // unit tests
        //assert(mgr.getAttendanceDetails().size()==2);
        //String tempDate=mgr.getAttendanceDetails().get(0).getDate();
        //assert(mgr.getAttendanceDetails().get(0).getDate().equals("3/2/2021"));
        
        // create screens
         
         JFrame attendanceUI = new AttendanceUI(mgr,idd);
        //JFrame addFlightUI = new AUI(mgr);
        attendanceUI.setVisible(true);
        //manageFlightsUI.setVisible(true);
        //addFlightUI.setVisible(true);
    }
}
