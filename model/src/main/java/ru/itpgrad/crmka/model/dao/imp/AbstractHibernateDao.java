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

package ru.itpgrad.crmka.model.dao.imp;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.itpgrad.crmka.model.dao.Dao;
import ru.itpgrad.crmka.model.entity.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Parent for all DAO implementations
 *
 * @author Ivan Maslov
 */
class AbstractHibernateDao<E extends Entity, ID extends Serializable> implements Dao<E, ID> {
    protected final Logger logger;
    private final SessionFactory sessionFactory;
    private final Class<E> targetClass;

    protected AbstractHibernateDao(SessionFactory sessionFactory, Class<E> targetClass) {
        logger = Logger.getLogger(getClass());
        this.sessionFactory = sessionFactory;
        this.targetClass = targetClass;
    }

    protected final Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public ID create(E newInstance) {
        return (ID) getSession().save(newInstance);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E read(ID id) {
        return (E) getSession().get(targetClass, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> readAll() {
        return (List<E>) getSession().createCriteria(targetClass).list();
    }

    @Override
    public void update(E transientObject) {
        getSession().update(transientObject);
    }

    @Override
    public void delete(E persistentObject) {
        getSession().delete(persistentObject);
    }
}
