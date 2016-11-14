package com.lvg.springtest.dao;

import com.lvg.springtest.models.Contact;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface ContactDao {
    
    List<Contact> findAll();
    List<Contact> findAllWithDetails();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
