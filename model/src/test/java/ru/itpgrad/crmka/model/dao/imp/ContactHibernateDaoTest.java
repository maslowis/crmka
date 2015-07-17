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
import ru.itpgrad.crmka.model.entity.imp.ContactEntity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ContactHibernateDaoTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Criteria criteria;

    @InjectMocks
    private ContactHibernateDao dao;

    private ContactEntity entity;

    private final Integer id = 999;

    private final String position = "test position";

    private final String name = "test name";

    private final String phone = "test phone";

    private final String mail = "test mail";

    @Before
    public void setUp() {
        entity = new ContactEntity(id, position, name, phone, mail, null);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    public void testCreate() {
        Serializable serializable = id;
        when(session.save(entity)).thenReturn(serializable);
        Integer result = dao.create(entity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).save(entity);
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void testRead() {
        Object object = entity;
        when(session.get(ContactEntity.class, id)).thenReturn(object);
        ContactEntity result = dao.read(id);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).get(ContactEntity.class, id);
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(position, result.getPosition());
        assertEquals(name, result.getName());
        assertEquals(phone, result.getPhone());
        assertEquals(mail, result.getMail());
    }

    @Test
    public void testReadAll() {
        Object object = entity;
        when(session.createCriteria(ContactEntity.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(Arrays.asList(object));
        List<ContactEntity> result = dao.readAll();
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).createCriteria(ContactEntity.class);
        verify(criteria, times(1)).list();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(id, result.get(0).getId());
        assertEquals(position, result.get(0).getPosition());
        assertEquals(name, result.get(0).getName());
        assertEquals(phone, result.get(0).getPhone());
        assertEquals(mail, result.get(0).getMail());
    }

    @Test
    public void testUpdate() {
        dao.update(entity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).update(entity);
    }

    @Test
    public void testDelete() {
        dao.delete(entity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).delete(entity);
    }
}