package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.Service;

@Controller
@RequestMapping("/")
//@PreAuthorize("hasAuthority('USER')")
public class UserController {

    @Autowired
    private Service service;

    @GetMapping("/user")
    public String getUser(ModelMap model, @RequestParam long id) {
        User user = service.getById(id);
        model.addAttribute("get", user);
        return "user";
    }
}

