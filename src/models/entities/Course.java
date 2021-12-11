package models.entities;

import models.MyConnection;

import java.sql.SQLException;

public class Course {
    private int id;
    private String label;
    private String category;
    Course(int id, String label, String category){
        this.id = id;
        this.label = label;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Course save() throws SQLException {
        String query = String.format("insert into courses (label, category) values('%s', '%s)", getLabel(), getCategory());
        int id = MyConnection.executeCreateQuery(query);
        this.setId(id);
        return this;
    }
}
