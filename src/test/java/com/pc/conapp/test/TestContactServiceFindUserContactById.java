package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.pojo.Contact;
import com.pc.conapp.service.ContactService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestContactServiceFindUserContactById {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactService contactService = context.getBean(ContactService.class);
        List<Contact> contact = contactService.findUserContact(5);
        System.out.println("************* ALL CONTACTS *************");
        System.out.println(contact);
    }
}
