package pl.coderslab.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {

        return "userLogin";
    }

    @PostMapping
    public String login(@RequestParam String userName, @RequestParam String password, Model model, HttpSession session) {
        User user = userRepository.findByUserName(userName);

        boolean isLogged = user != null && BCrypt.checkpw(password, user.getPassword());
        if (!isLogged) {
            model.addAttribute("loginFailed", true);
            return "userLogin";
        }

//        user.setLastLogin(LocalDate.now());
        userRepository.save(user);
        session.setAttribute("login", true);
        session.setAttribute("loggedInUser", user);
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userAdd";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "userAdd";
        }
//        user.setLastLogin(LocalDate.now());
        userService.save(user);
        session.setAttribute("login", true);
        session.setAttribute("loggedInUser", user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}