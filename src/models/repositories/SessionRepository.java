package models.repositories;

import models.MyConnection;
import models.entities.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SessionRepository {

    public List<Session> findAll() {
        try {
            Statement statement = MyConnection.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sessions");
            if (resultSet == null) {
                return null;
            } else {
                List<Session> sessions = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    int trainerId = resultSet.getInt("trainer_id");
                    sessions.add(new Session(id, trainerId, title));
                }
                return sessions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Session create(Session session) {
        try {
            return session.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
