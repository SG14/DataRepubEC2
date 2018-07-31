package ec2Package1;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

public class ec2Instance1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAI3AGIWAVKURGQ", "S6AO6auALJyHLblqhHzBtb8M4XB1lZcu6Nv");
		AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
		                       
		
//		 final String USAGE =
//		            "DataRepubInstance" +
//		            "ami-36241f53\n";
//
//		        if (args.length != 2) {
//		            System.out.println(USAGE);
//		            System.exit(1);
//		        }

		        String name = "DataRepubInstance";
		        String ami_id = "ami-36241f53";

		      //  final AmazonEC2 ec2Client = AmazonEC2ClientBuilder.defaultClient();

		        RunInstancesRequest run_request = new RunInstancesRequest()
		            .withImageId(ami_id)
		            .withInstanceType(InstanceType.T2Micro)
		            .withMaxCount(1)
		            .withMinCount(1)
		            .withKeyName("DataRepubVM1")
                    .withSecurityGroups("DataRepubDemo");;

		        RunInstancesResult run_response = ec2.runInstances(run_request);

		        String reservation_id = run_response.getReservation().getReservationId();

		        System.out.printf(
		            "Successfully started EC2 instance %s based on AMI %s",
		            reservation_id, ami_id);

	}

}
