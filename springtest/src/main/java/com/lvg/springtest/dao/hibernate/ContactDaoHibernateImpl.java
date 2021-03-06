package com.lvg.springtest.dao.hibernate;

import com.lvg.springtest.dao.ContactDao;
import com.lvg.springtest.models.Contact;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Victor
 */

@Transactional
@Repository("contactDao")
public class ContactDaoHibernateImpl implements ContactDao{
    private static final Logger LOG = Logger.getLogger(ContactDaoHibernateImpl.class);
    
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Contact c").list();
    }

    @Override
    public List<Contact> findAllWithDetails() {
        return sessionFactory.getCurrentSession().
                getNamedQuery("Contact.findAllWithDetail").list();
    }

    @Override
    public Contact findById(Long id) {
        return (Contact)sessionFactory.getCurrentSession().
                getNamedQuery("Contact.findById").
                setParameter("id", id).uniqueResult();
    }

    @Override
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        LOG.info("Contact saved with id: "+contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
        LOG.info("Contact deleted with id: "+contact.getId());
    }
    
    
}
