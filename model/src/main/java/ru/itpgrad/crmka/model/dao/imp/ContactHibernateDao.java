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

package ru.itpgrad.crmka.model.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.itpgrad.crmka.model.entity.imp.ContactEntity;
import ru.itpgrad.crmka.model.entity.imp.CustomerEntity;

/**
 * DAO implementation for {@link ru.itpgrad.crmka.model.entity.imp.ContactEntity}
 *
 * @author Ivan Maslov
 */
@Repository("contactDao")
public class ContactHibernateDao extends AbstractHibernateDao<ContactEntity, Integer> {

    @Autowired
    public ContactHibernateDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, ContactEntity.class);
    }

    @Override
    public Integer create(ContactEntity newInstance, Integer foreignId) {
        CustomerEntity customer = (CustomerEntity) getSession().get(CustomerEntity.class, foreignId);
        newInstance.setCustomer(customer);
        return create(newInstance);
    }

    @Override
    public void update(ContactEntity transientObject, Integer foreignId) {
        CustomerEntity customer = (CustomerEntity) getSession().get(CustomerEntity.class, foreignId);
        transientObject.setCustomer(customer);
        update(transientObject);
    }
}
