/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Ivan Maslov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package ru.itpgrad.crmka.model.entity.imp;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

/**
 * Customer is main domain object that aggregates all other domain objects.
 *
 * @author maslowis
 */
@javax.persistence.Entity
@Table(name = "customers")
public class CustomerEntity extends AbstractEntity {

    @Column
    @OneToOne
    @MapsId
    private DirectoryEntity country;

    @Column
    @OneToOne
    @MapsId
    private DirectoryEntity region;

    @Column
    @OneToOne
    @MapsId
    private DirectoryEntity city;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @OneToOne
    @MapsId
    private DirectoryEntity status;

    @OneToMany(targetEntity = ContactEntity.class, cascade = ALL, mappedBy = "customers", fetch = LAZY)
    private List<ContactEntity> contacts;

    @OneToMany(targetEntity = ActivityEntity.class, cascade = ALL, mappedBy = "customers", fetch = LAZY)
    private List<ActivityEntity> activities;

    @Column
    private String note;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer id, DirectoryEntity country, DirectoryEntity region, DirectoryEntity city, String name, String description, DirectoryEntity status, List<ContactEntity> contacts, List<ActivityEntity> activities, String note) {
        super(id);
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

    public DirectoryEntity getCountry() {
        return country;
    }

    public void setCountry(DirectoryEntity country) {
        this.country = country;
    }

    public DirectoryEntity getRegion() {
        return region;
    }

    public void setRegion(DirectoryEntity region) {
        this.region = region;
    }

    public DirectoryEntity getCity() {
        return city;
    }

    public void setCity(DirectoryEntity city) {
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

    public DirectoryEntity getStatus() {
        return status;
    }

    public void setStatus(DirectoryEntity status) {
        this.status = status;
    }

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    public List<ActivityEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityEntity> activities) {
        this.activities = activities;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
