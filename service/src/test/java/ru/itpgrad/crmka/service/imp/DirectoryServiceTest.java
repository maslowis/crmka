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

package ru.itpgrad.crmka.service.imp;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.itpgrad.crmka.model.dao.imp.DirectoryHibernateDao;
import ru.itpgrad.crmka.model.entity.imp.DirectoryEntity;
import ru.itpgrad.crmka.service.dto.imp.DirectoryDto;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static ru.itpgrad.crmka.model.entity.imp.DirectoryEntity.Type;

@RunWith(MockitoJUnitRunner.class)
public class DirectoryServiceTest {

    @Mock
    private DirectoryHibernateDao dao;

    private Mapper mapper = new DozerBeanMapper(Arrays.asList("/ru/itpgrad/crmka/service/dozer/mapping.xml"));

    private DirectoryService service;

    private DirectoryEntity entity;

    private DirectoryDto dto;

    private final Integer id = 999;

    private final String stringType = "COUNTRY";

    private final Type enumType = Type.COUNTRY;

    private final String value = "test value";

    @Before
    public void setUp() {
        service = new DirectoryService(dao, mapper);
        entity = new DirectoryEntity(id, enumType, value);
        dto = new DirectoryDto(id, stringType, value);
    }

    @Test
    public void testCreate() {
        when(dao.create(any(DirectoryEntity.class))).thenReturn(id);
        Integer result = service.create(dto);
        verify(dao, times(1)).create(any(DirectoryEntity.class));
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void testRead() {

    }

    @Test
    public void testReadAll() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}