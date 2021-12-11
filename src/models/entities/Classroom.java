package models.entities;

import models.MyConnection;

import java.sql.SQLException;

public class Classroom {
    private int id;
    private int number;
    private int availableChairsNumber;

    public Classroom(int id , int number ,int availableChairsNumber)
    {
        this.id=id;
        this.number=number;
        this.availableChairsNumber=availableChairsNumber;
    }

    public Classroom(int number ,int availableChairsNumber)
    {
        this.number=number;
        this.availableChairsNumber=availableChairsNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAvailableChairsNumber() {
        return availableChairsNumber;
    }

    public void setAvailableChairsNumber(int availableChairsNumber) {
        this.availableChairsNumber = availableChairsNumber;
    }

    public Classroom save() throws SQLException {
        String query = String.format(
                "INSERT INTO classrooms (number,availableChairsNumber) VALUES (%d, %d)",
                getNumber(), getAvailableChairsNumber()
        );
        int id = MyConnection.executeCreateQuery(query);
        this.setId(id);
        return this;
    }
}
