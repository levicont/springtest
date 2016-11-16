package com.lvg.springtest.services.springdatajpa;

import com.lvg.springtest.models.Contact;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Victor
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
