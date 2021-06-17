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
public class TeacherManager {
    private String teacherId;
    private List <Teacher> teacherslist;  
    private MainManager mgr;
    private Teacher ans;
    TeacherManager()
    {
     // this.mgr = mgr;
      this.teacherslist = new ArrayList<Teacher>();
      
    }
    public boolean init(String filename)  {
        
        boolean result = false;
        String line = "";  
        String splitBy = ",";  
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("Teachers.csv"));
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(TeacherManager.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }
        try {
            line = br.readLine();
            while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
            String[] teacher = line.split(splitBy); // use comma as separator 
            if(teacher.length > 0)
            {
                Teacher a = new Teacher(teacher[0],teacher[1],teacher[2],teacher[3],teacher[4],teacher[5],teacher[6],teacher[7],teacher[8],teacher[9]);
                teacherslist.add(a);
            }
            }
            br.close();
        } catch (IOException ex) {
           
            Logger.getLogger(TeacherManager.class.getName()).log(Level.SEVERE, null, ex);
             return result;
        }
        result = true;
        return result;
    }
    public List<Teacher> getteachers() {
        List<Teacher> result = null;
        result = Collections.unmodifiableList(this.teacherslist);
        return result;
    }   
    public boolean addteacher(Teacher newteacher) {
        boolean result = false; 
        try {
        FileWriter Writer;
        Writer = new FileWriter("Teachers.csv",true);
        teacherslist.add(newteacher); 
        Writer.write(newteacher.toString()); 
        Writer.write(System.getProperty("line.separator"));
        System.out.println("added " + newteacher.toString());
        Writer.close();
        }
        catch (IOException ex) {
           
            Logger.getLogger(TeacherManager.class.getName()).log(Level.SEVERE, null, ex);
             return result;
        }
        
        result = true;
        return result;
    } 
    void delete(String teacherId)
    {
        String line;
        String teacher[];
        File tempFile = new File("temp.csv"); 
        File inputFile = new File("Teachers.csv");
        int c = 0,s=0;
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
               teacher = line.split(",");
               if(!(teacher[7].equals(teacherId)))
               {
                   c++;            
                   pw.println(line);
               }
               else
                  s = c; 
            }
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
            br.close();
            fr.close();
         } catch (IOException ex) {
               Logger.getLogger(ManageTeacherUI.class.getName()).log(Level.SEVERE, null, ex);
           }
          inputFile.delete();
          tempFile.renameTo(inputFile);  
          teacherslist.remove(s-1); 
          
    } 
    public Teacher edit(String teacherId)
    {
           for(Teacher t1:teacherslist)
           {
           if((t1.getteacherId()).equals(teacherId))
           {
            ans = t1;
            break;
           }
           }
           return ans;
    }
    
    public Teacher view(String teacherId)
    {              
          for(Teacher t1:teacherslist)
           {
           if((t1.getteacherId()).equals(teacherId))
           {
             ans = t1;
             break;  
           }
           System.out.println(t1.getteacherId());
           }
         return ans;  
    }
    
    public boolean validateId(String teacherId)
    {
        for(Teacher t1:teacherslist)
       {
           if((t1.getteacherId()).equals(teacherId))
           {
             return true;
           }
       }  
         return false;   
    }
 
     public static void maink()    
    { 
            TeacherManager ob = new TeacherManager();
            boolean r = ob.init("Teachers.csv");
            if(r==false)
            {
               System.out.println("Exception");
            }    
        //assert(ob.getteachers().size()== 5);
       // assert(ob.getteachers().get(0).getexperience().equals("2"));
        JFrame TeacherUI = new ManageTeacherUI(ob);
        TeacherUI.setVisible(true);
    }
}
//}
//    String line = "";  
//    String splitBy = ",";  
//    BufferedReader br = new BufferedReader(new FileReader("D:\\tracks\\ManageTeacherUI.csv"));
//    try
//    {
//    while ((line = br.readLine()) != null)   //returns a Boolean value  
//    {  
//    String[] teacher = line.split(splitBy); // use comma as separator 
//    if(teacher.length > 0)
//    {
//        Teacher a = new Teacher(teacher[0],teacher[1],teacher[2],teacher[3],teacher[4],teacher[5],teacher[6],teacher[7],teacher[8],teacher[9]);
//        teachersdata.add(a);
//    }
//    for(Teacher t1:teachersdata)
//    {
//     System.out.println(t1.getFirstname());
//     System.out.println(t1.getLastname());
//     System.out.println(t1.getteacherId());
//     System.out.println(t1.getdateofbirth());
//     System.out.println(t1.getemailID());
//     System.out.println(t1.getqualification());
//     System.out.println(t1.getdesignation());
//     System.out.println(t1.getmobilenumber());
//     System.out.println(t1.getexperience());
//     System.out.println(t1.getgender()); 
//    }
//    br.close();
//    }   
//    catch (IOException e)   
//    {  
//    e.printStackTrace();  
//    } 
//    Teacher t1 = new Teacher("Rachu","Agarwal","07-08-1987","1234567890","Female","rachna@gmail.com",,"Professor","13","B.tech","2");
//    Teacher t2 = new Teacher("Rohit","Shaw","08-09-1998","9046373829","Male","rt@gmail.com","Professor","14","B.Sc","1");
//    List<teacherentity> teachers = new ArrayList();
//    teachers.add(t1);
//    teachers.add(t2);
//    try
//    {
//        FileWriter fileWriter = new FileWriter("D:\\tracks\\ManageTeacherUI.csv",true);
//         for (Teacher t : teachers) {
//                fileWriter.append(t.getFirstname());
//                fileWriter.append(",");
//                fileWriter.append(t.getLastname());
//                fileWriter.append(",");
//                fileWriter.append(t.getdateofbirth());
//                fileWriter.append(",");
//                fileWriter.append(t.getmobilenumber());
//                fileWriter.append(",");
//                fileWriter.append(t.getgender());
//                fileWriter.append(",");
//                fileWriter.append(t.getemailID());
//                fileWriter.append(",");
//                fileWriter.append(t.getspecialization());
//                fileWriter.append(",");
//                fileWriter.append(t.getteacherId());
//                fileWriter.append(",");
//                fileWriter.append(t.getqualification());
//                fileWriter.append(",");
//                fileWriter.append(t.getexperience());
//                fileWriter.append(",");
//            }
//         fileWriter.flush();
//    fileWriter.close();
//    }
//    catch (IOException e)   
//    {  
//        e.printStackTrace();   
//    } 
//    
//}

    

