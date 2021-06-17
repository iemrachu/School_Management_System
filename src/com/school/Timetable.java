/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author priya
 */
public class Timetable {
    private String[][]  timetable = new String[6][10];
    private String teacherid_class;
    public Timetable(String[][] timetable, String teacherid_class){
        this.teacherid_class = teacherid_class;
        
        this.timetable = timetable;
        
    }
public String getteacherid_class(){
    return teacherid_class;
}

public String[][] gettimetable(){
    return timetable;
}
//public String writer(){
//    String data[];
//    for(int i=0; i<7;i++){
//        String str;
//        for(int j=0; j<10; j++){
//            bw.write(timetable[i][j].toString()+",");
//        }
//    }
//   
    
} 
