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
    private final static PersonService personService = new PersonService();
    static DefaultTableModel model = new DefaultTableModel();
    private final static String[] columnNames = {"id Trainer", "name Trainer", "family name Trainer", "phone Trainer",
            "email Trainer"};
    private static final Object[] data = new Object[5];
    private final static JTable dataTable = new JTable();
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

    public void addRow(Trainer Trainer){
        data[0] = Trainer.getId();
        data[1] = Trainer.getName();
        data[2] = Trainer.getFamilyName();
        data[3] = Trainer.getPhone();
        data[4] = Trainer.getEmail();
        model.addRow(data);
    }

    public void get(){
        List<Trainer> Trainers = personService.findTrainers();
        Trainers.forEach(this::addRow);
    }

    public void add(){
        Trainer Trainer = new Trainer(cin.getText(), name.getText(), familyName.getText(), phone.getText(), email.getText());
        try {
            Trainer.save();
            addRow(Trainer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TrainerController();
    }
}
