package models.entities;

import models.MyConnection;

import java.sql.SQLException;

public class Customer extends Person{
    public Customer(int id, String name, String familyName, String cin, String phone, String email) {
        super(id, cin, name, familyName, phone, email);
    }

    @Override
    public Customer save() throws SQLException {
        String query = String.format(
                "INSERT INTO persons (cin, name, familyName, phone, email, typePerson) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                getCin(), getName(), getFamilyName(), getPhone(), getEmail(), "customer"
        );
        int id = MyConnection.executeCreateQuery(query);
        this.setId(id);
        return this;
    }
}
