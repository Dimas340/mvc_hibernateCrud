//package web.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import web.model.User;
//import web.service.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private Service service;
//
//    //@RequestParam -- извлекает значения из строки запроса
//    //@PathVariables извлекает значения из пути URI
//
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String getUsers(ModelMap model) {
//        List<User> users = service.getAllUser();
//        model.addAttribute("get", users);
//        return "get";
//    }
//
//    @RequestMapping(value = "/edit/*", method = RequestMethod.POST)
//    public String editPage(@RequestParam long id, @RequestParam String name, @RequestParam String password) {
//        User users = new User(id, name, password);
//        service.editUser(users);
//        return "redirect:/users";
//    }
//
//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public String editUser(@ModelAttribute("user") User user, ModelMap model) {
//        //@ModelAttribute мы получаем этот атрибут и можем его изменить
//        User user1 = service.getById(user.getId());
//        model.addAttribute("user", user1);
//        return "edit";
//    }
//
//    @RequestMapping(value = "/add/addUser", method = RequestMethod.GET)
//    public String addPage() {
//        return "add";
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addUser(@RequestParam String name, @RequestParam String password) {
//        User users = new User(name, password);
//        service.addUser(users);
//        return "redirect:/users";
//    }
//
//    @RequestMapping(value = "/delete/*", method = RequestMethod.GET)
//    public String deleteUser(@ModelAttribute("user") User user) {
//        User users = service.getById(user.getId());
//        if (users != null) {
//            service.deleteUser(users);
//        }
//        return "redirect:/users";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }
//
//    @PostConstruct
//    public void init() {
//        service.init();
//    }
//}