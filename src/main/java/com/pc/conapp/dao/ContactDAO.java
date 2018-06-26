
package com.pc.conapp.dao;

import com.pc.conapp.pojo.Contact;
import java.util.List;

/**
 *
 * @author Przemek
 */
public interface ContactDAO {

    public void save(Contact contact);

    public void update(Contact contact);

    public void delete(Contact contact);

    public void delete(Integer contactId);

    public Contact findById(Integer contactId);

    public List<Contact> findAll();

    public List<Contact> findByProperty(String propertyName, Object propertyValue);
}
