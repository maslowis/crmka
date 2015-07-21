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

package ru.itpgrad.crmka.service.dto.imp;

import ru.itpgrad.crmka.service.dto.Dto;

import java.util.List;

/**
 * DTO for {@link ru.itpgrad.crmka.model.entity.imp.CustomerEntity}
 *
 * @author Ivan Maslov
 */
public class CustomerDto implements Dto<Integer> {

    private Integer id;

    private DirectoryDto country;

    private DirectoryDto region;

    private DirectoryDto city;

    private String name;

    private String description;

    private DirectoryDto status;

    private List<ContactDto> contacts;

    private List<ActivityDto> activities;

    private String note;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, DirectoryDto country, DirectoryDto region, DirectoryDto city, String name, String description, DirectoryDto status, List<ContactDto> contacts, List<ActivityDto> activities, String note) {
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

    public DirectoryDto getCountry() {
        return country;
    }

    public void setCountry(DirectoryDto country) {
        this.country = country;
    }

    public DirectoryDto getRegion() {
        return region;
    }

    public void setRegion(DirectoryDto region) {
        this.region = region;
    }

    public DirectoryDto getCity() {
        return city;
    }

    public void setCity(DirectoryDto city) {
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

    public DirectoryDto getStatus() {
        return status;
    }

    public void setStatus(DirectoryDto status) {
        this.status = status;
    }

    public List<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDto> contacts) {
        this.contacts = contacts;
    }

    public List<ActivityDto> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityDto> activities) {
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
        return "CustomerDto{" +
                "id=" + id +
                ", country=" + country +
                ", region=" + region +
                ", city=" + city +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", contacts=" + contacts +
                ", activities=" + activities +
                ", note='" + note + '\'' +
                '}';
    }
}
