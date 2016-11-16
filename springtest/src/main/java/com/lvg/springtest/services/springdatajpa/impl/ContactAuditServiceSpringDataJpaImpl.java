/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lvg.springtest.services.springdatajpa.impl;

import com.google.common.collect.Lists;
import com.lvg.springtest.models.ContactAudit;
import com.lvg.springtest.services.springdatajpa.ContactAuditRepository;
import com.lvg.springtest.services.springdatajpa.ContactAuditService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Victor
 */
@Service("springDataJpaContactAuditService")
@Transactional
@Repository
public class ContactAuditServiceSpringDataJpaImpl implements ContactAuditService{
    private static final Logger LOG = Logger.getLogger(ContactAuditServiceSpringDataJpaImpl.class);
    
    @Autowired
    private ContactAuditRepository contactAuditRepository;
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    @Transactional(readOnly = true)
    public List<ContactAudit> findAll() {
        return Lists.newArrayList(contactAuditRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ContactAudit findById(Long id) {
        return contactAuditRepository.findOne(id);
    }

    @Override
    public ContactAudit save(ContactAudit contact) {
       return contactAuditRepository.save(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public ContactAudit findAuditByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(em);
        return auditReader.find(ContactAudit.class, id, revision);
    }
    
    
    
}
