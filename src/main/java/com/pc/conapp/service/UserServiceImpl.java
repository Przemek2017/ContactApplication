package com.pc.conapp.service;

import com.pc.conapp.dao.BaseDAO;
import com.pc.conapp.dao.UserDAO;
import com.pc.conapp.exception.UserBlockedException;
import com.pc.conapp.pojo.User;
import com.pc.conapp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Przemek
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        userDAO.save(user);
    }

    @Override
    public User login(String login, String password) throws UserBlockedException {
        String select = "SELECT user_id, name, phone, email, address, login, role, login_status "
                + "FROM user WHERE login = :login AND password = :password";
        Map map = new HashMap();
        map.put("login", login);
        map.put("password", password);
        try {
            User user = super.getNamedParameterJdbcTemplate().queryForObject(select, map, new UserRowMapper());
            if (user.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
                throw new UserBlockedException("Your account has been blocked. Contact with your admin.");
            } else {
                return user;
            }
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        return userDAO.findAll();
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
