package pl.coderslab.securityGroup;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;
import software.amazon.awssdk.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import software.amazon.awssdk.services.ec2.model.AuthorizeSecurityGroupIngressResponse;
import software.amazon.awssdk.services.ec2.model.IpPermission;
import software.amazon.awssdk.services.ec2.model.IpRange;

@Service
public class SecurityGroup {

    public String create(String group_name, String group_desc) {

        Ec2Client ec2 = Ec2Client.create();

        CreateSecurityGroupRequest create_request = CreateSecurityGroupRequest.builder()
                .groupName(group_name)
                .description(group_desc)
                .vpcId("vpc-083a8d72")
                .build();

        CreateSecurityGroupResponse create_response =
                ec2.createSecurityGroup(create_request);

        System.out.println(create_response);

        System.out.printf(
                "Successfully created security group named %s",
                group_name);

        IpRange ip_range = IpRange.builder()
                .cidrIp("0.0.0.0/0").build();

        IpPermission ip_perm = IpPermission.builder()
                .ipProtocol("tcp")
                .toPort(80)
                .fromPort(80)
                .ipRanges(ip_range)
                .build();

        IpPermission ip_perm2 = IpPermission.builder()
                .ipProtocol("tcp")
                .toPort(22)
                .fromPort(22)
                .ipRanges(ip_range)
                .build();

        AuthorizeSecurityGroupIngressRequest auth_request =
                AuthorizeSecurityGroupIngressRequest.builder()
                        .groupName(group_name)
                        .ipPermissions(ip_perm, ip_perm2)
                        .build();

        AuthorizeSecurityGroupIngressResponse auth_response =
                ec2.authorizeSecurityGroupIngress(auth_request);

        System.out.println(auth_response);

        System.out.printf(
                "Successfully added ingress policy to security group %s",
                group_name);

        return group_name + " " + group_desc;
    }


}
