package com.springapp.mvc.controller;

import com.springapp.mvc.model.Resources;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.ResourcesService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Maxim.Temborskiy on 19.11.2016.
 */

@Controller
public class UserController {

    @RequestMapping(value = {"index","/"},  method = RequestMethod.GET)
    public String index (Model model){
        return "index";
    }


    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping (value = "users", method = RequestMethod.GET)
    public String listUsers (Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping (value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if (user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }
        return  "redirect:/users";
    }

    @RequestMapping ("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        return "userdata";
    }






    private ResourcesService resourcesService;

    @Autowired(required = true)
    @Qualifier(value = "resourcesService")
    public void setResourcesService(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @RequestMapping(value = "resources", method = RequestMethod.GET)
    public String listResources(Model model){
        model.addAttribute("resources", new Resources());
        model.addAttribute("listResources", this.resourcesService.listResources());

        return "resources";
    }

    @RequestMapping(value = "limitedresources", method = RequestMethod.GET)
    public String listLimitedResources(Model model){
        model.addAttribute("resources", new Resources());
        model.addAttribute("listLimitedResources", this.resourcesService.listLimitedResources());

        return "limitedresources";
    }


    @RequestMapping(value = "/resources/add", method = RequestMethod.POST)
    public String addResources(@ModelAttribute("resources") Resources resources) throws InterruptedException {

        while (true) {
        this.resourcesService.addResources(resources);
        Thread.sleep(600000);
        }
    }



}





































