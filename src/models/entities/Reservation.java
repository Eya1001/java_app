package models.entities;

import models.MyConnection;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private int id;
    private int sessionId;
    private int classroomId;
    private Date dateStart;
    private Date dateEnd;

    public Reservation(int id, int sessionId, int classroomId, Date dateStart, Date dateEnd) {
        this.id = id;
        this.sessionId = sessionId;
        this.classroomId = classroomId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Reservation(int sessionId, int classroomId, Date dateStart, Date dateEnd) {
        this.sessionId = sessionId;
        this.classroomId = classroomId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Reservation save() throws SQLException {
        DateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateStart = df.format(this.dateStart);
        String dateEnd = df.format(this.dateEnd);
        String query = String.format(
                "INSERT INTO reservations (sessionId, classroomId, dateStart, dateEnd) VALUES (%d, %d, '%s', '%s')",
                this.sessionId, this.classroomId, dateStart, dateEnd
        );
        int id = MyConnection.executeCreateQuery(query);
        this.setId(id);
        return this;
    }
}
