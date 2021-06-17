/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school;

import java.util.List;

/**
 *
 * @author Rachna
 */
public class DisplayManager {
    // screens
    public ManageTeacherUI manageteacherUI;
    public ManageStudentUI managestudentUI;
    public  LoginUI login;
    private AdminUI admin;
    public MainManager Mgr;
    
       
    DisplayManager(MainManager Mgr)
    {
        this.Mgr = Mgr;
    }
    public void createScreens() {
        manageteacherUI = new ManageTeacherUI(Mgr.getTeacherMgr());
        managestudentUI = new ManageStudentUI(Mgr.getStudentMgr()); 
        login = new LoginUI();
        showScreen1();
    }
        
//    public List<Teacher> getteachers() {
//        return Mgr.getTeacherMgr().getteachers();
//    }
     
     public void showScreen1() {
        //manageFlightUI.populateFlights(flightMgr.getFlights());
        login.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                login.setVisible(true);
//                manageteacherUI.setVisible(false);
//                managestudentUI.setVisible(false);
            }
        });    
    }
    public void showScreen2() { 
        manageteacherUI.setVisible(true);
//        login.setVisible(true);
//        managestudentUI.setVisible(false);
    }
    
    public void exitFRS() {
        manageteacherUI.setVisible(false);
        managestudentUI.setVisible(false);
        
       // boolean result = flightMgr.doHousekeeping();
//        if (result) 
//            System.out.println("System shuts down gracefully");
//        else 
//            System.out.println("System shuts down with error");
    }
    
    
}
