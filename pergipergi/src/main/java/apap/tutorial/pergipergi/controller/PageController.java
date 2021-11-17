package apap.tutorial.pergipergi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import apap.tutorial.pergipergi.model.UserModel;
import apap.tutorial.pergipergi.service.UserService;

@Controller
public class PageController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        String username = user.getUsername();
        String role = userService.findByUsername(username).getRole().getRole();
        model.addAttribute("role", role);
        return "home";
        }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
