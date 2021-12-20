package controllers;

import models.entities.Trainer;
import services.PersonService;
import widgets.LabelTextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class TrainerController extends JFrame {
    /*
    this is the Trainer controller, it'll handle the communication between the trainer service and the screen
    of the trainer crud, it'll render the screen and do the actions based on the events and the significations of
    the button or mouse events.
     */
    private final static PersonService personService = new PersonService();
    private static final DefaultTableModel model = new DefaultTableModel();// the table that displays all the trainers
    private final static String[] columnNames = {"id Trainer", "name Trainer", "family name Trainer", "phone Trainer",
            "email Trainer"};// the columns' names of the trainers
    private static final Object[] data = new Object[5]; // the data of the trainers serialization
    private final static JTable dataTable = new JTable(); // the table of the trainers
    static {
        dataTable.setSize(600, 400);
        model.setColumnIdentifiers(columnNames);
        dataTable.setModel(model);
    }
    // form content
    private final static LabelTextField name = new LabelTextField("Trainer's name");
    private final static LabelTextField familyName = new LabelTextField("Trainer's familyName");
    private final static LabelTextField phone = new LabelTextField("Trainer's phone");
    private final static LabelTextField cin = new LabelTextField("Trainer's cin");
    private final static LabelTextField email = new LabelTextField("Trainer's email");

    TrainerController(){
        // define the meta design of the frame
        this.setSize(800, 400);
        this.setResizable(false);
        this.setTitle("list Trainers");

        Border blackLine = BorderFactory.createLineBorder(Color.black);

        // create the content of the frame
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("form of creation of the Trainer");
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        content.add(title, BorderLayout.CENTER);

        // create the Trainer form
        JPanel TrainerForm = new JPanel(new GridLayout(6, 0));
        TrainerForm.setBorder(blackLine);

        // form content of the Trainer's layout
        TrainerForm.add(cin, BorderLayout.CENTER);
        TrainerForm.add(name, BorderLayout.CENTER);
        TrainerForm.add(familyName, BorderLayout.CENTER);
        TrainerForm.add(phone, BorderLayout.CENTER);
        TrainerForm.add(email, BorderLayout.CENTER);
        // action buttons
        JPanel actionPanel = new JPanel(new GridLayout(1, 2));
        JButton resetButton = new JButton("reset");
        JButton addButton = new JButton("create Trainer");
        addButton.addActionListener(e -> add());
        actionPanel.add(resetButton);
        actionPanel.add(addButton);
        TrainerForm.add(actionPanel);
        // create the Trainer datatable
        JScrollPane scrollPane = new JScrollPane(dataTable);
        dataTable.setFillsViewportHeight(true);
        // add form and datatable to content
        content.add(TrainerForm);
        content.add(scrollPane);
        get();
        // define the content of the frame
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void addRow(Trainer trainer){
        /*
        the data class attribute will serialize the object class to a understandable object to the screen, but the model
        is the attribute who handle the mapping of the values of the data to the specified column
         */
        data[0] = trainer.getId();
        data[1] = trainer.getName();
        data[2] = trainer.getFamilyName();
        data[3] = trainer.getPhone();
        data[4] = trainer.getEmail();
        model.addRow(data);
    }

    public void get(){
        List<Trainer> Trainers = personService.findTrainers();
        Trainers.forEach(this::addRow);
    }

    public void add(){
        // this method will add the trainer to the database based on the method save implemented in the class Trainer
        // after adding the trainer to the database we will add the new trainer to the datatable using the addRow method
        Trainer trainer = new Trainer(cin.getText(), name.getText(),
                familyName.getText(), phone.getText(), email.getText());
        try {
            trainer.save();
            addRow(trainer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TrainerController();
    }
}
