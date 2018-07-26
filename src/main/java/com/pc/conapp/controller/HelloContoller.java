/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pc.conapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Przemek
 */
@Controller
public class HelloContoller {

    @RequestMapping("/test/hello")
    public ModelAndView seyHello(ModelAndView mav) {
        mav.setViewName("hello");
        mav.addObject("message", "Hello Przemek!!!!!");
        return mav;
    }
}
