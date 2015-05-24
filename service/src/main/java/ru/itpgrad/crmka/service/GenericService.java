package ru.itpgrad.crmka.service;

import java.io.Serializable;
import java.util.List;

/**
 * Generic service interface for interacting with the model layer.
 *
 * @author maslowis
 */
public interface GenericService<T, D, P extends Serializable> {

    /**
     * To select a single object by ID.
     *
     * @return single object
     */
    D find(P id);

    /**
     * To select all objects
     *
     * @return list of all objects.
     */
    List<D> findAll();

    /**
     * To insert or update an object in the repository
     *
     * @return saved object
     */
    D save(D object);

    /**
     * To remove an object from the repository.
     */
    void delete(D t);
}
