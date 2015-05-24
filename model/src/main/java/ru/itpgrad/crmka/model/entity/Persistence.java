package ru.itpgrad.crmka.model.entity;

import java.io.Serializable;

/**
 * It is the common interface for all entities
 *
 * @author maslowis
 */
public interface Persistence<P extends Serializable> {

    P getId();

    void setId(P id);
}
