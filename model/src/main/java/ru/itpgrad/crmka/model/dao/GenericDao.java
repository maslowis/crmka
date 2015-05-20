package ru.itpgrad.crmka.model.dao;

import java.io.Serializable;
import java.util.List;

/**
 * The generic data access object
 *
 * @author maslowis
 */
public interface GenericDao<T, P extends Serializable> {

    void create(T object);

    T read(P id);

    void update(T object);

    void delete(T object);

    List<T> readAll();
}
