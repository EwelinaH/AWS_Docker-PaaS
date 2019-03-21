package pl.coderslab.sshKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ssh")
public class SSHKeyController {

    @Autowired
    private SSHKey sshKey;

    @GetMapping("/create")
    public String createSSHKey(){
//        System.out.println("jestsem na create SSH KEy");
        return "ssh";
    }


    @PostMapping("/create")
    public String createSSHKey(@RequestParam("key_name") String key_name, Model model){
//        System.out.println("poszedl POST");
        String privateKey = sshKey.create(key_name);
        model.addAttribute("privateKey", privateKey);

        System.out.println(privateKey);
        return "privateKey";
    }
}
