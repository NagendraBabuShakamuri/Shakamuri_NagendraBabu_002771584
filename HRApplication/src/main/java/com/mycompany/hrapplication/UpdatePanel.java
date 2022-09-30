/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrapplication;

/**
 *
 * @author nbabu
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.mycompany.hrapplication.AddPanel;
public class UpdatePanel extends JPanel{
    private String fileName;
    private JLabel titleLabel;
    private JComboBox updateOptions;
    private JTextField updateField;
    private JButton searchButton;
    private JLabel nameLabel = new JLabel("Name: ");
    private JTextField nameField = new JTextField();
    private JLabel idLabel = new JLabel("Employee Id: ");
    private JTextField idField = new JTextField();
    private JLabel ageLabel = new JLabel("Age: ");
    private JComboBox ageField = new JComboBox();
    private JLabel genderLabel = new JLabel("Gender: ");
    private JRadioButton male = new JRadioButton();
    private JRadioButton female = new JRadioButton();
    private ButtonGroup bg;
    private JLabel startDateLabel = new JLabel("Start date: ");
    private JTextField startDateField = new JTextField();
    private JLabel levelLabel = new JLabel("Level: ");
    private JComboBox levelField = new JComboBox();
    private JLabel teamInfoLabel = new JLabel("Team Info (Optional): ");
    private JTextArea teamInfoField = new JTextArea();
    private JLabel positionTitleLabel = new JLabel("Position title: ");
    private JTextField positionTitleField = new JTextField();
    private JLabel mobileNumberLabel = new JLabel("Mobile Number: ");
    private JTextField mobileNumberField = new JTextField();
    private JLabel emailLabel = new JLabel("Email: ");
    private JTextField emailField = new JTextField();
    private JLabel photoLabel = new JLabel("Photo: ");
    private JTextField photoPath = new JTextField();
    private JButton fileButton = new JButton("..");
    private JButton updateButton = new JButton();
    UpdatePanel(JFrame frame){
        setLayout(null);
        titleLabel = new JLabel("Update an Employee record");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD,30));
        titleLabel.setBounds(200, 30, 400, 30);
        add(titleLabel);
        
        String[] options = {"Employee Id", "Mobile Number", "Email"};
        updateOptions = new JComboBox(options);
        updateOptions.setFont(new Font("Times New Roman", Font.PLAIN,20));
        updateOptions.setBounds(170, 100, 200, 30);
        add(updateOptions);
        
        updateField = new JTextField();
        updateField.setFont(new Font("Arial", Font.PLAIN,15));
        updateField.setBounds(390, 100, 200, 25);
        add(updateField);
        
        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.PLAIN,15));
        searchButton.setBounds(600, 100, 100, 25);
        add(searchButton);
        
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String selectedItem = updateOptions.getSelectedItem().toString();
                boolean flag = false;
                if(selectedItem.equals("Employee Id"))
                {
                  if(Pattern.compile("^[1-9]\\d*$").matcher(updateField.getText()).matches())
                      flag = true;
                  else
                    JOptionPane.showMessageDialog(frame, "Employee Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else if(selectedItem.equals("Mobile Number")){
                  if(Pattern.compile("\\+\\d(-\\d{3}){2}-\\d{4}").matcher(updateField.getText()).matches())
                      flag = true;
                  else
                    JOptionPane.showMessageDialog(frame, "Mobile Number should be in +X-XXX-XXX-XXXX.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else if(selectedItem.equals("Email")){
                  if(Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(updateField.getText()).matches())
                      flag = true;                   
                  else
                    JOptionPane.showMessageDialog(frame, "Email should be in the following format i.e.\nA-Z characters allowed\na-z characters allowed\n0-9 numbers allowed\nAdditionally email may contain only dot(.), dash(-) and underscore(_)\nRest all characters are not allowed", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                if(flag)
                 searchData(frame, selectedItem, updateField.getText().trim());
            }
        });
    }
    public void searchData(JFrame frame, String selectedItem, String searchText){
      int position = 0;
      nameLabel.setVisible(false);
      idLabel.setVisible(false);
      ageLabel.setVisible(false);
      genderLabel.setVisible(false);
      startDateLabel.setVisible(false);
      levelLabel.setVisible(false);
      teamInfoLabel.setVisible(false);
      positionTitleLabel.setVisible(false);
      mobileNumberLabel.setVisible(false);
      emailLabel.setVisible(false);
      photoLabel.setVisible(false);
      nameField.setVisible(false);
      idField.setVisible(false);
      ageField.setVisible(false);
      male.setVisible(false);
      female.setVisible(false);
      startDateField.setVisible(false);
      levelField.setVisible(false);
      teamInfoField.setVisible(false);
      positionTitleField.setVisible(false);
      mobileNumberField.setVisible(false);
      emailField.setVisible(false);
      photoPath.setVisible(false);
      fileButton.setVisible(false);
      updateButton.setVisible(false);
      JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("./src/main/java/com/mycompany/hrapplication/database.json")){
          JSONObject databaseJson = (JSONObject) parser.parse(reader);
          JSONArray employees = (JSONArray)databaseJson.get("Employees");
          boolean isFound = false;
          for(int i = 0; i < employees.size(); i++){
              JSONObject employee = (JSONObject)employees.get(i);
              if(employee.get(selectedItem).toString().equals(searchText)){
                isFound = true;
                position = i;
                
                nameLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                nameLabel.setBounds(200, 150, 200, 30);
                nameLabel.setVisible(true);
                add(nameLabel);
                
                nameField.setText(employee.get("Name").toString());
                nameField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                nameField.setBounds(390, 150, 200, 30);
                nameField.setVisible(true);
                add(nameField);
                
                ageLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                ageLabel.setBounds(200, 200, 200, 30);
                ageLabel.setVisible(true);
                add(ageLabel);
                
                ageField.removeAllItems();
                for(int j = 1; j< 100; j++){ 
                    ageField.addItem(j);
                }
                ageField.getModel().setSelectedItem(employee.get("Age").toString());
                ageField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                ageField.setBounds(390, 200, 200, 30);
                ageField.setVisible(true);
                add(ageField);
                
                genderLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                genderLabel.setBounds(200, 250, 200, 30);
                genderLabel.setVisible(true);
                add(genderLabel);
                
                male = new JRadioButton("Male");
                female = new JRadioButton("Female");
                male.setBounds(390, 250, 95, 25);
                female.setBounds(500, 250, 95, 25);
                bg = new ButtonGroup();
                bg.add(male);
                bg.add(female);
                String gender = employee.get("Gender").toString();
                if(gender.equals("Male"))
                    male.setSelected(true);
                else
                    female.setSelected(true);                
                
                male.setVisible(true);
                female.setVisible(true);
                add(male);
                add(female);
                
                startDateLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                startDateLabel.setBounds(200, 300, 200, 30);
                startDateLabel.setVisible(true);                
                add(startDateLabel);
                
                
                startDateField.setText(employee.get("Start date").toString());
                startDateField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                startDateField.setBounds(390, 300, 200, 30);
                startDateField.setVisible(true);
                add(startDateField);
                
                levelLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                levelLabel.setBounds(200, 350, 200, 30);
                levelLabel.setVisible(true);
                add(levelLabel);
                
                levelField.removeAllItems();
                levelField.addItem("I");
                levelField.addItem("II");
                levelField.addItem("III");
                levelField.addItem("IV");
                levelField.addItem("V");
                levelField.getModel().setSelectedItem(employee.get("level").toString());
                levelField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                levelField.setBounds(390, 350, 200, 30);
                levelField.setVisible(true);
                add(levelField);
                
                
                teamInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                teamInfoLabel.setBounds(200, 400, 200, 30);
                teamInfoLabel.setVisible(true);
                add(teamInfoLabel);
                
                
                teamInfoField.setText(employee.get("team info").toString());
                teamInfoField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                teamInfoField.setBounds(390, 400, 200, 90);
                teamInfoField.setVisible(true);
                add(teamInfoField);
                
                positionTitleLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                positionTitleLabel.setBounds(200, 500, 200, 30);
                positionTitleLabel.setVisible(true);
                add(positionTitleLabel);
                
                
                positionTitleField.setText(employee.get("Position title").toString());
                positionTitleField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                positionTitleField.setBounds(390, 500, 200, 30);
                positionTitleField.setVisible(true);
                add(positionTitleField);
                
                if(selectedItem.equals("Employee Id")){
                    mobileNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    mobileNumberLabel.setBounds(200, 550, 200, 30);
                    mobileNumberLabel.setVisible(true);
                    add(mobileNumberLabel);


                    mobileNumberField.setText(employee.get("Mobile Number").toString());
                    mobileNumberField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    mobileNumberField.setBounds(390, 550, 200, 30);
                    mobileNumberField.setVisible(true);
                    add(mobileNumberField);


                    emailLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    emailLabel.setBounds(200, 600, 200, 30);
                    emailLabel.setVisible(true);
                    add(emailLabel);


                    emailField.setText(employee.get("Email").toString());
                    emailField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    emailField.setBounds(390, 600, 200, 30);
                    emailField.setVisible(true);
                    add(emailField);
                }
                else if(selectedItem.equals("Mobile Number")){
                    idLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    idLabel.setBounds(200, 550, 200, 30);
                    idLabel.setVisible(true);
                    add(idLabel);


                    idField.setText(employee.get("Employee Id").toString());
                    idField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    idField.setBounds(390, 550, 200, 30);
                    idField.setVisible(true);
                    add(idField);
                    
                    emailLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    emailLabel.setBounds(200, 600, 200, 30);
                    emailLabel.setVisible(true);
                    add(emailLabel);


                    emailField.setText(employee.get("Email").toString());
                    emailField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    emailField.setBounds(390, 600, 200, 30);
                    emailField.setVisible(true);
                    add(emailField);
                }
                else if(selectedItem.equals("Email")){
                    idLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    idLabel.setBounds(200, 550, 200, 30);
                    idLabel.setVisible(true);
                    add(idLabel);


                    idField.setText(employee.get("Employee Id").toString());
                    idField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    idField.setBounds(390, 550, 200, 30);
                    idField.setVisible(true);
                    add(idField);
                    
                    mobileNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    mobileNumberLabel.setBounds(200, 600, 200, 30);
                    mobileNumberLabel.setVisible(true);
                    add(mobileNumberLabel);


                    mobileNumberField.setText(employee.get("Mobile Number").toString());
                    mobileNumberField.setFont(new Font("Times New Roman", Font.PLAIN,20));
                    mobileNumberField.setBounds(390, 600, 200, 30);
                    mobileNumberField.setVisible(true);
                    add(mobileNumberField);
                }
                
                photoLabel = new JLabel("Photo: ");
                photoLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
                photoLabel.setBounds(200, 650, 200, 25);
                photoLabel.setVisible(true);
                add(photoLabel);
                
                photoPath.setText(employee.get("Photo").toString());
                photoPath.setFont(new Font("Times New Roman", Font.PLAIN,20));
                photoPath.setBounds(390, 650, 200, 25);
                photoPath.setEditable(false);
                photoPath.setVisible(true);
                add(photoPath);
                
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
                fileButton.setFont(new Font("Arial", Font.PLAIN,20));
                fileButton.setBounds(600, 650, 50, 25);
                fileButton.setVisible(true);
                add(fileButton);
                
                updateButton = new JButton("Update");
                updateButton.setFont(new Font("Arial", Font.PLAIN,20));
                updateButton.setBounds(200, 700, 120, 25);
                fileButton.setVisible(true);
                add(updateButton);
                updateData(frame, updateButton, selectedItem, position);
                revalidate();
                repaint(); 
              }
          }
          reader.close();
            if(!isFound)
                JOptionPane.showMessageDialog(frame, "Employee directory for the given " + selectedItem + " does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
    }
    public void updateData(JFrame frame, JButton updateButton, String selectedItem, int position){
      updateButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
         JSONParser parser = new JSONParser();
          try(FileReader reader = new FileReader("./src/main/java/com/mycompany/hrapplication/database.json")){
            JSONObject databaseJson = (JSONObject) parser.parse(reader);
            JSONArray employees = (JSONArray)databaseJson.get("Employees");
            boolean allDataValid = false;
//            JSONObject employee = (JSONObject)employees.get(position);
            try
            {
              JSONObject employee = (JSONObject)employees.get(position);
              if(selectedItem.equals("Employee Id"))
              {
                allDataValid = AddPanel.clientSideValidation(frame, nameField.getText().trim(), updateField.getText().trim(), startDateField.getText().trim(), positionTitleField.getText().trim(), mobileNumberField.getText().trim(), emailField.getText().trim(), photoPath.getText());
                if(allDataValid)
                {
//                    System.out.println(updateField.getText());
                    employee.put(selectedItem, Integer.parseInt(updateField.getText().trim()));                    
                    employee.put("Mobile Number", mobileNumberField.getText().trim());
                    employee.put("Email", emailField.getText().trim());
                }
              }
              else if(selectedItem.equals("Mobile Number"))
              {
                allDataValid = AddPanel.clientSideValidation(frame, nameField.getText().trim(), idField.getText().trim(), startDateField.getText().trim(), positionTitleField.getText().trim(), updateField.getText().trim(), emailField.getText().trim(), photoPath.getText());
                if(allDataValid)
                {
                    employee.put("Employee Id", Integer.parseInt(idField.getText().trim()));
                    employee.put(selectedItem, updateField.getText().trim());
                    employee.put("Email", emailField.getText().trim());
                }
              }
              else if(selectedItem.equals("Email"))
              {
                allDataValid = AddPanel.clientSideValidation(frame, nameField.getText().trim(), idField.getText().trim(), startDateField.getText().trim(), positionTitleField.getText().trim(), mobileNumberField.getText().trim(), updateField.getText().trim(), photoPath.getText());
                if(allDataValid)
                {
                    employee.put("Employee Id", Integer.parseInt(idField.getText().trim()));    
                    employee.put("Mobile Number", mobileNumberField.getText().trim());
                    employee.put(selectedItem, updateField.getText().trim());
                }
              }
              reader.close();
              if(allDataValid)
              {
                employee.put("Name", nameField.getText().trim());
                employee.put("Age", Integer.parseInt(ageField.getSelectedItem().toString()));
                if(male.isSelected())
                    employee.put("Gender", "Male");
                else
                    employee.put("Gender", "Female");
                employee.put("Start date", startDateField.getText().trim());
                employee.put("level", levelField.getSelectedItem().toString());
                employee.put("team info", teamInfoField.getText().trim());
                employee.put("Position title", positionTitleField.getText().trim());
                employee.put("Photo", photoPath.getText());
                try(FileWriter writer = new FileWriter("./src/main/java/com/mycompany/hrapplication/database.json", false)){
                    writer.write(databaseJson.toJSONString());
                    writer.flush();
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Updated the record successfully.", null, JOptionPane.OK_OPTION);
                }
              }
            }
            catch(IndexOutOfBoundsException ie)
            {
              JOptionPane.showMessageDialog(frame, "The Employee record that you're trying to update has just been deleted\nPlease try updating another Employee record.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
          }
          catch(IOException ex){
            ex.printStackTrace();
          }
          catch(ParseException ex){
            ex.printStackTrace();
          }
        }
      });
    }
}
