package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.dao.UserDAO;
import com.pc.conapp.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestUserRowMapperFindSingleRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        User user = userDAO.findById(2);
        System.out.println("************* SINGLE USER *************");
        System.out.println(user);
    }
}
