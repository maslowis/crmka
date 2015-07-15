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

package ru.itpgrad.crmka.model.dao;

import ru.itpgrad.crmka.model.entity.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Generic interface DAO
 *
 * @author Ivan Maslov
 */
public interface Dao<E extends Entity, ID extends Serializable> {

    /**
     * Saves the new object in the database
     *
     * @param newInstance new object
     * @return primary key
     */
    ID create(E newInstance);

    /**
     * Returns the object stored in the database, using the specified id as the primary key
     *
     * @param id primary key
     * @return instance of object
     */
    E read(ID id);

    /**
     * Returns all objects stored in the database
     *
     * @return list of objects
     */
    List<E> readAll();

    /**
     * Saves the changes made to the object
     *
     * @param transientObject changed object
     */
    void update(E transientObject);

    /**
     * Removes the object from the database
     *
     * @param persistentObject object to delete
     */
    void delete(E persistentObject);
}
