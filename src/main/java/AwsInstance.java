//import com.amazonaws.AmazonClientException;
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.services.ec2.AmazonEC2;
//import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
//import com.amazonaws.services.ec2.model.*;


import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.InstanceType;
import software.amazon.awssdk.services.ec2.model.RunInstancesRequest;
import software.amazon.awssdk.services.ec2.model.RunInstancesResponse;
import software.amazon.awssdk.services.ec2.model.Tag;
import software.amazon.awssdk.services.ec2.model.CreateTagsRequest;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;


public class AwsInstance {

    public static void main(String[] args) {


        Ec2Client ec2 = Ec2Client.create();

        RunInstancesRequest run_request = RunInstancesRequest.builder()
                .imageId("ami-009d6802948d06e52")
                .instanceType(InstanceType.T2_MICRO)
                .maxCount(1)
                .minCount(1)
                .build();

        RunInstancesResponse response = ec2.runInstances(run_request);

        String instance_id = response.instances().get(0).instanceId();

        Tag tag = Tag.builder()
                .key("Name")
                .value("test")
                .build();



        CreateTagsRequest tag_request = CreateTagsRequest.builder()
                .resources(instance_id)
                .tags(tag)
                .build();


        try {
            ec2.createTags(tag_request);

            System.out.printf(
                    "Successfully started EC2 instance %s based on AMI %s",
                    instance_id, "ami-009d6802948d06e52");

        }
        catch (Ec2Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }



    }
}
