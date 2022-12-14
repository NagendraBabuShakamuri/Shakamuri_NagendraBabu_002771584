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
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.regex.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    AddPanel(JFrame frame){
        setLayout(null);
        titleLabel = new JLabel("Add a New Employee");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD,30));
        titleLabel.setBounds(250, 30, 300, 30);
        
        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        nameLabel.setBounds(200, 100, 100, 25);
        
        nameField = new JTextField();
        nameField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        nameField.setBounds(400, 100, 190, 25);
        
        idLabel = new JLabel("Employee Id: ");
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        idLabel.setBounds(200, 150, 200, 25);
        
        idField = new JTextField();
        idField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        idField.setBounds(400, 150, 190, 25);
        
        ageLabel = new JLabel("Age: ");
        ageLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        ageLabel.setBounds(200, 200, 100, 25);
        
        ageField = new JComboBox();
        for(int i = 18; i< 100; i++){
            ageField.addItem(i);
        }
        ageField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        ageField.setBounds(400, 200, 190, 25);

        
        genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        genderLabel.setBounds(200, 250, 100, 25);
        
        male = new JRadioButton("Male", true);
        female = new JRadioButton("Female");
        male.setBounds(400, 250, 95, 25);
        female.setBounds(500, 250, 95, 25);
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        
        startDateLabel = new JLabel("Start date: ");
        startDateLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        startDateLabel.setBounds(200, 300, 100, 25);
        
        startDateField = new JTextField();
        startDateField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        startDateField.setBounds(400, 300, 190, 25);
        
        levelLabel = new JLabel("Level: ");
        levelLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        levelLabel.setBounds(200, 350, 100, 25);
        
        levelField = new JComboBox();
        levelField.addItem("I");
        levelField.addItem("II");
        levelField.addItem("III");
        levelField.addItem("IV");
        levelField.addItem("V");
        levelField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        levelField.setBounds(400, 350, 190, 25);
        
        teamInfoLabel = new JLabel("Team info (Optional): ");
        teamInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        teamInfoLabel.setBounds(200, 400, 200, 25);
        
        teamInfoField = new JTextArea();
        teamInfoField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        teamInfoField.setBounds(400, 400, 190, 80);
        
        positionTitleLabel = new JLabel("Position title: ");
        positionTitleLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        positionTitleLabel.setBounds(200, 500, 200, 25);
        
        positionTitleField = new JTextField();
        positionTitleField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        positionTitleField.setBounds(400, 500, 190, 25);
        
        mobileNumberLabel = new JLabel("Mobile Number: ");
        mobileNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        mobileNumberLabel.setBounds(200, 550, 200, 25);
        
        mobileNumberField = new JTextField();
        mobileNumberField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        mobileNumberField.setBounds(400, 550, 190, 25);
        
        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        emailLabel.setBounds(200, 600, 200, 25);
        
        emailField = new JTextField();
        emailField.setFont(new Font("Times New Roman", Font.PLAIN,15));
        emailField.setBounds(400, 600, 190, 25);
        
        photoLabel = new JLabel("Photo: ");
        photoLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
        photoLabel.setBounds(200, 650, 200, 25);
        
        photoPath = new JTextField();
        photoPath.setFont(new Font("Times New Roman", Font.PLAIN,20));
        photoPath.setBounds(400, 650, 190, 25);
        photoPath.setEditable(false);
        
        fileButton = new JButton("..");
        fileButton.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "JPEG", "PNG", "JPG");
            fc.addChoosableFileFilter(filter);
            int i = fc.showOpenDialog(null);
            if (i == JFileChooser.APPROVE_OPTION) {
              File f = fc.getSelectedFile();
              try {
                 fileName = f.toString();
//                 System.out.println(fileName);
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
        fileButton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        fileButton.setBounds(600, 650, 50, 25);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Times New Roman", Font.PLAIN,20));
        submit.setBounds(200, 690, 150, 25);
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = nameField.getText().trim();
                String id = idField.getText().trim();
                int age = (int)ageField.getSelectedItem();
                String gender = "";
                if(male.isSelected())
                    gender = "Male";
                else if(female.isSelected())
                    gender = "Female";
                String startDate = startDateField.getText().trim();                
                String level = levelField.getSelectedItem().toString();
                String teamInfo = teamInfoField.getText().trim();
                String positionTitle = positionTitleField.getText().trim();
                String mobileNumber = mobileNumberField.getText().trim();
                String email = emailField.getText().trim();
                String photo = photoPath.getText();
                boolean allFieldsFilled = clientSideValidation(frame, name, id, startDate, positionTitle, mobileNumber, email, photo);
                
                System.out.println(name + " " + id + " " + age + " " + gender + " " + startDate + " " + level + " " + teamInfo + " " + positionTitle
                + " " + mobileNumber + " " + email + " " + photo);
                if(allFieldsFilled){
                    transferData(name, Integer.parseInt(id), age, gender, startDate, level, teamInfo, positionTitle, mobileNumber, email, photo, frame); 
                      
                }
            }
        });
        
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
    public static boolean clientSideValidation(JFrame frame, String name, String id, String startDate, String positionTitle, String mobileNumber, String email, String photo){
      if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(name).matches() && !name.equals("")){
//                    System.out.println("Name is valid.");
                    if(Pattern.compile("^[1-9]\\d*$").matcher(id).matches()){
//                        System.out.println("Id is valid.");
                        if(Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$").matcher(startDate).matches()){  
                                try {                          
                                    String DATE_FORMAT = "yyyy-MM-dd";
                                    DateFormat dfd = new SimpleDateFormat(DATE_FORMAT);
                                    dfd.setLenient(false);
                                    dfd.parse(startDate);
                                }catch (Exception ex) {     
                                   JOptionPane.showMessageDialog(frame, "Start date should be in correct format.", "Alert", JOptionPane.WARNING_MESSAGE);
                                   return false;
                                }
//                            System.out.println("Start date is valid.");
                            if(Pattern.compile("^[a-zA-Z\\s]*$").matcher(positionTitle).matches() && !positionTitle.equals("")){
//                                System.out.println("Position title is valid.");
                                if(Pattern.compile("\\+\\d(-\\d{3}){2}-\\d{4}").matcher(mobileNumber).matches()){
//                                    System.out.println("Mobile Number is valid.");
                                    if(Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches()){
//                                        System.out.println("Email is valid.");
                                        if(!photo.equals( "")){
//                                            System.out.println("Photo is uploaded.");
                                            return true;
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(frame, "Please add an Employee photo.", "Alert", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(frame, "Email should be in the following format i.e.\nA-Z characters allowed\na-z characters allowed\n0-9 numbers allowed\nAdditionally email may contain only dot(.), dash(-) and underscore(_)\nRest all characters are not allowed", "Alert", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(frame, "Mobile Number should be in +X-XXX-XXX-XXXX.", "Alert", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "Position title is not valid.\nOnly characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(frame, "Start date should be in YYYY-MM-DD format.", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Name is not valid.\nOnly characters and spaces are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
      return false;
    }
    public void transferData(String name, int id, int age, String gender, String startDate, String level, String teamInfo, String positionTitle, String mobileNumber, String email, String photo, JFrame frame){
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("./src/main/java/com/mycompany/hrapplication/database.json")){
            JSONObject databaseJson = (JSONObject) parser.parse(reader);
            JSONArray employees = (JSONArray)databaseJson.get("Employees");
            if(!backendValidation(employees, id, mobileNumber, email, frame)){
              return;
            }
            else
            {
                JSONObject employee = new JSONObject();
                employee.put("Name", name);
                employee.put("Employee Id", id);
                employee.put("Age", age);
                employee.put("Gender", gender);
                employee.put("Start date", startDate);
                employee.put("level", level);
                employee.put("team info", teamInfo);
                employee.put("Position title", positionTitle);
                employee.put("Mobile Number", mobileNumber);
                employee.put("Email", email);
                employee.put("Photo", photo);
                employees.add(employee);
    //            System.out.println(databaseJson);
                reader.close();
                try(FileWriter writer = new FileWriter("./src/main/java/com/mycompany/hrapplication/database.json", false)){
                    writer.write(databaseJson.toJSONString());
                    writer.flush();
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Added the record successfully.", null, JOptionPane.OK_OPTION);
                }
            }    
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
    }
    public boolean backendValidation(JSONArray employees, int id, String mobileNumber, String email, JFrame frame){
        for(int i = 0; i < employees.size(); i++){
            JSONObject employee = (JSONObject)employees.get(i);
            if(Integer.parseInt(employee.get("Employee Id").toString()) == id){
                JOptionPane.showMessageDialog(frame, "An employee with the given Id already exists.\nPlease enter another Id.", "Alert", JOptionPane.OK_OPTION);
                return false;
            }
            else if(employee.get("Mobile Number").equals(mobileNumber)){
                JOptionPane.showMessageDialog(frame, "An employee with the given mobile number already exists.\nPlease enter another mobile number.", "Alert", JOptionPane.OK_OPTION);
                return false;
            }
            else if(employee.get("Email").equals(email)){
                JOptionPane.showMessageDialog(frame, "An employee with the given email already exists.\nPlease enter another email Id.", "Alert", JOptionPane.OK_OPTION);
                return false;
            }
        }
        return true;
    }
}
