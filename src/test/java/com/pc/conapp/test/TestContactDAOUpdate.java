package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.dao.ContactDAO;
import com.pc.conapp.pojo.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestContactDAOUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactDAO = context.getBean(ContactDAO.class);
        Contact contact = new Contact();
        contact.setContactId(4);
        contact.setUserId(2);
        contact.setName("Gniewomir");
        contact.setPhone("987654321");
        contact.setEmail("gniewomir@poczta.pl");
        contact.setAddress("Za rogiem");
        contact.setRemark("friend");
        contactDAO.update(contact);
        System.out.println("************* CONTACT UPDATED *************");
    }
}
