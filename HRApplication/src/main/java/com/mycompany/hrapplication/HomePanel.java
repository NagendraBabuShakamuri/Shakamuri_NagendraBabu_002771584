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
public class HomePanel extends JPanel{
    private JLabel titleLabel;
    private JLabel infoLabel;
    HomePanel(){
        setLayout(null);
        titleLabel = new JLabel("Human Resource Application");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD,30));
        titleLabel.setBounds(200, 30, 500, 30);
        add(titleLabel);
    }
}
