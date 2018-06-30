package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.dao.ContactDAO;
import com.pc.conapp.pojo.Contact;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestContactRowMapperFindAllRecords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactDAO = context.getBean(ContactDAO.class);
        List<Contact> contacts = contactDAO.findAll();
        System.out.println("************* ALL CONTACTS *************");
        System.out.println(contacts);
    }
}
