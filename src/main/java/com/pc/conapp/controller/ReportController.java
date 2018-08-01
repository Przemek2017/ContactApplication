package com.pc.conapp.controller;

import com.pc.conapp.pojo.Contact;
import com.pc.conapp.report.ExcelReportView;
import com.pc.conapp.report.PdfReportView;
import com.pc.conapp.service.ContactService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Przemek
 */
@Controller
@RequestMapping(value = "/user/export")
public class ReportController {

    @Autowired
    ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getReportView(HttpSession httpSession, HttpServletRequest request) {
        Integer userId = (Integer) httpSession.getAttribute("userId");
        String typeReport = request.getParameter("type");
        List<Contact> contactList = contactService.findUserContact(userId);

        if (typeReport != null && typeReport.equals("excel")) {
            return new ModelAndView(new ExcelReportView(), "contactList", contactList);
        } else if (typeReport != null && typeReport.equals("pdf")) {
            return new ModelAndView(new PdfReportView(), "contactList", contactList);
        }
        return new ModelAndView("getReportView", "contactList", contactList);
    }
}
