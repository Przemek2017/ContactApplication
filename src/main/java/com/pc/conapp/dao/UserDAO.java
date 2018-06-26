
package com.pc.conapp.dao;

import com.pc.conapp.pojo.User;
import java.util.List;

/**
 *
 * @author Przemek
 */
public interface UserDAO {

    public void save(User user);

    public void update(User user);

    public void delete(User user);

    public void delete(Integer userId);

    public User findById(Integer userId);

    public List<User> findAll();

    public List<User> findByProperty(String propertyName, Object propertyValue);
}
