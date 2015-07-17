package ru.itpgrad.crmka.service;

import ru.itpgrad.crmka.service.dto.Dto;

import java.io.Serializable;
import java.util.List;

/**
 * Common interface for all service implementations
 *
 * @author Ivan Maslov
 */
public interface Service<D extends Dto, ID extends Serializable> {

    /**
     * Saves the new object in the repository
     *
     * @param newInstance new object
     * @return primary key
     */
    ID create(D newInstance);

    /**
     * Returns the object from the repository by its primary key
     *
     * @param id primary key
     * @return instance of object
     */
    D read(ID id);

    /**
     * Returns all objects from the repository
     *
     * @return list of objects
     */
    List<D> readAll();

    /**
     * Saves the changes made to the object
     *
     * @param transientObject changed object
     */
    void update(D transientObject);

    /**
     * Removes the object from the repository
     *
     * @param persistentObject object to delete
     */
    void delete(D persistentObject);

}
