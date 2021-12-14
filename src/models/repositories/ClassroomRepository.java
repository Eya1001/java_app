package models.repositories;

import models.MyConnection;
import models.entities.Classroom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassroomRepository implements Repository<Classroom>{
    public List<Classroom> findAll() {
        try {
            Statement statement = MyConnection.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM classrooms");
            if (resultSet == null) {
                return null;
            } else {
                List<Classroom> classrooms = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int num = resultSet.getInt("num");
                    int availableChairsNumber = resultSet.getInt("availableChairsNumber");
                    classrooms.add(new Classroom(id, num, availableChairsNumber));
                }
                return classrooms;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Classroom create(Classroom classroom) {
        try {
            return classroom.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
