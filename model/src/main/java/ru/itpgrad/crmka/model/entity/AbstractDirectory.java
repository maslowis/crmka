package ru.itpgrad.crmka.model.entity;

/**
 * This abstract class is the parent for all directories
 *
 * @author maslowis
 */
public abstract class AbstractDirectory implements Entity<Integer> {
    protected Integer id;
    protected String name;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
