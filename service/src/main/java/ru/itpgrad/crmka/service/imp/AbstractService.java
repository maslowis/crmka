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

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;
import ru.itpgrad.crmka.model.dao.Dao;
import ru.itpgrad.crmka.model.entity.Entity;
import ru.itpgrad.crmka.service.Service;
import ru.itpgrad.crmka.service.dto.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Parent for all service implementations
 * <p/>
 * <p>This class include a default implementation for CRUD operations via generic types</p>
 *
 * @author Ivan Maslov
 */
abstract class AbstractService<E extends Entity, D extends Dto, ID extends Serializable> implements Service<D, ID> {
    protected final Logger logger;
    protected final Dao<E, ID> dao;
    protected final Mapper mapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    protected AbstractService(Dao<E, ID> dao, Mapper mapper, Class<E> entityClass, Class<D> dtoClass) {
        logger = Logger.getLogger(getClass());
        this.dao = dao;
        this.mapper = mapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Transactional
    @Override
    public ID create(D newInstance) {
        E entity = mapper.map(newInstance, entityClass);
        return dao.create(entity);
    }

    @Transactional
    @Override
    public D read(ID id) {
        E entity = dao.read(id);
        return mapper.map(entity, dtoClass);
    }

    @Transactional
    @Override
    public List<D> readAll() {
        List<E> entities = dao.readAll();
        List<D> results = new ArrayList<>();
        for (E entity : entities) {
            D dto = mapper.map(entity, dtoClass);
            results.add(dto);
        }
        return results;
    }

    @Transactional
    @Override
    public void update(D transientObject) {
        E entity = mapper.map(transientObject, entityClass);
        dao.update(entity);
    }

    @Transactional
    @Override
    public void delete(D persistentObject) {
        E entity = mapper.map(persistentObject, entityClass);
        dao.delete(entity);
    }
}
