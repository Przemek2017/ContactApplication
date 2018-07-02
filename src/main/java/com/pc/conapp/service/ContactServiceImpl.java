package com.pc.conapp.service;

import com.pc.conapp.dao.BaseDAO;
import com.pc.conapp.pojo.Contact;
import com.pc.conapp.dao.ContactDAO;
import com.pc.conapp.rm.ContactRowMapper;
import com.pc.conapp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Przemek
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    @Override
    public void update(Contact contact) {
        contactDAO.update(contact);
    }

    @Override
    public void delete(Integer contactId) {
        contactDAO.delete(contactId);
    }

    @Override
    public void delete(Integer[] contactIds) {
        String ids = StringUtil.toSeperatedStringByComma(contactIds);
        String delete = "DELETE FROM contact WHERE contact_id IN (" + ids + ")";
        super.getJdbcTemplate().update(delete);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("user_id", userId);
    }

    @Override
    public List<Contact> findUserContact(Integer userId, String text) {
        String select = "SELECT contact_id, user_id, name, phone, email, address, remark "
                + "FROM contact WHERE user_id = ? "
                + "AND (name LIKE '%" + text + "%' "
                + "OR phone LIKE '%" + text + "%' "
                + "OR email LIKE '%" + text + "%' "
                + "OR address LIKE '%" + text + "%' "
                + "OR remark LIKE '%" + text + "%')";
        return super.getJdbcTemplate().query(select, new ContactRowMapper(), userId);
    }

}
