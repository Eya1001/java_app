package models.entities;

import models.MyConnection;

import java.sql.SQLException;

public class Session {
    private int id;
    private int trainerId;
    private String title;

    public Session(int id, int trainerId, String title) {
        this.id = id;
        this.trainerId = trainerId;
        this.title = title;
    }

    public Session(int trainerId, String title) {
        this.trainerId = trainerId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Session save() throws SQLException {
        String query = String.format(
                "INSERT INTO sessions (title) VALUES ('%s')", this.getTitle()
        );
        int id = MyConnection.executeCreateQuery(query);
        this.setId(id);
        return this;
    }
}
