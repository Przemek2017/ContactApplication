package com.pc.conapp.dao;

import com.pc.conapp.pojo.Contact;
import com.pc.conapp.rm.ContactRowMapper;
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
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

    @Override
    public void save(Contact contact) {
        String insert = "INSERT INTO contact (user_id, name, phone, email, address, remark)"
                + "  VALUES (:user_id, :name, :phone, :email, :address, :remark)";
        Map insertMap = new HashMap();
        insertMap.put("user_id", contact.getUserId());
        insertMap.put("name", contact.getName());
        insertMap.put("phone", contact.getPhone());
        insertMap.put("email", contact.getEmail());
        insertMap.put("address", contact.getAddress());
        insertMap.put("remark", contact.getRemark());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(insertMap);
        super.getNamedParameterJdbcTemplate().update(insert, sqlParameterSource, keyHolder);
        Integer getContactId = keyHolder.getKey().intValue();
        contact.setContactId(getContactId);
    }

    @Override
    public void update(Contact contact) {
        String update = "UPDATE contact SET"
                //+ " user_id = :user_id, "
                + " name = :name, "
                + " phone = :phone, "
                + " email = :email, "
                + " address = :address, "
                + " remark = :remark"
                + " WHERE contact_id = :contact_id";
        Map updateMap = new HashMap();
        updateMap.put("contact_id", contact.getContactId());
        //updateMap.put("user_id", contact.getUserId());
        updateMap.put("name", contact.getName());
        updateMap.put("phone", contact.getPhone());
        updateMap.put("email", contact.getEmail());
        updateMap.put("address", contact.getAddress());
        updateMap.put("remark", contact.getRemark());
        super.getNamedParameterJdbcTemplate().update(update, updateMap);
    }

    @Override
    public void delete(Contact contact) {
        this.delete(contact.getContactId());
    }

    @Override
    public void delete(Integer contactId) {
        String delete = "DELETE FROM contact WHERE contact_id = ?";
        super.getJdbcTemplate().update(delete, contactId);
    }

    @Override
    public Contact findById(Integer contactId) {
        String select = "SELECT contact_id, user_id, name, phone, email, address, remark "
                + "FROM contact WHERE contact_id = ?";
        return super.getJdbcTemplate().queryForObject(select, new ContactRowMapper(), contactId);
    }

    @Override
    public List<Contact> findAll() {
        String select = "SELECT contact_id, user_id, name, phone, email, address, remark FROM contact";
        return super.getJdbcTemplate().query(select, new ContactRowMapper());
    }

    @Override
    public List<Contact> findByProperty(String propertyName, Object propertyValue) {
        String select = "SELECT contact_id, user_id, name, phone, email, address, remark "
                + "FROM contact WHERE " + propertyName + " = ?";
        return super.getJdbcTemplate().query(select, new ContactRowMapper(), propertyValue);
    }

}
