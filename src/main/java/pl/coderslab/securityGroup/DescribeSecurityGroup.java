package pl.coderslab.securityGroup;


import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;
import software.amazon.awssdk.services.ec2.model.SecurityGroup;

import java.util.List;

public class DescribeSecurityGroup {

    public static void main(String[] args) {

//        final String USAGE =
//                "To run this example, supply a group id\n" +
//                        "Ex: DescribeSecurityGroups <group-id>\n";
//
//        if (args.length != 1) {
//            System.out.println(USAGE);
//            System.exit(1);
//        }
//
//        String group_id = args[0];
//
//        Ec2Client ec2 = Ec2Client.create();
//
//        DescribeSecurityGroupsRequest request =
//                new DescribeSecurityGroupsRequest()
//                        .withGroupIds(group_id);
//
//        DescribeSecurityGroupsResult response =
//                ec2.describeSecurityGroups(request);
//
//        for(SecurityGroup group : response.getSecurityGroups()) {
//            System.out.printf(
//                    "Found security group with id %s, " +
//                            "vpc id %s " +
//                            "and description %s",
//                    group.getGroupId(),
//                    group.getVpcId(),
//                    group.getDescription());
//
//        }
    }
}

