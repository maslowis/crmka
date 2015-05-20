package ru.itpgrad.crmka.model.entity;

/**
 * The contact of customer
 *
 * @author maslowis
 */
public class Contact implements Entity<Integer> {
    private Integer id;
    private String post;
    private String name;
    private String phone;
    private String mail;

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
