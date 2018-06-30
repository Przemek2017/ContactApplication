package com.pc.conapp.dao;

import com.pc.conapp.pojo.User;
import com.pc.conapp.rm.UserRowMapper;
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
        Map updatetMap = new HashMap();
        updatetMap.put("name", user.getName());
        updatetMap.put("phone", user.getPhone());
        updatetMap.put("email", user.getEmail());
        updatetMap.put("address", user.getAddress());
        updatetMap.put("role", user.getRole());
        updatetMap.put("login_status", user.getLoginStatus());
        updatetMap.put("user_id", user.getUserId());
        super.getNamedParameterJdbcTemplate().update(update, updatetMap);
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
        String select = "SELECT user_id, name, phone, email, address, login, role, login_status "
                + "FROM user WHERE user_id = ?";
        return super.getJdbcTemplate().queryForObject(select, new UserRowMapper(), userId);
    }

    @Override
    public List<User> findAll() {
        String select = "SELECT user_id, name, phone, email, address, login, role, login_status FROM user";
        return super.getJdbcTemplate().query(select, new UserRowMapper());
    }

    @Override
    public List<User> findByProperty(String propertyName, Object propertyValue) {
        String select = "SELECT user_id, name, phone, email, address, login, role, login_status "
                + "FROM user WHERE " + propertyName + " = ?";
        return super.getJdbcTemplate().query(select, new UserRowMapper(), propertyValue);
    }

}
