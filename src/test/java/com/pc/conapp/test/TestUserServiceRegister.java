package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.pojo.User;
import com.pc.conapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestUserServiceRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("Magda");
        user.setPhone("987654321");
        user.setEmail("magda@poczta.pl");
        user.setAddress("5th av");
        user.setLogin("magda");
        user.setPassword("magda123");
        user.setRole(UserService.ROLE_USER);
        user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        userService.register(user);
        System.out.println("************* USER REGISTERED *************");
    }
}
