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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.itpgrad.crmka.model.entity.imp.CustomerEntity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerHibernateDaoTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Criteria criteria;

    @InjectMocks
    private CustomerHibernateDao dao;

    private CustomerEntity entity;

    private final Integer id = 999;

    private final String name = "test name";

    private final String description = "test description";

    private final String note = "test note";

    @Before
    public void setUp() {
        entity = new CustomerEntity(id, null, null, null, name, description, null, null, null, note);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    public void createTest() {
        Serializable serializable = id;
        when(session.save(entity)).thenReturn(serializable);
        Integer result = dao.create(entity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).save(entity);
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void createFKTest() {
        dao.create(entity, id);
    }

    @Test
    public void readTest() {
        Object object = entity;
        when(session.get(CustomerEntity.class, id)).thenReturn(object);
        CustomerEntity result = dao.read(id);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).get(CustomerEntity.class, id);
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());
        assertEquals(note, result.getNote());
    }

    @Test
    public void readAllTest() {
        Object object = entity;
        when(session.createCriteria(CustomerEntity.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(Arrays.asList(object));
        List<CustomerEntity> result = dao.readAll();
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).createCriteria(CustomerEntity.class);
        verify(criteria, times(1)).list();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(id, result.get(0).getId());
        assertEquals(name, result.get(0).getName());
        assertEquals(description, result.get(0).getDescription());
        assertEquals(note, result.get(0).getNote());
    }

    @Test
    public void updateTest() {
        dao.update(entity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).update(entity);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void updateFKTest() {
        dao.update(entity, id);
    }

    @Test
    public void deleteTest() {
        dao.delete(entity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).delete(entity);
    }
}