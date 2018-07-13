package com.pc.conapp.controller;

import com.pc.conapp.command.LoginCommand;
import com.pc.conapp.command.UserCommand;
import com.pc.conapp.exception.UserBlockedException;
import com.pc.conapp.pojo.User;
import com.pc.conapp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Przemek
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("command", new LoginCommand());
        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginHandler(@ModelAttribute("command") LoginCommand loginCommand, Model model, HttpSession httpSession) {
        try {
            User loggedUser = userService.login(loginCommand.getLogin(), loginCommand.getPassword());
            if (loggedUser == null) {
                model.addAttribute("err", "Login faild! Enter valid data");
                return "index";
            } else {
                // check the user role and redirect to appropriate dashboard
                if (loggedUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    addUserSession(loggedUser, httpSession);
                    return "redirect:admin/dashboard";
                } else if (loggedUser.getRole().equals(UserService.ROLE_USER)) {
                    addUserSession(loggedUser, httpSession);
                    return "redirect:user/dashboard";
                } else {
                    model.addAttribute("err", "Invalid user role!");
                    return "index";
                }
            }
        } catch (UserBlockedException ex) {
            model.addAttribute("err", ex.getMessage());
            return "index";
        }
    }

    @RequestMapping(value = {"/user/dashboard"})
    public String userDashboard() {
        return "dashboard_user";
    }

    @RequestMapping(value = {"/admin/dashboard"})
    public String adminDashboard() {
        return "dashboard_admin";
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:index?act=lo";
    }
    
    @RequestMapping(value ="/register_form")
    public String registrationForm(Model model){
        UserCommand userCommand = new UserCommand();
        model.addAttribute("command", userCommand);
        return "register_form";
    }
    
    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand userCommand, Model model){
        try {
            User regUser = userCommand.getUser();
            regUser.setRole(UserService.ROLE_USER);
            regUser.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userService.register(regUser);
            return "redirect:index?act=reg";
        } catch (DuplicateKeyException dke) {
            dke.getMessage();
            model.addAttribute("err", "Login '" + userCommand.getUser().getLogin() + "' is alredy registered. Please select another login.");
            return "register_form";
        }
    }
    
    private void addUserSession(User user, HttpSession httpSession){
        httpSession.setAttribute("user", user);
        httpSession.setAttribute("userId", user.getUserId());
        httpSession.setAttribute("userRole", user.getRole());
        httpSession.setAttribute("userName", user.getName());
    }
}
