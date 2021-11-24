package apap.tutorial.pergipergi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import apap.tutorial.pergipergi.model.RoleModel;
import apap.tutorial.pergipergi.model.UserModel;
import apap.tutorial.pergipergi.service.RoleService;
import apap.tutorial.pergipergi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    public String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value="/add")
    public String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }
    
    @GetMapping(value="/view-all")
    public String viewAllUser(Model model){
        List<UserModel> listUserModel = userService.findAllUser();
        model.addAttribute("listUserModel", listUserModel);
        return "viewall-user";
        
    }
    @GetMapping("/delete/{username}")
    public String deleteUser(
        @PathVariable(value ="username") String username,
        Model model
    ){
        UserModel user =  userService.findByUsername(username);
        if(user != null){
            userService.deleteUser(user);
            return "delete-user";
        }
        return "notexist-user";
    }

    @GetMapping("/update-password")
    public String formUpdatePassword(){
        return "form-update-password";
    }

    @PostMapping("/update-password")
    public String updatePassword(@ModelAttribute UserModel userModel, String newPassword, String new2Password, Model model){
        UserModel user = userService.findByUsername(userModel.getUsername());
        if (userService.passwordMatch(userModel.getPassword(), user.getPassword() )){
            if (newPassword.equals(new2Password)){
                userService.setPassword(user, newPassword);
                userService.addUser(user);
                model.addAttribute("message", "password berhasil diubah");
            }else {
                model.addAttribute("message", "password baru tidak sama");
            }
        }else {
            model.addAttribute("message", "password lama salah");
        }
        return "form-update-password";
    }
}
