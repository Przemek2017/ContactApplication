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
public class TestUserDAOUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        User user = new User();
        user.setUserId(3);
        user.setName("MiłoszJR");
        user.setPhone("101010101");
        user.setEmail("miloszjr@miloszjr.pl");
        user.setAddress("brooklyn");
        user.setRole(2); // UserRole
        user.setLoginStatus(1); //Active
        userDAO.update(user);
        System.out.println("************* USER UPDATED *************");
    }
}
