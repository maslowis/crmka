package ru.itpgrad.crmka.model.entity;

import java.util.List;

/**
 * @author maslowis
 */
public class Customer implements Entity<Integer> {
    private Integer id;
    private CountryDirectory country;
    private RegionDirectory region;
    private CityDirectory city;
    private String name;
    private String description;
    private StatusCustomerDirectory status;
    private List<Contact> contacts;
    private List<Activity> activities;
    private String note;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public CountryDirectory getCountry() {
        return country;
    }

    public void setCountry(CountryDirectory country) {
        this.country = country;
    }

    public RegionDirectory getRegion() {
        return region;
    }

    public void setRegion(RegionDirectory region) {
        this.region = region;
    }

    public CityDirectory getCity() {
        return city;
    }

    public void setCity(CityDirectory city) {
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

    public StatusCustomerDirectory getStatus() {
        return status;
    }

    public void setStatus(StatusCustomerDirectory status) {
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
