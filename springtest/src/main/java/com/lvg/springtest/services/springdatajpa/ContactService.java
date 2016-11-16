package com.lvg.springtest.services.springdatajpa;

import com.lvg.springtest.models.Contact;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface ContactService {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
