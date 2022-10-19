/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author nbabu
 */
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class HospitalApplication {
  private JLabel roleLabel;
  private JLabel userNameLabel;
  private JLabel passwordLabel;
  private JTextField userNameField;
  private JPasswordField passwordField;
  private JComboBox role;
  private JButton loginButton;
  HospitalApplication(JFrame frame){
    Container contentPane = frame.getContentPane();
    JPanel panel = new JPanel();
    panel.setLayout(null);
    
    roleLabel = new JLabel("Login as: ");
    roleLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
    roleLabel.setBounds(250, 250, 100, 25);
    
    role = new JComboBox();
    role.addItem("Patient");
    role.addItem("Doctor");
    role.addItem("System Administrator");
    role.addItem("Hospital Administrator");
    role.addItem("Community Administrator");
    role.setFont(new Font("Times New Roman", Font.PLAIN,15));
    role.setBounds(350, 250, 220, 25);
    
    userNameLabel = new JLabel("Username: ");
    userNameLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
    userNameLabel.setBounds(250, 300, 100, 25);
    
    userNameField = new JTextField();
    userNameField.setFont(new Font("Times New Roman", Font.PLAIN,20));
    userNameField.setBounds(350, 300, 220, 25);
    
    passwordLabel = new JLabel("Password: ");
    passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
    passwordLabel.setBounds(250, 350, 100, 25);
    
    passwordField = new JPasswordField();
    passwordField.setFont(new Font("Times New Roman", Font.PLAIN,20));
    passwordField.setBounds(350, 350, 220, 25);
    
    loginButton = new JButton("Login");
    loginButton.setFont(new Font("Times New Roman", Font.PLAIN,20));
    loginButton.setBounds(250, 400, 320, 30);
    loginButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          if(role.getSelectedItem().toString().equals("Community Administrator")){
            System.out.println(role.getSelectedItem().toString());
            new CommunityAdministrator(frame);
            frame.revalidate();
          }  
        }
    });
    
    
    panel.add(roleLabel);
    panel.add(role);
    panel.add(userNameLabel); 
    panel.add(passwordLabel);
    panel.add(userNameField);
    panel.add(passwordField);
    panel.add(loginButton);
    
    contentPane.add(panel);
  }
  public static void main(String[] args) {
    JFrame frame = new JFrame("Hospital Application");
    HospitalApplication hp = new HospitalApplication(frame);
    frame.setSize(800, 800);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}