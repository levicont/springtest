package com.lvg.springtest.services.springdatajpa;

import com.lvg.springtest.models.ContactAudit;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Victor
 */
public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long>{
    
}
