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
public class HRApplication {

    HRApplication(JFrame window){
        Container contentPane = window.getContentPane();
        JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
        tabPane.addTab("Home", new HomePanel());
        tabPane.addTab("Add", new AddPanel());
        tabPane.addTab("Search", new SearchPanel());
        tabPane.addTab("Update", new UpdatePanel());
        tabPane.addTab("Delete", new DeletePanel());
        contentPane.add(tabPane);
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
