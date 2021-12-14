package controllers;

import services.InscriptionService;
import services.PersonService;

import javax.swing.*;

public class InscriptionController extends JFrame {
    private final static InscriptionService inscriptionService = new InscriptionService();
    private final static PersonService personService = new PersonService();
    private final static String[] columnNames = {"id customer", "name customer", "family name customer", "phone customer",
            "email customer", "date inscription", "amount payed", "method of payment"};
    InscriptionController()
    {

    }
}
