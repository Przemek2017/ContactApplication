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
public class TestUserDAOSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        User user = new User();
        user.setName("Miłosz");
        user.setPhone("987654321");
        user.setEmail("milosz@milosz.pl");
        user.setAddress("5th av");
        user.setLogin("milosz");
        user.setPassword("m123");
        user.setRole(1); // AdminRole
        user.setLoginStatus(1); //Active
        userDAO.save(user);
        System.out.println("************* USER SAVED *************");
    }
}
