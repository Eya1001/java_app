package models.repositories;

import models.MyConnection;
import models.entities.Customer;
import models.entities.Person;
import models.entities.Trainer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    public static MyConnection connection = new MyConnection();

    public List<Person> findAll() {
        try {
            Statement statement = MyConnection.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persons");
            if (resultSet == null) {
                return null;
            } else {
                List<Person> persons = new ArrayList<Person>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String familyName = resultSet.getString("familyName");
                    String cin = resultSet.getString("cin");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    String typePerson = resultSet.getString("typePerson");
                    if (typePerson.equals("customer")) {
                        persons.add(new Customer(id, name, familyName, cin, phone, email));
                    } else if (typePerson.equals("trainer")) {
                        persons.add(new Trainer(id, name, familyName, cin, phone, email));
                    }
                }
                return persons;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Person create(Person person) {
        try {
            if (person.getTypePerson().equals("trainer")) {
                return ((Trainer) person).save();
            } else if (person.getTypePerson().equals("customer")) {
                return ((Customer) person).save();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
