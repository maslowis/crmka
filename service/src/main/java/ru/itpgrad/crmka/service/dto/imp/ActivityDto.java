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

import java.util.Date;

/**
 * DTO for {@link ru.itpgrad.crmka.model.entity.imp.ActivityEntity}
 *
 * @author Ivan Maslov
 */
public class ActivityDto implements Dto<Integer> {

    private Integer id;

    private DirectoryDto status;

    private Date date;

    private String description;

    private String result;

    private String note;

    public ActivityDto() {
    }

    public ActivityDto(Integer id, DirectoryDto status, Date date, String description, String result, String note) {
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

    public DirectoryDto getStatus() {
        return status;
    }

    public void setStatus(DirectoryDto status) {
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
        return "ActivityDto{" +
                "id=" + id +
                ", status=" + status +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
