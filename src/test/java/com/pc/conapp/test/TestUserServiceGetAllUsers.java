package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.pojo.User;
import com.pc.conapp.service.UserService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestUserServiceGetAllUsers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = context.getBean(UserService.class);
        List<User> users = userService.getUserList();
        System.out.println("************* ALL USERS *************");
        System.out.println(users);
    }
}
