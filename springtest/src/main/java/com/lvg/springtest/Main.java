package com.lvg.springtest;

import com.lvg.springtest.beans.Simple;
import com.lvg.springtest.dao.ContactDao;
import com.lvg.springtest.models.Contact;
import com.lvg.springtest.models.ContactSummary;
import com.lvg.springtest.models.ContactTelDetail;
import com.lvg.springtest.models.Hobby;
import com.lvg.springtest.services.ContactService;
import com.lvg.springtest.services.ContactSummaryService;
import com.lvg.springtest.services.jpa.ContactSummaryUntypeJpaImpl;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author Victor
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    
    
    public static void main(String[] args) {
        LOG.debug("Start application...");
        GenericXmlApplicationContext ctx;
        ctx = new GenericXmlApplicationContext("/spring/app-context-jpa.xml");        
       
        /** Testing Hibernate ContactDao ***
         * 
        GenericXmlApplicationContext ctx;
        ctx = new GenericXmlApplicationContext("/spring/app-context.xml");
        Simple simpleBean = ctx.getBean("simpleBean", Simple.class);
        simpleBean.printName();
        
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAllWithDetails();
        printContactsWithDetails(contacts);
        
        Contact c = contactDao.findById(1L);
        contacts.clear();
        contacts.add(c);
        printContactsWithDetails(contacts);
        
        Contact newContact = getTestContact();
        Long id = contactDao.save(newContact).getId();
        newContact = contactDao.findById(id);
        contacts.clear();
        contacts.add(newContact);
        printContactsWithDetails(contacts);
        
        newContact.setFirstName("Miguel");
        contactDao.save(newContact);
        contacts.clear();
        contacts.add(newContact);
        printContactsWithDetails(contacts);
        
        contactDao.delete(newContact);
        printContactsWithDetails(contactDao.findAllWithDetails());
        
        */
        
        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
        
        List<Contact> contacts = contactService.findAll();
        printContacts(contacts);
        
        contacts = contactService.findAllWithDetails();
        printContactsWithDetails(contacts);
        
        contacts.clear();
        contacts.add(contactService.findById(1L));
        printContactsWithDetails(contacts);
        
        ContactSummaryService summaryService = ctx.getBean("contactSummaryUntype", 
                ContactSummaryService.class);        
        printAllContactSummaries(summaryService.findAll());
        
        Contact newContact = getTestContact();
        Long id = contactService.save(newContact).getId();
        
        Contact updContact = contactService.findById(1l);
        updContact.setFirstName("KING");
        updContact.setLastName("THEO");
        contactService.save(updContact);
        printContactsWithDetails(contactService.findAllWithDetails());
        
        contactService.delete(newContact);
        
        printContacts(contactService.findAllByNativeQuery());
        
        printContactsWithDetails(contactService.findByCriteriaQuery("KING", "THEO"));
        
    }
    
    private static void printContacts(List<Contact> contacts){
        LOG.debug("Printing all contacts");
        for(Contact c : contacts){
            System.out.println(c);
        }
    }
    
    private static void printContactsWithDetails(List<Contact> contacts){
        LOG.debug("Printing all contacts");
        for(Contact c : contacts){
            System.out.println(c);
            if(c.getContactTelDetails() != null)
                for(ContactTelDetail ctd : c.getContactTelDetails()){
                    System.out.println(ctd);
                }
            
            if(c.getHobbies() != null)
                c.getHobbies().stream().forEach((h) -> {
                    System.out.println(h);
            });
        }
    }
    
    private static void printAllContactSummaries(List<ContactSummary> list){
        LOG.debug("Printing all contact summaries");
        for(ContactSummary cs : list){
            System.out.println(cs);
        }
    }
    
    private static Contact getTestContact(){
        Contact newContact = new Contact();
        newContact.setFirstName("Michel");
        newContact.setLastName("Jordan");
        newContact.setBirthDate(new Date());
        ContactTelDetail ctd1 = new ContactTelDetail("Home", "444555666");
        newContact.addContactTelDetail(ctd1);
        ContactTelDetail ctd2 = new ContactTelDetail("Work", "777888999");
        newContact.addContactTelDetail(ctd2);
        return newContact;
    }
}
