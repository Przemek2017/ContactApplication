package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.exception.UserBlockedException;
import com.pc.conapp.pojo.User;
import com.pc.conapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestUserServiceLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UserBlockedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("test", "123");
        if (user != null) {
            System.out.println("\n************* USER LOGGED *************\n");
        } else {
            System.out.println("\n************* WRONG LOGIN OR PASSWORD *************\n");
        }
    }
}
