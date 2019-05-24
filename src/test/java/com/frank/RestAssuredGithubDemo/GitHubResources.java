package com.frank.RestAssuredGithubDemo;

public class GitHubResources {

	public static String getUserResource() {

		String res = "/users/{username}";
		return res;
	}

	public static String getUserRepoResource() {

		String res = "/user/repos";
		return res;
	}
	
	public static String postUserRepoResource() {

		String res = "/user/repos";
		return res;
	}
	
	public static String patchUserRepoResource() {

		String res = "/repos/{owner}/{repo}";
		return res;
	}
	
	public static String putUserTopicResource() {

		String res = "/repos/{owner}/{repo}/topics";
		return res;
	}	
	
	public static String deleteUserRepoResource() {

		String res = "/repos/{owner}/{repo}";
		return res;
	}
	
}
