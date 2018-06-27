package com.pc.conapp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Przemek
 */
@Configuration
@ComponentScan(basePackages = {"com.pc.conapp.dao"})
public class SpringRootConfig {
// todo service, dao, dataSoruce, bussiness etc

    @Bean
    public BasicDataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/capp_db?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("toor");
        dataSource.setMaxTotal(2);
        dataSource.setInitialSize(1);
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setDefaultAutoCommit(true);
        return dataSource;
    }
}
