package models.entities;


import java.sql.SQLException;

abstract public class Person {
    private String cin;
    private String name;
    private String familyName;
    private String phone;
    private String email;
    private String typePerson;
    private int id;
    public Person(int id, String cin, String name, String familyName, String phone, String email, String typePerson){
        this.id = id;
        this.cin = cin;
        this.name = name;
        this.familyName = familyName;
        this.phone = phone;
        this.email = email;
        this.typePerson = typePerson;
    }
    public Person(String cin, String name, String familyName, String phone, String email, String typePerson){
        this.cin = cin;
        this.name = name;
        this.familyName = familyName;
        this.phone = phone;
        this.email = email;
        this.typePerson = typePerson;
    }
    public Person(int id, String cin, String name, String familyName, String phone, String email){
        this.id = id;
        this.cin = cin;
        this.name = name;
        this.familyName = familyName;
        this.phone = phone;
        this.email = email;
    }
    public abstract Person save() throws SQLException;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }
}
