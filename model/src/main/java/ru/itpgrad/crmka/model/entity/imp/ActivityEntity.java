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
import java.util.Date;

/**
 * Activity with the client
 *
 * @author Ivan Maslov
 */
@javax.persistence.Entity
@Table(name = "activities")
public class ActivityEntity implements ru.itpgrad.crmka.model.entity.Entity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @MapsId
    private DirectoryEntity status;

    @Column
    private Date date;

    @Column
    private String description;

    @Column
    private String result;

    @Column
    private String note;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    public ActivityEntity() {
    }

    public ActivityEntity(Integer id, DirectoryEntity status, Date date, String description, String result, String note, CustomerEntity customer) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.description = description;
        this.result = result;
        this.note = note;
        this.customer = customer;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public DirectoryEntity getStatus() {
        return status;
    }

    public void setStatus(DirectoryEntity status) {
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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivityEntity)) return false;
        ActivityEntity entity = (ActivityEntity) o;
        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (date != null ? !date.equals(entity.date) : entity.date != null) return false;
        if (description != null ? !description.equals(entity.description) : entity.description != null) return false;
        if (note != null ? !note.equals(entity.note) : entity.note != null) return false;
        if (result != null ? !result.equals(entity.result) : entity.result != null) return false;
        if (status != null ? !status.equals(entity.status) : entity.status != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (status != null ? status.hashCode() : 0);
        result1 = 31 * result1 + (date != null ? date.hashCode() : 0);
        result1 = 31 * result1 + (description != null ? description.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (note != null ? note.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "ActivityEntity{" +
                "note='" + note + '\'' +
                ", result='" + result + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
