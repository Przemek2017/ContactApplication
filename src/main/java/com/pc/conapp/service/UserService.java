package com.pc.conapp.service;

import com.pc.conapp.exception.UserBlockedException;
import com.pc.conapp.pojo.User;
import java.util.List;

/**
 * The interface specifies all business operation for User Entity
 * @author Przemek
 */
public interface UserService {

    public static final int LOGIN_STATUS_ACTIVE = 1;
    public static final int LOGIN_STATUS_BLOCKED = 2;

    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_USER = 2;
    
    public void register(User user);

    /**
     * Handles login operation (authentication) using given credentials, it
     * return user when correct and null when failed.
     *
     * @param login
     * @param password
     * @return
     * @throws com.pc.conapp.exception.UserBlockedException when user account is
     * blocked.
     */
    public User login(String login, String password) throws UserBlockedException;

    /**
     * This method show list of registered user.
     *
     * @return
     */
    public List<User> getUserList();

    /**
     * The method change login status for details passed as argument.
     *
     * @param userId
     * @param loginStatus
     * @return
     */
    public void changeLoginStatus(Integer userId, Integer loginStatus);
}
