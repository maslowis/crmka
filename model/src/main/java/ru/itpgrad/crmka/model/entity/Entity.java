package ru.itpgrad.crmka.model.entity;

import java.io.Serializable;

/**
 * It is the common interface for all entities
 *
 * @author maslowis
 */
public interface Entity<P extends Serializable> {

    void setId(P id);

    P getId();
}
