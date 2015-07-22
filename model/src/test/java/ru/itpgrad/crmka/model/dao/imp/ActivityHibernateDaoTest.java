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
import ru.itpgrad.crmka.model.entity.imp.ActivityEntity;
import ru.itpgrad.crmka.model.entity.imp.CustomerEntity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ActivityHibernateDaoTest {
    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Criteria criteria;

    @InjectMocks
    private ActivityHibernateDao dao;

    private final Integer id = 999;

    private final Integer foreignId = 111;

    private final Date date = new Date();

    private final ActivityEntity expectedEntity = getNewEntity();

    private ActivityEntity testedEntity;

    @Before
    public void setUp() {
        testedEntity = getNewEntity();
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    public void createTest() {
        Serializable serializable = id;
        when(session.save(testedEntity)).thenReturn(serializable);
        Integer result = dao.create(testedEntity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).save(testedEntity);
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void createFKTest() {
        Serializable serializable = id;
        when(session.save(testedEntity)).thenReturn(serializable);
        Integer result = dao.create(testedEntity, foreignId);
        verify(sessionFactory, times(2)).getCurrentSession();
        verify(session, times(1)).get(CustomerEntity.class, foreignId);
        verify(session, times(1)).save(testedEntity);
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void readTest() {
        Object object = testedEntity;
        when(session.get(ActivityEntity.class, id)).thenReturn(object);
        ActivityEntity result = dao.read(id);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).get(ActivityEntity.class, id);
        assertNotNull(result);
        assertEquals(expectedEntity, result);
    }

    @Test
    public void readAllTest() {
        Object object = testedEntity;
        when(session.createCriteria(ActivityEntity.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(Arrays.asList(object));
        List<ActivityEntity> results = dao.readAll();
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).createCriteria(ActivityEntity.class);
        verify(criteria, times(1)).list();
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertTrue(results.size() == 1);
        assertEquals(expectedEntity, results.get(0));
    }

    @Test
    public void updateTest() {
        dao.update(testedEntity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).update(testedEntity);
    }

    @Test
    public void updateFKTest() {
        dao.update(testedEntity, foreignId);
        verify(sessionFactory, times(2)).getCurrentSession();
        verify(session, times(1)).get(CustomerEntity.class, foreignId);
        verify(session, times(1)).update(testedEntity);
    }

    @Test
    public void deleteTest() {
        dao.delete(testedEntity);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).delete(testedEntity);
    }

    private ActivityEntity getNewEntity() {
        return new ActivityEntity(id, null, date, "test description", "test results", "test note", null);
    }
}