package models.entities;

import models.MyConnection;

import java.sql.SQLException;

public class Classroom {
    private int id;
    private int num;
    private int availableChairsNumber;
    public Classroom(int id , int num ,int availableChairsNumber)
    {
        this.id=id;
        this.num=num;
        this.availableChairsNumber=availableChairsNumber;
    }

    public Classroom(int num ,int availableChairsNumber)
    {
        this.num=num;
        this.availableChairsNumber=availableChairsNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAvailableChairsNumber() {
        return availableChairsNumber;
    }

    public void setAvailableChairsNumber(int availableChairsNumber) {
        this.availableChairsNumber = availableChairsNumber;
    }

    public Classroom save() throws SQLException {
        String query = String.format(
                "INSERT INTO classrooms (number, availableChairsNumber) VALUES (%d, %d)",
                getNum(), getAvailableChairsNumber()
        );
        int id = MyConnection.executeCreateQuery(query);
        this.setId(id);
        return this;
    }
}
