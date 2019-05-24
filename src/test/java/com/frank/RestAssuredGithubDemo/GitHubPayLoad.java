package com.frank.RestAssuredGithubDemo;

public class GitHubPayLoad
{
	public static String postNewRepo()
	{
		String str ="{\r\n" + 
				"  \"name\": \"Hello-World2\",\r\n" + 
				"  \"description\": \"This is your first repository\",\r\n" + 
				"  \"homepage\": \"https://github.com\",\r\n" + 
				"  \"private\": false,\r\n" + 
				"  \"has_issues\": true,\r\n" + 
				"  \"has_projects\": true,\r\n" + 
				"  \"has_wiki\": true\r\n" + 
				"}";
				
		return str;
	}
	

	public static String patchRepo()
	{
		String str ="{\r\n" + 
				"  \"name\": \"Hello-World2\",\r\n" + 
				"  \"description\": \"This is your first repository\",\r\n" + 
				"  \"homepage\": \"https://github.com\",\r\n" + 
				"  \"private\": false,\r\n" + 
				"  \"has_issues\": false,\r\n" + 
				"  \"has_projects\": false,\r\n" + 
				"  \"has_wiki\": true\r\n" + 
				"}";
				
		return str;
	}
	
	public static String putTopic()
	{
		String str ="{\r\n" + 
				"  \"names\": [\r\n" + 
				"    \"octocat\",\r\n" + 
				"    \"atom\",\r\n" + 
				"    \"electron\",\r\n" + 
				"    \"api\"\r\n" + 
				"  ]\r\n" + 
				"}";
				
		return str;
	}
	


}