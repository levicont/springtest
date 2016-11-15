package com.lvg.springtest.services.jpa;

import com.lvg.springtest.models.ContactSummary;
import com.lvg.springtest.services.ContactSummaryService;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Victor
 */
@Service("contactSummaryUntype")
@Repository
@Transactional
public class ContactSummaryUntypeJpaImpl implements ContactSummaryService{
    private static final Logger LOG = Logger
            .getLogger(ContactSummaryUntypeJpaImpl.class);
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(readOnly = true)
    @Override
    public void displayAllContactSummary(){
        List result = em.createQuery("select c.firstName, c.lastName, t.telNumber "
                + "from Contact c left join c.contactTelDetails t where t.telType = 'Home'").getResultList();
        int count = 0;
        for(Iterator i = result.iterator(); i.hasNext();){
            
            Object[] values = (Object[])i.next();
            System.out.printf("\n %d %s %s %s \n",++count, values[0],values[1], values[2]);
                    
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactSummary> findAll() {
       List<ContactSummary> result = 
               em.createQuery("select new com.lvg.springtest.models.ContactSummary("
                       + "c.firstName, c.lastName, t.telNumber) from Contact c "
                       + "left join c.contactTelDetails t where t.telType = 'Home'"
                       , ContactSummary.class).getResultList();
       return result;
    }
    
    
}
