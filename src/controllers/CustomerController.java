package controllers;

import models.entities.Customer;
import models.entities.Person;
import services.PersonService;
import widgets.LabelTextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class CustomerController extends JFrame {
    private final static PersonService personService = new PersonService();
    static DefaultTableModel model = new DefaultTableModel();
    private final static String[] columnNames = {"id customer", "name customer", "family name customer", "phone customer",
            "email customer"};
    private static final Object[] data = new Object[5];
    private final static JTable dataTable = new JTable();
    static {
        dataTable.setSize(600, 400);
        model.setColumnIdentifiers(columnNames);
        dataTable.setModel(model);
    }
    // form content
    private final static LabelTextField name = new LabelTextField("customer's name");
    private final static LabelTextField familyName = new LabelTextField("customer's familyName");
    private final static LabelTextField phone = new LabelTextField("customer's phone");
    private final static LabelTextField cin = new LabelTextField("customer's cin");
    private final static LabelTextField email = new LabelTextField("customer's email");

    CustomerController(){
        // define the meta design of the frame
        this.setSize(800, 400);
        this.setResizable(false);
        this.setTitle("list customers");

        Border blackLine = BorderFactory.createLineBorder(Color.black);

        // create the content of the frame
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("form of creation of the customer");
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        content.add(title, BorderLayout.CENTER);

        // create the customer form
        JPanel customerForm = new JPanel(new GridLayout(6, 0));
        customerForm.setBorder(blackLine);

        // form content of the customer's layout
        customerForm.add(cin, BorderLayout.CENTER);
        customerForm.add(name, BorderLayout.CENTER);
        customerForm.add(familyName, BorderLayout.CENTER);
        customerForm.add(phone, BorderLayout.CENTER);
        customerForm.add(email, BorderLayout.CENTER);
        // action buttons
        JPanel actionPanel = new JPanel(new GridLayout(1, 2));
        JButton resetButton = new JButton("reset");
        JButton addButton = new JButton("create customer");
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

    public void addRow(Person customer){
        data[0] = customer.getId();
        data[1] = customer.getName();
        data[2] = customer.getFamilyName();
        data[3] = customer.getPhone();
        data[4] = customer.getEmail();
        model.addRow(data);
    }

    public void get(){
        List<Person> customers = personService.findAll();
        customers.forEach(this::addRow);
    }

    public void add(){
        Customer customer = new Customer(cin.getText(), name.getText(), familyName.getText(), phone.getText(), email.getText());
        try {
            customer.save();
            addRow(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CustomerController();
    }
}
