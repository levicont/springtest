package com.lvg.springtest.services;

import com.lvg.springtest.models.Contact;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface ContactService {
    
    List<Contact> findAll();
    List<Contact> findAllWithDetails();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
    List<Contact> findAllByNativeQuery();
}
