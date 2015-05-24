package ru.itpgrad.crmka.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author maslowis
 */
public class GenericServiceImp<T, D, P extends Serializable> implements GenericService<T, D, P> {


    @Override
    public D find(P id) {
        return null;
    }

    @Override
    public List<D> findAll() {
        return null;
    }

    @Override
    public D save(D object) {
        return null;
    }

    @Override
    public void delete(D t) {

    }
}
