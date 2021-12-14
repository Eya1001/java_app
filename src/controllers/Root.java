package controllers;

import models.entities.Inscription;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Root extends JFrame {

    Root(){
        this.setSize(800, 500);
        this.setResizable(false);
        this.setTitle("management training center app");
        JPanel jPanel = new JPanel(new GridLayout(2, 2));
        // inscription button
        JButton inscriptionButton = new JButton();
        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InscriptionController inscriptionController = new InscriptionController();
                inscriptionController.setVisible(true);
            }
        });
        try {
            inscriptionButton.setIcon(new ImageIcon(ImageIO.read(new File("resources/inscription.png"))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // customers button
        JButton customerButton = new JButton();
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerController customerController = new CustomerController();
                customerController.setVisible(true);
            }
        });
        try {
            customerButton.setIcon(new ImageIcon(ImageIO.read(new File("resources/customer.png"))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jPanel.add(inscriptionButton);
        jPanel.add(customerButton);
        this.setContentPane(jPanel);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Root();
    }
}
