package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;


@SpringBootApplication
public class SimpleDyanamicProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDyanamicProjectApplication.class, args);
		
		 String roleARN="arn:aws:iam::491852517787:role/AssumethisRole";
		 String roleSessionName="Session_1";

		
		
		AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder.standard().build();
		AssumeRoleRequest roleRequest = new AssumeRoleRequest().withRoleArn(roleARN)
				.withRoleSessionName(roleSessionName).withDurationSeconds(7200);
		AssumeRoleResult assumeResult = stsClient.assumeRole(roleRequest);
		Credentials temporaryCredentials = assumeResult.getCredentials();
		
		System.out.println("AccessKEy" + temporaryCredentials.getAccessKeyId());
		System.out.println("AccessKEy" + temporaryCredentials.getSecretAccessKey());
		
		
	}

}
