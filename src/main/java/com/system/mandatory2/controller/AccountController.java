package com.system.mandatory2.controller;

import com.system.mandatory2.repositories.CourseRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gerli on 28/11/2017.
 */
@Controller
public class AccountController {
    @Autowired
    CourseRequestRepo courseRequestRepo;

    @GetMapping("/admin")
    public ModelAndView studentPage() {
        ModelAndView mv = new ModelAndView("admin");
        mv.getModel().put("courseRequestList", courseRequestRepo.findAll());
        return mv;
    }
}



/*
    Role role = roleRepo.findByRoleName(roleName);
        if (role == null) {
        role = new Role();
        role.setRoleName(roleName);
        roleRepo.save(role);
    } else if (roleRepo.findByRoleName(roleName).equals(role)){

    }*/

