
package com.pc.conapp.test;

import com.pc.conapp.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Przemek
 */
public class TestDataSource {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String insert = "INSERT INTO user (name, phone, email, address, login, password) VALUES (?,?,?,?,?,?)";
        Object[] insertParam = new Object[]{"Przemek", "123456789", "pc@mail.com", "Bytom", "przemek", "123"};
        jt.update(insert, insertParam);
        System.out.println("********** SQL EXECUTE **********");
    }
    
}
