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
import ru.itpgrad.crmka.model.entity.imp.ContactEntity;
import ru.itpgrad.crmka.model.entity.imp.CustomerEntity;
import ru.itpgrad.crmka.model.entity.imp.DirectoryEntity;
import ru.itpgrad.crmka.service.dto.imp.ActivityDto;
import ru.itpgrad.crmka.service.dto.imp.ContactDto;
import ru.itpgrad.crmka.service.dto.imp.CustomerDto;
import ru.itpgrad.crmka.service.dto.imp.DirectoryDto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private Dao<CustomerEntity, Integer> dao;

    @Spy
    private DozerBeanMapper mapper;

    @InjectMocks
    private CustomerService service;

    private final Integer id = 999;

    private final Integer foreignId = 111;

    private final Date date = new Date();

    private final CustomerDto exceptedDto = getNewDto();

    private CustomerEntity testedEntity;

    private CustomerDto testedDto;

    @Before
    public void setUp() {
        testedEntity = getNewEntity();
        testedDto = getNewDto();
    }

    @Test
    public void createTest() {
        when(dao.create(any(CustomerEntity.class))).thenReturn(id);
        Integer result = service.create(testedDto);
        verify(dao, times(1)).create(any(CustomerEntity.class));
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void createFKTest() {
        when(dao.create(any(CustomerEntity.class), eq(foreignId))).thenReturn(id);
        Integer result = service.create(testedDto, foreignId);
        verify(dao, times(1)).create(any(CustomerEntity.class), eq(foreignId));
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void readTest() {
        when(dao.read(id)).thenReturn(testedEntity);
        CustomerDto result = service.read(id);
        verify(dao, times(1)).read(id);
        assertNotNull(result);
        assertEquals(exceptedDto, result);
    }

    @Test
    public void readAllTest() {
        when(dao.readAll()).thenReturn(Arrays.asList(testedEntity));
        List<CustomerDto> results = service.readAll();
        verify(dao, times(1)).readAll();
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertTrue(results.size() == 1);
        assertEquals(exceptedDto, results.get(0));
    }

    @Test
    public void updateTest() {
        service.update(testedDto);
        verify(dao, times(1)).update(any(CustomerEntity.class));
    }

    @Test
    public void updateFKTest() {
        service.update(testedDto, foreignId);
        verify(dao, times(1)).update(any(CustomerEntity.class), eq(foreignId));
    }

    @Test
    public void deleteTest() {
        service.delete(testedDto);
        verify(dao, times(1)).delete(any(CustomerEntity.class));
    }

    private CustomerEntity getNewEntity() {
        DirectoryEntity country = new DirectoryEntity(1, DirectoryEntity.Type.COUNTRY, "test country");
        DirectoryEntity region = new DirectoryEntity(2, DirectoryEntity.Type.REGION, "test region");
        DirectoryEntity city = new DirectoryEntity(3, DirectoryEntity.Type.CITY, "test city");
        String name = "test name";
        String description = "test description";
        DirectoryEntity status = new DirectoryEntity(4, DirectoryEntity.Type.CUSTOMER_STATUS, "test customer status");
        List<ContactEntity> contacts = Arrays.asList(new ContactEntity(1, "test position", "test name", "test phone", "test mail", null));
        DirectoryEntity activityStatus = new DirectoryEntity(5, DirectoryEntity.Type.ACTIVITY_STATUS, "test activity status");
        List<ActivityEntity> activities = Arrays.asList(new ActivityEntity(1, activityStatus, date, "test description", "test result", "test note", null));
        String note = "test note";
        return new CustomerEntity(id, country, region, city, name, description, status, contacts, activities, note);
    }

    private CustomerDto getNewDto() {
        DirectoryDto country = new DirectoryDto(1, "COUNTRY", "test country");
        DirectoryDto region = new DirectoryDto(2, "REGION", "test region");
        DirectoryDto city = new DirectoryDto(3, "CITY", "test city");
        String name = "test name";
        String description = "test description";
        DirectoryDto status = new DirectoryDto(4, "CUSTOMER_STATUS", "test customer status");
        List<ContactDto> contacts = Arrays.asList(new ContactDto(1, "test position", "test name", "test phone", "test mail"));
        DirectoryDto activityStatus = new DirectoryDto(5, "ACTIVITY_STATUS", "test activity status");
        List<ActivityDto> activities = Arrays.asList(new ActivityDto(1, activityStatus, date, "test description", "test result", "test note"));
        String note = "test note";
        return new CustomerDto(id, country, region, city, name, description, status, contacts, activities, note);
    }
}