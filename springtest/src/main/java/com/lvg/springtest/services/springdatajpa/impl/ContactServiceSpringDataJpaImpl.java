package com.lvg.springtest.services.springdatajpa.impl;

import com.google.common.collect.Lists;
import com.lvg.springtest.models.Contact;
import com.lvg.springtest.services.springdatajpa.ContactRepository;
import com.lvg.springtest.services.springdatajpa.ContactService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Victor
 */
@Service("springJpaContactService")
@Repository
@Transactional
public class ContactServiceSpringDataJpaImpl implements ContactService{
    private static final Logger LOG = Logger.getLogger(ContactServiceSpringDataJpaImpl.class);
    
    @Autowired
    private ContactRepository contactRepository;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(firstName, lastName);
    }
    
}
