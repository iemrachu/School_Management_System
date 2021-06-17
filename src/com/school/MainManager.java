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
public class MainManager {
    private TeacherManager teacherMgr;  
    private StudentManager studentMgr; 
    private DisplayManager disMgr;
   
    
    public boolean init() {
        boolean result = true;
        
        // create managers and call init()
        
        result = teacherMgr.init("Teachers.csv");
        
        result = studentMgr.init();
        
        disMgr.createScreens();
        
        return result;
    }
    
   
    public StudentManager getStudentMgr()
    {
        return this.studentMgr;
    }
    public DisplayManager getDisplayMgr()
    {
        return this.disMgr;
    }
     public TeacherManager getTeacherMgr() {
        return this.teacherMgr;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    public static void main(String[] args)
    {
        MainManager ob = new MainManager();
        //ob.teacherMgr = new TeacherManager(ob);
        //ob.studentMgr = new StudentManager(ob);
        ob.disMgr = new DisplayManager(ob);
        
        ob.init();
        
    }

    
}
