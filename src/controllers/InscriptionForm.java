package controllers;

import jdk.jfr.internal.tool.Main;

import javax.swing.*;
import java.awt.*;

public class InscriptionForm extends JFrame {
    public static void main(String[] args) {
        new InscriptionForm();
    }

    InscriptionForm(){
        this.setTitle("inscription form");
        this.setSize(400, 300);
        this.setVisible(true);
    }
}
