package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.beans.MainPOJO;
import com.model.ResponseSuccess;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class Utils implements UtilsInter {
	public Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Subscriptions", "root", "password");
		return conn;
	}
	
	public HttpURLConnection signOAuth (String eventUrl) throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException
	{
        OAuthConsumer consumer = new DefaultOAuthConsumer("octane-154134", "MwBfFFKgYkdTu9Bt");
        URL url = new URL(eventUrl);
        HttpURLConnection req = (HttpURLConnection) url.openConnection();
        req.setRequestProperty("Accept", "application/json");
        consumer.sign(req);
		return req;

	}
	
	public String readJSON(HttpURLConnection req) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String line = br.readLine(); 
        br.close();
		return line;
	}
	
	public void sendJSON(ResponseSuccess responseObject, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(responseObject);
        out.print(json);
        out.flush();
	}
	
	public MainPOJO mapJsonToPojo(String json) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
        MainPOJO pojo = mapper.readValue(json,MainPOJO.class);
		return pojo;
		
	}
}
