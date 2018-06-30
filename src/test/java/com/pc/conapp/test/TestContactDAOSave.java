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
public class TestContactDAOSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactDAO = context.getBean(ContactDAO.class);
        for (int i = 0; i < 5; i++) {
            Contact contact = new Contact();
            contact.setUserId(2);
            contact.setName("Imie " + i);
            contact.setPhone("00000000" + i);
            contact.setEmail("email_" + i + "@pl");
            contact.setAddress("Adres " + i);
            contact.setRemark("remark " + i);
            contactDAO.save(contact);
        }
        System.out.println("************* CONTACTS SAVED *************");
    }

}
