package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
//@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private Service service;

    private JFrame jFrame;

    @GetMapping("/admin")
    public String getUsers(ModelMap model) {
        List<User> users = service.getAllUser();
        model.addAttribute("get", users);
        return "get";
    }

    @PostMapping("/admin/edit/*")
    public String editPage(@ModelAttribute("user") User user, @RequestParam String role) {
        service.editUser(user, role);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit")
    public String editUser(@ModelAttribute("user") User user, ModelMap model) {
        User user1 = service.getById(user.getId());
        model.addAttribute("user", user1);
        return "edit";
    }

    @GetMapping(value = "/admin/add")
    public String addPage() {
        return "add";
    }

    @PostMapping("/admin/add")
    public String addUser(@ModelAttribute("user") User user, @RequestParam String role) {//пару строк убрал
//        User users = new User(name, password);
        service.addUser(user, role);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete/*")
    public String deleteUser(@ModelAttribute("user") User user) {// id
        User users = service.getById(user.getId());
        if (users != null) {
            service.deleteUser(users);
        }
        return "redirect:/admin";
    }

    @PostConstruct
    public void init() {
        service.init();
    }
}
