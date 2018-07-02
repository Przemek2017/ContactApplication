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
public class TestContactServiceDeleteContactByIds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactService contactService = context.getBean(ContactService.class);
        contactService.delete(new Integer[]{5,6,7});
        System.out.println("************* CONTACTS DELETED *************");
    }
}
