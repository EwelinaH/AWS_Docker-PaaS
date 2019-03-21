package pl.coderslab.user;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserRepository userRepository;

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/list")
    public String listAll() {
        return "userList";
    }






//    @GetMapping("/list")
//    public String getList(Model model){
//        List<User> users = userService.findAll();
//        model.addAttribute("users", users);
//        return "userList";
//    }
//
//    @GetMapping("/add")
//    public String addUser(Model model){
//        model.addAttribute("user", new User());
//        return "user";
//    }
//
//
//    @PostMapping("/add")
//    public String addUser(@ModelAttribute User user){
//
//        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
//        userService.save(user);
//
//        return "redirect:/user/list";
//    }




}
