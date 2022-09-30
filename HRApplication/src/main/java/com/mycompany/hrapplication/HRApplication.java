/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hrapplication;

/**
 *
 * @author nbabu
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class HRApplication {

    HRApplication(JFrame window){
        Container contentPane = window.getContentPane();
        JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
        AddPanel ap = new AddPanel(window);
        SearchPanel sp = new SearchPanel(window);
        UpdatePanel up = new UpdatePanel(window);
        DeletePanel dp = new DeletePanel(window);
        tabPane.addTab("Add", ap);     
        tabPane.addTab("Search", sp);     
        tabPane.addTab("Update", up);      
        tabPane.addTab("Delete", dp);
        contentPane.add(tabPane);
//        tabPane.addChangeListener(new ChangeListener() {
//            public void stateChanged(ChangeEvent e) {
//                tabPane.removeAll();
//                tabPane.addTab("Add", new AddPanel(window));     
//                tabPane.addTab("Search", new SearchPanel(window));     
//                tabPane.addTab("Update", new UpdatePanel(window));      
//                tabPane.addTab("Delete", new DeletePanel(window));
//                window.pack();
//            }
//        });
    }
    public static void main(String args[]) {
        // TODO code application logic here
        JFrame window = new JFrame("HRApplication");
        window.setTitle("HRApplication");
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HRApplication hr = new HRApplication(window);
        window.setResizable(false);
//        window.revalidate();
        window.setVisible(true);
    }
}
