package com.frank.RestAssuredGoogleDemo;


import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.frank.RestAssuredGithubDemo.GitHubDemoTest;


public class GoogleDemoTest {

	private static Logger log = LogManager.getLogger(GitHubDemoTest.class.getName());
	
	Properties prop=new Properties();
		
	@BeforeTest
	public void getData() throws IOException
	{
		log.info("**********BeforeTestcase getData Start*******");
		/*
		 * Wait for implement steps
		 */
		log.info("**********BeforeTestcase getData End*******");
	}

	@Test
	public void addDeletePlace()
	{
		log.info("**********Testcase addDeletePlace Start*******");
		/*
		 * Wait for implement steps
		 */
		log.info("**********Testcase addDeletePlace End*******");
		
	}
}