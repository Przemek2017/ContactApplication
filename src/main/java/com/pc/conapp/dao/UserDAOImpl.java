package com.pc.conapp.dao;

import com.pc.conapp.pojo.User;
import com.sun.xml.internal.bind.api.JAXBRIContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Przemek
 */
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public void save(User user) {
        String insert = "INSERT INTO user (name, phone, email, address, login, password, role, login_status)"
                + " VALUES (:name, :phone, :email, :address, :login, :password, :role, :login_status)";
        Map insertMap = new HashMap();
        insertMap.put("name", user.getName());
        insertMap.put("phone", user.getPhone());
        insertMap.put("email", user.getEmail());
        insertMap.put("address", user.getAddress());
        insertMap.put("login", user.getLogin());
        insertMap.put("password", user.getPassword());
        insertMap.put("role", user.getRole());
        insertMap.put("login_status", user.getLoginStatus());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(insertMap);
        super.getNamedParameterJdbcTemplate().update(insert, sqlParameterSource, keyHolder);
        Integer getUserId = keyHolder.getKey().intValue();
        user.setUserId(getUserId);
    }

    @Override
    public void update(User user) {
        String update = "UPDATE user SET"
                + " name = :name,"
                + " phone = :phone,"
                + " email = :email,"
                + " address = :address,"
                + " role = :role,"
                + " login_status = :login_status"
                + " WHERE user_id = :user_id";
        Map insertMap = new HashMap();
        insertMap.put("name", user.getName());
        insertMap.put("phone", user.getPhone());
        insertMap.put("email", user.getEmail());
        insertMap.put("address", user.getAddress());
        insertMap.put("role", user.getRole());
        insertMap.put("login_status", user.getLoginStatus());
        insertMap.put("user_id", user.getUserId());
        super.getNamedParameterJdbcTemplate().update(update, insertMap);
    }

    @Override
    public void delete(User user) {
        this.delete(user.getUserId());
    }

    @Override
    public void delete(Integer userId) {
        String delete = "DELETE FROM user WHERE user_id = ?";
        super.getJdbcTemplate().update(delete, userId);
    }

    @Override
    public User findById(Integer userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> findByProperty(String propertyName, Object propertyValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
