package com.pc.conapp.rm;

import com.pc.conapp.pojo.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Przemek
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setPhone(rs.getString("phone"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setLogin(rs.getString("login"));
        user.setRole(rs.getInt("role"));
        user.setLoginStatus(rs.getInt("login_status"));
        return user;
    }

}
