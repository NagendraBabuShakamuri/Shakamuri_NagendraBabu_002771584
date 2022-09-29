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
public class DeletePanel extends JPanel{
    private JLabel titleLabel;
    private JComboBox deleteOptions;
    private JTextField deleteField;
    private JButton submit;
    DeletePanel(JFrame frame){
        setLayout(null);
        titleLabel = new JLabel("Delete an Employee record");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD,30));
        titleLabel.setBounds(200, 30, 350, 30);
        add(titleLabel);
        
        String[] options = {"Employee Id", "Mobile Number", "Email"};
        deleteOptions = new JComboBox(options);
        deleteOptions.setFont(new Font("Times New Roman", Font.PLAIN,20));
        deleteOptions.setBounds(170, 150, 200, 30);
        add(deleteOptions);
        
        deleteField = new JTextField();
        deleteField.setFont(new Font("Arial", Font.PLAIN,15));
        deleteField.setBounds(390, 150, 190, 25);
        add(deleteField);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN,15));
        submit.setBounds(300, 200, 150, 25);
        add(submit);
        clientSideValidation(frame);
    }
    public void clientSideValidation(JFrame frame){
        submit.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
            String selectedItem = deleteOptions.getSelectedItem().toString();
            boolean flag = false;
            if(selectedItem.equals("Employee Id"))
            {
              if(Pattern.compile("^[1-9]\\d*$").matcher(deleteField.getText()).matches())
                  flag = true;
              else
                  JOptionPane.showMessageDialog(frame, "Employee Id is not valid.\nOnly Numbers are allowed.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            else if(selectedItem.equals("Mobile Number"))
            {
              if(Pattern.compile("\\+\\d(-\\d{3}){2}-\\d{4}").matcher(deleteField.getText()).matches())
                  flag = true;
              else
                  JOptionPane.showMessageDialog(frame, "Mobile Number should be in +X-XXX-XXX-XXXX.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            else if(selectedItem.equals("Email"))
            {
              if(Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(deleteField.getText()).matches())
                  flag = true;
              else
                  JOptionPane.showMessageDialog(frame, "Email should be in the following format i.e.\nA-Z characters allowed\na-z characters allowed\n0-9 numbers allowed\nAdditionally email may contain only dot(.), dash(-) and underscore(_)\nRest all characters are not allowed", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            if(flag)
                deleteData(frame, selectedItem, deleteField.getText());
          }
        });
    }
    public void deleteData(JFrame frame, String selectedItem, String deleteText){
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("./src/main/java/com/mycompany/hrapplication/database.json")){
            JSONObject databaseJson = (JSONObject) parser.parse(reader);
            JSONArray employees = (JSONArray)databaseJson.get("Employees");
            boolean isFound = false;
            for(int i = 0; i < employees.size(); i++){
              JSONObject employee = (JSONObject)employees.get(i);
              if(employee.get(selectedItem).toString().equals(deleteText)){
                isFound = true;
                employees.remove(employee);
                break;  
              }
            }
            reader.close();
            if(!isFound)
                JOptionPane.showMessageDialog(frame, "Employee directory for the given " + selectedItem + " does not exist.", "Alert", JOptionPane.WARNING_MESSAGE);
            else
            {
                try(FileWriter writer = new FileWriter("./src/main/java/com/mycompany/hrapplication/database.json", false)){
                    writer.write(databaseJson.toJSONString());
                    writer.flush();
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Deleted the record successfully.", null, JOptionPane.OK_OPTION);
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
}
