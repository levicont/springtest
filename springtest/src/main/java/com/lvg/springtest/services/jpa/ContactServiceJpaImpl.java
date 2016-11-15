package com.lvg.springtest.services.jpa;

import com.lvg.springtest.models.Contact;
import com.lvg.springtest.services.ContactService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Victor
 */
@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceJpaImpl implements ContactService{
    private static final String ALL_CONTACT_NATIVE_QUERY = 
            "select id, first_name, last_name, birth_date, version from contact";
    
    private static final Logger LOG = Logger.getLogger(ContactServiceJpaImpl.class);
    
    @PersistenceContext
    private EntityManager em;
    
    
    
    
    @Override
    @Transactional(readOnly = true)    
    public List<Contact> findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class)
                .getResultList();
        return contacts;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetails() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAllWithDetail", Contact.class)
                .getResultList();
        return contacts;
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
        query.setParameter("id", id);        
        return query.getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        if(null == contact.getId()){
            LOG.info("Inserting new contact");
            em.persist(contact);
        }else{
            em.merge(contact);
            LOG.info("Updating exists contact");
        }
        LOG.info("Saved contact with id: "+contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        Contact mergedContact = em.merge(contact);
        em.remove(mergedContact);
        LOG.info("Contact with id: "+contact.getId()+" deleted successfully");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllByNativeQuery() {
        
//        return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, Contact.class)
//                .getResultList();
        return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult")
                .getResultList();
    }
    
    
    
}
