package ru.itpgrad.crmka.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * The customer is the main domain object that aggregates all other domain objects.
 *
 * @author maslowis
 */
@Entity
public class Customer implements Persistence<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @MapsId
    private Country country;
    @OneToOne
    @MapsId
    private Region region;
    @OneToOne
    @MapsId
    private City city;
    private String name;
    private String description;
    @OneToOne
    @MapsId
    private StatusCustomer status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<Contact> contacts;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<Activity> activities;
    private String note;

    public Customer() {
    }

    public Customer(Integer id, Country country, Region region, City city, String name, String description, StatusCustomer status, List<Contact> contacts, List<Activity> activities, String note) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.city = city;
        this.name = name;
        this.description = description;
        this.status = status;
        this.contacts = contacts;
        this.activities = activities;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusCustomer getStatus() {
        return status;
    }

    public void setStatus(StatusCustomer status) {
        this.status = status;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return city + " " + name;
    }
}
