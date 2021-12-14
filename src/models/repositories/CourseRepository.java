package models.repositories;

import models.MyConnection;
import models.entities.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements Repository<Course>{

    public List<Course> findAll() {
        try {
            Statement statement = MyConnection.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");
            if (resultSet == null) {
                return null;
            } else {
                List<Course> courses = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String label = resultSet.getString("label");
                    String category = resultSet.getString("category");
                    courses.add(new Course(id, label, category));
                }
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Course create(Course course) {
        try {
            return course.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
