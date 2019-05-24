package com.frank.RestAssuredGithubDemo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;



public class GitHubDemoTest
{
	private static Logger log = LogManager.getLogger(GitHubDemoTest.class.getName());
	
	Properties prop=new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//env.properties");
		prop.load(fis);
				
		log.info("Host information:"+prop.getProperty("HOST"));
		RestAssured.baseURI = prop.getProperty("HOST");
	}


	@Test
	public void getUser()
	{
		log.info("**********Testcase getUser Start*******");

		given().
			pathParam("username", prop.getProperty("USERNAME")).
		when().
			get(GitHubResources.getUserResource()).
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("avatar_url", equalTo("https://avatars1.githubusercontent.com/u/7381745?v=4")).and().
			log().body().and().
			log().headers().and().
			header("Server", containsString("GitHub.com"));
		
		log.info("*********Testcase getUser End*********");
	}
	
	@Test
	public void getUserRepo()
	{
		log.info("**********Testcase getUserRepo Start*******");
		
		log.info("Host information:"+prop.getProperty("TOKEN"));
		
		given().
		    header("Authorization", "token "+prop.getProperty("TOKEN")).
		when().
			get(GitHubResources.getUserRepoResource()).
		then().
			log().all();
		log.info("**********Testcase getUserRepo Start*******");
	}

	@Test
	public void postRepo()
	{
		log.info("**********Testcase postRepo Start*******");
		String postBody = GitHubPayLoad.postNewRepo();
		given().
			log().all().and().
			auth().oauth2(prop.getProperty("TOKEN")).and().
			body(postBody).
		when().
			post(GitHubResources.getUserRepoResource()).
		then().
			log().all().statusCode(201);
		log.info("**********Testcase postRepo Start*******");
	}

	@Test
	public void patchRepo()
	{
		log.info("**********Testcase patchRepo Start*******");
		String editBody = GitHubPayLoad.patchRepo();

		JsonPath json = given().
			log().all().and().auth().oauth2(prop.getProperty("TOKEN")).and().
			pathParam("owner", prop.getProperty("USERNAME")).and().
			pathParam("repo", prop.getProperty("REPOTITLE")).and().
			body(editBody).
		when().
			patch(GitHubResources.patchUserRepoResource()).
		then().
			log().all().statusCode(200).and().extract().jsonPath();
		
		String trees_url = json.get("trees_url");
		log.info("Retrive 'trees_url' value: " + trees_url);
		
		log.info("**********Testcase patchRepo Start*******");
	}

	@Test
	public void putTopic()
	{
		log.info("**********Testcase putTopic Start*******");
		String putBody = GitHubPayLoad.putTopic();
		given().
			log().all().and().auth().oauth2(prop.getProperty("TOKEN")).and().
			header("Accept", "application/vnd.github.mercy-preview+json").and().
			pathParam("owner", prop.getProperty("USERNAME")).and().
			pathParam("repo", prop.getProperty("REPOTITLE")).and().
			body(putBody).
		when().
			put(GitHubResources.putUserTopicResource()).
		then().
			log().all().statusCode(200);
		log.info("**********Testcase putTopic Start*******");
	}

	@Test
	public void deleteRepo()
	{
		log.info("**********Testcase deleteRepo Start*******");
		given().
			log().all().and().
			auth().oauth2(prop.getProperty("TOKEN")).and().
			pathParam("owner", prop.getProperty("USERNAME")).and().
			pathParam("repo", prop.getProperty("REPOTITLE")).
		when().
			delete(GitHubResources.deleteUserRepoResource()).
		then().
			log().all().statusCode(204);
		log.info("**********Testcase deleteRepo Start*******");
	}
}
