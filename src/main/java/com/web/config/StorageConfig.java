package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;

@Configuration
public class StorageConfig {

	private String accesskey = "AKIAXFBFR2GNXRQDVYFK";
	private String secret = "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";
	private String region = "ap-south-1";
	
	

	
	
	//System.out.println("ACCESS KEY ===>" + temporaryCredentials.getAccessKeyId());
	//System.out.println("ACCESS KEY ===>" + temporaryCredentials.getSecretAccessKey());
	//System.out.println("ACCESS KEY ===>" + temporaryCredentials.getSessionToken());

	
	@Bean
	public AmazonS3 s3Client() {
		
		

		AWSCredentials credentials = new BasicAWSCredentials ( accesskey , secret);
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(region).build();
		

	}
	
	
}
