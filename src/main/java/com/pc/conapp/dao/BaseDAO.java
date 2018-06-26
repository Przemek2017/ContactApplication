package com.pc.conapp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author Przemek
 */
public class BaseDAO extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void dataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
