package models.repositories;

import models.MyConnection;
import models.entities.Course;
import models.entities.Inscription;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InscriptionRepository implements Repository<Inscription>{
    @Override
    public List<Inscription> findAll() {
        try {
            Statement statement = MyConnection.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inscriptions");
            if (resultSet == null) {
                return null;
            } else {
                List<Inscription> inscriptions = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    Date date = resultSet.getDate("dateInscription");
                    float amountPayed = resultSet.getFloat("amountPayed");
                    String methodPayment = resultSet.getString("methodPayment");
                    int customerId = resultSet.getInt("customerId");
                    int courseId = resultSet.getInt("courseId");
                    inscriptions.add(new Inscription(id, date, amountPayed, methodPayment, customerId, courseId));
                }
                return inscriptions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Inscription create(Inscription inscription) {
        try {
            return inscription.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
