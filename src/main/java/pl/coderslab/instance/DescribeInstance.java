package pl.coderslab.instance;


import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

import java.util.List;


@Service
public class DescribeInstance {

    public  Instance describe(String instanceId)
    {
        Ec2Client ec2 = Ec2Client.create();
        boolean done = false;


        System.out.println("\n\n\n Tu mamy opis instajic\n");
        System.out.println(ec2.describeInstances().reservations().get(0));
        System.out.println("-------------------------------------------------------------");
        System.out.println("\n\n\n Wszystkie rezerwacje\n");
        System.out.println(ec2.describeInstances().reservations());
        System.out.println("-------------------------------------------------------------");

        List<Reservation> reservations =  ec2.describeInstances().reservations();

        for (int i = 0; i < reservations.size(); i++){
            System.out.println("\n to instancja numer " + i);
            String instanceID = reservations.get(i).instances().get(0).instanceId();

            if (instanceID.equals(instanceId)){
                Instance inst = reservations.get(i).instances().get(0);

                return inst;
            }



        }

        System.out.println("-------------------------------------------------------------");


        Reservation instanceRez = ec2.describeInstances().reservations().get(0);
        System.out.println("tu mamy instanceRez");
        System.out.println(instanceRez);

        Instance inst = instanceRez.instances().get(0);
        System.out.println("tutaj mamy inst");
        System.out.println(inst);

        System.out.println("-------------------------------------------------------------");
        System.out.println(inst.instanceId());



        if (inst.instanceId().equals(instanceId)){
            System.out.printf(
                    "Found reservation with id %s, \n" +
                            "AMI %s, \n" +
                            "type %s, \n" +
                            "keyName %s, \n" +
                            "launchTime %s, \n" +
                            "privateIpAddress %s, \n" +
                            "publicIpAddress %s, \n" +
                            "securityGroupName %s, \n" +
                            "state %s \n" +
                            "and state %s \n",
                    inst.instanceId(),
                    inst.imageId(),
                    inst.instanceType(),
                    inst.keyName(),
                    inst.launchTime(),
                    inst.privateIpAddress(),
                    inst.publicIpAddress(),
                    inst.securityGroups().get(0).groupName(),
                    inst.state().name(),
                    inst.state().name());
//                    inst.monitoring().state());
            System.out.println("");

        }

        System.out.println("-------------------------------------------------------------");
        GroupIdentifier secGroup = inst.securityGroups().get(0);
        System.out.println("to jest group Id");
        System.out.println(secGroup.groupId());


        String groupId = secGroup.groupId();
        System.out.println(groupId);

        DescribeSecurityGroupsRequest request =
                DescribeSecurityGroupsRequest.builder()
                        .groupIds(groupId).build();

        DescribeSecurityGroupsResponse response =
                ec2.describeSecurityGroups(request);

        for(SecurityGroup group : response.securityGroups()) {
            System.out.printf(
                    "Found security group with id %s, \n" +
                            "vpc id %s \n" +
                            "description %s \n" +
                            "and ipPermissions %s \n " ,
                    group.groupId(),
                    group.vpcId(),
                    group.description(),
                    group.ipPermissions());
            System.out.println("");

            System.out.println(group.ipPermissions().get(0));

            List <IpPermission> ipPermissionList = group.ipPermissions();

            System.out.println(ipPermissionList);

            System.out.println("-------------------------------------------------------------");

            System.out.println("Security Group INBOUND: \n");

            for( int i = 0; i < ipPermissionList.size(); i++){
//                System.out.println(ipPermissionList.get(i) + "\n");

                Integer fromPort = ipPermissionList.get(i).fromPort();
                String ipProtocol = ipPermissionList.get(i).ipProtocol();
                String cidrIp = ipPermissionList.get(i).ipRanges().get(0).cidrIp();
//                String cidrIpv6 = ipPermissionList.get(i).ipv6Ranges().get(0).cidrIpv6();
                Integer toPort = ipPermissionList.get(i).toPort();

                System.out.println("From Port: " + fromPort + "\n" + "Range protocol: " + ipProtocol + "\n" + "Source: "
                        + cidrIp + "\n" + "To Port: " + toPort + "\n");


            }

        }
        return inst;
    }

}
