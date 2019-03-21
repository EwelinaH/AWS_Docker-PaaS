package pl.coderslab.instance;

import jdk.nashorn.internal.objects.annotations.Getter;
import software.amazon.awssdk.services.ec2.model.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instance")
public class AWSInstanceController {

    @Autowired
    private AwsInstance awsInstance;

    @Autowired
    private DescribeInstance describeInstance;


    @GetMapping("/create")
    public String createAwsInstance(){
        return "awsInstance";
    }


    @PostMapping("/create")
    public String createAwsInstance(@RequestParam("name") String ec2Name, @RequestParam("owner") String ec2Owner,
                                    @RequestParam("keyName") String keyName, Model model){
//        System.out.println("poszedl POST");
        Instance createdInstance = awsInstance.create(ec2Name, ec2Owner, keyName);
        System.out.println(createdInstance);

//        String instance_id = awsInstance.create(ec2Name, keyName);
        model.addAttribute("instance_id", createdInstance.instanceId());

//        String instance_keyName = awsInstance.create(ec2Name, keyName);
        model.addAttribute("instance_keyName", createdInstance.keyName());
//
//        String instance_launchTime = awsInstance.create(ec2Name, keyName);
        model.addAttribute("instance_launchTime", createdInstance.launchTime());
//
//        String instance_privIP = awsInstance.create(ec2Name, keyName);
        model.addAttribute("instance_privIP", createdInstance.privateIpAddress());
//
//        String instance_type = awsInstance.create(ec2Name, keyName);
        model.addAttribute("instance_type", createdInstance.instanceType());

        return "crInst";
    }

    @GetMapping("/describe")
    public String findById(){
        System.out.println("get describe");
        return "instanceInfoById";

    }

    @PostMapping("/describe")
    public String find(@RequestParam("instanceId") String instanceId){
        System.out.println("post1 describe");

        return "redirect:/instance/describe/" + instanceId ;
    }


    @GetMapping("/describe/{instanceId}")
    public String describeInstance(@PathVariable("instanceId") String instanceId, Model model){
        System.out.println("get2 describe with ID");


        Instance instanceDescription = describeInstance.describe(instanceId);
        System.out.println(instanceDescription);

        model.addAttribute("instanceId", instanceId);
        model.addAttribute("imageId", instanceDescription.imageId());
        model.addAttribute("instanceType", instanceDescription.instanceType());
        model.addAttribute("keyName", instanceDescription.keyName());
        model.addAttribute("launchTime", instanceDescription.launchTime());
        model.addAttribute("privateIpAddress", instanceDescription.privateIpAddress());
        model.addAttribute("publicIpAddress", instanceDescription.publicIpAddress());
        model.addAttribute("securityGroupName", instanceDescription.securityGroups().get(0).groupName());
        model.addAttribute("state", instanceDescription.state().name());

        return "instanceDescription";
    }

}
