/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lvg.springtest;

import com.lvg.springtest.beans.Simple;
import com.lvg.springtest.dao.ContactDao;
import com.lvg.springtest.models.Contact;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        ctx = new GenericXmlApplicationContext("/spring/app-context.xml");        
       
        Simple simpleBean = ctx.getBean("simpleBean", Simple.class);
        simpleBean.printName();
        
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAll();
        printContacts(contacts);
    }
    
    private static void printContacts(List<Contact> contacts){
        LOG.debug("Printing all contacts");
        for(Contact c : contacts){
            System.out.println(c);
        }
    }
}
