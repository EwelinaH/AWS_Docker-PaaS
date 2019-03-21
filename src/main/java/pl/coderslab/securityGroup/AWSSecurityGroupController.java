package pl.coderslab.securityGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AWSSecurityGroupController {

    @Autowired
    private SecurityGroup securityGroup;

    @GetMapping("/createSG")
    public String createSG(){

        return "securityGroup";
    }


    @PostMapping("/createSG")
    public String createSG(@RequestParam("group_name") String sgName, @RequestParam("group_desc") String sgDescription){
//        System.out.println("poszedl POST");
        securityGroup.create(sgName, sgDescription);
        return "home";
    }

}
