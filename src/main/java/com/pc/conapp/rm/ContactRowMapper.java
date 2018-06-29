package com.pc.conapp.rm;

import com.pc.conapp.pojo.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Przemek
 */
public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setContactId(rs.getInt("contact_id"));
        contact.setUserId(rs.getInt("user_id"));
        contact.setName(rs.getString("name"));
        contact.setPhone(rs.getString("phone"));
        contact.setEmail(rs.getString("email"));
        contact.setAddress(rs.getString("address"));
        contact.setRemark(rs.getString("remark"));
        return contact;
    }

}
