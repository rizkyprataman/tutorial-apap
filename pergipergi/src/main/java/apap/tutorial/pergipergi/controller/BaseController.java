package apap.tutorial.pergipergi.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class BaseController {
    
    @GetMapping("/")
    private String home(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "home";}
}
