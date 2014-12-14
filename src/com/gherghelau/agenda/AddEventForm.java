/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gherghelau.agenda;

import com.gherghelau.agenda.models.AEvent;
import com.gherghelau.agenda.sql.DbConnect;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Andrei
 */
public class AddEventForm extends javax.swing.JFrame {

    /**
     * Creates new form AddEventForm
     */
    
    AgendaForm _agendaForm ;
    AEvent _instance;
    JDatePickerImpl myDatePicker;
    
    private AEvent getInstance(){
        if(_instance == null){
            _instance = new AEvent();
        }
        return _instance;
    }
            
    private void setCenterScreen(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    private void setDetails(){
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties(null));
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new AbstractFormatter() {

            @Override
            public Object stringToValue(String text) throws ParseException {
                return null;
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                if(value != null){
                    GregorianCalendar cal = (GregorianCalendar)value;
                    Date dt = cal.getTime();
                    int year = dt.getYear();
                    int month = dt.getMonth();
                    int dayOfMonth = dt.getDate();
                    return String.format("%d-%d-%d", year + 1900 , month + 1 , dayOfMonth);
                }
                return "";
            }
        });
       
        //datePicker.getJFormattedTextField().getText(); // all that I need
        //Date dt = new Date(WIDTH, WIDTH, WIDTH)
        
        datePicker.setBounds(10, 250, 150, 30);
        this.add(datePicker);
        myDatePicker = datePicker;
    }
    
    public AddEventForm() {
        initComponents();
        setCenterScreen();
        //DatePicker dt = new DatePicker();//
        //jList1.setModel(null);
        setDetails();
    }
    
    public AddEventForm(AgendaForm agForm, AEvent event) {
        _agendaForm = agForm;
        _agendaForm.getAddEventButton().setEnabled(false);
        _instance = event;
        
        initComponents();
        
        setCenterScreen();
        setDetails();
        if(event != null){
            completeFields(event);
        }
    }
    
    private void completeFields(AEvent event) {
        
        this.txtDescription.setText(event.getDescription());
        this.txtTitle.setText(event.getTitle());
        
      //  UtilDateModel model = new UtilDateModel();
      //  model.setValue(event.getDate());
      //  model.setSelected(true);
        
        /*
        JDatePanelImpl datePanel = new JDatePanelImpl(model,new Properties(null));
        
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new AbstractFormatter(){

            @Override
            public Object stringToValue(String text) throws ParseException {
                return null;
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                if(value != null){
                    GregorianCalendar cal = (GregorianCalendar)value;
                    Date dt = cal.getTime();
                    int year = dt.getYear();
                    int month = dt.getMonth();
                    int dayOfMonth = dt.getDate();
                    return String.format("%d-%d-%d", year + 1900 , month + 1 , dayOfMonth);
                }
                return "";
            }
        });
        
        datePicker.setBounds(10, 250, 150, 30);
        //datePicker.setVisible(true);
        //this.add(datePicker);
        
        myDatePicker = datePicker;
        myDatePicker.getModel().setSelected(true);
        
        //myDatePicker.repaint();
        */
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        btnAddPerson = new javax.swing.JButton();
        btnRemovePerson = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        lblDate = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add or Edit Event");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTitle.setText("Title");

        txtTitle.setToolTipText("Enter a title");

        lblDescription.setText(" Description :");

        btnAddPerson.setText("+");
        btnAddPerson.setToolTipText("Add Person");

        btnRemovePerson.setText("-");
        btnRemovePerson.setToolTipText("Remove Person");

        jScrollPane1.setViewportView(jList1);

        lblDate.setText("Date :");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Clear text");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.setToolTipText("Enter a description");
        txtDescription.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitle)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemovePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addComponent(lblDescription)
                            .addComponent(lblDate))
                        .addGap(193, 193, 193)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddPerson)
                            .addComponent(btnRemovePerson))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnSave)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        _agendaForm.getAddEventButton().setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private boolean isCompleteSave(){
        return (!this.txtDescription.getText().isEmpty() && 
                !this.txtTitle.getText().isEmpty()) ? true : false;
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        //First add the event into the db then the persons
        if(!isCompleteSave()){
            JOptionPane.showMessageDialog(null, "Complete all fields please before saving!");
            return;
        }
        
        _instance = this.getInstance();
        
        _instance.setOwnerId(_agendaForm.getOwnerOfAgenda().getId());
        _instance.setDescription(this.txtDescription.getText());
        _instance.setTitle(this.txtTitle.getText());
        
        String sDate = this.myDatePicker.getJFormattedTextField().getText();
        String[] chunks = null;
        
        if(sDate != null){
            chunks = sDate.split("-");
            Date dt = new Date(Integer.valueOf(chunks[0])-1900, Integer.valueOf(chunks[1])-1, Integer.valueOf(chunks[2]));
            System.out.println(dt.toString());
            _instance.setDate(dt);
            _instance.setSqlDate(sDate);
        }
        
        // save by using the connection (singleton)
        // dbConnect.saveEvent(_instance);
        DbConnect dbConnect = DbConnect.getInstance();
        boolean res = dbConnect.saveEvent(_instance);
        if(res){
            JOptionPane.showMessageDialog(null, "Event saved!");
            
            //_agendaForm.addEvent(_instance);
            _agendaForm.loadEvents();
            _agendaForm.getAddEventButton().setEnabled(true);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Problems while saving check your server status!");
        }
        
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        // clear text!
        this.txtDescription.setText("");
        this.txtTitle.setText("");
        //set persons to null
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(AddEventForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEventForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEventForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEventForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEventForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPerson;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemovePerson;
    private javax.swing.JButton btnSave;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

   
}
