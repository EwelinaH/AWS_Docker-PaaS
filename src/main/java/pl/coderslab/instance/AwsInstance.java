package pl.coderslab.instance;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.Instance;
import software.amazon.awssdk.services.ec2.model.InstanceType;
import software.amazon.awssdk.services.ec2.model.RunInstancesRequest;
import software.amazon.awssdk.services.ec2.model.RunInstancesResponse;
import software.amazon.awssdk.services.ec2.model.Tag;
import software.amazon.awssdk.services.ec2.model.CreateTagsRequest;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;

@Service
public class AwsInstance {

    public Instance create(String name, String owner, String keyName) {

        Ec2Client ec2 = Ec2Client.create();

        RunInstancesRequest run_request = RunInstancesRequest.builder()
                .imageId("ami-0285e7f130eb94cf9")
                .instanceType(InstanceType.T2_MICRO)
                .maxCount(1)
                .minCount(1)
                .keyName(keyName)
                .securityGroups("ewe-lab-sg")
                .build();

        RunInstancesResponse response = ec2.runInstances(run_request);

        Instance createdInstance = response.instances().get(0);
        System.out.println(createdInstance);

        String instance_id = createdInstance.instanceId();
        System.out.println(instance_id);

        String instance_type = createdInstance.instanceType().toString();
        System.out.println(instance_type);

        String instance_keyName = createdInstance.keyName();
        System.out.println(instance_keyName);

        String instance_launchTime = createdInstance.launchTime().toString();
        System.out.println(instance_launchTime);

        String instance_privIP = createdInstance.privateIpAddress();
        System.out.println(instance_privIP);



        Tag tagName = Tag.builder()
                .key("Name")
                .value(name)
                .build();

        CreateTagsRequest tag_requestName = CreateTagsRequest.builder()
                .resources(instance_id)
                .tags(tagName)
                .build();

        Tag tagOwner = Tag.builder()
                .key("Owner")
                .value(owner)
                .build();

        CreateTagsRequest tag_requestOwner = CreateTagsRequest.builder()
                .resources(instance_id)
                .tags(tagOwner)
                .build();

        try {
            ec2.createTags(tag_requestName);
            ec2.createTags(tag_requestOwner);

            System.out.printf(
                    "Successfully started EC2 instance %s based on AMI %s",
                    instance_id, "ami-009d6802948d06e52");

        }
        catch (Ec2Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return createdInstance;
    }
}
