package pl.coderslab.s3bucket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.jenkinsJobBuild.JobBuild;

import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class PutObjectController {

    @Autowired
    private PutObjectApi2 putObjectApi2;

    @Autowired
    private JobBuild jobBuild;

    @GetMapping("/upload")
    public String uploadFile(){
//        System.out.println("to jest GET upload");
        return "uploadFile";
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("bucket") String bucket, @RequestParam("key") String key,
                             @RequestParam("file_path") String file_path){

//        System.out.println("poszlo ");

        Path filePath = Paths.get(file_path);
//        System.out.println("----------- To jest servlet");
        System.out.println(file_path);
        System.out.println(filePath.toAbsolutePath());


        Object uploadObj = putObjectApi2.uploadFile(bucket, key, file_path);
        System.out.println(uploadObj);

//        model.addAttribute("bucket", bucket);
//        model.addAttribute("key", name);
//        model.addAttribute("file_path", file_path);

        return "home";

    }

        @GetMapping("/deploy")
        public String deployApp(){
//            System.out.println("to jest GET deploy");
            return "deploy";
        }

        @PostMapping("/deploy")
        public String deployApp(@RequestParam("serverIP") String serverIP,
                                 @RequestParam("warName") String warName){

//            System.out.println("poszlo ");

            Path filePath = Paths.get(warName);
//            System.out.println("----------- To jest servlet");
//            System.out.println(warName);
            System.out.println(filePath.toAbsolutePath());

            String bucket = "aws-paas-bucket";

            Object uploadObj = putObjectApi2.uploadFile(bucket, warName, warName);
            System.out.println(uploadObj);

            jobBuild.deployApp(serverIP, warName);
//            System.out.println("job sie odpalil");

            return "home";
        }
}