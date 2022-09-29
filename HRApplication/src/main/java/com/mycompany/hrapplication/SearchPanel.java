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
import java.util.regex.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class SearchPanel extends JPanel{
    private JLabel titleLabel;
    private JComboBox searchOptions;
    private JTextField searchField;
    private JButton submit;
    private JLabel name = new JLabel("Name: ");
    private JLabel id = new JLabel("Employee Id: ");
    private JLabel age = new JLabel("Age: ");
    private JLabel gender = new JLabel("Gender: ");
    private JLabel startDate = new JLabel("Start date: ");
    private JLabel level = new JLabel("Level: ");
    private JLabel teamInfo = new JLabel("Team info: ");
    private JLabel positionTitle = new JLabel("Position title: ");
    private JLabel mobileNumber = new JLabel("Mobile Number: ");
    private JLabel email = new JLabel("Email: ");
    private JLabel imageLabel = new JLabel();
    private JLabel nameValue = new JLabel();
    private JLabel idValue = new JLabel();
    private JLabel ageValue = new JLabel();
    private JLabel genderValue = new JLabel();
    private JLabel startDateValue = new JLabel();
    private JLabel levelValue = new JLabel();
    private JLabel teamInfoValue = new JLabel();
    private JLabel positionTitleValue = new JLabel();
    private JLabel mobileNumberValue = new JLabel();
    private JLabel emailValue = new JLabel();
    SearchPanel(JFrame frame){
        setLayout(null);
        titleLabel = new JLabel("Search an Employee record");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD,30));
        titleLabel.setBounds(200, 30, 400, 30);
        add(titleLabel);
        
        String[] options = {"Employee Id", "Mobile Number", "Email"};
        searchOptions = new JComboBox(options);
        searchOptions.setFont(new Font("Times New Roman", Font.PLAIN,20));
        searchOptions.setBounds(170, 100, 200, 30);
        add(searchOptions);
        
        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN,15));
        searchField.setBounds(390, 100, 190, 25);
        add(searchField);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN,15));
        submit.setBounds(300, 150, 150, 25);
        add(submit);
        clientSideValidation(frame);
    }
    public void clientSideValidation(JFrame frame){
        submit.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
            String selectedItem = searchOptions.getSelectedItem().toString();
            boolean flag = false;
            if(selectedItem.equals("Employee Id"))
            {
              if(Pattern.compile("^[1-9]\\d*$").matcher(searchField.getText()).matches())
                  flag = true;
              else
                  JOptionPane.showMessageDialog(frame, "Employee Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            else if(selectedItem.equals("Mobile Number"))
            {
              if(Pattern.compile("\\+\\d(-\\d{3}){2}-\\d{4}").matcher(searchField.getText()).matches())
                  flag = true;
              else
                  JOptionPane.showMessageDialog(frame, "Mobile Number should be in +X-XXX-XXX-XXXX.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            else if(selectedItem.equals("Email"))
            {
              if(Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(searchField.getText()).matches())
                  flag = true;
              else
                  JOptionPane.showMessageDialog(frame, "Email should be in the following format i.e.\nA-Z characters allowed\na-z characters allowed\n0-9 numbers allowed\nAdditionally email may contain only dot(.), dash(-) and underscore(_)\nRest all characters are not allowed", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            if(flag)
                searchData(frame, selectedItem, searchField.getText());
          }
        });
    }
    public void searchData(JFrame frame, String selectedItem, String searchText){
      name.setVisible(false);
      id.setVisible(false);
      age.setVisible(false);
      gender.setVisible(false);
      startDate.setVisible(false);
      level.setVisible(false);
      teamInfo.setVisible(false);
      positionTitle.setVisible(false);
      mobileNumber.setVisible(false);
      email.setVisible(false);
      imageLabel.setVisible(false);
      nameValue.setVisible(false);
      idValue.setVisible(false);
      ageValue.setVisible(false);
      genderValue.setVisible(false);
      startDateValue.setVisible(false);
      levelValue.setVisible(false);
      teamInfoValue.setVisible(false);
      positionTitleValue.setVisible(false);
      mobileNumberValue.setVisible(false);
      emailValue.setVisible(false);
      JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("./src/main/java/com/mycompany/hrapplication/database.json")){
            JSONObject databaseJson = (JSONObject) parser.parse(reader);
            JSONArray employees = (JSONArray)databaseJson.get("Employees");
            boolean isFound = false;
            for(int i = 0; i < employees.size(); i++){
              JSONObject employee = (JSONObject)employees.get(i);
              if(employee.get(selectedItem).toString().equals(searchText)){
                isFound = true;           
                imageLabel.setBounds(300, 200, 150, 100);
                ImageIcon image = new ImageIcon(employee.get("Photo").toString());
                Image img = image.getImage();
                Image imgScale = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);
                imageLabel.setIcon(scaledIcon);
                imageLabel.setVisible(true);
                add(imageLabel);
                
                
                name.setFont(new Font("Times New Roman", Font.PLAIN,20));
                name.setBounds(250, 300, 200, 30);
                name.setVisible(true);
                add(name);
                
                nameValue.setText(employee.get("Name").toString());
                nameValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                nameValue.setBounds(400, 300, 200, 30);
                nameValue.setVisible(true);
                add(nameValue);
                
                
                id.setFont(new Font("Times New Roman", Font.PLAIN,20));
                id.setBounds(250, 330, 200, 30);
                id.setVisible(true);
                add(id);
                
                
                idValue.setText(employee.get("Employee Id").toString());
                idValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                idValue.setBounds(400, 330, 200, 30);
                idValue.setVisible(true);
                add(idValue);
                
                
                age.setFont(new Font("Times New Roman", Font.PLAIN,20));
                age.setBounds(250, 360, 200, 30);
                age.setVisible(true);
                add(age);
                
                
                ageValue.setText(employee.get("Age").toString());
                ageValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                ageValue.setBounds(400, 360, 200, 30);
                ageValue.setVisible(true);
                add(ageValue);
                
                
                gender.setFont(new Font("Times New Roman", Font.PLAIN,20));
                gender.setBounds(250, 390, 200, 30);
                gender.setVisible(true);
                add(gender);
                
                
                genderValue.setText(employee.get("Gender").toString());
                genderValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                genderValue.setBounds(400, 390, 200, 30);
                genderValue.setVisible(true);
                add(genderValue);
                
                
                startDate.setFont(new Font("Times New Roman", Font.PLAIN,20));
                startDate.setBounds(250, 420, 200, 30);
                startDate.setVisible(true);
                add(startDate);
                
                
                startDateValue.setText(employee.get("Start date").toString());
                startDateValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                startDateValue.setBounds(400, 420, 200, 30);
                startDateValue.setVisible(true);
                add(startDateValue);
                
                
                level.setFont(new Font("Times New Roman", Font.PLAIN,20));
                level.setBounds(250, 450, 200, 30);
                level.setVisible(true);
                add(level);
                
                
                levelValue.setText(employee.get("level").toString());
                levelValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                levelValue.setBounds(400, 450, 200, 30);
                levelValue.setVisible(true);
                add(levelValue);
                
                
                teamInfo.setFont(new Font("Times New Roman", Font.PLAIN,20));
                teamInfo.setBounds(250, 480, 200, 30);
                teamInfo.setVisible(true);
                add(teamInfo);
                
                
                teamInfoValue.setText(employee.get("team info").toString());
                teamInfoValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                teamInfoValue.setBounds(400, 480, 200, 30);
                teamInfoValue.setVisible(true);
                add(teamInfoValue);
                
                
                positionTitle.setFont(new Font("Times New Roman", Font.PLAIN,20));
                positionTitle.setBounds(250, 510, 200, 30);
                positionTitle.setVisible(true);
                add(positionTitle);
                
                
                positionTitleValue.setText(employee.get("Position title").toString());
                positionTitleValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                positionTitleValue.setBounds(400, 510, 200, 30);
                positionTitleValue.setVisible(true);
                add(positionTitleValue);
                
                
                mobileNumber.setFont(new Font("Times New Roman", Font.PLAIN,20));
                mobileNumber.setBounds(250, 540, 200, 30);
                mobileNumber.setVisible(true);
                add(mobileNumber);
                
                
                mobileNumberValue.setText(employee.get("Mobile Number").toString());
                mobileNumberValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                mobileNumberValue.setBounds(400, 540, 200, 30);
                mobileNumberValue.setVisible(true);
                add(mobileNumberValue);
                
                
                email.setFont(new Font("Times New Roman", Font.PLAIN,20));
                email.setBounds(250, 570, 200, 30);
                email.setVisible(true);
                add(email);
                
                
                emailValue.setText(employee.get("Email").toString());
                emailValue.setFont(new Font("Times New Roman", Font.PLAIN,20));
                emailValue.setBounds(400, 570, 200, 30);
                emailValue.setVisible(true);
                add(emailValue);
                repaint();
                break;  
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
}
