package ru.itpgrad.crmka.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpgrad.crmka.model.entity.Customer;

/**
 * JPA repository for customer
 *
 * @author maslowis
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
