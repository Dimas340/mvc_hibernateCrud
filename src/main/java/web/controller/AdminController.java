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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
//@RequestMapping("/") из за этого были ошибки в add
//@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private Service service;

    @GetMapping("/admin")
    public String getUsers(ModelMap model) {
        List<User> users = service.getAllUser();
        model.addAttribute("get", users);
        return "get";
    }

    @PostMapping("/admin/edit/*")
    public String editPage(@RequestParam String name, @RequestParam String password, @RequestParam String role) {
        User users = new User(name, password);
        Role roles = new Role(role);
        Set<Role> set = new HashSet<>();
        set.add(roles);
        users.setRoles(set);
        service.editUser(users);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit")
    public String editUser(@ModelAttribute("user") User user, ModelMap model) {
        //@ModelAttribute мы получаем этот атрибут и можем его изменить
        User user1 = service.getById(user.getId());
        model.addAttribute("user", user1);
        return "edit";
    }

    @GetMapping(value = "/admin/add/addUser")
    public String addPage() {
        return "add";
    }

    @PostMapping("/admin/add")
    public String addUser(@RequestParam String name, @RequestParam String password, @RequestParam String role) {
        User users = new User(name, password);
        Role roles = new Role(role);
        Set<Role> set = new HashSet<>();
        set.add(roles);
        users.setRoles(set);
        service.addUser(users);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete/*")
    public String deleteUser(@ModelAttribute("user") User user) {
        User users = service.getById(user.getId());
        if (users != null) {
            service.deleteUser(users);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/login")
    public String loginPage() {
        return "registration";
    }

    @PostConstruct
    public void init() {
        service.init();
    }
}
