package controllers;

import models.entities.Classroom;
import services.ClassroomService;
import widgets.LabelTextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ClassroomController extends JFrame{
    private final static ClassroomService classroomService = new ClassroomService();
    static DefaultTableModel model = new DefaultTableModel();
    private final static String[] columnNames = {"id classroom", "classroom's number", "number of availabel chairs"};
    private static final Object[] data = new Object[3];
    private final static JTable dataTable = new JTable();
    static {
        dataTable.setSize(600, 400);
        model.setColumnIdentifiers(columnNames);
        dataTable.setModel(model);
    }
    // form content
    private final static LabelTextField num = new LabelTextField("classroom's number");
    private final static LabelTextField availableChairs = new LabelTextField("number of available chairs");

    ClassroomController(){
        // define the meta design of the frame
        this.setSize(800, 400);
        this.setResizable(false);
        this.setTitle("list classrooms");

        Border blackLine = BorderFactory.createLineBorder(Color.black);

        // create the content of the frame
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("form of creation of the classroom");
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        content.add(title, BorderLayout.CENTER);

        // create the customer form
        JPanel customerForm = new JPanel(new GridLayout(3, 0));
        customerForm.setBorder(blackLine);

        // form content of the customer's layout
        customerForm.add(num, BorderLayout.CENTER);
        customerForm.add(availableChairs, BorderLayout.CENTER);
        // action buttons
        JPanel actionPanel = new JPanel(new GridLayout(1, 2));
        JButton resetButton = new JButton("reset");
        JButton addButton = new JButton("create classroom");
        addButton.addActionListener(e -> add());
        actionPanel.add(resetButton);
        actionPanel.add(addButton);
        customerForm.add(actionPanel);
        // create the customer datatable
        JScrollPane scrollPane = new JScrollPane(dataTable);
        dataTable.setFillsViewportHeight(true);
        // add form and datatable to content
        content.add(customerForm);
        content.add(scrollPane);
        get();
        // define the content of the frame
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void addRow(Classroom classroom){
        data[0] = classroom.getId();
        data[1] = classroom.getNum();
        data[2] = classroom.getAvailableChairsNumber();
        model.addRow(data);
    }

    public void get(){
        List<Classroom> classrooms = classroomService.findAll();
        classrooms.forEach(this::addRow);
    }

    public void add(){
        Classroom classroom = new Classroom(Integer.parseInt(num.getText()), Integer.parseInt(availableChairs.getText()));
        try {
            classroom.save();
            addRow(classroom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CustomerController();
    }
}
