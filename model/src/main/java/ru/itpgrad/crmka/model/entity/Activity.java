package ru.itpgrad.crmka.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * The activity - work with the customer
 *
 * @author maslowis
 */
@Entity
public class Activity implements Persistence<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @MapsId
    private StatusActivity status;
    private Date date;

    private String description;
    private String result;
    private String note;

    public Activity() {
    }

    public Activity(Integer id, StatusActivity status, Date date, String description, String result, String note) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.description = description;
        this.result = result;
        this.note = note;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public StatusActivity getStatus() {
        return status;
    }

    public void setStatus(StatusActivity status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return date + " " + status + " " + description;
    }
}
