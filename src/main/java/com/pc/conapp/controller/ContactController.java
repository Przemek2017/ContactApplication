package com.pc.conapp.controller;

import com.pc.conapp.pojo.Contact;
import com.pc.conapp.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/user/save_contact")
    public String addContact(@ModelAttribute("command") Contact contact, Model model, HttpSession httpSession) {
        try {
            Integer userId = (Integer) httpSession.getAttribute("userId");
            contact.setUserId(userId);
            contactService.save(contact);
            return "redirect:contact_list?act=sv";
        } catch (Exception e) {
            model.addAttribute("err", "Failed to save contact");
            return "contact_form";
        }
    }

    @RequestMapping(value = "/user/contact_list")
    public String contactList() {
        return "contact_list";
    }
}
