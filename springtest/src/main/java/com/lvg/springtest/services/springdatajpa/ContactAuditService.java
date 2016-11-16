package com.lvg.springtest.services.springdatajpa;

import com.lvg.springtest.models.ContactAudit;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface ContactAuditService {
    List<ContactAudit> findAll();
    ContactAudit findById(Long id);
    ContactAudit save(ContactAudit contact);
    ContactAudit findAuditByRevision(Long id, int revision);
}
