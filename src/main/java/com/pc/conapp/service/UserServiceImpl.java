package com.pc.conapp.service;

import com.pc.conapp.dao.BaseDAO;
import com.pc.conapp.dao.UserDAO;
import com.pc.conapp.exception.UserBlockedException;
import com.pc.conapp.pojo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
