/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Rachna
 */
public class StudentManager {
    private String studentId;
    private List <Student> studentslist;
    private Student ans;
    private MainManager mgr;
    StudentManager()
    {
      //this.mgr = mgr;
      this.studentslist = new ArrayList<Student>();
    }
    public boolean init()  { 
        boolean result = false;
        String line = "";   
        String splitBy = ","; 
        String filename;
        for(int i=1;i<=5;i++)
        {
        BufferedReader br;
        try {
            filename = i+".csv";
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }
        try {
            //line = br.readLine();
            while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
            String[] student = line.split(splitBy); // use comma as separator 
            if(student.length > 0)
            {
                Student a = new Student(student[0],student[1],student[2],student[3],student[4],student[5],student[6],student[7]);
                studentslist.add(a);
            }
            }
            br.close();
        } catch (IOException ex) {
           
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
             return result;
        }
        }
        result = true;
        return result;
    }
    public List<Student> getstudents() {
        List<Student> result = null;
        result = Collections.unmodifiableList(this.studentslist);
        return result;
    } 
     public boolean addstudent(Student newstudent,String Class)  {
        boolean result = false; 
        FileWriter Writer;
        String filename = Class+".csv";
        try {
        Writer = new FileWriter(filename,true);
        studentslist.add(newstudent); 
        Writer.write(newstudent.toString()); 
        Writer.write(System.getProperty("line.separator"));
        System.out.println("added " + newstudent.toString());
        Writer.close();
        }
        catch (IOException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        result = true;
        return result;
    } 
    void delete(String studentId)
    {
        String line;
        String student[];
        String filename = studentId.charAt(0)+".csv";
        File tempFile = new File("temp.csv"); 
        File inputFile = new File(filename);
        int c = 0;
          try
          {
            FileWriter fw = new FileWriter(tempFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            
            //line = br.readLine();
            
            while((line = br.readLine())!= null)
            {
               student = line.split(",");
               if(!(student[0].equals(studentId)))
               {         
                   pw.println(line);
               }
            }
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
            br.close();
            fr.close();
         } catch (IOException ex) {
               Logger.getLogger(ManageStudentUI.class.getName()).log(Level.SEVERE, null, ex);
           }
          inputFile.delete();
          tempFile.renameTo(inputFile);
          for(Student t1:studentslist)
          {
            if((t1.getstudentId()).equals(studentId))
            {
              break;
            }
            c++;
          }
          studentslist.remove(c);      
    } 
    public Student edit(String studentId) 
    {
           for(Student t1:studentslist)
           {
           if((t1.getstudentId()).equals(studentId))
           {
            ans = t1;
            break;
           }
           }
           return ans;
    }
    
    public Student view(String studentId)
    {              
          for(Student t1:studentslist)
           {
           if((t1.getstudentId()).equals(studentId))
           {
             ans = t1;
             break;  
           }
           }
         return ans;  
    }
    
    public boolean validateId(String studentId)
    {
        for(Student t1:studentslist)
       {
           if((t1.getstudentId()).equals(studentId))
           {
             return true;
           }
       }  
         return false;   
    }
     public static void maink()    
    { 
            StudentManager ob = new StudentManager();
            boolean r = ob.init();
            if(r==false)
            {
               System.out.println("Exception");
            }    
        //assert(ob.getstudents().size()== 5);
       // assert(ob.getstudents().get(0).getclass().equals("1"));
        JFrame StudentUI = new ManageStudentUI(ob);
        StudentUI.setVisible(true);
    }
}

