package com.school;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
        
//ackage attendance_package;

/**
 *
 * @author Win8.1
 */
public class AttendanceUI extends javax.swing.JFrame {

    /**
     * Creates new form attendance
     */
    int len=0,i;
    String id;
    String attend=" ";
    private AttendanceManager mgr;
    String selectedValue,nowDate;
    public AttendanceUI(AttendanceManager mgr, String idd) {
        this.mgr=mgr;
        this.id=idd;
        initComponents();
       dateSet();
    }

    /*AttendanceUI(AttendanceManager mgr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    
    
    
    public void dateSet(){
         DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now= LocalDateTime.now();
        jLabel5.setText(dtf.format(now));
        nowDate=dtf.format(now)+" ";
    }
    
    private static class PositiveIntegerCellEditor extends DefaultCellEditor {
//create 2 constant to be used when input is invalid and valid
    private static final Border red = new LineBorder(Color.red);
    private static final Border black = new LineBorder(Color.black);
    private JTextField textField;

//construct a `PositiveIntegerCellEditor` object  
//which use JTextField when this constructor is called
    public PositiveIntegerCellEditor(JTextField textField) {
        super(textField);
        this.textField = textField;
        this.textField.setHorizontalAlignment(JTextField.RIGHT);
    }
//basically stopCellEditing() being called to stop the editing mode  
//but here we override it so it will evaluate the input before  
//stop the editing mode
    @Override
    public boolean stopCellEditing() {
        try {
            int v = Integer.valueOf(textField.getText());
            if (v != 0 && v!=1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            textField.setBorder(red);
            return false;
        }
//if no exception thrown,call the normal stopCellEditing()
        return super.stopCellEditing();
    }

//we override the getTableCellEditorComponent method so that
//at the back end when getTableCellEditorComponent method is  
//called to render the input, 
//set the color of the border of the JTextField back to black 
    @Override
    public Component getTableCellEditorComponent(JTable table,
        Object value, boolean isSelected, int row, int column) {
        textField.setBorder(black);
        return super.getTableCellEditorComponent(
            table, value, isSelected, row, column);
    }
}  
    
    public void table(){
            //String[] columns= {"Roll No","Attendance"};
            String[][] data = new String[len+1][2];
            
            for(int i=1;i<=len;i++){
                data[i][0]=i+"";
                data[i][1]="";
            }
            DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
            jTable1.setDefaultEditor(Object.class,new PositiveIntegerCellEditor(new JTextField()));

            
            for(int i=1;i<=len;i++){
                 String[] row = new String[2];
                 for(int j=0;j<2;j++){
                     row[j]=data[i][j];
                 }
                 //row[i][0]=data[i][0];
                 //row[i][1]=data[i][1];
                 
                 model.addRow(row);
            }
            
           /* for(int i=0;i<len;i++){
                String[][] row = new String[len][2];
                for(int j=0;j<len;j++){
                    row[j][0]=data[i][j];
                }*/
                //model.addRow(row);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(530, 485));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Manage Attendance");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Class");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select--", "1", "2", "3", "4", "5" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll No", "Attendance"
            }
        ));
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date");

        jButton2.setText("VIEW ATTENDANCE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String response;
        response=JOptionPane.showInputDialog("Enter Student ID");
        
        String res=mgr.viewAttendance(response);
        
       /* BufferedReader reader;
        int val, cls,roll,sum,len;
        val=Integer.parseInt(response);
        
        
        cls=val/100;
        
        if(cls<1 || cls>5){
            JOptionPane.showMessageDialog(null, "Invalid ID!!");
        }
        roll=val%100;
        String filepath="";
        
        if(cls==1){
            len=0;
            filepath = "C:\\Users\\Win8.1\\Desktop\\JavaProject\\Book1.csv";
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
                JOptionPane.showMessageDialog(null, "Invalid ID");
            }
            
        }
        
        //System.out.print(roll);
        if(cls==1){
            filepath="C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class1.csv";
        
            sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                sum = sum + Integer.parseInt(fields[roll]);
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
            filepath="C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class2.csv";
             sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                sum = sum + Integer.parseInt(fields[roll]);
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
            filepath="C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class3.csv";
             sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                sum = sum + Integer.parseInt(fields[roll]);
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
            filepath="C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class4.csv";
             sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                sum = sum + Integer.parseInt(fields[roll]);
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
            filepath="C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class5.csv";
             sum=0;
            len=0;
            
            String line="";
            try {
                reader= new BufferedReader(new FileReader(filepath));
                //reader.readLine();
                
                while((line =reader.readLine())!=null){
                String[] fields= line.split(",");
                len++;
                sum = sum + Integer.parseInt(fields[roll]);
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
            
        } */
        
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
            
            
            /*File file = null;
            selectedValue = jComboBox1.getSelectedItem().toString();
            if(selectedValue == "1"){
                file= new File("C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class1.csv");
                if(!file.exists()){
                    file.createNewFile();
                }
            }else if(selectedValue == "2"){
               file= new File("C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class2.csv");
                if(!file.exists()){
                    file.createNewFile();
                } 
            }else if(selectedValue == "3"){
                file= new File("C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class3.csv");
                if(!file.exists()){
                    file.createNewFile();
                }
            }else if(selectedValue == "4"){
                file= new File("C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class4.csv");
                if(!file.exists()){
                    file.createNewFile();
                }
            }else if(selectedValue == "5"){
                file= new File("C:\\Users\\Win8.1\\Desktop\\JavaProject\\Class5.csv");
                if(!file.exists()){
                    file.createNewFile();
                }
            }
            
            FileWriter fw= new FileWriter(file,true);
            BufferedWriter bw= new BufferedWriter(fw);
            //PrintWriter pw=new PrintWriter(bw);*/

           // bw.write(nowDate+",");
           attend="";
            for(i=0;i<jTable1.getRowCount();i++){
                //bw.append(jTable1.getModel().getValueAt(i, 1)+",");
                
               // bw.write(jTable1.getValueAt(i,1)+",");
                attend=attend+","+ (String) jTable1.getValueAt(i,1);

            }
        try {
            // bw.newLine();
            //pw.println(jTable1.getModel().getValueAt(i,1)+" ");
            //  bw.close();
            //   fw.close();
            mgr.addAttendance(new Attendance(nowDate,attend));
        } catch (IOException ex) {
            Logger.getLogger(AttendanceUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(this, "Attendance Marked successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
           
            
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1PropertyChange

     
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        selectedValue = jComboBox1.getSelectedItem().toString();

        mgr.setFile(selectedValue);
        if(selectedValue == "1"){
            
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            len=0;
            String filepath = "1.csv";
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

            table();

        }else if(selectedValue == "2"){
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            len=0;
            String filepath = "2.csv";
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

            table();
        }else if(selectedValue == "3"){
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            len=0;
            String filepath = "3.csv";
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

            table();
        }else if(selectedValue =="4"){
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            len=0;
            String filepath = "4.csv";
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

            table();
        }else if(selectedValue == "5"){
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            len=0;
            String filepath = "5.csv";
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

            table();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         this.setVisible(false);
       TeacherUI q = new TeacherUI(id);
       q.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AttendanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new AttendanceUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
