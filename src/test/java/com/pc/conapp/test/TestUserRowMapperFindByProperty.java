package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import com.pc.conapp.dao.UserDAO;
import com.pc.conapp.pojo.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class TestUserRowMapperFindByProperty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        //List<User> user = userDAO.findByProperty("user_id", 2);
        List<User> user = userDAO.findByProperty("name", "Przemek");
        System.out.println("************* USER BY PROPERTY *************");
        System.out.println(user);
    }
}
