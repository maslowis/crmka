package ru.itpgrad.crmka.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The contact of customer
 *
 * @author maslowis
 */
@Entity
public class Contact implements Persistence<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String post;
    private String name;
    private String phone;
    private String mail;

    public Contact() {
    }

    public Contact(Integer id, String post, String name, String phone, String mail) {
        this.id = id;
        this.post = post;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return post + " " + name;
    }
}
