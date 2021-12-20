package models.entities;

import models.MyConnection;

import java.sql.SQLException;

public class Trainer extends Person{
    public Trainer(int id, String name, String familyName, String cin, String phone, String email) {
        super(id, cin, name, familyName, phone, email, "trainer");
    }

    public Trainer(String cin, String name, String familyName, String phone, String email) {
        super(cin, name, familyName, phone, email, "trainer");
    }

    @Override
    public Trainer save() throws SQLException {
        String query = String.format(
                "INSERT INTO persons (cin, name, familyName, phone, email, typePerson) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                getCin(), getName(), getFamilyName(), getPhone(), getEmail(), "trainer"
        );
        int id = MyConnection.executeCreateQuery(query) + 1;
        this.setId(id);
        return this;
    }
}
