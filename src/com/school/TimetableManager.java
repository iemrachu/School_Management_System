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
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.swing.JFrame;


/**
 *
 * @author priya
 */
public class TimetableManager {
    private Timetable t;
    private CreateTimetableUI q;
    private String[][] data = new String[6][10];
    private Timetable ans;
    private List <Timetable> timetablelist;
    String teacherid_class="";
    public TimetableManager() {
        
        this.timetablelist = new ArrayList<Timetable>(); 
         
    }
    
    public String[][] newArray(int row, int col) {
   return new String[row][col];

}

 public void init( String file){
     timetablelist.clear();
     String tchridcls;
     data = newArray(6, 10);
     
     
     try{
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    
                    Object[] lines = br.lines().toArray();
                    int i=0,j=0;
                    
                    while(i<lines.length){
                        String[] row = lines[i].toString().split(",",-1);
                        
                        tchridcls=row[0];
                        
                        data[j][0]=row[1];
                        
                        data[j][1]=row[2];
                        data[j][2]=row[3];
                        data[j][3]=row[4];
                        data[j][4]=row[5];
                        data[j][5]=row[6];
                        data[j][6]=row[7];
                        data[j][7]=row[8];
                        data[j][8]=row[9];
                        data[j][9]=row[10];
                        
//                        else{
//                        data2[j][0]=row[1];
//                        
//                        data2[j][1]=row[2];
//                        data2[j][2]=row[3];
//                        data2[j][3]=row[4];
//                        data2[j][4]=row[5];
//                        data2[j][5]=row[6];
//                        data2[j][6]=row[7];
//                        data2[j][7]=row[8];
//                        data2[j][8]=row[9];
//                        data2[j][9]=row[10];
//                        }
                        i++;
                        j++;
                       
                        if(i%6==0){
                            
                        //if(k==0)    
                        t = new Timetable(data,tchridcls);
                        data = newArray(6, 10);
//                        else{
//                        t = new Timetable(data2,tchridcls);
//                        data2 = newArray(6, 10);}
                        timetablelist.add(t);
                        j=0;
                       // k++;
                        
                        }
                        
                    }
                    
                }
                catch( FileNotFoundException e) {
                    e.printStackTrace();
                    
                    q.showMessage("ID/Class Found but timetable database not found, Try creating a new timetable for the same");

                }          
}
String teacheridcls;
public Timetable open(String teacherId){

    for(Timetable t1:timetablelist)
           { System.out.println(t1.getteacherid_class());
           if((t1.getteacherid_class()).equals(teacherId))
           {
             ans = t1;
             break;
             
           }
           
           }
         return ans; 
}
public boolean save(Timetable data, File file){
    boolean result =false;
    String[][] d = new String[6][10];
    int id=0;
    try{
    PrintWriter writer = new PrintWriter(file);
    writer.print("");
    writer.close();
    }
    catch( FileNotFoundException e) {
            e.printStackTrace();   
        }
    for(Timetable t1:timetablelist)
           {
               
           
           if((t1.getteacherid_class()).equals(data.getteacherid_class()))
           {timetablelist.set(id, data);
               try{
             BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
             d=data.gettimetable();
                for(int i=0;i<6;i++){
                    
                    for(int j=0;j<10;j++){
                        if(j==0)
                        bw.write(data.getteacherid_class()+ ",");
                        bw.write(d[i][j]+",");
                    }
                    bw.newLine();
                }
                bw.close();
           }
           catch( FileNotFoundException e) {
                    e.printStackTrace();   
        }
            catch(IOException e){
                e.printStackTrace();
            }
               continue;
           }
           
               try{
                   d=t1.gettimetable();
                BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
                for(int i=0;i<6;i++){
                    for(int j=0;j<10;j++){
                        if(j==0)
                        bw.write(t1.getteacherid_class()+ ",");
                        bw.write(d[i][j]+",");
                    }
                    bw.newLine();
                }
                bw.close();
               }
catch( FileNotFoundException e) {
                    e.printStackTrace();   
        }
            catch(IOException e){
                e.printStackTrace();
            }
               id++;
            }
       //  q.showMessage("Saved Successfully");
result=true;
return result;
}
public boolean createnew(Timetable data, String file){
    boolean result = false;
    timetablelist.add(data);
    for(Timetable t1:timetablelist){
        System.out.println(t1.getteacherid_class());
    }
    String[][] d = new String[6][10];
    d=data.gettimetable();
    try{
    BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
                for(int i=0;i<6;i++){
                    for(int j=0;j<10;j++){
                       if(j==0)
                        bw.write(data.getteacherid_class()+",");
                       bw.write(d[i][j]+ ",");
                    }
                    bw.newLine();
                }
               bw.close();
                
            }
            catch( FileNotFoundException e) {
                    e.printStackTrace();   
        }
            catch(IOException e){
                e.printStackTrace();
            }
//            q.showMessage( "Saved Successfully");

result=true;
return result;
}
public static void maint()    
    {       TimetableManager q = new TimetableManager();
    String file = "teacher timetable.csv";
    q.init(file);
            
            CreateTimetableUI w = new CreateTimetableUI(q);
            w.runn(q);
            //w.setVisible(true);
           }
   
        //assert(ob.getstudents().size()== 5);
       // assert(ob.getstudents().get(0).getexperience().equals("2"));
        
 }