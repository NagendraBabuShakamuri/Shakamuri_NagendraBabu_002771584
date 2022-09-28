/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.hrapplication;

/**
 *
 * @author nbabu
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.SqlDateModel;
public class AddPanel extends JPanel{
    private String fileName;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel ageLabel;
    private JComboBox ageField;
    private JLabel genderLabel;
    private JRadioButton male, female;
    private ButtonGroup bg;
    private JLabel startDateLabel;
    private JTextField startDateField;
    private JLabel levelLabel;
    private JComboBox levelField;
    private JLabel teamInfoLabel;
    private JTextArea teamInfoField;
    private JLabel positionTitleLabel;
    private JTextField positionTitleField;
    private JLabel mobileNumberLabel;
    private JTextField mobileNumberField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel photoLabel;
    private JTextField photoPath;
    private JButton fileButton;
    private JButton submit;
    AddPanel(){
//        GridBagLayout gb = new GridBagLayout();
        setLayout(null);
        titleLabel = new JLabel("Add a New Employee");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD,30));
        titleLabel.setBounds(250, 30, 300, 30);
        
        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Arial", Font.PLAIN,20));
        nameLabel.setBounds(230, 100, 100, 25);
        
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN,15));
        nameField.setBounds(370, 100, 190, 25);
        
        idLabel = new JLabel("Employee Id: ");
        idLabel.setFont(new Font("Arial", Font.PLAIN,20));
        idLabel.setBounds(230, 150, 200, 25);
        
        idField = new JTextField();
        idField.setFont(new Font("Arial", Font.PLAIN,15));
        idField.setBounds(370, 150, 190, 25);
        
        ageLabel = new JLabel("Age: ");
        ageLabel.setFont(new Font("Arial", Font.PLAIN,20));
        ageLabel.setBounds(230, 200, 100, 25);
        
        ageField = new JComboBox();
        for(int i = 1; i< 100; i++){
            ageField.addItem(i);
        }
        ageField.setFont(new Font("Arial", Font.PLAIN,15));
        ageField.setBounds(370, 200, 190, 25);

        
        genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(new Font("Arial", Font.PLAIN,20));
        genderLabel.setBounds(230, 250, 100, 25);
        
        male = new JRadioButton("Male", true);
        female = new JRadioButton("Female");
        male.setBounds(370, 250, 95, 25);
        female.setBounds(470, 250, 95, 25);
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        
        startDateLabel = new JLabel("Start date: ");
        startDateLabel.setFont(new Font("Arial", Font.PLAIN,20));
        startDateLabel.setBounds(230, 300, 100, 25);
        
        startDateField = new JTextField();
        startDateField.setFont(new Font("Arial", Font.PLAIN,15));
        startDateField.setBounds(370, 300, 190, 25);
        
        levelLabel = new JLabel("Level: ");
        levelLabel.setFont(new Font("Arial", Font.PLAIN,20));
        levelLabel.setBounds(230, 350, 100, 25);
        
        levelField = new JComboBox();
        levelField.addItem("I");
        levelField.addItem("II");
        levelField.addItem("III");
        levelField.addItem("IV");
        levelField.addItem("V");
        levelField.setFont(new Font("Arial", Font.PLAIN,15));
        levelField.setBounds(370, 350, 190, 25);
        
        teamInfoLabel = new JLabel("Team info: ");
        teamInfoLabel.setFont(new Font("Arial", Font.PLAIN,20));
        teamInfoLabel.setBounds(230, 400, 200, 25);
        
        teamInfoField = new JTextArea();
        teamInfoField.setFont(new Font("Arial", Font.PLAIN,15));
        teamInfoField.setBounds(370, 400, 190, 50);
        
        positionTitleLabel = new JLabel("Position title: ");
        positionTitleLabel.setFont(new Font("Arial", Font.PLAIN,20));
        positionTitleLabel.setBounds(230, 500, 200, 25);
        
        positionTitleField = new JTextField();
        positionTitleField.setFont(new Font("Arial", Font.PLAIN,15));
        positionTitleField.setBounds(370, 500, 190, 25);
        
        mobileNumberLabel = new JLabel("Mobile Number: ");
        mobileNumberLabel.setFont(new Font("Arial", Font.PLAIN,20));
        mobileNumberLabel.setBounds(230, 550, 200, 25);
        
        mobileNumberField = new JTextField();
        mobileNumberField.setFont(new Font("Arial", Font.PLAIN,15));
        mobileNumberField.setBounds(370, 550, 190, 25);
        
        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN,20));
        emailLabel.setBounds(230, 600, 200, 25);
        
        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN,15));
        emailField.setBounds(370, 600, 190, 25);
        
        photoLabel = new JLabel("Photo: ");
        photoLabel.setFont(new Font("Arial", Font.PLAIN,20));
        photoLabel.setBounds(230, 650, 200, 25);
        
        photoPath = new JTextField();
        photoPath.setFont(new Font("Arial", Font.PLAIN,20));
        photoPath.setBounds(370, 650, 200, 25);
        photoPath.setEditable(false);
        
        fileButton = new JButton("..");
        fileButton.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(null);
            if (i == JFileChooser.APPROVE_OPTION) {
              File f = fc.getSelectedFile();
              try {
                 fileName = f.toString();
                 System.out.println(fileName);
                 photoPath.setText(fileName);
              } catch (Exception ex) {
                 System.out.println("problem accessing file " + f.getAbsolutePath());
              }
            } 
            else {
               fileName = "";
               System.out.println("File access cancelled by user.");
            }
          }
  
        });
        fileButton.setFont(new Font("Arial", Font.PLAIN,20));
        fileButton.setBounds(580, 650, 50, 25);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN,20));
        submit.setBounds(220, 690, 150, 25);
//        GridBagConstraints cons = new GridBagConstraints();
//        cons.gridx = 0;
//        cons.gridy = 0;
//        gb.setConstraints(nameLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 1;
//        gb.setConstraints(employeeIdLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 2;
//        gb.setConstraints(ageLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 3;
//        gb.setConstraints(genderLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 4;
//        gb.setConstraints(startDateLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 5;
//        gb.setConstraints(levelLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 6;
//        gb.setConstraints(teamInfoLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 7;
//        gb.setConstraints(positionTitleLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 8;
//        gb.setConstraints(contactInfoLabel, cons);
//        cons.gridx = 0;
//        cons.gridy = 9;
//        gb.setConstraints(photoLabel, cons);
        add(titleLabel);
        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(ageLabel);
        add(ageField);
        add(genderLabel);
        add(male);
        add(female);
        add(startDateLabel);
        add(startDateField);
        add(levelLabel);
        add(levelField);
        add(teamInfoLabel);
        add(teamInfoField);
        add(positionTitleLabel);
        add(positionTitleField);
        add(mobileNumberLabel);
        add(mobileNumberField);
        add(emailLabel);
        add(emailField);
        add(photoLabel);
        add(photoPath);
        add(fileButton);
        add(submit);
    }
}
