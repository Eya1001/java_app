package models.entities;

import models.MyConnection;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inscription {
    private int id;
    private Date date;
    private float amountPayed;
    private String methodPayment;
    private int customerId;
    private int courseId;

    public Inscription(int id, Date date, float amountPayed, String methodPayment, int customerId, int courseId) {
        this.id = id;
        this.date = date;
        this.amountPayed = amountPayed;
        this.methodPayment = methodPayment;
        this.customerId = customerId;
        this.courseId = courseId;
    }

    public Inscription(Date date, float amountPayed, String methodPayment, int customerId, int courseId) {
        this.date = date;
        this.amountPayed = amountPayed;
        this.methodPayment = methodPayment;
        this.customerId = customerId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(float amountPayed) {
        this.amountPayed = amountPayed;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Inscription save() throws SQLException {
        DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
        String date = df.format(this.date);
        String query = String.format(
                "INSERT INTO inscriptions (date, amountPayed, methodPayment, customerId, courseId) VALUES ('%s', %.2f, '%s', %d, %d)",
                date, this.amountPayed, this.methodPayment, this.customerId, this.courseId
        );
        int id = MyConnection.executeCreateQuery(query);
        this.setId(id);
        return this;
    }
}
