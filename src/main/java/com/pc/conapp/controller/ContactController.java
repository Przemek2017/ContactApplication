package com.pc.conapp.controller;

import com.pc.conapp.pojo.Contact;
import com.pc.conapp.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Przemek
 */
@Controller
public class ContactController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("command", contact);
        return "contact_form";
    }

    @RequestMapping(value = "/user/edit_contact")
    public String prepareEditForm(Model model, HttpSession httpSession, @RequestParam("cid") Integer contactId) {
        httpSession.setAttribute("aContactId", contactId);
        Contact c = contactService.findById(contactId);
        model.addAttribute("command", c);
        return "contact_form";
    }

    @RequestMapping(value = "/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact contact, Model model, HttpSession httpSession) {
        Integer contactId = (Integer) httpSession.getAttribute("aContactId");
        if (contactId == null) {
            try {
                Integer userId = (Integer) httpSession.getAttribute("userId");
                contact.setUserId(userId);
                contactService.save(contact);
                return "redirect:contact_list?act=sv";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("err", "Failed to save contact");
                return "contact_form";
            }
        } else {
            try {
                contact.setContactId(contactId);
                contactService.update(contact);
                return "redirect:contact_list?act=edt";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("err", "Failed to update contact");
                return "contact_form";
            }
        }
    }

    @RequestMapping(value = "/user/contact_list")
    public String contactList(Model model, HttpSession httpSession) {
        Integer userId = (Integer) httpSession.getAttribute("userId");
        model.addAttribute("contactList", contactService.findUserContact(userId));
        return "contact_list";
    }

    @RequestMapping(value = "/user/search_contact")
    public String contactSearch(Model model, HttpSession httpSession, @RequestParam("searchText") String searchText) {
        Integer userId = (Integer) httpSession.getAttribute("userId");
        model.addAttribute("contactList", contactService.findUserContact(userId, searchText));
        return "contact_list";
    }

    @RequestMapping(value = "/user/delete_contact")
    public String deleteContact(@RequestParam("cid") Integer contactId) {
        contactService.delete(contactId);
        return "redirect:contact_list?act=del";
    }

}
