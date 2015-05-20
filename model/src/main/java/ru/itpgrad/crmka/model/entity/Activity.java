package ru.itpgrad.crmka.model.entity;

import java.util.Date;

/**
 * The activity work with the customer
 *
 * @author maslowis
 */
public class Activity implements Entity<Integer> {
    private Integer id;
    private StatusActivityDirectory status;
    private Date date;
    private Contact contact;
    private String description;
    private String result;
    private String note;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public StatusActivityDirectory getStatus() {
        return status;
    }

    public void setStatus(StatusActivityDirectory status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
