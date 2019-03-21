package pl.coderslab.s3bucket;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PutObjectApi2 {

    public PutObjectResponse uploadFile(String bucket, String key, String file_path) {

        Region region = Region.US_EAST_1;
        S3Client s3 = S3Client.builder().region(region).build();

        System.out.println("------------ To jest API class");
        Path path = Paths.get(file_path);
        System.out.println(path);
//        Path absolutePath = path.toAbsolutePath();
        String absolutePath = path.toAbsolutePath().toString().replace("apache-tomcat-9.0.12/bin/", "");
        Path abosultePathFixed = Paths.get(absolutePath);
//        absolutePath.toString().replace().

        System.out.println(System.getProperty("catalina.home"));



        // Put Object
        PutObjectResponse myFile = s3.putObject(PutObjectRequest.builder().bucket(bucket).key(key)
                        .build(),
                RequestBody.fromFile(abosultePathFixed));

//        s3.putObject(PutObjectRequest.builder().bucket(bucket).key(key)
//                        .build(),
//                RequestBody.fromFile(absulutePath));


        return myFile;
    }

}
