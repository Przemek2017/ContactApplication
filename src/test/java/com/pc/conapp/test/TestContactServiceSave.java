package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.dao.ContactDAO;
import com.pc.conapp.pojo.Contact;
import com.pc.conapp.service.ContactService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestContactServiceSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactService contactService = context.getBean(ContactService.class);
        for (int i = 1; i < 6; i++) {
            Contact contact = new Contact();
            contact.setUserId(5);
            contact.setName("Znajomy nr " + i);
            contact.setPhone("00000005" + i);
            contact.setEmail("email_5" + i + "@pl");
            contact.setAddress("Adres " + i);
            contact.setRemark("remark " + i);
            contactService.save(contact);
        }
        System.out.println("************* CONTACTS SAVED *************");
    }

}
