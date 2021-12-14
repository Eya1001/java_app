package models.repositories;

import models.MyConnection;
import models.entities.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationRepository {

    public List<Reservation> findAll() {
        try {
            Statement statement = MyConnection.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reservations");
            if (resultSet == null) {
                return null;
            } else {
                List<Reservation> reservations = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    Date dateStart = resultSet.getDate("dateStart");
                    Date dateEnd = resultSet.getDate("dateEnd");
                    int sessionId = resultSet.getInt("sessionId");
                    int classroomId = resultSet.getInt("classroomId");
                    reservations.add(new Reservation(id, sessionId, classroomId, dateStart, dateEnd));
                }
                return reservations;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Reservation create(Reservation reservation) {
        try {
            return reservation.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
