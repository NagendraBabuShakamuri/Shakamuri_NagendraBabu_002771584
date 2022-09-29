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
      JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("./src/main/java/com/mycompany/hrapplication/database.json")){
            JSONObject databaseJson = (JSONObject) parser.parse(reader);
            JSONArray employees = (JSONArray)databaseJson.get("Employees");
            boolean isFound = false;
            for(int i = 0; i < employees.size(); i++){
              JSONObject employee = (JSONObject)employees.get(i);
              if(employee.get(selectedItem).toString().equals(searchText)){
                isFound = true;
                JLabel imageLabel = new JLabel();
                imageLabel.setBounds(300, 200, 150, 100);
                ImageIcon image = new ImageIcon(employee.get("Photo").toString());
                Image img = image.getImage();
                Image imgScale = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);
                imageLabel.setIcon(scaledIcon);
                add(imageLabel);
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
