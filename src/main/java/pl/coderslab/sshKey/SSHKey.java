package pl.coderslab.sshKey;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.CreateKeyPairRequest;
import software.amazon.awssdk.services.ec2.model.CreateKeyPairResponse;


@Service
public class SSHKey {

    public String create(String key_name) {

        Ec2Client ec2 = Ec2Client.create();

        CreateKeyPairRequest request = CreateKeyPairRequest.builder()
                .keyName(key_name).build();

        CreateKeyPairResponse response = ec2.createKeyPair(request);

        String privateKey = response.keyMaterial();
        System.out.println(privateKey);


        System.out.printf(
                "Successfulyl created key pair named %s\n",
                key_name);
        privateKey = privateKey.replaceAll("(\r\n|\n)", "<br />");

        return privateKey;
    }

}

