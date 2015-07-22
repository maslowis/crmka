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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ru.itpgrad.crmka.model.dao.Dao;
import ru.itpgrad.crmka.model.entity.imp.ActivityEntity;
import ru.itpgrad.crmka.model.entity.imp.CustomerEntity;
import ru.itpgrad.crmka.model.entity.imp.DirectoryEntity;
import ru.itpgrad.crmka.service.dto.imp.ActivityDto;
import ru.itpgrad.crmka.service.dto.imp.DirectoryDto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ActivityServiceTest {

    @Mock
    private Dao<ActivityEntity, Integer> dao;

    @Spy
    private DozerBeanMapper mapper;

    @InjectMocks
    private ActivityService service;

    private final Integer id = 999;

    private final Integer foreignId = 111;

    private final Date date = new Date();

    private final ActivityDto exceptedDto = getNewDto();

    private ActivityEntity testedEntity;

    private ActivityDto testedDto;

    @Before
    public void setUp() {
        testedEntity = getNewEntity();
        testedDto = getNewDto();
    }

    @Test
    public void createTest() {
        when(dao.create(any(ActivityEntity.class))).thenReturn(id);
        Integer result = service.create(testedDto);
        verify(dao, times(1)).create(any(ActivityEntity.class));
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void createFKTest() {
        when(dao.create(any(ActivityEntity.class), eq(foreignId))).thenReturn(id);
        Integer result = service.create(testedDto, foreignId);
        verify(dao, times(1)).create(any(ActivityEntity.class), eq(foreignId));
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void readTest() {
        when(dao.read(id)).thenReturn(testedEntity);
        ActivityDto result = service.read(id);
        verify(dao, times(1)).read(id);
        assertNotNull(result);
        assertEquals(exceptedDto, result);
    }

    @Test
    public void readAllTest() {
        when(dao.readAll()).thenReturn(Arrays.asList(testedEntity));
        List<ActivityDto> results = service.readAll();
        verify(dao, times(1)).readAll();
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertTrue(results.size() == 1);
        assertEquals(exceptedDto, results.get(0));
    }

    @Test
    public void updateTest() {
        service.update(testedDto);
        verify(dao, times(1)).update(any(ActivityEntity.class));
    }

    @Test
    public void updateFKTest() {
        service.update(testedDto, foreignId);
        verify(dao, times(1)).update(any(ActivityEntity.class), eq(foreignId));
    }

    @Test
    public void deleteTest() {
        service.delete(testedDto);
        verify(dao, times(1)).delete(any(ActivityEntity.class));
    }

    private ActivityEntity getNewEntity() {
        DirectoryEntity status = new DirectoryEntity(1, DirectoryEntity.Type.ACTIVITY_STATUS, "test status");
        return new ActivityEntity(id, status, date, "test description", "test result", "test note", new CustomerEntity());
    }

    private ActivityDto getNewDto() {
        DirectoryDto status = new DirectoryDto(1, "ACTIVITY_STATUS", "test status");
        return new ActivityDto(id, status, date, "test description", "test result", "test note");
    }
}