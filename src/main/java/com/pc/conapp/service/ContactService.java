package com.pc.conapp.service;

import com.pc.conapp.pojo.Contact;
import java.util.List;

/**
 * The interface specifies all business operation for Contact Entity
 * @author Przemek
 */
public interface ContactService {
    public void save(Contact contact);
    public void update(Contact contact);
    public void delete(Integer contactId);
    public void delete(Integer[] contactIds);
    /**
     * Method returns all user contacts.
     * @param userId
     * @return 
     */
    public List<Contact> findUserContact(Integer userId);
    /**
     * Method serach contact for user(userId) based on given free-text-criteria(text). 
     * @param userId - User who is logged in
     * @param text - criteria used for search - free text search criteria.
     * @return 
     */
    public List<Contact> findUserContact(Integer userId, String text);
}
